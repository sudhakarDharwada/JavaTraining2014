package com.ThreadPoolSyncaccDetails;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListFiles 
{

	public static void main(String[] args) throws InterruptedException 
	{

		String path = "/home/valuelabs/Desktop/Input"; 


		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(); 
		FileToObject fto = new FileToObject();
		ExecutorService executor = Executors.newFixedThreadPool(2);
		ThreadClass[] t = new ThreadClass[listOfFiles.length];

		for(int i=0;i<listOfFiles.length;i++){

			t[i] = new ThreadClass(fto,listOfFiles[i],"Thread"+(i+1));
			executor.execute(t[i]);
			
		}

		executor.shutdown();
		while(!executor.isTerminated()){
			
		}

		Map<Integer, ChangedAmount> mm = fto.m;

		Iterator<Entry<Integer, ChangedAmount>> it = mm.entrySet().iterator();

		System.out.println("final values are");
		while(it.hasNext()){

			Entry<Integer,ChangedAmount> e =it.next();
			System.out.println(e.getKey()+"      "+e.getValue().amount);

		}
	}

}

