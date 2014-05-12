import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class FileReader1 {

	public List<BirthDetails> birthDetails(String fname) throws FileNotFoundException, ParseException {
		List<BirthDetails>bd=new ArrayList<BirthDetails>();
		BirthDetails b=null;
		FileReader fr=new FileReader(fname);
		Scanner sc=new Scanner(new BufferedReader(fr));
		while(sc.hasNext()){
			String name=sc.useDelimiter(" ").next();
            		String dates=sc.useDelimiter("\n").next();
                        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	        //Date d=formatter.parse(date);
            		@SuppressWarnings("deprecation")
			long date=Date.parse(dates);
        		Date d=new Date(date);
            		b=new BirthDetails(name, d);
            		bd.add(b);
		}
		return bd;
	}

}


