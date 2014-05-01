package transactiondetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

class Transaction {
	static Map<Integer, CurrentBalance> ht = new Hashtable<Integer, CurrentBalance>();
	

	public static Map<Integer, CurrentBalance> transactionDetailes(
			String filePath) throws FileNotFoundException {
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(br);
		while (sc.hasNext()) {
			String Id = sc.useDelimiter(" ").next().trim();
			int accId = Integer.parseInt(Id);
			String status = sc.useDelimiter(" ").next();
			String amount = sc.useDelimiter("\n").next().trim();
			int money = Integer.parseInt(amount);
			CurrentBalance ad = null;
			ad = ht.get(accId);
			if(ad==null)
			{
			
			synchronized (ht)
			
			{
				System.out.println("Thread Entered Synchronised Block");
				System.out.println(Thread.currentThread());
			ad=ht.get(accId);
			CurrentBalance bal=null;
			if(ad==null)
			{
				if (status.equals("deb"))
			{
					bal=new CurrentBalance(0+money);

			}
			else if((status.equals("crd")))
			{
			bal=new CurrentBalance(0-money);
			}
			ht.put(accId, bal);
			}
			else
			{
//				if (status.equals("deb")) {
//					synchronized (ad) {
//						
//						ad.deposit(money);
//						
//					}
//				} else if (status.equals("crd")) {
//					synchronized (ad) {
//						ad.withdraw(money);
//						System.out.println("End Of The Synchinisation");
//					}
//				}

				updateBalance(status,ad,money);
			}System.out.println("End of the Synchronised Block");
			}
			
			}
			else
			{
				updateBalance(status,ad,money);
			}

			}
		return ht;
			}
			
			  
			
	private static void updateBalance(String status, CurrentBalance ad,
			int money) {

		if (status.equals("deb")) {
			synchronized (ad) {
				System.out.println(Thread.currentThread());
				System.out.println("Thread Entered Synchronised Block");
				ad.deposit(money);
				System.out.println("End Of The Thread");
			}
		} else if (status.equals("crd")) {
			synchronized (ad) {
				System.out.println("Thread Entered");
				ad.withdraw(money);
				System.out.println("End Of The Synchinisation");
			}
		}

	}

	public static void finalAmount() {
		 Scanner sc = new Scanner(System.in);

		for (Entry<Integer, CurrentBalance> entry : ht.entrySet()) {
			System.out.println("AccountNumber : " + entry.getKey()
					+ " CurrentBalance : " + entry.getValue().amount);
		}
		System.out.println("enter account number");
		int accountnum = sc.nextInt();
		if (ht.containsKey(accountnum)) {
			System.out.println(ht.get(accountnum).amount);
		} else {
			System.out.println("accountnumber does not exist");
		}

	}

}
