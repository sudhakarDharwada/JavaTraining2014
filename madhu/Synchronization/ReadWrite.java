package org.thread.synchronization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite implements Runnable {
	String path;
	//ReadWriteLock rwl; 
	String operation="read";
	public ReadWrite(String path,String operation){


		this.path=path;

		this.operation=operation;
		//rwl=new ReadWriteLock();

	}	
	public void readFile() {

		ReadWriteLock rwl=new ReadWriteLock();
		String ch;
		FileReader fr;
		try {
			rwl.getReadAccess();
			System.out.println("reading in progress");
			fr = new FileReader(path);
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);

			//System.out.println("reading");
			while((ch = br.readLine())!=null)
				System.out.println(ch);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			rwl.releaseLock();
		}
	}
	public void writeFile() {

		ReadWriteLock rwl=new ReadWriteLock();

		try {
			rwl.getWriteAccess();
			System.out.println("writing progress");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			rwl.releaseLock();
		}

	}

	public  void run() {
		if(operation.equalsIgnoreCase("read"))
			readFile();
		else{
			
				
				writeFile();
			


		}

	}
}

