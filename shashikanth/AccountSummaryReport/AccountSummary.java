package com.val.Acc;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountSummary 
{
   public static void main(String[]args) throws NumberFormatException, IOException
   {
	   String fileName=args[0];
	   List<Account> acclist=Account.readDetails(fileName);
	   Map<Integer,Integer> ht=new Hashtable<Integer, Integer>();
	   for(int i=0;i<acclist.size();i++)
	   {
			   ht.put(acclist.get(i).getAccId(),Account.currentBalance(acclist,acclist.get(i).getAccId()));
	   }
	   System.out.println("AccoutId\tCurrentBalance");
	   for(Map.Entry<Integer, Integer> entry:ht.entrySet())
	   {
		   int accountId=entry.getKey();
		   int currentBalance=entry.getValue();
		   System.out.println(accountId+"\t\t"+currentBalance);
	   }
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter account id:");
	   int acid=sc.nextInt();
	   System.out.println("Current Balance:"+ht.get(acid));
   }
}
