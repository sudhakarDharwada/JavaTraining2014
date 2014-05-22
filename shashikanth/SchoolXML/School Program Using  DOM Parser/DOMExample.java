package com.val.DOM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMExample 
{
	static int count;
	public static void main(String[] args) 
	{
		try
		{
			DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputStream inputFile=new FileInputStream("/home/valuelabs/Programs/XML/School.xml");
			Document doc=db.parse(inputFile);
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose\n1:Enter Class Name to get no.of students\n2:Enter Class Teacher Name to get the ClassName\n3:Enter Class Name to get the oldest student age from the class");
			int choice=sc.nextInt();
			if(choice==1)
			{
				System.out.println("Enter Class Name to get no.of students:");
				String classname=sc.next();
				NodeList nodeList=doc.getElementsByTagName("ClassName");
				for(int i=0;i<nodeList.getLength();i++)
				{
					Node n2=nodeList.item(i);
					if(n2.getTextContent().equalsIgnoreCase(classname))
					{
						NodeList nlist=n2.getParentNode().getChildNodes();
						for(int j=0;j<nlist.getLength();j++)
						{
							if(nlist.item(j).getNodeName().equals("Student"))
							{
								count++;
							}
						}
					}
				}
				System.out.println("The Total No of Students in "+classname+" :"+count);
			}
			else if(choice==2)
			{
				System.out.println("Enter Class Teacher Name to get the ClassName:");
				String teacher=sc.next();
				NodeList teacherNodes=doc.getElementsByTagName("Teacher");
				for(int i=0;i<teacherNodes.getLength();i++)
				{
					Node n=teacherNodes.item(i);
					if(n.getTextContent().equalsIgnoreCase(teacher))
					{
						NodeList nl=n.getParentNode().getChildNodes();
						for(int j=0;j<nl.getLength();j++)
						{
							if(nl.item(j).getNodeName().equalsIgnoreCase("ClassName"))
							{
								System.out.println(teacher+" Class Teacher of :"+nl.item(j).getTextContent()+" Standard");
							}
						}
					}
				}
			}
			else if(choice==3)
			{
				List<Date> dtlist=new ArrayList<Date>();
				System.out.println("Enter Class Name to get the oldest student from the class:");
				String className=sc.next();
				NodeList nodeList2=doc.getElementsByTagName("ClassName");
				for(int i=0;i<nodeList2.getLength();i++)
				{
					Node n2=nodeList2.item(i);
					if(n2.getTextContent().equalsIgnoreCase(className))
					{
						NodeList nlist=n2.getParentNode().getChildNodes();
						for(int j=0;j<nlist.getLength();j++)
						{
							if(nlist.item(j).getNodeName().equals("Student"))
							{
								NodeList chNodes=nlist.item(j).getChildNodes();
								for(int k=0;k<chNodes.getLength();k++)
								{
									if(chNodes.item(k).getNodeName().equalsIgnoreCase("DOB"))
									{
										dtlist.add(Date.valueOf(chNodes.item(k).getTextContent()));
									}
								}
							}
						}
					}
				}
				Collections.sort(dtlist);
				Calendar now = Calendar.getInstance();
				Calendar dob = Calendar.getInstance();
				dob.setTime(dtlist.get(0));
				if (dob.after(now)) 
				{
					throw new IllegalArgumentException("Can't be born in the future");
				}
				int year1 = now.get(Calendar.YEAR);
				int year2 = dob.get(Calendar.YEAR);
				int age = year1 - year2;
				int month1 = now.get(Calendar.MONTH);
				int month2 = dob.get(Calendar.MONTH);
				if (month2 > month1) 
				{
					age--;
				} 
				else if (month1 == month2) 
				{
					int day1 = now.get(Calendar.DAY_OF_MONTH);
					int day2 = dob.get(Calendar.DAY_OF_MONTH);
					if (day2 > day1) 
					{
						age--;
					}
				}
				System.out.println("The oldest student age is "+age+" yrs");
			}

		}
		catch (ParserConfigurationException e) 
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SAXException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
