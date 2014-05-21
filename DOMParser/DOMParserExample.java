package parserpackage;

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

public class DOMParserExample {
	static Scanner sc = new Scanner(System.in);
	static int studentsperclass = 0;
	static Document document;
	static DocumentBuilder documentbuilder;
	static DocumentBuilderFactory buliderfactory;

	public static void main(String[] args) {
		try {
			buliderfactory = DocumentBuilderFactory.newInstance();
			buliderfactory.setValidating(true);
			System.out.println("enter xml file :");
			File file = new File(sc.next());
			documentbuilder = buliderfactory.newDocumentBuilder();
			document = documentbuilder.parse(file);
			students();
			classTeacher();
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	public static void students() {
		System.out.println("enter the class name :");
		String classname = sc.next();
		NodeList nodelist = document.getElementsByTagName("Class_Name");
		for (int itr = 0; itr < nodelist.getLength(); itr++) {

			Node node = nodelist.item(itr);

			if (classname.equals(node.getTextContent())) {
				Node parentnode = node.getParentNode();
				NodeList childnodes = parentnode.getChildNodes();
				for (int itr1 = 0; itr1 < childnodes.getLength(); itr1++) {
					if (childnodes.item(itr1).getNodeName().equals("Student")) {
						studentsperclass++;
					}
				}
			}
		}
		System.out.println("total students in a  :" + studentsperclass);
	}

	public static void classTeacher() {
		System.out.println("enter the teacher name ");
		String teachername = sc.next();
		NodeList nodelist1 = document.getElementsByTagName("Teacher_Name");
		for (int itr = 0; itr < nodelist1.getLength(); itr++) {

			Node node = nodelist1.item(itr);
	if (teachername.equalsIgnoreCase(node.getTextContent())) {
				Node parentn1 = node.getParentNode();
				Node childnode1 = parentn1.getParentNode();
				NodeList nodelist2 = childnode1.getChildNodes();
				for (int itr1 = 0; itr1<nodelist2.getLength(); itr1++) {

					Node node1 = nodelist2.item(itr1);
	if (node1.getNodeName().equalsIgnoreCase("Class_Name")) {
						System.out.println(" teacher of "+ node1.getTextContent());
						
					}
				}
			}

		}
	}
}
