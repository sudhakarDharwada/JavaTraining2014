package org.bank.detailes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BankAccountDetailes {
	public void readBankDetailes(String filePath) throws FileNotFoundException{
		FileReader fr=new FileReader(filePath);
		BufferedReader br=new BufferedReader(fr);
		Scanner sc=new Scanner(br);
		List<BankAccount> list=new ArrayList<BankAccount>();
		Map<Integer,ArrayList<BankAccount>> map=new HashMap<Integer, ArrayList<BankAccount>>();


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

			list.add(ac);
			map.put(accId, (ArrayList<BankAccount>) list);

		}
		transactionDetailes(map,list);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void transactionDetailes(Map<Integer, ArrayList<BankAccount>> map,List<BankAccount> list){
		Iterator<?> iter = map.entrySet().iterator();
		int money=0,amount=0;
		int result;
		System.out.println("**********************************************");
		System.out.println("final summary processing");

		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			int key=(Integer) entry.getKey();
			list=(ArrayList<BankAccount>)entry.getValue();

			for(BankAccount bank:list){
				BankAccount ba=(BankAccount)bank;

				if(key==ba.getAccId()&&ba.getStatus().equals("deposit")){
					money=money+ba.getAmount();
					//System.out.println(key+": deposit :"+money);
					//money=0;
				}
				else if(key==ba.getAccId()&&ba.getStatus().equals("withdraw")){
					amount=money-ba.getAmount();
					//System.out.println(key+": withdraw :"+amount);
					money=0;
				}
			}
			result=money-amount;
			int balance=Math.abs(result);
			System.out.println(balance+": final balance for account :"+key);
			money=0;
			amount=0;
		}
	}
	public static void main(String[] args) {
		BankAccountDetailes bad=new BankAccountDetailes();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter File Location");
		String filePath=sc.next();
		try {
			bad.readBankDetailes(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
