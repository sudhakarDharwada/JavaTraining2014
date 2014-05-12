package com.vl.wainotifyexamples;

public class WriteReadlock 
{
	static boolean iswriteinprogress=false;
	static int numofreads;
	static WriteReadlock obj=new WriteReadlock();

	public  void getreadaccess() throws InterruptedException
	{
		synchronized (obj) 
		{
			while(true)
			{
				if(iswriteinprogress)
				{
					obj.wait();
				}
				else
				{
					numofreads++;
					System.out.println(Thread.currentThread().getName()+" read started");
					break;
				}
			}
		}
	}
	public void getwriteaccess() throws InterruptedException
	{
		synchronized (obj) 
		{
			while(true)
			{
				if(iswriteinprogress||!(numofreads==0))
				{
					obj.wait();
				}
				else
				{
					iswriteinprogress=true;
					System.out.println(Thread.currentThread().getName()+" write started");
					break;
				}
			}
		}
	}
	public   void getrelease()
	{
		synchronized (obj) 
		{
			if(!iswriteinprogress&&numofreads>0)
			{
				numofreads--;
				obj.notifyAll();
				System.out.println(Thread.currentThread().getName()+" read action completed");
			}
			if(iswriteinprogress)
			{
				iswriteinprogress=false;
				obj.notifyAll();
				System.out.println(Thread.currentThread().getName()+" write action completed");
			}
		}
	}
}
