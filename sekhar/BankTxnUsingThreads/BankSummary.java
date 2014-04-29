import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;
class BankSummary
{
	public static void main(String[] args) {
		BankSummary bs=new BankSummary();
		HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
		File folder = new File("/home/administrator/Desktop/bank1");
		File[] listOfFiles = folder.listFiles();
		List<Thread> list = new ArrayList<Thread>();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				BankThread t = new BankThread(map,file.getAbsolutePath());
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
		bs.printentries(map);
	}
	public void printentries(HashMap<Integer, Integer> map) {
		System.out.println("\nSummary:");
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			Integer Account = entry.getKey();
			Integer balance = entry.getValue();
			System.out.println("The Account no:" + Account + " Amount:"+ balance);
		}
	}
}
class BankThread extends Thread {
	static HashMap<Integer, Integer> map;
	private String filepath;
	public BankThread(HashMap<Integer, Integer> maps,String filepath)
	{
		map=maps;
		this.filepath=filepath;

	}
	public void run() {
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filepath));
			String str = null;
			String arg[] = new String[3];
			StringTokenizer sTokenizer = null;
			while ((str = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg[i] = sTokenizer.nextToken();
				}
				if (arg[0] != null) {
					int AccountNo = Integer.parseInt(arg[0]);
					String status = arg[1];
					int Amount = Integer.parseInt(arg[2]);
					System.out.println(AccountNo+" "+status+" "+Amount+":"+currentThread().getName());
					calculate(AccountNo,status,Amount);
				}
			}
		} 
		catch (NumberFormatException e) {
			// TODO: handle exception
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  calculate(Integer accountNo, String status, Integer amount) {
		int bal=0;
		synchronized (accountNo) {
			Integer initialAmount = map.get(accountNo);
			if (initialAmount != null) {
				if (status.equalsIgnoreCase("deposite")) {
					map.put(accountNo, initialAmount + amount);
				} else if (status.equalsIgnoreCase("withdraw")) {
					map.put(accountNo, initialAmount - amount);
				}
			}
			else {
				map.put(accountNo, bal);
				initialAmount=bal;
				if (status.equalsIgnoreCase("deposite")) {
					map.put(accountNo, initialAmount + amount);
				} else if (status.equalsIgnoreCase("withdraw")) {
					map.put(accountNo, initialAmount - amount);
				}
			}
		}
	}

}
