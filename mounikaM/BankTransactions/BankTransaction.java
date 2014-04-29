import java.util.Hashtable;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;
public class BankTransaction{
	public static void main(String args[])
	{
		File inFile =null;
		int accountId;
		double balance;
		/* reading a file*/
		if (0 < args.length) {
			inFile = new File(args[0]);
			AccountSummary as=new AccountSummary();
			as.readingAccountsToHashtable(inFile);
			as.printAccountSummary();				
		}
		else{
			System.out.println("please enter a file name while running");
		}
	}
}

class AccountSummary{
	Hashtable<Integer, Account> accountInfo=new Hashtable<Integer, Account>();
	/* Read account information into hash table*/
	void readingAccountsToHashtable(File inFile){
		BufferedReader br = null;
		String line;
		int acc=0;
		double bal=0;
		String[] e=new String[3];
		String trans_type;
		try{
			br = new BufferedReader(new FileReader(inFile));
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line," ");
				int i=0;
				while (st.hasMoreElements()) {
					String d=(String)st.nextElement();
					e[i]=d;
					i++;
				}
				acc=Integer.parseInt(e[0]);
				trans_type=e[1];
				bal=Double.parseDouble(e[2]);
				Account  b=accountInfo.get(acc);
    	    	if(b!=null){
    	    	    b.setBalance(bal,trans_type);
    	    	    accountInfo.put(acc,b);
    	    	}
    	    	else{
    	    	    b = new Account();
    	    	    b.setBalance(bal,trans_type);
    	    	    accountInfo.put(acc,b);
    	    	}
    	    }
		}
		catch (Exception e1) {
			e1.printStackTrace();
		} 		
	}
	/*For printing the summary of account information*/
	void printAccountSummary(){
		Enumeration accounts=accountInfo.keys();
		System.out.println("The Account details are");
		while(accounts.hasMoreElements()) {
			int account = (int)accounts.nextElement();
			System.out.println(account + ": " +accountInfo.get(account));
		}	
	}
}
