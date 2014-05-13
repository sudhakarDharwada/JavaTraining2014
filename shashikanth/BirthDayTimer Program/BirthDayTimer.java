package com.val.Timer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class BirthDayTimer 
{
	public static List<BirthDayDetails> bdlist=new ArrayList<BirthDayDetails>();
	TimerExample tx=new TimerExample();
	public void readFile(String fileName) throws IOException
	{
		File file=new File(fileName);
		FileInputStream fileInput = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInput);
		fileInput.close();
		Enumeration<Object> enuKeys = properties.keys();
		while (enuKeys.hasMoreElements()) 
		{
			String name = (String) enuKeys.nextElement();
			String datetime = properties.getProperty(name);
			BirthDayDetails bd=new BirthDayDetails();
			bd.setName(name);
			bd.setDateTime(Timestamp.valueOf(datetime));
			bdlist.add(bd);
		}
		Collections.sort(bdlist,new DateCompare());
	}
	@SuppressWarnings("deprecation")
	public void sendAlert() throws InterruptedException 
	{
		List<BirthDayDetails> newlist=new ArrayList<BirthDayDetails>();
		
		for(int i=0;i<bdlist.size();i++)
		{
			Timestamp t=new Timestamp(System.currentTimeMillis());
			Timestamp t1=new Timestamp(t.getYear(),bdlist.get(i).getDateTime().getMonth(),bdlist.get(i).getDateTime().getDate(),bdlist.get(i).getDateTime().getHours(),
					bdlist.get(i).getDateTime().getMinutes(),bdlist.get(i).getDateTime().getSeconds(),bdlist.get(i).getDateTime().getNanos());
			BirthDayDetails bdt=new BirthDayDetails();
			bdt.setName(bdlist.get(i).getName());
			bdt.setDateTime(t1);
			newlist.add(bdt);
		}
		Collections.sort(newlist,new DateCompare());
		while(true)
		{
			for(int i=0;i<newlist.size();i++)
			{
				Timestamp t=new Timestamp(System.currentTimeMillis());
				long time=newlist.get(i).getDateTime().getTime()-t.getTime();
				if(time<0)
				{
				
				}
				else
				{
					synchronized (tx)
					{
						tx.wait(time);	
						System.out.println("Happy BirthDay "+newlist.get(i).getName());
					}
				}
			}
		}
	}
}
