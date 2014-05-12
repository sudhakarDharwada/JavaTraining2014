package com.threadlocal.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*main classs*/
public class ThreadLocalExample1{

	public static void main(String[] args) {
		RequiredInfo info;
		String Filepath="/home/praveen/Desktop/file1.txt";
		String operation[] = {"Write","Read","Read", "Write","Write","Read"};
		for(int i=0;i<operation.length;i++)
		{
			info=new RequiredInfo(operation[i],Filepath);
			MyThread t=new MyThread(info);
			t.start();
		}
	}

}
/*This is the componet which stores the operation type(Read/Write) and FilePath */
class RequiredInfo
{
	private String operationType;
	private String filePath;
	public RequiredInfo(String operationType,String filePath) {
		this.operationType=operationType;
		this.filePath=filePath;
	}
	public String getOperationType() {
		return operationType;
	}
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
/*This is ThreadLocal component */
class MyThreadLocal
{
	public static final ThreadLocal<RequiredInfo> MY_THREAD_LOCAL=new ThreadLocal<RequiredInfo>();
	public static void set(RequiredInfo info)
	{
		MY_THREAD_LOCAL.set(info);
	}
	public static RequiredInfo get()
	{
		return MY_THREAD_LOCAL.get();
	}
	public static void unset()
	{
		MY_THREAD_LOCAL.remove();
	}
}
/*This is user Thread class */
class MyThread extends Thread{

	RequiredInfo info;
	public MyThread(RequiredInfo info) {
		this.info=info;
	}
	@Override
	public void run() {
		MyThreadLocal.set(info);
		try {
			FileOperation.ReadWriteDesider();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

/*This is Fileoperation class contains the read and write operations as methods*/
class FileOperation
{
	BufferedReader input;
	BufferedWriter out;
	String str;
	RequiredInfo info;
	ReadWriteLock lock=new ReadWriteLock();
	public static void ReadWriteDesider() throws InterruptedException, IOException
	{
		FileOperation fo=new FileOperation();
		RequiredInfo info=MyThreadLocal.get();
		if(info.getOperationType()=="Read")
		{
			fo.ReadFile();
		}
		else if(info.getOperationType()=="Write") {
			fo.WriteFile();
		}
		else {
			System.out.println("unknown operation");
		}
	}
	void ReadFile() throws InterruptedException, IOException
	{
		lock.getReadAccess();
		info=MyThreadLocal.get();
		try {
			input=new BufferedReader(new FileReader(new File(info.getFilePath())));
			while((str=input.readLine())!=null)
			{
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			input.close();
			lock.release();
		}
	}
	void WriteFile() throws InterruptedException, IOException
	{
		info=MyThreadLocal.get();
		out=new BufferedWriter(new FileWriter(info.getFilePath(), true));
		Scanner s=new Scanner(System.in);
		lock.getWriteAccess();
		System.out.println("Enter the text to print into file");
		String string=s.next();
		try {
			out.append("\n"+string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.close();
			lock.release();
		}
	}
}

/*This is ReadWiteLock class to provide permission to acces the file*/
class ReadWriteLock
{
	static ReadWriteLock lock=new ReadWriteLock();
	int readOperationCount=0;
	static boolean is_write_Accessing=false;
	public void getReadAccess() throws InterruptedException
	{
		boolean condition=true;
		synchronized (lock) {
			while (condition) {
				if(is_write_Accessing){
					lock.wait();
				}
				else{
					readOperationCount++;
					condition=false;
				}
			}
			
		}
	}
	public void getWriteAccess() throws InterruptedException
	{
		boolean condition=true;
		synchronized (lock) {
			while(condition){
				if(is_write_Accessing==true||readOperationCount!=0)
				{
					lock.wait();
				}
				else {
					is_write_Accessing=true;
					condition=false;
				}
			}
			
			
		}
	}
	public void release()
	{
		synchronized (lock) {
			if (is_write_Accessing) {
				is_write_Accessing=false;
			}
			else {
				readOperationCount--;
				
			}
			lock.notify();
		}
	}
}


