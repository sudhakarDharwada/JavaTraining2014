package com.val.Thread;

import java.io.IOException;


class RWThread implements Runnable
{
	RWLock rlock=new RWLock();
	public void run() 
	{
		try {
			
			while(true)
			{
			  if(!RWLock.writer)
			  {
			    rlock.getReadAccess();
			    break;
			  }
			  else
			  {
			      synchronized (this) 
				  {
			    	  System.out.println(Thread.currentThread().getName()+"at wait");
					  wait();
					  System.out.println(Thread.currentThread().getName()+"at active");
				  }
			  }
			}
			while(true)
			{
			  if(!(RWLock.writer)&&(RWLock.reader==0))
			  {
			    rlock.getWriteAccess();
			    break;
			  }
			  else
			  {
				  synchronized (this)
				  {
					  System.out.println(Thread.currentThread().getName()+"at wait");
					  wait();	 
					  System.out.println(Thread.currentThread().getName()+"at active");
				  }
			  }
			 
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
}