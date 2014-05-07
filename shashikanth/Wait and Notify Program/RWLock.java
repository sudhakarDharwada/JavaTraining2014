package com.val.Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

class RWLock
{
	public static int reader;
	public static boolean writer;
	public static RWThread rwt;
	public static String file;
	public RWLock(RWThread r, String file) 
	{
		reader=0;
		writer=false;
		RWLock.rwt=r;
		RWLock.file=file;
	}
	public RWLock() {
		
	}
	public void getReadAccess() throws IOException, InterruptedException
	{
		reader++;System.out.println(Thread.currentThread().getName()+" reading");
		Reader rd=new FileReader(file);
		BufferedReader br=new BufferedReader(rd);
		String read=null;
		while((read=br.readLine())!=null)
		{
			System.out.println(Thread.currentThread().getName()+read);
		}
		releaseReadLock();
		rd.close();br.close();
	}
	public void getWriteAccess() throws IOException, InterruptedException
	{
		writer=true;
		String somthing="Hello\n";
		Writer fw=new FileWriter(file,true);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.append(somthing);
		System.out.println(Thread.currentThread().getName()+" "+"written");
		releaseWriteLock();
		bw.close();fw.close();	
	}
	public void releaseReadLock()
	{
		reader--;System.out.println(Thread.currentThread().getName()+" released");
		synchronized (rwt) 
		{
			if(reader==0)
			{
				rwt.notifyAll();
			}
		}
	}
	public void releaseWriteLock()
	{
		synchronized (rwt) 
		{
			System.out.println(Thread.currentThread().getName()+" released");
			writer=false;
			rwt.notifyAll();
		}
	}
	
}
