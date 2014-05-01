package com.val.Threading;

import java.io.File;
import java.io.IOException;


public class SyncExample 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String dir=args[0];
		File folder=new File(dir);
		File[] listoffiles=folder.listFiles();
		int n=listoffiles.length;System.out.println(n);
		Thread[] th=new Thread[n];
		long starttime=System.currentTimeMillis();
		for(int i=0;i<n;i++)
		{
			th[i]=new Thread(new FileThread(listoffiles[i].getAbsolutePath()));
		}
		for(int j=0;j<n;j++)
		{
			th[j].start();
		}
		for(int j=0;j<n;j++)
		{
			th[j].join();
		}
		Transaction.showCurrentBalance();
	        long endtime=System.currentTimeMillis();
	        System.out.println("Total Time:"+(endtime-starttime));
		
	}
}
