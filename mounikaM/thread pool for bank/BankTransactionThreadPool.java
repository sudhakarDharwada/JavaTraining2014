import bank.AccountSummary;
import bank.Account;

import java.util.Hashtable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 
import java.util.*;
import java.io.*;

public class BankTransactionThreadPool 
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
			ExecutorService executor = Executors.newFixedThreadPool(3); 
			for(int i=0;i<list_of_files.length;i++)
			{
				if(list_of_files[i].isFile())
				{
					acc[i] = new AccountSummary(list_of_files[i]);
					executor.execute(acc[i]);
				}
			} 
			executor.shutdown(); 
			while (!executor.isTerminated()) 
			{   
			}     
			AccountSummary.printAccountSummary();
		}
		else
		{
			System.out.println("please enter a directory");
		}		
	}
}

