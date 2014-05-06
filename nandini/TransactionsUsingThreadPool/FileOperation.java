package com.vl.ThreadPool;

import java.util.*;
import java.io.*;

public class FileOperation implements Runnable{
    
    static Map<String,Balance> accountMap = new HashMap<String,Balance>(); //To store Account Ids and Balance
    File fileName = null;
    public FileOperation(File fileName){
    	this.fileName = fileName;
    }
    public void run(){
    	try {
	
    	    this.processFile(fileName);
    	}catch(Exception e){
    	}
    }
    //Process file based on fileName 
    public void processFile(File fileName){
		try{
    	BufferedReader br = new BufferedReader(new FileReader(fileName));
    	String line;
    
    	while ((line = br.readLine()) != null){
    	    StringTokenizer st=new StringTokenizer(line);
    	    String acId=st.nextToken();
    	    int accid=Integer.parseInt(acId);
    	    String type=st.nextToken();
    	    double amount=Double.parseDouble(st.nextToken()); 
    	    this.calculateBalance(acId,type,amount);
    	}
    	if(br!=null)
    	    br.close();
		}
	
	catch(Exception e){
	}
    	
    }
    //Calculate the balance with diff type transactions
    public void calculateBalance(String acId,String type,double amount){
		Balance bal = accountMap.get(acId);
		System.out.println(bal);
    	if(bal==null)
    	{
    	    synchronized(accountMap)
    	    {
    	    	Balance bal1 = accountMap.get(acId);
    	    	if(bal1==null)
    	    	{
						Balance bal2= new Balance();
						bal2.setBalance(amount,type);
						accountMap.put(acId,bal2);
				}
    	    	else
    	    	{
					System.out.println(acId+" "+type+" "+amount);
    	    	    bal1.setBalance(amount,type);
					
				}
			}
		}
    	else {
			synchronized(bal){
			bal.setBalance(amount,type);
			}
        }
    }
    
    //To print the details of summary
    public static void getDetails(){
    	Iterator itr = accountMap.keySet().iterator();
    	System.out.println("AccountId\t  Balance");
    	while(itr.hasNext()){
    	    String acId = itr.next().toString(); 
    	    String balance = accountMap.get(acId).toString();  
    	    System.out.println(acId + "\t\t" + balance); 
    	}
    }
}
