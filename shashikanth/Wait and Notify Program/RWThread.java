package com.val.Thread;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


class RWThread implements Runnable
{
	RWLock lock=new RWLock();
	public String operation;
	public static String file;
	public RWThread(String op) 
	{
		this.operation=op;
	}
	public RWThread() 
	{
	}
	
	public void run() 
	{
		try
		{
			if(operation.equalsIgnoreCase("read"))
			{
				lock.getReadAccess();
				Reader rd=new FileReader(file);
				BufferedReader br=new BufferedReader(rd);
				String read=null;
				while((read=br.readLine())!=null)
				{
					System.out.println(Thread.currentThread().getName()+" "+read);
				}
				rd.close();br.close();
			}
			else if(operation.equalsIgnoreCase("write"))
			{
				lock.getWriteAccess();
				Writer wr=new FileWriter(file,true);
				BufferedWriter bw=new BufferedWriter(wr);
				String text="Hello!";
				bw.append(text);
				bw.close();wr.close();
			}
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			lock.releaseLock();
		}
	}
	public static void getFile(String file) 
	{
		RWThread.file=file;
	}
}