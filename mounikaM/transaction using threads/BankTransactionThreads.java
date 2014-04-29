import bank.AccountSummary;
import bank.Account;

import java.util.Hashtable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class BankTransactionThreads 
{
	public static void main(String args[])throws InterruptedException
	{
		int accountId;
		double balance;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a folder name");
		String name=s.next();
		File  dir=new File(name);
		if(dir.isDirectory())
		{
			File[] list_of_files = dir.listFiles();
			AccountSummary acc[]=new AccountSummary[list_of_files.length]; 
			Thread t[]=new Thread[list_of_files.length]; // creating array of threads
			for(int i=0;i<list_of_files.length;i++)
			{
				if(list_of_files[i].isFile())
					acc[i] = new AccountSummary(list_of_files[i]);
				t[i]=new Thread(acc[i]);
				try
				{
					t[i].start();	//starting a thread
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}					
			} 
			//for joining all the threads
			for(int j=0;j<list_of_files.length;j++)
			{
				t[j].join(); 
			}   
			AccountSummary.printAccountSummary();
		}		
	}
}

