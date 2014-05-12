package com.RWLocks;
import java.io.*;

public class FileReadWrite{
	public static void main(String[] args) {
		File file=new File("/home/vnandini/Desktop/java/WaitandNotify/info.txt");
		ReadandWrite rw=new ReadandWrite(file,"read");
		ReadandWrite rw1=new ReadandWrite(file,"write");
		ReadandWrite rw2=new ReadandWrite(file,"read");
		ReadandWrite rw3=new ReadandWrite(file,"write");
		ReadandWrite rw4=new ReadandWrite(file,"write");
		ReadandWrite rw5=new ReadandWrite(file,"read");
		Thread t1=new Thread(rw);
		Thread t2=new Thread(rw1);
		Thread t3=new Thread(rw2);
		Thread t4=new Thread(rw3);
		Thread t5=new Thread(rw4);
		Thread t6=new Thread(rw5);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}	
}
class ReadandWrite implements Runnable
{
	FileRead fr;
	File file;
	FileWrite fw;
	String mode;
	ReadandWrite(File file,String mode)
	{
		this.mode=mode;
		this.file=file;
		fr=new FileRead(file);
		fw=new FileWrite(file);
	}
	public void run(){
		try{
			if(mode.equals("read"))
			{
				fr.readingFromFile();
			}
			else
			{			
				fw.writingToFile();
			}
		}
		catch(Exception e)
		{
		}
	}
}
