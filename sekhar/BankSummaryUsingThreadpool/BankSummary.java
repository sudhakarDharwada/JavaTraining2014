package com.vlabs.BankTxn;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.vlabs.BankTxn.AccountDetails.AccountDetails;
import com.vlabs.BankTxn.MyThread.MyThread;
public class BankSummary {
	public static void main(String[] args) {
		BankSummary bs=new BankSummary();
		HashMap<Integer, AccountDetails>map = new HashMap<Integer, AccountDetails>();
		File folder = new File("/home/administrator/Desktop/bank1");
		File[] listOfFiles = folder.listFiles();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t = new MyThread(file.getAbsolutePath(), map);
				executor.execute(t);
			}
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		bs.printentries(map);
	}
	public void printentries(HashMap<Integer, AccountDetails> HashMap) {
		System.out.println("\nSummary:");
		for (Entry<Integer, AccountDetails> entry : HashMap.entrySet()) {
			AccountDetails Amount = entry.getValue();
			System.out.println("The Account Id:\t" + Amount.getAccountId() + "\tAmount:" + Amount.getAmount());
		}
	}
}
