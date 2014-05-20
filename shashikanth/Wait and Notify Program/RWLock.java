package com.val.Thread;

class RWLock
{
	public static int reads;
	public static boolean iswriting;
	public static RWLock rwt=new RWLock();
	public RWLock() 
	{
		reads=0;
		iswriting=false;
	}	
	public void getReadAccess() throws InterruptedException
	{
		synchronized (rwt) 
		{
		while(true)
		{
			if(iswriting)
			{
				System.out.println(Thread.currentThread().getName()+" at wait");
				rwt.wait();
				System.out.println(Thread.currentThread().getName()+" at active");
			}
			else
			{
				reads++;System.out.println(Thread.currentThread().getName()+"reading");
				break;
			}
		}
		}
	}
	public void getWriteAccess() throws InterruptedException
	{
		synchronized (rwt)
		{
			while(true)
			{
				if(iswriting||(reads>0))
				{
					System.out.println(Thread.currentThread().getName()+" at wait");
					rwt.wait();
					System.out.println(Thread.currentThread().getName()+" at active");
				}
				else
				{
					iswriting=true;System.out.println(Thread.currentThread().getName()+"writing");
					break;
				}
			}
		}
	}
	public void releaseLock()
	{
		synchronized (rwt)
		{
			if(reads>0)
			{
				reads--;
				if(reads==0)
				{
					rwt.notifyAll();
					System.out.println(Thread.currentThread().getName()+" released");
				}
			}
			if(iswriting)
			{
				iswriting=false;
				rwt.notifyAll();
				System.out.println(Thread.currentThread().getName()+" released");
			}
		}
	}
}
