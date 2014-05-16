package vl.com.threads;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;

public class Timer 
{
	List<Bdaydtls> bdaylist=new ArrayList<Bdaydtls>();
	Main t=new Main();
	FileInputStream input;
	public void readdtls(String file) throws IOException
	{
		Properties prop=new Properties();
		input=new FileInputStream(file);
		prop.load(input);
		for(Entry<Object, Object> e:prop.entrySet())
		{
			Bdaydtls bdtls1=new Bdaydtls();
			String n2=(String)e.getKey();
			bdtls1.setName(n2);
			String n3=(String)e.getValue();
			bdtls1.setDate(Timestamp.valueOf(n3));
			bdaylist.add(bdtls1);
		}
		Collections.sort(bdaylist,new Compare());
	}

	public void generatealert()
	{
		int i=0;
		while(true)
		{
			if(i==bdaylist.size())
				i=0;
			long time=bdaylist.get(i).date.getTime()-System.currentTimeMillis();
			System.out.println(time);
			if(time<0){System.out.println("-ve time");}
			else
			{
				System.out.println("+ve time");
				synchronized (t) 
				{
					try {
						System.out.println("wating for next bday");
						t.wait(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(bdaylist.get(i).name+"  bday occured now");
				}
			}
			i++;
		}
	}
}
class Compare implements Comparator<Bdaydtls>
{
	@SuppressWarnings("deprecation")
	@Override
	public int compare(Bdaydtls o1, Bdaydtls o2) {
		o1.date.setYear(new Timestamp(System.currentTimeMillis()).getYear());
		o2.date.setYear(new Timestamp(System.currentTimeMillis()).getYear());
		return o1.date.compareTo(o2.date);
	}
}