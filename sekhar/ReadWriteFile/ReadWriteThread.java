package com.vl.readwritethread;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.vl.readwritefile.ReadWriteFile;

public class ReadWriteThread extends Thread{
	String operation_type;
	String filePath;
	ReadWriteFile rwf;

	public ReadWriteThread(String opType, String filepath) {
		this.operation_type=opType;
		this.filePath=filepath;
		rwf=new ReadWriteFile(filePath);
	}
	@Override
	public void run() {
		if(operation_type=="Read")
		{
			try {
				rwf.read();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(operation_type=="Write") {
			try {
				rwf.write();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Unknown Operation");
		}
	}
}
