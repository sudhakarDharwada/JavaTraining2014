import java.io.BufferedReader;
import java.io.File;
import java.util.Date;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class Timer{
  public static List<BirthdayDetails> list = new ArrayList<BirthdayDetails>();
  BirthdayWish wish = new BirthdayWish();
  Date date ;

  public List<BirthdayDetails> readFile(File file) throws NumberFormatException, IOException, ParseException {
    BufferedReader br = new BufferedReader(new FileReader(file));
    String line;

    while ((line = br.readLine()) != null) {
      BirthdayDetails bd = new BirthdayDetails();
      StringTokenizer st = new StringTokenizer(line);
      while (st.hasMoreTokens()) {
         String name =st.nextToken();
	 bd.setName(name);
	 String dateString =st.nextToken();
         String timeString =st.nextToken();
         Timestamp ts = Timestamp.valueOf(dateString+" "+timeString);
	 bd.setTimestamp(ts);
	 list.add(bd);

      }
    }
    return list;
  }

  public void reminder(){
    Iterator<BirthdayDetails> i = list.listIterator();
    while(i.hasNext()){
      BirthdayDetails bd =i.next();
      long wishTime=bd.timestamp.getTime()-System.currentTimeMillis();
      if(wishTime>=0){
	 synchronized (wish){
            try{
	      wish.wait(wishTime);
	    }
            catch (InterruptedException e){
	      e.printStackTrace();
	    }
	    System.out.println("Happy Birthday  "+bd.name);
	 }
      }
    }
  }
}
