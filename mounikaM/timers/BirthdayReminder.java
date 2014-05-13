import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Date;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;
import java.text.ParseException;

class BirthdayReminder
{
	public static void main(String args[])
	{
		BirthdayTimer bt=new BirthdayTimer();
		Map<String, Date> sort=new HashMap<String, Date>();
		sort=bt.BirthdayFileReading();
		bt.displayBirthdays(sort);
	}
}

class BirthdayTimer 
{
	Map<String, Date> b_map=new HashMap<String, Date>();
	public Map<String, Date> BirthdayFileReading()
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Properties prop=new Properties();
		InputStream input = null;
		HashMap<String, Date> birthday_map=new HashMap<String, Date>();
		Map<String, Date> b_map_sort=new HashMap<String, Date>();
		try
		{
			df= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			input = new FileInputStream("Bday.properties");
			prop.load(input);	
			Enumeration enuKeys = prop.keys();
			while (enuKeys.hasMoreElements()) {
				String key = (String) enuKeys.nextElement();
				String value = prop.getProperty(key);
				Date b2=df.parse(value);
				birthday_map.put(key,b2);
			}	
			ArrayList b_list=new ArrayList(birthday_map.entrySet());
			return b_map_sort=sortByValues(birthday_map);
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception m)
		{
			m.printStackTrace();
		}
		
		finally
		{
			if (input != null) 
			{
				try 
				{
					input.close();
				} 
				catch (IOException e1) 
				{
					e1.printStackTrace();
				}
			}
			return b_map_sort;
		}
	}
	
	public void displayBirthdays(Map<String, Date> b_map_sort)
	{
		Date current=new Date();
		Set set = b_map_sort.entrySet();
			Iterator l = set.iterator();
			while(l.hasNext()) 
			{
				Map.Entry me = (Map.Entry)l.next();
				Date b_day2=(Date)me.getValue();
				if(b_day2.after(current))
				{
					String str=(String)me.getKey();
					long time=((Date)b_map_sort.get(str)).getTime()-current.getTime();
					if(time>0)
					{
						synchronized (this)
						{
							try 
							{
								System.out.println("\n Waiting for next persons birthday..!!!\n");
								this.wait(time);
							} 
							catch (InterruptedException e) 
							{
								e.printStackTrace();
							}
							System.out.println(str+"'s birthday is now\n");
						}
					}
				}
			}
	}
	
	public static <K extends Comparable,V extends Comparable> Map<K,V> sortByValues(Map<K,V> map)
	{
		List<Map.Entry<K,V>> entries = new LinkedList<Map.Entry<K,V>>(map.entrySet());        
		Collections.sort(entries, new Comparator<Map.Entry<K,V>>() 
		{
			public int compare(Entry<K, V> o1, Entry<K, V> o2) 
			{
				return o1.getValue().compareTo(o2.getValue());
            }
        });
        Map<K,V> sortedMap = new LinkedHashMap<K,V>();
        for(Map.Entry<K,V> entry: entries)
        {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}


