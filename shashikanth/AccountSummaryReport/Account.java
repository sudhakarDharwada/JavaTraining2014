package com.val.Acc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Account
{
	private int accId;
	private String transaction;
	private int amount;
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public static List<Account> readDetails(String filename) throws NumberFormatException, IOException 
	{
		List<Account> acclist=new ArrayList<Account>();
		File file=new File(filename);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String read=null;boolean isFirstLine=true;
		while((read=br.readLine())!=null)
		{
			if(!isFirstLine)
			{
				StringTokenizer token=new StringTokenizer(read.trim());
				 while(token.hasMoreTokens())
				 {
					Account acc=new Account();
					acc.accId=Integer.parseInt(token.nextToken());
					acc.transaction=token.nextToken();
					acc.amount=Integer.parseInt(token.nextToken());
					acclist.add(acc);
				 }  
			 }
			 isFirstLine=false;
		}
		return acclist;
	}
	public static Integer currentBalance(List<Account> acclist,int acId) 
	{
		int currentBalance=0;
	
			for(int i=0;i<acclist.size();i++)
			{
				if(acId==acclist.get(i).getAccId())
				{
		          if(("withdraw".equalsIgnoreCase(acclist.get(i).getTransaction())))
		          {
			        currentBalance-=acclist.get(i).getAmount();
			        
		          }
		          else if("deposit".equalsIgnoreCase(acclist.get(i).getTransaction()))
		          {
			        currentBalance+=acclist.get(i).getAmount();
		          }   
				}
			}
		return currentBalance;
	}
}