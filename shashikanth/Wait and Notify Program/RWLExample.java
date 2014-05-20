package com.val.Thread;

public class RWLExample
{
	public static void main(String[] args) 
	{
		String file=args[0];
		RWThread r=new RWThread();
		RWThread.getFile(file);
		Thread t1=new Thread(new RWThread("read"));
		Thread t2=new Thread(new RWThread("write"));
		Thread t3=new Thread(new RWThread("read"));
		Thread t4=new Thread(new RWThread("write"));
		Thread t5=new Thread(new RWThread("read"));
		t1.start();t2.start();t3.start();t4.start();t5.start();
	}
}
