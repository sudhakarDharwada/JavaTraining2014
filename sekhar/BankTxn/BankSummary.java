import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class BankSummary {
	public static void main(String args[]){
		try
		{
			BankSummary bs=new BankSummary();
			String fname=args[0];
			HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
			map=bs.readinput(fname);
			Scanner sc1=new Scanner(System.in);
			String ch="y";
			while(ch.equalsIgnoreCase("y"))
			{
				System.out.println("enter the account number");
				int accountno=sc1.nextInt();
				System.out.println(map.get(accountno));
				if(map.containsKey(accountno)){
					int balance=map.get(accountno);
					System.out.println("the balance of "+accountno+"accountno is:"+balance);
				}
				else{
					System.out.println("no account number");
				}
				System.out.println("Do you want once ? plz press 'y' ");
				ch=sc1.next();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public HashMap<Integer, Integer> readinput(String fname) throws FileNotFoundException {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		FileReader fr = new FileReader(fname);
		Scanner sc =new Scanner(new BufferedReader(fr));
		int bal=0;
		int amt=0;
		while(sc.hasNext())
		{
			int act=Integer.parseInt(sc.useDelimiter(" ").next().trim());
			String status=sc.useDelimiter(" ").next();
			amt=Integer.parseInt(sc.useDelimiter("\n").next().trim());
			if(map.containsKey(act)){
				if(status.equalsIgnoreCase("Deposit"))
					map.put(act,map.get(act)+amt);
				else
					map.put(act, map.get(act)-amt);
			}
			else
			{
				map.put(act, bal);
				if(status.equalsIgnoreCase("Deposit"))
					map.put(act,map.get(act)+amt);
				else
					map.put(act, map.get(act)-amt);
			}
		}
		System.out.println(map);
		return map;

	}
}
