package com.val.Threading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class Transaction 
{
	public static Map<Integer,Account> ht=new Hashtable<Integer,Account>();
	public static void processTransactions(String file) throws NumberFormatException, IOException, InterruptedException 
	{
		Reader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String read=null;boolean isFirstLine=true;
		while((read=br.readLine())!=null)
		{
			if(!isFirstLine)
			{
				StringTokenizer str=new StringTokenizer(read.trim());
				while(str.hasMoreTokens())
				{		
					Integer id=Integer.parseInt(str.nextToken());
					System.out.println(Thread.currentThread().getName()+"----"+id);
					System.out.println("*"+id);
					String type=str.nextToken();
					int amount=Integer.parseInt(str.nextToken());
					Account ac=null;
					System.out.println(id);
					System.out.println(Thread.currentThread().getName()+"----"+id);
					synchronized (id) 
					{
						ac=ht.get(id);
						System.out.println(Thread.currentThread().getName()+"-----"+ht.get(id)+"  withid  "+id);
						if(ac==null)
						{
							System.out.println(Thread.currentThread().getName()+"  entered");
							Account ac1=null;
							if(type.equalsIgnoreCase("withdraw"))
							{
								synchronized (id) 
								{
									ac1=new Account(0-amount);
									ht.put(id, ac1);
								}
							}
							else
							{
								synchronized (id) 
								{
									ac1=new Account(0+amount);
									ht.put(id, ac1);
								}
							}
						}
						else
						{
							if(type.equalsIgnoreCase("withdraw"))
							{
								synchronized (id) 
								{
									ac.withdraw(amount);
								}
							}
							else
							{
								synchronized (id) 
								{
									ac.deposit(amount);
								}
							}
						}
					}
				}
			}
			isFirstLine=false;
     	}
	}
	public static void showCurrentBalance()
	{
		System.out.println("Current List");
		for(Map.Entry<Integer, Account> entry:ht.entrySet())
		{
			int id=entry.getKey();
			Account b=entry.getValue();
			System.out.println(id+"     "+b.amount);
		}
	}
}
