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
		Hashtable<Integer, Double> accountInfo=new Hashtable<Integer, Double>();
		/* reading a file*/
		if (0 < args.length) {
			inFile = new File(args[0]);
			AccountSummary as=new AccountSummary();
			as.readingAccountsToHashtable(inFile,accountInfo);
			as.printAccountSummary(accountInfo);				
		}
		else{
			System.out.println("please enter a file name while running");
		}
	}
}

class AccountSummary{
	/* Read account information into hash table*/
	void readingAccountsToHashtable(File inFile,Hashtable accountInfo){
		BufferedReader br = null;
		String line;
		int acc=0;
		double bal=0;
		String[] e=new String[3];
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
				bal=Double.parseDouble(e[2]);
				if(accountInfo.containsKey(acc))
				{
					if(e[1].equalsIgnoreCase("deposit"))
					{
						accountInfo.put(acc,(double)accountInfo.get(acc)+bal);
						
					}
					else {
						accountInfo.put(acc,(double)accountInfo.get(acc)-bal);
					}
				}
				else{
					accountInfo.put(acc,bal);					
				}
			}	
		}
		catch (Exception e1) {
			e1.printStackTrace();
		} 		
	}
	/*For printing the summary of account information*/
	void printAccountSummary(Hashtable accountInfo){
		Enumeration accounts=accountInfo.keys();
		System.out.println("The Account details are");
		//accounts=accountInfo.keys();
		while(accounts.hasMoreElements()) {
			int account = (int)accounts.nextElement();
			System.out.println(account + ": " +accountInfo.get(account));
		}	
	}
}
