package com.vl.wainotifyexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Test 
{
	Filerd fd;
	static String curentstatus="free";
	static int numofactiveoperations;
	public static void main(String[] args)
	{
		new Test();
	}
	public Test(){
		fd=new Filerd();	
		startthreads();
	}
	public synchronized void startthreads()
	{
		Thread t1=new Thread(fd);
		Thread t2=new Thread(fd);
		Thread t3=new Thread(fd);
		Thread t4=new Thread(fd);
		Thread t5=new Thread(fd);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
	public class Fileop 
	{
		String filename="/home/valuelabs/reader.txt";
		public void getreadaccess(Filerd f) throws InterruptedException, IOException
		{
			if(Test.curentstatus.equalsIgnoreCase("read")||Test.curentstatus.equalsIgnoreCase("free"))
			{
				curentstatus="read";
				numofactiveoperations++;
				System.out.println(Thread.currentThread().getName()+" is reading");
				BufferedReader br=new BufferedReader(new FileReader(filename));
				String line;
				while((line=br.readLine())!=null)
				{
					System.out.println(line);
				}
				br.close();
				System.out.println(Thread.currentThread().getName()+" reading completed");
				getrelease(f);
			}
		}
		public void getwriteaccess(Filerd f) throws InterruptedException, IOException
		{
			if(Test.curentstatus.equalsIgnoreCase("free")&&Test.numofactiveoperations==0)
			{
				curentstatus="write";
				numofactiveoperations++;
				System.out.println(Thread.currentThread().getName()+" is writing on file");
				BufferedWriter bw=new BufferedWriter(new FileWriter(filename,true));
				try
				{
					bw.append("writing into the file\n");
				}catch(IOException e){
					e.printStackTrace();
				}
				finally{
					bw.close();
				}
				System.out.println(Thread.currentThread().getName()+" writing completed");
				getrelease(f);
			}
		}
		public void getrelease(Filerd f1)
		{
			curentstatus="free";
			numofactiveoperations--;
			synchronized (f1) {
				f1.notifyAll();
			}
		}
	}
	class Filerd implements Runnable
	{
		Fileop f=new Fileop();
		@Override
		public void run() 
		{
			try
			{
				while(true)
				{
					if(Test.curentstatus.equalsIgnoreCase("write"))
					{
						synchronized (fd) 
						{
							wait();
						}
					}
					else
					{
						f.getreadaccess(fd);
						break;
					}
				}
				while(true)
				{
					if(!(Test.curentstatus.equalsIgnoreCase("free")&&Test.numofactiveoperations==0))
					{
						synchronized (fd) 
						{
							wait();
						}
					}
					else
					{
						f.getwriteaccess(fd);
						break;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
