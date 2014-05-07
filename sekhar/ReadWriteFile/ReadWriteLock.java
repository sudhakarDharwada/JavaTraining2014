package com.vl.readwritelock;

public class ReadWriteLock {
	static ReadWriteLock lock=new ReadWriteLock();
	int readOperationCount=0;
	static boolean is_write_Accessing=false;
	public ReadWriteLock() {

	}
	public void getReadAccess() throws InterruptedException {
		boolean condition=true;
		synchronized (lock) {
			while (condition) {
				if(is_write_Accessing){
					lock.wait();
					condition=false;
				}
				else{
					readOperationCount++;
					condition=false;
				}
			}

		}

	}
	public void getWriteAccess() throws InterruptedException {
		boolean condition=true;
		synchronized (lock) {
			while(condition){
				if(is_write_Accessing==true||readOperationCount!=0)
				{
					lock.wait();
				}
				else {
					is_write_Accessing=true;
					condition=false;
				}
			}


		}

	}
	public void release() {
		synchronized (lock) {
			if (is_write_Accessing) {
				is_write_Accessing=false;
			}
			else {
				readOperationCount--;

			}
			lock.notify();
		}
	}


}
