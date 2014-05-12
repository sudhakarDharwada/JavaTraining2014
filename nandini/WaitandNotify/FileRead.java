package com.RWLocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
class FileRead{
	File file;
	BufferedReader br;
	//FileReader fr;
	String currentline;
	ReadWriteLock rwl;
	FileRead(File file)
	{
		this.file=file;
		rwl=new ReadWriteLock();
	}
	public void readingFromFile(){
		try{
			rwl.getReadAccess();
			br=new BufferedReader(new FileReader(file));
			System.out.println(Thread.currentThread().getName()+"Reading Started");
			while((currentline= br.readLine())!=null)
			{
				System.out.println(currentline);
			}
			rwl.doRelease();
			System.out.println(Thread.currentThread().getName()+"Done Reading");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

		
