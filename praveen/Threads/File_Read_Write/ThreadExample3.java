package com.threads.testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ThreadExample3 {

	public static void main(String[] args) {
		String Filepath="/home/praveen/Desktop/file1.txt";
		String operation[] = {"Write","Read","Read", "Write","Write","Read"};
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < operation.length; i++) {
			ReadWriteThread1 rw = new ReadWriteThread1(operation[i],Filepath);
			rw.start();
			list.add(rw);
		}
		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class ReadWriteThread1 extends Thread {
	String operation_type;
	String filePath;
	ReadWriteOperation rwo;

	public ReadWriteThread1(String opType, String filepath) {
		this.operation_type=opType;
		this.filePath=filepath;
		rwo=new ReadWriteOperation(filePath);
	}
	@Override
	public void run() {
		if(operation_type=="Read")
		{
			try {
				rwo.readOperation();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(operation_type=="Write") {
			try {
				rwo.writeOperation();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Unknown Operation");
		}
	}
}

class FilePermission {
	static FilePermission lock=new FilePermission();
	int readOperationCount=0;
	static boolean is_write_Accessing=false;
	public FilePermission() {
			
	}
	public void getReadAccess() throws InterruptedException {
		boolean condition=true;
		synchronized (lock) {
			while (condition) {
				if(is_write_Accessing){
					lock.wait();
					condition=false;
				}
				else{
					readOperationCount++;
				}
			}
			
		}
		
	}
	public void getWriteAccess() throws InterruptedException {
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
	void release() {
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
class ReadWriteOperation
{
	String filepath;
	FilePermission fp;
	BufferedReader input;
	BufferedWriter out;
	private String str;
	public ReadWriteOperation(String filePath) {
		this.filepath=filePath;
		fp=new FilePermission();
	}
	void readOperation() throws InterruptedException, IOException
	{
		fp.getReadAccess();
		try {
			input=new BufferedReader(new FileReader(new File(filepath)));
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
			fp.release();
		}
		
	}
	void writeOperation() throws InterruptedException, IOException
	{
		out=new BufferedWriter(new FileWriter(filepath, true));
		Scanner s=new Scanner(System.in);
		fp.getWriteAccess();
		System.out.println("Enter the text to print into file");
		String string=s.next();
		try {
			out.append(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.close();
			fp.release();
		}
	}
}

