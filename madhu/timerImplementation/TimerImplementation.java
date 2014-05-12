package org.thread.timerImplementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class TimerImplementation {

	public BufferedReader remainder;
	public static List<BirthdayRemainder> list = new ArrayList<BirthdayRemainder>();
	Main tc = new Main();
	Date date ;


	public List<BirthdayRemainder> readFile(File file) throws NumberFormatException, IOException, ParseException {

		remainder = new BufferedReader(new FileReader(file));
		String line;

		while ((line = remainder.readLine()) != null) {

			BirthdayRemainder remainder = new BirthdayRemainder();

			StringTokenizer st = new StringTokenizer(line);

			while (st.hasMoreTokens()) {

				//Name
				String name =st.nextToken();
				remainder.setName(name);
				System.out.print(name);

				//Date
				String dateString =st.nextToken();

				//Time
				String timeString =st.nextToken();

				Timestamp ts = Timestamp.valueOf(dateString+" "+timeString);
				remainder.setTimestamp(ts);
				System.out.println(ts);

				list.add(remainder);

			}
		}

		return list;
	}

	public void remainder(){

		Iterator<BirthdayRemainder> i = list.listIterator();

		while(i.hasNext()){

			BirthdayRemainder remainder =i.next();
			long wishingTime=remainder.timestamp.getTime()-System.currentTimeMillis();

			if(wishingTime>=0){
				synchronized (tc) {

					try {
						tc.wait(wishingTime);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Best Wishes... "+remainder.name);
				}
			}
		}

	}
}