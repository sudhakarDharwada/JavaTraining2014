package com.vl.threads.transaction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;

import com.vl.transaction.Balance;

public class Transaction 
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		File file = new File("/home/valuelabs/input/");
		File[] files = file.listFiles();
		Thread[] t=new Thread[files.length];
		long st=System.currentTimeMillis();
		for(int j=0;j<3;j++)
		{
			t[j]=new Thread(new ReportThread(files[j].getAbsolutePath()));
			t[j].start();
		}
		for(int i=0;i<files.length;i++)
			try {
				t[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		for(Entry<Accno,Balance> e:ReportThread.accdetails.entrySet())
			System.out.println(e.getKey()+"   "+e.getValue().amount);
		long et=System.currentTimeMillis();
		System.out.println(et-st);
		System.out.println("enter the account no. to get current balance:");
		Scanner sc=new Scanner(System.in);
		Accno a1=new Accno(sc.nextInt());
		if(!(ReportThread.accdetails.containsKey(a1)))
			System.out.println("account with no. "+a1.accno+" is not existed");
		else
			System.out.println("current balance in account no. "+a1.accno+" is "+ReportThread.accdetails.get(a1).amount);
	}
}
class Generate
{
	static Accno ns=null;
	
	public static Hashtable<Accno,Balance> generatereport(int i,String s1,int amount)
	{	
		
		ns=new Accno(i);
		synchronized (ns) 
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
				synchronized (Generate.class) 
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
			return ReportThread.accdetails;
		}
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
		try
		{
			FileReader re = new FileReader(file);
			Scanner sc =new Scanner(new BufferedReader(re));
			while(sc.hasNext())
			{
				int i=Integer.parseInt((sc.useDelimiter("  ").next().trim()));
				String s1=sc.useDelimiter("  ").next();
				int amount=Integer.parseInt(sc.useDelimiter("\n").next().trim());
				Generate.generatereport(i,s1,amount);
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}
