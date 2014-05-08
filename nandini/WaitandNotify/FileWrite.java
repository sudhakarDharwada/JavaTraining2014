package com.RWLocks;

import java.io.FileWriter;
import java.io.*;
public class FileWrite{
	File file;
	FileWriter fw;
	ReadWriteLock rwl;
	String content="writing data into file";
	FileWrite(File file)
	{
		this.file=file;
		rwl=new ReadWriteLock();
	}
	public void writingToFile(){
		try{
			if(!file.exists())
			{
				file.createNewFile();
			}
			else
			{
				rwl.getwriteAccess();
				FileWriter writer=new FileWriter(file);
				System.out.println(Thread.currentThread().getName()+"started Writing----------------------------------");
				writer.write(content);
				writer.flush();
				writer.close();
				System.out.println(Thread.currentThread().getName()+"Done Writing");
			}
		}
		catch(InterruptedException ex)
		{
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		rwl.doRelease();
	}
}
		
		
		
