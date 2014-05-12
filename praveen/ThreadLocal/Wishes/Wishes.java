package com.vl.mainthings.wishes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;



public class Wishes {


	public static void main(String[] args) {
		System.out.println("Main Started");
		List<ProBean> list;
		PropertiesReader pr=new PropertiesReader();
		list=pr.propReader();
		MyThreadLocal.set(list);
		WishTimer wt=new  WishTimer();
		wt.wishes();
		System.out.println("Main Ended");
	}

}
class ProBean{
	private String Name;
	private String Wish;
	private Date d;
	public ProBean( String Name,String Wish,Date d) {
		this.Name=Name;
		this.Wish=Wish;
		this.d=d;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getWish() {
		return Wish;
	}
	public void setWish(String wish) {
		Wish = wish;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}

}
class MyThreadLocal
{
	public static final ThreadLocal<List<ProBean>> MY_THREAD_LOCAL=new ThreadLocal<List<ProBean>>();
	public static void set(List<ProBean> list)
	{
		MY_THREAD_LOCAL.set(list);
	}
	public static List<ProBean> get()
	{
		return MY_THREAD_LOCAL.get();
	}
	public static void unset()
	{
		MY_THREAD_LOCAL.remove();
	}
}
class PropertiesReader{
	Properties prop = new Properties();
	ProBean b=null;
	InputStream input = null;
	public List<ProBean> propReader()
	{
		List<ProBean> list=new ArrayList<ProBean>();
		try {
			input = new FileInputStream("/home/praveen/Downloads/wokspaces/training/BirthDayWishes/src/com/vl/mainthings/wishes/wishes.properties");
			prop.load(input);

			Enumeration enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value[] = prop.getProperty(key).split(",");
				long date=Date.parse(value[0]);
				Date d=new Date(date);
				String wish=value[1];
				b=new ProBean(key, wish, d);
				list.add(b);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
class WishTimer{
	public void timeSort(){
		List<ProBean> list=MyThreadLocal.get();
		Collections.sort(list, new Compare());
		displayList();

	}
	public void wishes(){
		timeSort();
	}
	public void displayList()
	{
		List<ProBean> list=MyThreadLocal.get();
		Iterator<ProBean> itr2=list.iterator();
		while (itr2.hasNext()) {
			ProBean pq = (ProBean) itr2.next();
			Date d=new Date(System.currentTimeMillis());
			Date d2=pq.getD();
			int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);

			d2.setYear(year);
			long time=(pq.getD().getTime()-d.getTime());
			if(time>0)
			{
				synchronized (this) {
					try {
						System.out.println("\n\n\n\t\twaiting......!");
						this.wait(time);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(pq.getName()+" "+pq.getWish());
				}
			}
			else {
				continue;
			}
		}
	}
}
class Compare implements Comparator<ProBean>{

	@SuppressWarnings("deprecation")
	@Override
	public int compare(ProBean p1, ProBean p2) {
		int year=(Calendar.getInstance().get(Calendar.YEAR)-1900);
		Date d1=(Date) p1.getD().clone();
		d1.setYear(year);
		Date d2=(Date) p2.getD().clone();
		d2.setYear(year);
		return d1.compareTo(d2);
	}
}

