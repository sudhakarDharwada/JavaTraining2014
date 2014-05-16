
import java.util.Hashtable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors; 
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class TransactionUsingThreadPool 
{
	public static void main(String args[])throws InterruptedException
	{
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
                TransactionUsingThreadPool tp=new TransactionUsingThreadPool();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a folder name");
		String name=s.next();
		File  dir=new File(name);
		if(dir.isDirectory())
		{
			File[] list_of_files = dir.listFiles();
			BankTransaction acc[]=new BankTransaction[list_of_files.length];
			ExecutorService executor = Executors.newFixedThreadPool(3); 
			for(int i=0;i<list_of_files.length;i++)
			{
				if(list_of_files[i].isFile())
				{
					acc[i] = new BankTransaction(list_of_files[i]);
					executor.execute(acc[i]);
				}
			} 
			executor.shutdown(); 
			while (!executor.isTerminated()) 
			{   
			} 
                        tp.printAccountDetails(map);    
			
              }
		
		else
		{
			System.out.println("please enter a directory");
		}		
	}


public void printAccountDetails(HashMap<Integer, Integer> map) {	
                          for (Entry<Integer, Integer> entry : map.entrySet()) {
                          Integer Account = entry.getKey();
	                  Integer balance = entry.getValue();
	                  System.out.println("The Account no:" + Account + " has amount:"+ balance);
	               }
}
}

