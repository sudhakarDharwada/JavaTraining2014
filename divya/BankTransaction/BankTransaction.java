import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.io.*;

public class BankTransaction{

   public static void main(String args[]){
 
      Hashtable<Integer, Double> bankAccount=new Hashtable<Integer, Double>();
      Scanner s = new Scanner(System.in);
      System.out.println("Enter The Input file");
      String File = s.next();
     
      BankTransaction bt=new BankTransaction();
      try{
	bankAccount = bt.input(File,bankAccount);
        bt.printAccountDetails(bankAccount);
      }
      catch(NumberFormatException e){
	e.printStackTrace();
      }
      catch(IOException e1){
        e1.printStackTrace();
      }
		
    }
	

    public Hashtable<Integer,Double> input(String File, Hashtable<Integer,Double> bankAccount)throws NumberFormatException, IOException{
    
      int accnum=0;
      double bal=0;
      String line=null;
      double amount=0.0;     
       
      BufferedReader input = new BufferedReader(new FileReader(File));
      String arr[]=new String[3];

      while((line=input.readLine())!=null){
	StringTokenizer st = new StringTokenizer(line, " ");
	for(int i=0;st.hasMoreTokens();i++){
	   arr[i]=st.nextToken();
	}

        if( arr[0] != null)  {
          accnum=Integer.parseInt(arr[0]);
          String Status = arr[1];
          bal=Double.parseDouble(arr[2]);
           
          if(bankAccount.containsKey(accnum)){
	    bankAccount=Transaction(bankAccount,accnum,Status,bal);
	  }
	  else{
	    bankAccount.put(accnum,amount);
	    bankAccount=Transaction(bankAccount,accnum,Status,bal);
	  }
        }
      }
      input.close();
      return bankAccount;
    }

    public Hashtable<Integer,Double> Transaction(Hashtable<Integer,Double> bankAccount,int accnum,String Status,double bal){
       if (Status.equalsIgnoreCase("withdrawal")){
	  bankAccount.put(accnum, bankAccount.get(accnum) - bal);
       }
       else if (Status.equalsIgnoreCase("deposit")){
	  bankAccount.put(accnum,bankAccount.get(accnum) + bal);
       }
       return bankAccount;
    }

    public void printAccountDetails(Hashtable<Integer, Double> bankAccount) {
      System.out.println("\nAccount details are\n");
      for (Entry<Integer, Double> entry : bankAccount.entrySet()) {
	 int accnum = entry.getKey();
	 double bal = entry.getValue();
	 System.out.println("The Account no:" + accnum + " has amount:"+ bal);
      }
    }
}



