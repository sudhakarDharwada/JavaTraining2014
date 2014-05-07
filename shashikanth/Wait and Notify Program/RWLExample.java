package com.val.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RWLExample
{
	public static void main(String[] args) 
	{
		String file=args[0];
		RWThread r=new RWThread();
		RWLock rwl=new RWLock(r,file);
		ExecutorService service=Executors.newFixedThreadPool(4);
		for(int i=0;i<4;i++)
		{
			service.execute(r);
		}
		service.shutdown();
	}
}
