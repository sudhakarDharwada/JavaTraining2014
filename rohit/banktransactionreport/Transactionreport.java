package com.vl.transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Scanner;

public class Transactionreport 
{
	public static void main(String[] args) 
	{
		String file=args[0];
		Hashtable<Integer,Balance> accdetails=new Hashtable<Integer,Balance>();
		Transactionreport tr=new Transactionreport();
		accdetails=tr.generatereport(file);
		Scanner sc=new Scanner(System.in);
		String cont=null;
		do
		{
		System.out.println("enter the account no. to get current balance:");
		int accno=sc.nextInt();
		if(!(accdetails.containsKey(accno)))
			System.out.println("account with no. "+accno+" is not existed");
		else
			System.out.println("current balance in account no. "+accno+" is "+accdetails.get(accno).amount);
		System.out.println("do you want to continue[y/n] :");
		cont=sc.next();
		}while(cont.equalsIgnoreCase("y"));
	}

	public Hashtable<Integer,Balance> generatereport(String file)
	{
		Hashtable<Integer,Balance> accdetails=new Hashtable<Integer,Balance>();
		try 
		{
			FileReader re = new FileReader(file);
			Scanner sc =new Scanner(new BufferedReader(re));
			while(sc.hasNext())
			{
				int i=Integer.parseInt(sc.useDelimiter("  ").next().trim());
				String s1=sc.useDelimiter("  ").next();
				int amount=Integer.parseInt(sc.useDelimiter("\n").next().trim());
				Balance v=accdetails.get(i);
				if(v==null)
				{
                    Balance b = null;
					if(s1.equalsIgnoreCase("Cr"))
					{
						b=new Balance(0+amount);
					}
					else
					{
						b=new Balance(0-amount);
					}
                    accdetails.put(i,b);
				}
				else
				{
					if(s1.equalsIgnoreCase("Cr"))
					{
						
						//Balance b=new Balance(accdetails.get(i).amount);
						v.increment(amount);
						System.out.println(b.amount);
						//accdetails.put(i,(Integer)accdetails.get(i)+amount);
					}
					else
					{
						//Balance b=new Balance(accdetails.get(i).amount);
						v.decrement(amount);
						System.out.println(b.amount);
						//accdetails.put(i,(Integer)accdetails.get(i)-amount);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return accdetails;
	}
}
