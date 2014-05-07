package com.vl.ReadWriteLocks;

public class ReadWriteLock{
	
	private Lock l;
	private int no_of_write_issued;
	private int no_of_read_issued;
	private boolean is_write_lock_issued;
	private int write_waiting;
	
	public ReadWriteLock() 
	{
		l = new Lock();
		is_write_lock_issued = false;
	}
	
	void getReadLock()
	{
		synchronized(l)
		{
			if(is_write_lock_issued==true || write_waiting != 0)
			{
				try
				{
					l.wait();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				no_of_read_issued++;
			}
		}
	}
	
	void getWriteLock()
	{
		synchronized(l)
		{
			write_waiting++;
			while(is_write_lock_issued && no_of_read_issued== 0)
			{
				try
				{
					l.wait();
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			is_write_lock_issued=true;
			write_waiting--;
		}
	}
	
	void doRelease()
	{
		synchronized(l)
		{
			if(is_write_lock_issued)
				is_write_lock_issued=false;
			else
				no_of_read_issued--;
			l.notify();
		}
	}
}
