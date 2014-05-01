package org.thread.pooling;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooling {
	
	public static void main(String[] args){
		
		File folder = new File("/home/valuelabs/thread");
		File[] listFiles = folder.listFiles();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Main[] t=new Main[listFiles.length];
		
		for(int i=0;i<listFiles.length;i++)
		{
			t[i]=new Main(listFiles[i]);
			//t[i].start();
			executor.execute(t[i]);
		}
		executor.shutdown();
		while(!executor.isTerminated()){
			
		}
		Main.bankTransactionDetailes();
	}
}
