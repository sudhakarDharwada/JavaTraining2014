package org.thread.synchronization;

public class ReadWriteLock {
	static boolean writeInProgress=false;
	static int nReads;
	static ReadWriteLock lock=new ReadWriteLock();


	public synchronized  void getReadAccess() throws InterruptedException{
		synchronized (lock) {

			while(writeInProgress){
				System.out.println("r waiting"+Thread.currentThread().getName());
				lock.wait(600);
				System.out.println("active "+Thread.currentThread().getName());
			}
			nReads++;
			System.out.println("giving read access"+Thread.currentThread().getName());
		}
	}
	public synchronized void releaseLock(){
		synchronized (lock) {

			if(!writeInProgress&&nReads>0)
			{
				nReads--;
				System.out.println("read released"+Thread.currentThread().getName());
				lock.notifyAll();	
			}
			if(writeInProgress){
				writeInProgress=false;
				System.out.println("write released"+Thread.currentThread().getName());
				lock.notifyAll();
			}
		}
	}
	public synchronized  void getWriteAccess() throws InterruptedException{

		synchronized (lock) 
		{

			while(writeInProgress&&nReads!=0){
				System.out.println("w waiting"+Thread.currentThread().getName());
				lock.wait(200);
				System.out.println("active"+Thread.currentThread().getName());
			}

			writeInProgress=true;
			System.out.println("giving write access"+Thread.currentThread().getName());
		}
	}
}
