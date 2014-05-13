package com.val.Thread1;

public class ReadWriteExample 
{
	public static void main(String[] args) 
	{
		String file="/home/valuelabs/Programs/FirstProgram.txt";
		ReadThread.getFile(file);
		WriteThread.getFile(file);
		Thread t1=new Thread(new ReadThread());
		Thread t2=new Thread(new WriteThread());
		Thread t3=new Thread(new ReadThread());
		Thread t4=new Thread(new WriteThread());
		Thread t5=new Thread(new ReadThread());
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
