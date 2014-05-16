package com.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentDetails {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder= factory.newDocumentBuilder();


		File file = new File("/home/valuelabs/workspace/Threads/src/com/xml/student details.xml");

		FileInputStream fis = new FileInputStream(file);

		Document document = builder.parse(fis);
		
		NodeList nodelist = document.getElementsByTagName("details");

		for(int i=0;i<nodelist.getLength();i++){

			Node node = nodelist.item(i);
		
			if(node instanceof Element){

				System.out.println("Stream is : "+((Element) node).getAttribute("stream"));
			}

			NodeList childnodelist = node.getChildNodes();

			for ( int j = 0; j < childnodelist.getLength(); j++ ) {
				Node childNode = childnodelist.item(j);

				if(childNode instanceof Element){
					if(childNode.getNodeName().equalsIgnoreCase("firstname")){
						System.out.println("first name"+childNode.getTextContent());
					}else if(childNode.getNodeName().equalsIgnoreCase("lastname")){
						System.out.println("last name"+childNode.getTextContent());
					}
				}

				if(node instanceof Element){
					if(node.getNodeName().equalsIgnoreCase("group")){
						System.out.println("group "+node.getTextContent());
					}else if(node.getNodeName().equalsIgnoreCase("city")){
						System.out.println("city "+node.getTextContent());
					}else if(node.getNodeName().equalsIgnoreCase("percentage")){
						System.out.println("percentage "+node.getTextContent());
					}
				}

			}
		}

	}
}
