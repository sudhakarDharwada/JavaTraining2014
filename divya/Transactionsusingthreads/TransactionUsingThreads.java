import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.NullPointerException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map.Entry;
import java.util.Scanner;

class TransactionUsingThreads{
     public static void main(String[] args) {
        TransactionUsingThreads tu=new TransactionUsingThreads();
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a folder name");
	String name=s.next();
	File  dir=new File(name);
	if(dir.isDirectory()){
	   File[] list_of_files = dir.listFiles();
	   BankTransaction acc[]=new BankTransaction[list_of_files.length]; 
	   Thread t[]=new Thread[list_of_files.length];
	   for(int i=0;i<list_of_files.length;i++){
	     if(list_of_files[i].isFile())
	     acc[i] = new BankTransaction(map);
	     t[i]=new Thread(acc[i]);
	     try{
		t[i].start();
	     }
	     catch(Exception e1){
	        e1.printStackTrace();
	     }					
	  } 
			
	  for(int j=0;j<list_of_files.length;j++){
	    try{
              t[j].join();
            }
            catch(InterruptedException e) {
              e.printStackTrace();
            }
	  }   
       }
       tu.printAccountDetails(map);
     }
     public void printAccountDetails(HashMap<Integer, Integer> map) {	
        for (Entry<Integer, Integer> entry : map.entrySet()) {
           Integer Account = entry.getKey();
	   Integer balance = entry.getValue();
	   System.out.println("The Account no:" + Account + " has amount:"+ balance);
	}
    }
}

