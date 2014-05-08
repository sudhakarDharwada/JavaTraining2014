package com.vl.readwritefile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.vl.readwritelock.ReadWriteLock;

public class ReadWriteFile {
	String filepath;
	ReadWriteLock rwl;
	BufferedReader input;
	BufferedWriter out;
	private String str;
	public ReadWriteFile(String filePath) {
		this.filepath=filePath;
		rwl=new ReadWriteLock();
	}
	public void read() throws InterruptedException, IOException
	{
		rwl.getReadAccess();
		try {
			input=new BufferedReader(new FileReader(new File(filepath)));
			while((str=input.readLine())!=null)
			{
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			input.close();
			rwl.release();
		}

	}
	public void write() throws InterruptedException, IOException
	{
		out=new BufferedWriter(new FileWriter(filepath, true));
		Scanner s=new Scanner(System.in);
		rwl.getWriteAccess();
		System.out.println("Enter the text to print into file");
		String string=s.next();
		try {
			out.append(string+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			out.close();
			rwl.release();
		}
	}

}
