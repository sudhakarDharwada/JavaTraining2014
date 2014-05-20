package com.vl.parserexamples;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParserexample extends DefaultHandler 
{
	private static Hashtable<String, Classes> schooldtls=new Hashtable<String, Classes>();
	List<Student> studentslist = null;
	List<String> sublist = null;
	private static School sch = null;
	private static Classes clas = null;
	private static Teacher t=null;
	private Student st=null;
	private String text = null;
	String cname;

	@Override
	// A start tag is encountered.
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase("School"))
		{
			sch = new School();
		}
		else if(qName.equalsIgnoreCase("Class"))
		{
			clas = new Classes();
			studentslist = new ArrayList<Student>();
			sublist = new ArrayList<String>();
		}
		else if(qName.equalsIgnoreCase("Student"))
		{
			st = new Student();
		}
		else if(qName.equalsIgnoreCase("Teacher"))
		{
			t = new Teacher();
		}
	}
	// a end tag is encountered
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("School")) {
		}
		else if(qName.equalsIgnoreCase("Class")) {
			clas.setSublist(sublist);
			clas.setS(studentslist);
			schooldtls.put(cname, clas);
		}
		else if(qName.equalsIgnoreCase("Student")) {
			studentslist.add(st);
		}
		else if(qName.equalsIgnoreCase("Teacher")) {
			clas.setT(t);
		}
		else if(qName.equalsIgnoreCase("Subjects")) {
			sublist.add(text);
		}
		else if(qName.equalsIgnoreCase("Name")) {
			st.setName(text);
		}
		else if(qName.equalsIgnoreCase("DOB")) {
			st.setDob(convert(text));
		}
		else if(qName.equalsIgnoreCase("Adress")) {
			st.setAdress(text);
		}
		else if(qName.equalsIgnoreCase("Class_Name")){
			cname=text;
		}
		else if(qName.equalsIgnoreCase("Teacher_Name")) {
			t.setTeacher_Name(text);
		}
		else if(qName.equalsIgnoreCase("School_Name")) {
			sch.setSchool_Name(text);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text = String.copyValueOf(ch, start, length).trim();
	}

	public Date convert(String t)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date=null;
		try {
			date = formatter.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	public static void main(String[] args) throws ParserConfigurationException,SAXException, IOException 
	{
		String s1="/home/valuelabs/workspace/parserprograms/src/com/vl/parserexamples/School.xml";
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SaxParserexample handler = new SaxParserexample();
		System.out.println("started");
		parser.parse(new File(s1), handler);
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 no.of students from a class\n 2 class name of given teacher and\n 3 oldest age form a class");
		int choice =sc.nextInt();
		if(choice==1)
		{
			System.out.println("enter the class name :");
			String clname=sc.next();
			int i=schooldtls.get(clname).s.size();
			System.out.println("no of students :"+i);
		}
		else if(choice==2)
		{
			System.out.println("enter the teacher name :");
			String s2=sc.next();
			for(Entry<String, Classes> e:schooldtls.entrySet())
			{
				if(e.getValue().t.teacher_Name.equalsIgnoreCase(s2))
					System.out.println(s2+" is class teacher of "+e.getKey());
			}
		}
		else if(choice==3)
		{
			System.out.println("enter the class name :");
			String clname=sc.next();
			Collections.sort(schooldtls.get(clname).s,new compare());
			System.out.print("oldest student in "+clname+" "+schooldtls.get(clname).s.get(0).name);
			long time=System.currentTimeMillis()-schooldtls.get(clname).s.get(0).dob.getTime();
			System.out.println("and age is "+TimeUnit.MILLISECONDS.toDays(time)/365+" years "+(TimeUnit.MILLISECONDS.toDays(time)%365)/30+" months "+((TimeUnit.MILLISECONDS.toDays(time)%365)%30)+" days");
		}
	}
}
