package com.vl.main;

import java.util.ArrayList;
import java.util.List;

import com.vl.readwritethread.ReadWriteThread;

public class MainThread {
	public static void main(String[] args) {
		String Filepath="/home/administrator/Desktop/test1.txt";
		ReadWriteThread rw1=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw2=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw3=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw4=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw5=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw6=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw7=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw8=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw9=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw10=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw11=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw12=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw13=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw14=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw15=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw16=new ReadWriteThread("Write",Filepath);
		ReadWriteThread rw17=new ReadWriteThread("Read",Filepath);
		ReadWriteThread rw18=new ReadWriteThread("Write",Filepath);
		rw1.start();
		rw2.start();
		rw3.start();
		rw4.start();
		rw5.start();
		rw6.start();
		rw7.start();
		rw8.start();
		rw9.start();
		rw10.start();
		rw11.start();
		rw12.start();
		rw13.start();
		rw14.start();
		rw15.start();
		rw16.start();
		rw17.start();
		rw18.start();


	}

}
