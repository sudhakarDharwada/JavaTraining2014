package com.snapfish.banktransaction.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map.Entry;

public class BankTransaction {
	/*The Main method*/
	public static void main(String[] args) {
		Hashtable<Integer, Double> UserAccounts = new Hashtable<Integer, Double>();
		Scanner s = new Scanner(System.in);
		/*Read the File*/
		System.out.print("Enter The Input file path:");
		String FilePath = s.next();

		BankTransaction bt = new BankTransaction();
		try {
			UserAccounts = bt.input(FilePath, UserAccounts);
			bt.summary(UserAccounts);
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}
	/*This method diplays all Account details*/
	public void summary(Hashtable<Integer, Double> userAccounts) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<Integer, Double> entry : userAccounts.entrySet()) {
			int Account = entry.getKey();
			double Amount = entry.getValue();
			System.out.println("The Account no:\t" + Account + "\t Amount:\t"
					+ Amount);
		}
	}
	/*This method read the file and perform creation of new account and transaction operations*/
	public Hashtable<Integer, Double> input(String filePath,
			Hashtable<Integer, Double> UserAccounts)
			throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(filePath));
		String str = null;
		double bal = 0.0;
		String arg[] = new String[3];
		StringTokenizer sTokenizer = null;
		while ((str = input.readLine()) != null) {
			sTokenizer = new StringTokenizer(str, ",");
			for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
				arg[i] = sTokenizer.nextToken();
			}
			if (arg[0] != null) {
				int AccountNo = Integer.parseInt(arg[0]);
				String transaction = arg[1];
				double Amount = Double.parseDouble(arg[2]);
				/*This if condition checks whether the account is exist or not*/
				if (UserAccounts.containsKey(AccountNo)) {
					/*Account is exist so, we perform transaction*/
					UserAccounts = Transaction(UserAccounts, AccountNo, Amount,
							transaction);
				} else {
					/*Account is not exist so we creating an Account*/
					UserAccounts.put(AccountNo, bal);
					/*we perform transaction*/
					UserAccounts = Transaction(UserAccounts, AccountNo, Amount,
							transaction);
				}
			}
		}
		input.close();
		return UserAccounts;
	}
	/*This method perform transaction*/
	public Hashtable<Integer, Double> Transaction(
			Hashtable<Integer, Double> UserAccounts, int AccountNo,
			double amount, String transaction) {
		if (transaction.equalsIgnoreCase("deposite")) {
			UserAccounts.put(AccountNo, UserAccounts.get(AccountNo) + amount);
		} else if (transaction.equalsIgnoreCase("withdraw")) {
			UserAccounts.put(AccountNo, UserAccounts.get(AccountNo) - amount);
		}
		return UserAccounts;
	}

}
