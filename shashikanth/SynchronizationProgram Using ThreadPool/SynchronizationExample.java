package com.val.Threadpool;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizationExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		String dir=args[0];
		File folder=new File(dir);
		File[] listoffiles=folder.listFiles();
		int n=listoffiles.length;System.out.println(n);
		ExecutorService service=Executors.newFixedThreadPool(n);
		long starttime=System.currentTimeMillis();
		for(int i=0;i<n;i++)
		{
			service.execute(new FileThread(listoffiles[i].getAbsolutePath()));
		}
		service.shutdown();
		while(!service.isTerminated());
		Transaction.showCurrentBalance();
	        long endtime=System.currentTimeMillis();
	        System.out.println("Total Time:"+(endtime-starttime));
	}
}
