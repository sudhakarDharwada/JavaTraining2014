package org.thread.sync;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.thread.sync.AccountStatus;

public class Main extends Thread {
	File file;
	public Main(File file){
		this.file=file;
	}
	public void run(){
		try {
			readFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	static Map<Integer,AccountStatus> ht=new Hashtable<Integer, AccountStatus>();

	@SuppressWarnings("null")
	public void readFile() throws FileNotFoundException{

		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		Scanner sc=new Scanner(br);
		while(sc.hasNext()){
			String Id=sc.useDelimiter(" ").next().trim();
			int accId=Integer.parseInt(Id);
			String status=sc.useDelimiter(" ").next();
			String amount=sc.useDelimiter("\n").next().trim();
			int money=Integer.parseInt(amount);


			AccountStatus ad = ht.get(accId);
			if(ad==null){
				synchronized (ht) {
					AccountStatus aad = ht.get(accId);

					if(aad == null){
						AccountStatus as=new AccountStatus(money);
						//System.out.println("first ..."+ as.amount);
						ht.put(accId, as);
					}
					else{ 
						if(status.equals("deposit")){
							ad.deposit(money);
							//System.out.println("deposit called");
						}
						else if(status.equals("withdraw")){
							ad.withdraw(money);
							//System.out.println("withdraw called");
						}
					}
				}
			}
			else{
				synchronized (ad) {
					if(status.equals("deposit")){
						ad.deposit(money);
						//System.out.println("deposit called");
					}
					else if(status.equals("withdraw")){
						ad.withdraw(money);
						//System.out.println("withdraw called");
					}
					//System.out.println("synchronized"+ad);
				}
			}
		}
	}

	public static void bankTransactionDetailes(){
		Iterator<?> iter = ht.entrySet().iterator();
		while (iter.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<Integer,AccountStatus> entry = (Map.Entry<Integer, AccountStatus>) iter.next();
			System.out.println(entry.getKey()+" Avalible Balance in Account"+entry.getValue().amount);
		}

	}
}
