package com.val.Threading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
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
					int id=Integer.parseInt(str.nextToken());
					String type=str.nextToken();
					int amount=Integer.parseInt(str.nextToken());
					Account ac=null;
					ac=ht.get(id);
					if(ac==null)
					{
						System.out.println(Thread.currentThread().getName()+"  entered");
						synchronized (ht) 
						{
							 ac=ht.get(id);
							 Account ac1=null;
							 if(ac==null)
							 {
							      if(type.equalsIgnoreCase("withdraw"))
							      {
								     ac1=new Account(0-amount);
							      }
							      else
							      {
								     ac1=new Account(0+amount);
							      }
							      ht.put(id, ac1);
							  }
							  else
							  {
								update(type,ac,amount);
							  }
						 }
						 System.out.println(Thread.currentThread().getName()+"  exit");
					 }
					 else
					 {
						update(type,ac,amount);
					 }
					
				}
			}
			isFirstLine=false;
     	        }
	}
	private static void update(String type, Account ac, int amount) 
	{
		if(type.equalsIgnoreCase("withdraw"))
		{
			synchronized (ac) 
			{
				ac.withdraw(amount);
			}
		}
		else
		{
			synchronized (ac) 
			{
				ac.deposit(amount);
			}
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
