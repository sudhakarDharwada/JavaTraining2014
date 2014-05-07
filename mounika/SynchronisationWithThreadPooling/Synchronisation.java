package transactiondetails;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronisation {
	public static void main(String[] args) throws InterruptedException {
		String foldername = "BankFiles";
		File folder = new File(foldername);
		File[] listoffiles = folder.listFiles();
		int n = listoffiles.length;
		System.out.println(n);

		ExecutorService executor = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 4; i++) {
			Runnable ListOfFiles = new ListOfFiles(listoffiles[i].getAbsolutePath());
			executor.execute(ListOfFiles);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");
		Transaction.finalAmount();
	}
}
