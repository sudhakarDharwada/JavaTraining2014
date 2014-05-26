package com.vl.parserexamples;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParserExample 
{
	static Scanner sc=new Scanner(System.in);
	static int count=0;	
	static Document doc;
	static DocumentBuilder dBuilder;
	static DocumentBuilderFactory factory;

	public static void main(String[] args) {
		try {
			factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			System.out.println("enter xml file :");
			File file = new File(sc.next());
			dBuilder=factory.newDocumentBuilder();
			doc = dBuilder.parse(file);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Enter 1 no.of students from a class\n 2 class name of given teacher and\n 3 oldest age form a class");
		int choice =sc.nextInt();
		if(choice==1)
			noofstudents();
		else if(choice==2)
			getclassname();
		else if(choice==3)
			getoldestage();
		else
			System.out.println("invalid choice");
	}
	@SuppressWarnings("unused")
	public static void noofstudents()
	{
		System.out.println("enter class name :");
		String cname=sc.next();
		NodeList nList = doc.getElementsByTagName("Class_Name");
		for(int i=0;i<nList.getLength();i++)
		{
			Node n=nList.item(i);
			if(cname.equalsIgnoreCase(n.getTextContent()))
			{
				Node n1=n.getParentNode();
				NodeList nList1=n1.getChildNodes();
				for(int j=0;j<nList1.getLength();j++)
				{
					if(nList1.item(j).getNodeName().equalsIgnoreCase("Student"))
					{count++;}
				}
			}
			break;
		}
		System.out.println("no of students :"+count);
	}
	@SuppressWarnings("unused")
	public static void getclassname()
	{
		System.out.println("enter teacher name :");
		String tname=sc.next();
		NodeList nList = doc.getElementsByTagName("Teacher_Name");
		for(int k=0;k<nList.getLength();k++)
		{
			Node n=nList.item(k);
			if(tname.equalsIgnoreCase(n.getTextContent()))
			{
				Node n1=n.getParentNode();
				Node n2=n1.getParentNode();
				NodeList nList1=n2.getChildNodes();
				for(int p=0;p<nList1.getLength();p++)
				{
					Node n3=nList1.item(p);
					if(n3.getNodeName().equalsIgnoreCase("Class_Name"))
					{
						System.out.println(tname+" teacher of "+n3.getTextContent());break;
					}
				}
			}
			break;
		}
	}
	public static void getoldestage()
	{
		System.out.println("enter class name :");
		String cname1=sc.next();
		NodeList nList = doc.getElementsByTagName("Class_Name");
		long time=0;
		for(int i=0;i<nList.getLength();i++)
		{
			Node n=nList.item(i);
			if(cname1.equalsIgnoreCase(n.getTextContent()))
			{
				Node n1=n.getParentNode();
				NodeList nList1=n1.getChildNodes();
				for(int j=0;j<nList1.getLength();j++)
				{
					Node n2=nList1.item(j);
					if(n2.getNodeName().equalsIgnoreCase("Student"))
					{
						NodeList nList2=n2.getChildNodes();
						for(int a=1;a<nList2.getLength();a++)
						{
							Node n3=nList2.item(a);
							if(n3.getNodeName().equalsIgnoreCase("DOB"))
							{
								long dtime=DomParserExample.convert(n3.getTextContent());
								if(dtime>time)
									time=dtime;
							}
						}
					}
				}
				System.out.println("oldest age is "+TimeUnit.MILLISECONDS.toDays(time)/365+" years "+(TimeUnit.MILLISECONDS.toDays(time)%365)/30+" months "+((TimeUnit.MILLISECONDS.toDays(time)%365)%30)+" days");
			}
		}
	}
	public static long convert(String t)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date=null;
		try {
			date = formatter.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis()-date.getTime();
	}
}