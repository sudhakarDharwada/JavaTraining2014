package com.syncaccdetails;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ListFiles 
{

	public static void main(String[] args) throws InterruptedException 
	{

		String path = "/home/valuelabs/Desktop/Input"; 

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles(); 
		FileToObject fto = new FileToObject();
		ThreadClass[] t = new ThreadClass[listOfFiles.length];

		for(int i=0;i<listOfFiles.length;i++){

			t[i] = new ThreadClass(fto,listOfFiles[i],"Thread"+(i+1));
			t[i].start();
		}

		for(int i=0;i<listOfFiles.length;i++){

			t[i].join();
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

