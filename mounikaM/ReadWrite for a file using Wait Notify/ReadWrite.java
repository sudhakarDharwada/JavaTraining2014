package com.vl.ReadWriteLocks;

import java.io.File;
import java.io.IOException;
import java.io.*;

public class ReadWrite
{
	public static void main(String args[])
	{
		File inFile;
		if (0 < args.length) 
		{
			inFile = new File(args[0]);
			Thread t[]=new Thread[20];
			t[0]=new Thread(new ReadWriteThread(inFile,"read"));
			t[1]=new Thread(new ReadWriteThread(inFile,"read"));
			t[2]=new Thread(new ReadWriteThread(inFile,"read"));
			t[3]=new Thread(new ReadWriteThread(inFile,"read"));
			t[4]=new Thread(new ReadWriteThread(inFile,"read"));
			t[5]=new Thread(new ReadWriteThread(inFile,"write"));
			t[6]=new Thread(new ReadWriteThread(inFile,"read"));
			t[7]=new Thread(new ReadWriteThread(inFile,"write"));
			t[8]=new Thread(new ReadWriteThread(inFile,"read"));
			t[9]=new Thread(new ReadWriteThread(inFile,"write"));
			t[10]=new Thread(new ReadWriteThread(inFile,"write"));
			t[11]=new Thread(new ReadWriteThread(inFile,"write"));
			t[12]=new Thread(new ReadWriteThread(inFile,"write"));
			t[13]=new Thread(new ReadWriteThread(inFile,"write"));
			t[14]=new Thread(new ReadWriteThread(inFile,"write"));
			t[15]=new Thread(new ReadWriteThread(inFile,"read"));
			t[16]=new Thread(new ReadWriteThread(inFile,"read"));
			t[17]=new Thread(new ReadWriteThread(inFile,"read"));
			t[18]=new Thread(new ReadWriteThread(inFile,"write"));
			t[19]=new Thread(new ReadWriteThread(inFile,"write"));			
			try
			{
				for(int i=0;i<20;i++)
				{
					t[i].start();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Please enter a file name while running");
		}
	}
}

class ReadWriteThread implements Runnable
{
	private File inFile=null;
	private String operation_type;
	RWType rw;
	
	ReadWriteThread(File inFile,String operation_type)
	{
		this.inFile=inFile;
		this.operation_type=operation_type;
		rw=new RWType(this.inFile);
	}
	
	public void run()
	{
		try
		{
			System.out.println("Starting..."+Thread.currentThread().getName());
			if(operation_type.equalsIgnoreCase("read"))
			{
				rw.readFile();
			}
			else
				rw.writeFile();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error");
		}
	}	
}
