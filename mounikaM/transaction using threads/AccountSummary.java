package bank;

import java.util.Hashtable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;
public class AccountSummary implements Runnable
{
	private File file=null;
	private static Hashtable<Integer, Account> accountInfo=new Hashtable<Integer, Account>();
	private static Hashtable<Integer, Lock> lock_hash = new Hashtable<Integer, Lock>();
	public AccountSummary(File file)
	{
		this.file=file;
	}
	
	/*overriding run method */
	public void run()
	{
		try
		{
			this.readingAccountsToHashtable(file);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		
	/* Reading information into hash table*/
	public void readingAccountsToHashtable(File file){
		BufferedReader br = null;
		String line;
		int acc=0;
		double bal=0;
		String trans_type;
		String[] e=new String[3];
		try
		{
			br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line," ");
				int i=0;
				String d=null;
				while (st.hasMoreElements()) 
				{
					d=(String)st.nextElement();
					e[i]=d;
					i++;
				}
				acc=Integer.parseInt(e[0]);
				trans_type=e[1];
				bal=Double.parseDouble(e[2]);
				Lock lock = new Lock(acc);
				lock_hash.put(acc,lock);
				this.calculateBalance(acc,trans_type,bal);
			}	
		}
		catch(FileNotFoundException e2)
		{
			e2.printStackTrace();
		} 	
		catch (IOException e1) {
			e1.printStackTrace();
		}		
	}
	
	
	/*Caluculating the balance */
	public void calculateBalance(int acc,String trans_type,double bal)
	{		
    	Lock lock = this.getLockObject(acc);
    	if(lock!=null){   
			 synchronized(lock){     // To lock the object if the process base on same ID
    	    	Account  b=accountInfo.get(acc);
    	    	if(b!=null)
    	    	{
    	    	    b.setBalance(bal,trans_type);
    	    	}
    	    	else{
    	    	    b = new Account();
    	    	    b.setBalance(bal,trans_type);
    	    	    accountInfo.put(acc,b);
    	    	}
    	    }
        }
    }	
	
	/*For printing the summary of account information*/
	public static void printAccountSummary()
	{
		Enumeration accounts=accountInfo.keys();
		System.out.println("The Account details are");
		while(accounts.hasMoreElements()) 
		{
			int account = (int)accounts.nextElement();
			System.out.println(account + ": " +accountInfo.get(account));
		}	
	}
	
	/*to avoid concurrent modification*/
	public Lock getLockObject(int id)
	{
    	while(lock_hash.get(id)!=null)
    	{
			return lock_hash.get(id);
		}
		return null;
    }    
}

class Lock 
{
    protected int id;
    Lock(int id)
    {
        this.id = id;
    }
}

