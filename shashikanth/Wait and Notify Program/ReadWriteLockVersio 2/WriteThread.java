package com.val.Thread1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


public class WriteThread implements Runnable
{
	ReadWriteLock rwl=new ReadWriteLock();
	public static String file;
	public void run()
	{	
		try
		{
			rwl.getWriteAccess();
			Writer wr=new FileWriter(file,true);
			BufferedWriter bw=new BufferedWriter(wr);
			String text="Hi!";
			bw.append(text);
			bw.close();wr.close();
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
		WriteThread.file=file;
	}
}
