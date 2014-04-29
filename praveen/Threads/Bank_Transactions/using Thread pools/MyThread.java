package com.snapfish.threads.Threads;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

import com.snapfish.threads.beans.AccountRecord;

public class MyThread extends Thread
{
	static Hashtable<Integer, AccountRecord> userAccount;
	String filepath;
	public MyThread(String filepath,Hashtable<Integer, AccountRecord> users)
	{
		this.filepath=filepath;
		userAccount=users;
	}
	public MyThread() {
	}
	public void run()
	{
		BufferedReader input=null;
		try {
			input=new BufferedReader(new FileReader(filepath));
			String str = null;
			String arg[] = new String[3];
			StringTokenizer sTokenizer = null;
			while ((str = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg[i] = sTokenizer.nextToken();
				}
				if (arg[0] != null) {
					Integer UserId=Integer.parseInt(arg[0]);
					String trans=arg[1];
					double amount=Double.parseDouble(arg[2]);

					AccountRecord obj=AccountRecord.setAccountRecord(UserId, userAccount);
					synchronized (obj) {
						transaction(UserId, trans, amount);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
			
	public void transaction(Integer userId,String trans,double amount) {
		if(trans.equalsIgnoreCase("deposite"))
		{
			userAccount.put(userId,(userAccount.get(userId).addValue(amount)));
		}
		else {
			userAccount.put(userId,(userAccount.get(userId).diffValue(amount)));
		}
	}
	
}
