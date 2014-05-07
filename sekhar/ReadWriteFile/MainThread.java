package com.vl.main;

import java.util.ArrayList;
import java.util.List;

import com.vl.readwritethread.ReadWriteThread;

public class MainThread {
	public static void main(String[] args) {
		String Filepath="/home/administrator/Desktop/test1.txt";
		String operation[] = {"Write","Read","Read", "Write","Write","Read"};
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < operation.length; i++) {
			ReadWriteThread rwt = new ReadWriteThread(operation[i],Filepath);
			rwt.start();
			list.add(rwt);
		}
		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
