package com.val.xml;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXHandler extends DefaultHandler
{
	public static List<Student> studentList;
	public static List<Classes> classesList=new ArrayList<Classes>();
	private List<String> subjects;
	Student std=null;
	Classes classes=null;
	boolean isStudent=false;
	boolean isClass=false;
	boolean isClassName=false;
	boolean isTeacher=false;
	boolean isSubjects=false;
	String content=null;
	
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException 
	{
		if(qName.equals("Class"))
		{
			classes=new Classes();
			subjects=new ArrayList<String>();
			studentList=new ArrayList<Student>();
			isClass=true;
		}
		if(qName.equals("ClassName"))
		{
			isClassName=true;
		}
		if(qName.equals("Student"))
		{
			std=new Student();
			isStudent=true;
		}
		if(qName.equals("Teacher"))
		{
			isTeacher=true;
		}
		if(qName.equals("Subjects"))
		{
			isSubjects=true;
		}
	}

	public void endElement(String uri, String localName, String qName)throws SAXException
	{
		if(qName.equals("Class"))
		{
			
			classesList.add(classes);
			classes.setSd(studentList);
			isClass=false;
		}
		else if(qName.equals("ClassName"))
		{
			classes.setClassName(content);
			isClassName=false;
		}
		else if(qName.equals("Student"))
		{
			studentList.add(std);
			isStudent=false;
		}
		else if(qName.equals("Teacher"))
		{
			isTeacher=false;
		}
		else if(qName.equals("Subjects"))
		{
			isSubjects=false;
		}
		else if(qName.equals("Name"))
		{
			if(isStudent)
			{
				std.setName(content);
			}
			else if(isTeacher)
			{
				classes.setTeacherName(content);
			}
			else if(isSubjects)
			{
				subjects.add(content);
				classes.setSubjects(subjects);
			}
		}
		else if(qName.equals("DOB"))
		{
			std.setDOB(Date.valueOf(content));
		}
		else if(qName.equals("Address"))
		{
			std.setAddress(content);
		}
	}

	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		content=new String(ch,start,length);
	}

	public static List<Classes> getClasses() 
	{
		return classesList;
	}
}
