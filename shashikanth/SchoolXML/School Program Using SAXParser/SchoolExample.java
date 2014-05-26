package com.val.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SchoolExample 
{
	public static void main(String[] args) 
	{
		try 
		{
			SAXParserFactory factory=SAXParserFactory.newInstance();
			SAXParser parser=factory.newSAXParser();
			InputStream inputFile=new FileInputStream("/home/valuelabs/Programs/XML/School.xml");
			DefaultHandler handler=new SAXHandler();
			parser.parse(inputFile, handler);
			List<Classes> clList=null;
			List<Student> sdList=null;
			clList=SAXHandler.getClasses();
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose\n1:Enter Class Name to get no.of students\n2:Enter Class Teacher Name to get the ClassName\n3:Enter Class Name to get the oldest student from the class");
			int choice=sc.nextInt();
			if(choice==1) 
			{
				System.out.println("Enter Class Name to get no.of students:");
				String name=sc.next();
				for(Classes cs:clList)
				{
					if(name.equals(cs.getClassName()))
					{
						System.out.println("The Total No of Students in "+name+" :"+cs.getSd().size());
					}
				}
			}
			else if(choice==2)
			{
				System.out.println("Enter Class Teacher Name to get the ClassName:");
				String teacher=sc.next();
				for(Classes cs:clList)
				{
					if(teacher.equals(cs.getTeacherName()))
					{
						System.out.println(teacher+" Class Teacher of :"+cs.getClassName()+" Standard");
					}
				}
			}
			else if(choice==3)
			{
				System.out.println("Enter Class Name to get the oldest student from the class:");
				String classname=sc.next();
				for(Classes cs:clList)
				{
					if(classname.equals(cs.getClassName()))
					{
						sdList=cs.getSd();
						Collections.sort(sdList,new AgeCompare());
						System.out.println("Oldest Student in "+classname+" Standard :"+sdList.get(0).getName());
					}
				}
			}
		}
		catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		catch (SAXException e) 
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
