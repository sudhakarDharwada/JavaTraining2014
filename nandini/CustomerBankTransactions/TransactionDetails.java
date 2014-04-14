import java.util.Hashtable;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.io.*;
public class TransactionDetails{
	public static void main(String args[])
	{
		Hashtable<Integer,Double> details=new Hashtable<Integer,Double>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file name to read");
		String Filename=sc.next();
		TransactionDetails td=new TransactionDetails();
		try{
			details = td.br(Filename,details);
			td.AccountDetails(details);
		}
		catch(NumberFormatException e1){
			e1.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void AccountDetails(Hashtable<Integer,Double> details){
		System.out.println("\nDetails of Bank accounts");
		int accountno;
		double amount;
		for(Entry<Integer,Double> entry : details.entrySet()){
			accountno=entry.getKey();
			amount=entry.getValue();
			System.out.println(" Amount in the "+ accountno +"is "+ amount);	
		}
	}
	public Hashtable<Integer,Double> br(String Filename, Hashtable<Integer,Double> details)throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new FileReader(Filename));
		String str=null;
		double bal=0.0;
		int i;
		String list[]=new String[3];
		while((str=br.readLine())!=null){
			StringTokenizer st = new StringTokenizer(str, ",");
			for(i=0;st.hasMoreTokens();i++){
				list[i]=st.nextToken();
				System.out.print(list[i]);				
			}
			System.out.println(" ");
			if( list[0] != null)
			{
				int account=Integer.parseInt(list[0]);
				String status=list[1];
				double amount=Double.parseDouble(list[2]);
				if(details.containsKey(account)){
					details=Transaction(details,account,status,amount);
				}
				else{
					details.put(account,bal);
					details=Transaction(details,account,status,amount);
				}
			}
		}
		br.close();
		return details;
	}

	public Hashtable<Integer,Double> Transaction(Hashtable<Integer,Double> details,int account,String status,double amount){
		if (status.equalsIgnoreCase("withdraw")){
			details.put(account, details.get(account) - amount);
		}
		else {
			details.put(account,details.get(account)+amount);
		}
		return details;
	}					
}
