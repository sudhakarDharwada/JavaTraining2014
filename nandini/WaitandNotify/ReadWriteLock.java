package com.RWLocks;

class ReadWriteLock{
	static boolean is_write_access=false;
	static int no_of_read_access;
	static boolean is_write_wait;
	public static synchronized void getReadAccess()throws InterruptedException
	{
			if(!is_write_access)
			{
				no_of_read_access++;
			}
			else
			{
				ReadWriteLock.class.wait();
			}
	
	}
	public static  synchronized void getwriteAccess()throws InterruptedException
	{
		
			while(is_write_access && no_of_read_access==0)
			{
				is_write_access=true;	
			}
			ReadWriteLock.class.wait();
		
	}
	public synchronized static void doRelease()
	{
		
			if(is_write_access)
				is_write_access=false;
			else
				no_of_read_access--;
				ReadWriteLock.class.notifyAll();
	}
}
