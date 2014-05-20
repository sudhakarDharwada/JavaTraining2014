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
import java.util.Scanner;

public class BankTransaction extends Thread {
    static HashMap<Integer, Integer> map;
    private String filepath;
    public BankTransaction(HashMap<Integer, Integer> map){
		this.filepath=filepath;
    }
    public void run() {
      BufferedReader input = null;
      try {
	input = new BufferedReader(new FileReader(filepath));
	String line = null;
	String arr[] = new String[3];
	StringTokenizer st = null;
	while ((line = input.readLine()) != null) {
	  st = new StringTokenizer(line, " ");
	  for (int i = 0; st.hasMoreTokens(); i++) {
	    arr[i] = st.nextToken();
	  }
	  if (arr[0] != null) {
	     int accnum = Integer.parseInt(arr[0]);
	     String status = arr[1];
	     int Amount = Integer.parseInt(arr[2]);
	     balCalculation(accnum,status,Amount);
	  }
	}
      } 
      catch (NullPointerException e) {
	e.printStackTrace();
      }
      catch (NumberFormatException e) {
	e.printStackTrace();
      }
      catch (FileNotFoundException e) {
	e.printStackTrace();
      }
      catch (IOException e) {
	e.printStackTrace();
      }
      
    }
    public static void  balCalculation(Integer accnum, String status, Integer amount) {
	int bal=0;
	synchronized (accnum) {
	   Integer Amnt = map.get(accnum);
	   if (Amnt != null) {
	      if (status.equalsIgnoreCase("deposit")) {
	        map.put(accnum, Amnt + amount);
              } 
              else if (status.equalsIgnoreCase("withdrawal")) {
		map.put(accnum, Amnt - amount);
	      }
	   }
	   else {
	      map.put(accnum, bal);
	      Amnt=bal;
	      if (status.equalsIgnoreCase("deposit")) {
		map.put(accnum, Amnt + amount);
	      } 
              else if (status.equalsIgnoreCase("withdrawal")) {
		map.put(accnum, Amnt - amount);
	      }
	   }
        }
     }

}

