package com.vl.bank;

import java.util.*;
import java.io.*;

public class FileOperation extends Thread{
    
    static Map<String,Balance> accountMap = new HashMap<String,Balance>(); //To store Account Ids and Balance
    protected static Set<Lock> lockSet = new HashSet<Lock>(); // To identify unique object for synchronization
    
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
    	    Lock lock = new Lock(Integer.parseInt(acId));
    	    lockSet.add(lock);
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
    
    //To get the object uniquely based on AccountID
    public Lock getLockObject(int id){
    	synchronized(lockSet){//TO avoid ConcurrentModificationException
    	    Iterator i = lockSet.iterator();
    	    while(i.hasNext()){
    	    	Lock l = (Lock)i.next();
    	    	if(l.id == id){
    	    	    return l;
    	    	}
    	    }
    	    return null;
    	}
    }
    
    //Calculate the balance with diff type transactions
    public void calculateBalance(String acId,String type,double amount){
		Lock lock = this.getLockObject(Integer.parseInt(acId));
    	if(lock!=null){
    	    synchronized(lock){ // To lock the object if the process base on same ID
    	    	Balance bal = accountMap.get(acId);
    	    	if(bal!=null){
    	    	    bal.setBalance(amount,type);
    	    	    accountMap.put(acId,bal);
    	    	}
    	    	else{
    	    	    bal = new Balance();
    	    	    System.out.println(acId+" "+type+" "+amount);
    	    	    bal.setBalance(amount,type);
    	    	    accountMap.put(acId,bal);
    	    	}
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
