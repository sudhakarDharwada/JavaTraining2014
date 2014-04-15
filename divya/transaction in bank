import java.util.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.Map.Entry;


public class BankTransaction{

   public static void main(String args[]){
 
      Hashtable<Integer, Double> bankAccount=new Hashtable<Integer, Double>();
      Scanner s = new Scanner(System.in);
      System.out.println("Enter The Input file");
      String File = s.next();
     
      AccountDetails ad=new AccountDetails();
      ad.readAccountDetails(File,bankAccount);
      ad.printAccountDetails(bankAccount);
   }
}	


class AccountDetails{

   void readAccountDetails(String File,Hashtable bankAccount){
      int accnum=0;
      double bal=0;
      String line=null;
    
      try{
             
        BufferedReader input = new BufferedReader(new FileReader(File));
        while ((line=input.readLine())!=null){
	         
           StringTokenizer st = new StringTokenizer(line," ");
           String arr[] = new String[st.countTokens()]; 
           int i=0;
           while (st.hasMoreElements()) {
              arr[i] = st.nextToken();
              i++;
           }
             
           accnum=Integer.parseInt(arr[0]);
           String Status = arr[1];
           bal=Double.parseDouble(arr[2]);
              
           if(bankAccount.containsKey(accnum)){
               if(Status.equalsIgnoreCase("deposit")){
                    bankAccount.put(accnum,(double)bankAccount.get(accnum)+bal);
               }

               else if(Status.equalsIgnoreCase("withdrawal")){ 
                    bankAccount.put(accnum,(double)bankAccount.get(accnum)-bal);
               }
           }

           else{
              bankAccount.put(accnum,bal);	
           }
        }
      }
      
      catch (Exception e1) {
         e1.printStackTrace();
         
      }
  }


  public void printAccountDetails(Hashtable<Integer, Double> bankAccount) {
      System.out.println("\nAccount details are\n");
      for (Entry<Integer, Double> entry : bankAccount.entrySet()) {
	 int accnum = entry.getKey();
	 double bal = entry.getValue();
	 System.out.println("The Account no:" + accnum + " Amount:"+ bal);
      }
  }

}

