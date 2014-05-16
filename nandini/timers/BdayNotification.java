package com.timers;

import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.text.DateFormat;

public class BdayNotification 
{
	public static void main(String[] args) throws IOException 
	{
		String file="/home/vnandini/Desktop/java/timers/BdayDetails.properties";
		BdayAlerts ba=new BdayAlerts();
		ba.readDetailsFromFile(file);
		ba.generateMessage();
	}
}
class BdayAlerts
{
	List<BdayList> bl=new ArrayList<BdayList>();
	FileInputStream fileInput;
	String key;
	DateFormat sdf=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
	public void readDetailsFromFile(String file)
	{
		try
		{
			Properties prop=new Properties();
			fileInput=new FileInputStream(file);
			prop.load(fileInput);
			Enumeration enumKeys = prop.keys(); 
			while (enumKeys.hasMoreElements()) 
				{
					BdayList bdaylst=new BdayList();
					key = (String) enumKeys.nextElement();
					bdaylst.setValue(key);
					String m=prop.getProperty(key);
					Date date=(Date)sdf.parse(m);
					bdaylst.setDate1(date);
					bl.add(bdaylst);
				}
				Collections.sort(bl,new CompareElements());
		}
		catch(IOException e){e.printStackTrace();}
		catch(ParseException pe){pe.printStackTrace();}
	}
	public void generateMessage()
	{
		int n=bl.size();
		while(true)
		{
			for(int i=0;i<n;i++)
			{
				Date current= new Date();
				Date b=bl.get(i).date;
				if(current.before(b))
				{
					System.out.println(b.after(current));
					long time=bl.get(i).date.getTime()-current.getTime();
					System.out.println("Waiting time is");
					System.out.println(time);
					if(time>0)
					{
						synchronized(this)
						{
							try
							{
								System.out.println("Wating to Know next BirtDay");
								this.wait(time);
							}
							catch(Exception e)
							{
							}
							System.out.println("Today is " + bl.get(i).value + " BirthDay ");
						}
					}
				}
			}
			break;
		}
	}
}
class CompareElements implements Comparator<BdayList>
{
	public int compare(BdayList b1, BdayList b2) {
		b1.date.setYear(new Date(System.currentTimeMillis()).getYear());
		b2.date.setYear(new Date(System.currentTimeMillis()).getYear());
		return b1.date.compareTo(b2.date);
	}
}
