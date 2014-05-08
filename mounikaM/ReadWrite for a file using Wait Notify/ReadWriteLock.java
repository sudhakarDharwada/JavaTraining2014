package com.vl.ReadWriteLocks;

public class ReadWriteLock{
	
	static int no_of_write_issued;
	static int no_of_read_issued;
	static boolean is_write_lock_issued;
	static int write_waiting;
	
	public ReadWriteLock() 
	{
		is_write_lock_issued = false;
	}
	
	public static synchronized void getReadLock()
	{
		while(is_write_lock_issued==true || write_waiting != 0)
		{
			try
			{
				ReadWriteLock.class.wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			no_of_read_issued++;
		}	
	}
	
	public static synchronized void getWriteLock()
	{
		write_waiting++;
		while(is_write_lock_issued && no_of_read_issued!= 0)
		{
			try
			{
				System.out.println("write waiting");
				ReadWriteLock.class.wait();
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		is_write_lock_issued=true;
		write_waiting--;
	}
	
	public static synchronized void doRelease()
	{
		if(no_of_read_issued==0 && !is_write_lock_issued)
			return;
		if(is_write_lock_issued)
		{
			is_write_lock_issued=false;
			ReadWriteLock.class.notify();
		}
		else
		{
			no_of_read_issued--;
			if(no_of_read_issued==0)
				ReadWriteLock.class.notify();
		}
	}
}
