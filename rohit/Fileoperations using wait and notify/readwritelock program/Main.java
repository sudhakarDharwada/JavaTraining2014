package com.vl.wainotifyexamples;

public class Main 
{
	public static void main(String[] args) 
	{
		Thread t0=new Thread(new Task("read"));
		Thread t1=new Thread(new Task("write"));
		Thread t2=new Thread(new Task("write"));
		Thread t3=new Thread(new Task("read"));
		Thread t4=new Thread(new Task("read"));
		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
class Task implements Runnable
{
	WriteReadlock wrlock=new WriteReadlock();
	String action;
	public Task(String action)
	{
		this.action=action;
	}
	@Override
	public void run() 
	{
		try
		{
			if(action.equalsIgnoreCase("read"))
			{
				wrlock.getreadaccess();
				System.out.println(Thread.currentThread().getName()+" reading");
				for(int i=0;i<4;i++)
				{
					Thread.sleep(500);
					System.out.println(i);
				}
				wrlock.getrelease();
			}
			else 
			{
				wrlock.getwriteaccess();
				System.out.println(Thread.currentThread().getName()+" writing");
				for(int i=0;i<4;i++)
				{
					Thread.sleep(500);
					System.out.println(i);
				}
				wrlock.getrelease();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
