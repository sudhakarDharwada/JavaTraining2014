package com.vl.ReadWriteLocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;

class RWType
{
	private BufferedReader br;
	private BufferedWriter bw;
	private String line;
	ReadWriteLock rwl;
	private File inFile=null;
	
	RWType(File inFile)
	{
		this.inFile=inFile;
		rwl=new ReadWriteLock();
	}
	
	void readFile() throws FileNotFoundException,IOException
	{
		rwl.getReadLock();
		br = new BufferedReader(new FileReader(inFile));
		while((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
		br.close();
		rwl.doRelease();
		System.out.println("done reading "+Thread.currentThread().getName());
	}
	
	void writeFile() throws FileNotFoundException,IOException
	{
		rwl.getWriteLock();
		String content="writing data\n";
		FileWriter fw=new FileWriter(inFile,true);
		fw.write(content);
		fw.close();
		rwl.doRelease();
		System.out.println("done writing "+Thread.currentThread().getName());
	}
}
