import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class Whish {

	@SuppressWarnings("deprecation")
	public void calculate(List<BirthDetails> birth) {
		Collections.sort(birth,new Compare());//overriding compare method
		Iterator<BirthDetails> itr=birth.iterator();
		while (itr.hasNext()) {
			BirthDetails bdetails = (BirthDetails) itr.next();
			Date t1=new Date(System.currentTimeMillis());
			Date t2=bdetails.getDate();
			int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);
			t2.setYear(year);
			long time=(bdetails.getDate().getTime()-t1.getTime());
			if(time>0)
			{
				synchronized (this) {
					try {
						System.out.println("\nwaiting for whish");
						this.wait(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.print("happy b'day:"+bdetails.getName());
				}
			}
		}

	}

}
class Compare implements Comparator<BirthDetails>{

	@SuppressWarnings("deprecation")
	@Override
	public int compare(BirthDetails p1, BirthDetails p2) {
		int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);
		Date d1=(Date) p1.getDate().clone();
		d1.setYear(year);
		Date d2=(Date) p2.getDate().clone();
		d2.setYear(year);
		return d1.compareTo(d2);
	}
}

