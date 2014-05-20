package org.thread.synchronization;

public class Main {
	static String path="/home/valuelabs/Desktop/study.txt";
	public static void main(String[] args) {

		Thread t[]=new Thread[5];
		t[0]=new Thread(new ReadWrite(path,"read"));
		t[1]=new Thread(new ReadWrite(path,"read"));
		t[2]=new Thread(new ReadWrite(path,"write"));
		t[3]=new Thread(new ReadWrite(path,"read"));
		t[4]=new Thread(new ReadWrite(path,"write"));
		
	
		for(int i=0;i<5;i++){
			//t[i]=new Thread(new ReadWrite(path));
			t[i].start();
		}
		for(int i=0;i<5;i++){
			try {
				t[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
