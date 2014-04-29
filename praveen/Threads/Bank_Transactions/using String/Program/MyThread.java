package com.snapfish.threads.Threads;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class MyThread extends Thread
{
	static Hashtable<String, Double> userAccount;
	String filepath;
	public MyThread(String filepath,Hashtable<String, Double> users)
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
					String UserId=arg[0];
					String trans=arg[1];
					double amount=Double.parseDouble(arg[2]);

					addToTable(UserId,trans,amount);
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
	public void addToTable(String userId, String trans, double amount) {
			double initBal=0.0;
			synchronized (userId) {
			Double init=userAccount.get(userId);
			if(init==null)
			{
				userAccount.put(userId,initBal);
				init=initBal;
				synchronized (userId) {
					traansaction(userId, trans, amount,init);
				}
			}
			else {
				synchronized (userId) {
					traansaction(userId, trans, amount,init);
				}
			}
		}
	}
	public void traansaction(String userId,String trans,double amount,double init) {
		if(trans.equalsIgnoreCase("deposite"))
		{
			userAccount.put(userId,(userAccount.get(userId)+amount));
		}
		else {
			userAccount.put(userId,(userAccount.get(userId)-amount));
		}
	}
}
