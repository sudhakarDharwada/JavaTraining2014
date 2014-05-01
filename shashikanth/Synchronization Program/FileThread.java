package com.val.Threading;

import java.io.IOException;


class FileThread implements Runnable
{
	String file=null;
	public FileThread(String file) 
	{
		this.file=file;
	}
	public void run()
	{
			try {
				Transaction.processTransactions(file);	
				
			} catch (NumberFormatException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
