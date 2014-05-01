package org.thread.sync;

import java.io.File;

public class ThreadArray {
	
	public static void main(String[] args){
		
		File folder = new File("/home/valuelabs/thread");
		File[] listFiles = folder.listFiles();
		Main[] t=new Main[listFiles.length];
		
		for(int i=0;i<listFiles.length;i++)
		{
			t[i]=new Main(listFiles[i]);
			t[i].start();
		}
		
		for(int i=0;i<listFiles.length;i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Main.bankTransactionDetailes();
	}
}
