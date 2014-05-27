import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class UsingSax extends DefaultHandler
{
	static Scanner sn=new Scanner(System.in);
	static Hashtable<String, Classes> schoolInfo=new Hashtable<String, Classes>();
	static List<Student> students=null;
	static List<String> sub=null;
	static School sc;
	static Classes c;
	static Teacher t;
	static Name stud_name;
	Student stud;
	String text;
	String n;
	String k;
	
	public static void main(String args[])
	{
		try
		{
		if(args.length != 1)
		{
			System.out.println("please enter a xml file name while running");
			System.exit(1);
		}
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		SAXParser sp = spfac.newSAXParser();
		UsingSax h = new UsingSax();
		File f1=new File(args[0]);
		sp.parse(f1, h);
		System.out.println("Enter 1 to get no.of students from a class\n 2 for to get class name for a given teacher and\n 3 for a given class to get the oldest age.");
		int i=sn.nextInt();
		System.out.println("Input is "+ i);
		switch(i)
		{
			case 1: h.noOfStudents();
					break;
			case 2: h.getClassName();
					break;
			case 3: h.getOldestAge();
					break;
			default:System.out.println("please enter 1, 2 or 3 only");
		}
		}
		catch(SAXException e)
		{
			e.printStackTrace();
		}
		catch(ParserConfigurationException p)
		{
			p.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	public void noOfStudents()
	{
		System.out.println("enter a class name");
		String class_name=sn.next();
		int i=schoolInfo.get(class_name).s.size();
		System.out.println("no of students are "+ i +" in "+class_name);
	}
	public void getClassName()
	{ 
		System.out.println("enter a first name of the teacher");
		String t_name=sn.next();
		Enumeration sch=schoolInfo.keys();
		while(sch.hasMoreElements()) 
		{
			String m=(String)sch.nextElement();
			if((schoolInfo.get(m)).t.name_t.equalsIgnoreCase(t_name))
				System.out.println(t_name+" is class teacher of "+m);
		}
	}
	public void getOldestAge()
	{
		System.out.println("enter the class name to get the oldest age");
		String cls=sn.next();
		long time1=0;
		long age=0;
		Enumeration sch=schoolInfo.keys();
		while(sch.hasMoreElements()) 
		{
			String m=(String)sch.nextElement();
			if(m.equals(cls))
			{
				for(int n=0;n<(schoolInfo.get(m)).s.size();n++)
				{
					time1=(schoolInfo.get(m)).s.get(n).dob;
					if(time1>age)
					{
						age=time1;
					}
				}
			}
		}
		System.out.println("Oldest age in the class is "+TimeUnit.MILLISECONDS.toDays(age)/365);
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		if(qName.equals("schools"))
		{	
			sc=new School();
			n=attributes.getValue("name1");
			sc.setS_name(n);
		}
		else if(qName.equals("student"))
		{
			stud=new Student();
		}
		else if(qName.equals("teacher"))
		{
			t=new Teacher();
		}
		else if(qName.equals("classes"))
		{
			c=new Classes();
			students=new ArrayList<Student>();
			k=attributes.getValue("standard");
		}
		else if(qName.equals("name"))
		{
			
			stud_name=new Name();
		}
		else if(qName.equals("subject"))
		{
			sub=new ArrayList<String>();
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("schools"))
		{
		}
		else if(qName.equals("student"))
		{
			students.add(stud);	
			
		}
		else if(qName.equals("name_t"))
		{
			t.setName_t(text);
		}
		else if(qName.equals("classes"))
		{
			c.setStd(k);
			c.setT(t);
			c.setSubject_list(sub);
			c.setS(students);
			schoolInfo.put(k,c);
		}
		else if(qName.equals("fname"))
		{
			stud_name.setFname(text);
		}
		else if(qName.equals("lname"))
		{
			stud_name.setLname(text);
		}
		else if(qName.equals("subject"))
		{
			sub.add(text);
		}
		else if(qName.equals("name"))
		{
			stud.setN(stud_name);
		}
		else if(qName.equals("dob"))
		{
			try
			{
				stud.setDob(ageCal(text));
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}		
		} 
		else if(qName.equals("address"))
		{
			stud.setAddress(text);
		}
		else if(qName.equals("teacher"))
		{
			
		} 
	}
	@Override
	public void characters(char[] ch, int start, int length)throws SAXException {
		text = String.copyValueOf(ch, start, length).trim();
	}
	public static long ageCal(String str) throws ParseException
	{
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d2=dateFormat.parse(str);
		return System.currentTimeMillis()-d2.getTime();
	}

}
