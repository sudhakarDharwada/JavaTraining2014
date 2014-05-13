package com.val.Thread1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadThread implements Runnable
{
	ReadWriteLock rwl=new ReadWriteLock();
	public static String file;
	public void run()
	{	
		try
		{
			rwl.getReadAccess();
			Reader rd=new FileReader(file);
			BufferedReader br=new BufferedReader(rd);
			String read=null;
			while((read=br.readLine())!=null)
			{
				System.out.println(Thread.currentThread().getName()+" "+read);
			}
			rd.close();br.close();
			
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			rwl.releaseLock();
		}
	}

	public static void getFile(String file) 
	{
		ReadThread.file=file;
	}
}
