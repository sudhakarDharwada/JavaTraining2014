
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.text.ParseException;
import java.util.Comparator;
import java.util.Scanner;

 public class BirthdayWish{
   public static void main(String[] args) throws NumberFormatException, IOException, ParseException{
     Scanner in = new Scanner(System.in);
     System.out.println("Enter filename with list of birthdays");
     String s = in.next();
     File file = new File(s);
     Timer tm = new Timer();
     List<BirthdayDetails> list = tm.readFile(file);
     Collections.sort(list,new Sort());
     tm.reminder();	
   }
 }


 class Sort implements Comparator<BirthdayDetails>{
   public int compare(BirthdayDetails bd1, BirthdayDetails bd2){
      return bd1.timestamp.compareTo(bd2.timestamp);
   }	
 }
