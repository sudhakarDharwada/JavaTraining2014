package transactiondetails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Transaction {
	public static void main(String[] args) throws FileNotFoundException {
		Transaction t = new Transaction();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter File name");
		String filename = sc.next();

		Map<Integer, CurrentBalance> ht = t.transactionDetailes(filename);
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

	public Map<Integer, CurrentBalance> transactionDetailes(String filePath)
			throws FileNotFoundException {
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		Scanner sc = new Scanner(br);
		Map<Integer, CurrentBalance> ht = new Hashtable<Integer, CurrentBalance>();
		while (sc.hasNext()) {
			String Id = sc.useDelimiter(" ").next().trim();
			int accId = Integer.parseInt(Id);
			String status = sc.useDelimiter(" ").next();
			String amount = sc.useDelimiter("\n").next().trim();
			int money = Integer.parseInt(amount);

			CurrentBalance ad = ht.get(accId);
			if (ad == null) {
				CurrentBalance as = new CurrentBalance(money);
				ht.put(accId, as);
			} else {
				if (status.equals("deb")) {
					ad.deposit(money);
				} else if (status.equals("crd")) {
					ad.withdraw(money);
				}

			}
		}
		return ht;

	}

}
