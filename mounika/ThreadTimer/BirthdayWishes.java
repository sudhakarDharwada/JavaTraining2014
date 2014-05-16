package FirstTimer;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BirthdayWishes {

	public static List<BirthDayDetails> BirthDayList = new ArrayList<BirthDayDetails>();
	BirthDay bd = new BirthDay();

	public  void birthDayFile() throws FileNotFoundException

	{

		String file = "BirthdayFile";
		File f = new File(file);

		Scanner sc = new Scanner(f);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] details = line.split(" ");
			String name = details[0];
			String date = details[1];
			String time = details[2];
			Timestamp t = Timestamp.valueOf(date + " " + time);
			// System.out.println( t);


			BirthDayDetails bdd = new BirthDayDetails(name, t);
			BirthDayList.add(bdd);
		}

	}

	public void birthdayRemainder() {
		Collections.sort(BirthDayList, new SortDates());
		Iterator<BirthDayDetails> i = BirthDayList.listIterator();

		while (i.hasNext()) {

			BirthDayDetails date = i.next();
			long TimeToWish = date.birthTime.getTime()- System.currentTimeMillis();

			if (TimeToWish >= 0) {

				synchronized (bd) {

					try {
						bd.wait(TimeToWish);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("HappyBirthday " + date.name);
				}
			}
			else 
		{
				System.out.println("no birthdays at this time");
			}
		}
	}

	static class SortDates implements Comparator<BirthDayDetails> {

		public int compare(BirthDayDetails b1, BirthDayDetails b2) {

			return b1.birthTime.compareTo(b2.birthTime);
		}
	}
}
