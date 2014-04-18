package org.bank.transaction;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class BankAccountTransaction {

	public Map<Integer, AccountStatus> transactionDetailes(String filePath) throws FileNotFoundException{

		FileReader fr=new FileReader(filePath);
		BufferedReader br=new BufferedReader(fr);
		Scanner sc=new Scanner(br);
		Map<Integer,AccountStatus> ht=new Hashtable<Integer, AccountStatus>();

		while(sc.hasNext()){
			String Id=sc.useDelimiter(" ").next().trim();
			int accId=Integer.parseInt(Id);
			String status=sc.useDelimiter(" ").next();
			String amount=sc.useDelimiter("\n").next().trim();
			int money=Integer.parseInt(amount);

			BankAccount ac=new BankAccount();
			ac.setAccId(accId);
			ac.setAmount(money);
			ac.setStatus(status);
			System.out.println(ac.getAccId()+" "+ac.getAmount()+" "+ac.getStatus());


			AccountStatus ad = ht.get(accId);
			if(ad==null){
				AccountStatus as=new AccountStatus(money);
				ht.put(accId, as);
			}
			else{
				if(ht.containsKey(accId) && status.equals("deposit")){
					ad.deposit(money);
				}
				else if(ht.containsKey(accId) && status.equals("withdraw")){
					ad.withdraw(money);
				}

			}
		}
		return ht;

	}
	public static void main(String[] args) {
		BankAccountTransaction bad=new BankAccountTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter File Location");
		String filePath=sc.next();
		try {
			Hashtable<Integer,AccountStatus> ht=(Hashtable<Integer, AccountStatus>) bad.transactionDetailes(filePath);
			Iterator<?> iter = ht.entrySet().iterator();
			while (iter.hasNext()) {
				@SuppressWarnings("unchecked")
				Map.Entry<Integer,AccountStatus> entry = (Map.Entry<Integer, AccountStatus>) iter.next();
				System.out.println(entry.getKey()+" Avalible Balance in Account"+entry.getValue().amount);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("please enter file location");
			//e.printStackTrace();
		}

	}

}
