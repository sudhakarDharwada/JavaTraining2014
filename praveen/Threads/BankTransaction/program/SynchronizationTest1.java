package bankTransactionSampleProject.testcases;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;

public class SynchronizationTest1 {

	public static void main(String[] args) {
		SynchronizationTest1 st1=new SynchronizationTest1();
		Hashtable<String, Double> userAccount = new Hashtable<String, Double>();
		if (args.length != 1) {
			System.err
					.println("Invalid command line, exactly one argument required");
			System.exit(1);
		}
		String FilePath = args[0];
		File folder = new File(FilePath);
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();

		for (File file : listOfFiles) {
			if (file.isFile()) {
				MyThread t = new MyThread(file.getAbsolutePath(), userAccount);
				t.start();
				list.add(t);
			}
		}
		for (Thread t : list) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		st1.summary(userAccount);
		System.out.println("Main completed");
		if (userAccount != null) {
			userAccount = null;
		}
		
	}
	public void summary(Hashtable<String, Double> hashtable) {
		System.out.println("\n\n\tSummary\n");
		for (Entry<String, Double> entry : hashtable.entrySet()) {
			String Account = entry.getKey();
			double Amount = entry.getValue();
			System.out.println("The Account Id:\t" + Account + "\t\tAmount:\t"
					+ Amount);
		}
	}

}
