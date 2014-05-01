package com.vl.threadpools.transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import com.vl.transaction.Balance;
import java.util.concurrent.*;

public class TransactionReport 
{
	public static void main(String[] args) throws InterruptedException 
	{
		File file = new File("/home/valuelabs/input/");
		File[] files = file.listFiles();
		ThreadPoolExecutor thrpool=new ThreadPoolExecutor(2, 3, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()); 
		for(int j=0;j<files.length;j++)
		{
			thrpool.execute(new ReportThread(files[j].getAbsolutePath()));
		}
		thrpool.shutdown();
		while(!thrpool.isTerminated())
		{
		}
		System.out.println("enter the account no. to get current balance:");
		Scanner sc=new Scanner(System.in);
		Accno a1=new Accno(sc.nextInt());
		if(!(ReportThread.accdetails.containsKey(a1)))
			System.out.println("account with no. "+a1.accno+" is not existed");
		else
			System.out.println("current balance in account no. "+a1.accno+" is "+ReportThread.accdetails.get(a1).amount);
	}
}
class GenerateReport
{
	static Accno ns=null;
	static Map<Integer,Accno> m=new HashMap<Integer,Accno>();
	public static Hashtable<Accno,Balance> generatereport(int i,String s1,int amount)
	{	
		if(!(m.containsKey(i)))
			m.put(i,new Accno(i));
		synchronized (m.get(i)) 
		{
			if(ReportThread.accdetails.get(new Accno(i))==null)
			{
				Balance b=null;
				if(s1.equalsIgnoreCase("Cr"))
				{
					b=new Balance(0+amount);
				}
				else
				{
					b=new Balance(0-amount);
				}
				synchronized (ReportThread.accdetails) 
				{
					ReportThread.accdetails.put(new Accno(i),b);
				}
			}
		else
		{	
			if(s1.equalsIgnoreCase("Cr"))
			{
				ReportThread.accdetails.get(new Accno(i)).increment(amount);
			}
			else
			{
				ReportThread.accdetails.get(new Accno(i)).decrement(amount);
			}
			}
		}
			return ReportThread.accdetails;
	}
}
class ReportThread implements Runnable
{
	String file;
	public static Hashtable<Accno,Balance> accdetails=new Hashtable<Accno,Balance>();
	public ReportThread(String file)
	{
		this.file=file;
	}
	@Override
	public void run() 
	{
		System.out.println(Thread.currentThread().getName()+" started ");
		try
		{
			FileReader re = new FileReader(file);
			Scanner sc =new Scanner(new BufferedReader(re));
			while(sc.hasNext())
			{
				int i=Integer.parseInt((sc.useDelimiter("  ").next().trim()));
				String s1=sc.useDelimiter("  ").next();
				int amount=Integer.parseInt(sc.useDelimiter("\n").next().trim());
				GenerateReport.generatereport(i,s1,amount);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" end ");
	}
}

