package com.domparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class School {
	static DocumentBuilderFactory builderFactory;
	static DocumentBuilder builder;
	static Document document;
	static Scanner s = new Scanner(System.in);
	
	

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		builderFactory = DocumentBuilderFactory.newInstance();
		builder = builderFactory.newDocumentBuilder();
		
		File file = new File("/home/valuelabs/workspace/Threads/src/com/domparser/school.xml");
		FileInputStream fis = new FileInputStream(file);
		document = builder.parse(fis);
		System.out.println("Enter your choice ");
		System.out.println(" 1 no.of students from a class \n 2 class name of given teacher \n 3 oldest age form a class");
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter class number");
			int classnumber = s.nextInt();
			numberOfStudents(classnumber);
			break;

		case 2:
			System.out.println("Enter class teacher to find class number");
			String classTeacher = s.next();
			classteacher(classTeacher);
			break;

		case 3:
			System.out.println("Enter class number find Oldest age from a class");
			int classNumber = s.nextInt();
			older(classNumber);
			break;

		default: System.out.println("Please Enter Correct Option");
		break;
		}
	}
	private static void older(int classNumber) {

		long older = 0  ;
		long mseconds = 0;
		DateFormat frmtr = new SimpleDateFormat("dd-MM-yyyy");
		NodeList nodelist = document.getElementsByTagName("class");
		for ( int i = 0; i <  nodelist.getLength(); i++ ) {

			Node currentNode = nodelist.item(i);
			if(currentNode instanceof Element){
				if(classNumber == Integer.parseInt(((Element) currentNode).getAttribute("number"))){
					NodeList childNodes = currentNode.getChildNodes();
					for ( int j = 0; j < childNodes.getLength(); j++ ) {
						Node childNode = childNodes.item(j);

						if ( childNode instanceof Element ) {
							NodeList subnodelist = childNode.getChildNodes();

							for(int k=0;k<subnodelist.getLength();k++){

								Node subnode = subnodelist.item(k);
								if ( subnode.getNodeName().equalsIgnoreCase("DOB") ) {

									SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
									Date date = null;
									try {
										date = (Date) formatter.parse(subnode.getTextContent());
										mseconds = date.getTime();
									} catch (ParseException e) {
										e.printStackTrace();
									}

									if(older == 0){
										older = mseconds;
									}

									if(older > mseconds){
									}
								}
							}
						}
					}

					System.out.println("Older date is "+frmtr.format(older ));
				}
			}
		}
	}

	private static void classteacher(String classTeacher) {

		NodeList nodelist = document.getElementsByTagName("class");
		
		for ( int i = 0; i <  nodelist.getLength(); i++ ) {

			Node currentNode = nodelist.item(i);
			if(currentNode instanceof Element){
				NodeList childNodes = currentNode.getChildNodes();
				for ( int j = 0; j < childNodes.getLength(); j++ ) {
					Node childNode = childNodes.item(j);
					if ( childNode instanceof Element ) {
						if(childNode.hasChildNodes()){
							NodeList subnodelist = childNode.getChildNodes();
							for(int k=0;k<subnodelist.getLength();k++){
								if ( childNode.getNodeName().equalsIgnoreCase("classteacher") ) {
									if(classTeacher.equals(childNode.getTextContent()))
										System.out.println("classteacher name :"+childNode.getTextContent()+"---Class number---"+Integer.parseInt(((Element) currentNode).getAttribute("number")));
								} 
							}
						}	
					}
				}
			}
		}
	}


	private static void numberOfStudents(int classnumber) {
		int count = 0;
		NodeList nodelist = document.getElementsByTagName("class");
		for ( int i = 0; i <  nodelist.getLength(); i++ ) {

			Node currentNode = nodelist.item(i);
			if(currentNode instanceof Element){
				if(classnumber == Integer.parseInt(((Element) currentNode).getAttribute("number"))){
					NodeList childNodes = currentNode.getChildNodes();
					for ( int j = 0; j < childNodes.getLength(); j++ ) {
						Node childNode = childNodes.item(j);
						if ( childNode instanceof Element ) {
							if(childNode.hasChildNodes()){
								NodeList subnodelist = childNode.getChildNodes();
								for(int k=0;k<subnodelist.getLength();k++){
									Node subnode = subnodelist.item(k);
									if ( subnode.getNodeName().equalsIgnoreCase("firstname") ) {
										count++;
									}
								}
							}
						}
					}
					System.out.println("Total "+ count);
				}
			}
		}
	}
}
