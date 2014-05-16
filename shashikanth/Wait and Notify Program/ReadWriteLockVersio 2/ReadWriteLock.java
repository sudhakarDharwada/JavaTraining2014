package com.val.Thread1;

import java.io.IOException;

public class ReadWriteLock 
{
	public  static  int reads;
	public static boolean isWriting;
	public static ReadWriteLock rwl=new ReadWriteLock();
	public ReadWriteLock() 
	{
		reads=0;
		isWriting=false;
	}
	public  void getReadAccess( ) throws InterruptedException, IOException
	{
		synchronized (rwl) 
		{
			while(true)
			{
				if(isWriting)
				{
					System.out.println(Thread.currentThread().getName()+" at wait");
					rwl.wait();
					System.out.println(Thread.currentThread().getName()+" at active");
				}
				else
				{
					reads++;System.out.println(Thread.currentThread().getName()+" reading");
					break;
				}
			}
		}
	}
	public  void getWriteAccess( ) throws InterruptedException, IOException
	{
		synchronized (rwl) 
		{
			while(true)
			{
				if(isWriting||(reads>0))
				{
					System.out.println(Thread.currentThread().getName()+" at wait");
					rwl.wait();
					System.out.println(Thread.currentThread().getName()+" at active");
				}
				else
				{
					isWriting=true;System.out.println(Thread.currentThread().getName()+" writing");
					break;
				}
			}
		}
	}
	public  void releaseLock()
	{
		synchronized (rwl) 
		{
			if(reads>0)
			{
				reads--;
				if(reads==0)
				{
					rwl.notifyAll();
					System.out.println(Thread.currentThread().getName()+" released");
				}
			}
			if(isWriting)
			{
				isWriting=false;
				rwl.notifyAll();
				System.out.println(Thread.currentThread().getName()+" released");
			}
		}
	}
}
