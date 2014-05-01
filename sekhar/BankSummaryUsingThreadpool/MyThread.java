package com.vlabs.BankTxn.MyThread;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import com.vlabs.BankTxn.AccountDetails.AccountDetails;
public class MyThread extends Thread
{
	static HashMap<Integer, AccountDetails>map;
	String filepath;
	public MyThread(String filepath,HashMap<Integer, AccountDetails> maps)
	{
		this.filepath=filepath;
		map=maps;
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
					int UserId=Integer.parseInt(arg[0]);
					String status=arg[1];
					double amount=Double.parseDouble(arg[2]);
					AccountDetails obj=calculate(UserId, map);
					synchronized (obj) {
						operation(UserId, status, amount);
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
	public static AccountDetails calculate(Integer UserId,HashMap<Integer, AccountDetails> maps) {
		synchronized (UserId) {
			map = maps;
			AccountDetails ad;
			if (map.containsKey(UserId)) {
				ad = map.get(UserId);
			} else {
				ad = new AccountDetails(UserId);
				map.put(UserId, ad);
			}
			return ad;
		}
	}
			
	public void operation(Integer userId,String status,double amount) {
		if(status.equalsIgnoreCase("deposite"))
		{
			map.put(userId,(map.get(userId).deposite(amount)));
		}
		else {
			map.put(userId,(map.get(userId).withdraw(amount)));
		}
	}
	
}