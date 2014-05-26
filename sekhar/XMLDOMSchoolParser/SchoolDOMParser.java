package SchoolXml;
import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class SchoolDOMParser {
	public static void main(String args[])throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		File file = new File("/home/administrator/Desktop/javapgms/SchoolXml/school.xml");
		Document doc = docBuilder.parse(file);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter teacher name");
		String teacher=sc.next();
		getclassname(teacher,doc);
		System.out.println("enter the classname");
		String classname=sc.next();
		get_of_students(classname,doc);

	}
	public static void get_of_students(String classname, Document doc) {
		int noOfStudents=0;
		NodeList list = doc.getElementsByTagName("class");
		for(int i=0;i<list.getLength();i++)
		{
			Element element = (Element)list.item(i);
			if(element.getAttribute("name").equalsIgnoreCase(classname))
			{
				NodeList nlist=element.getChildNodes();
				for(int j=0;j<nlist.getLength();j++)
				{
					Node tag=nlist.item(j);
					if(tag.getNodeName().equals("student"))
					{
						noOfStudents++;
					}	
				}
			}
		}
		System.out.println("the no.of students in "+classname+" class are "+noOfStudents);		
	}
	public static void getclassname(String teacher, Document doc) {
		NodeList list = doc.getElementsByTagName("class");
		for(int i=0;i<list.getLength();i++){
			Element element = (Element)list.item(i);
			NodeList nlist=element.getChildNodes();
			for(int j=0;j<nlist.getLength();j++)
			{
				Node tag=nlist.item(j);
				if(tag.getNodeName().equals("teacher")&&tag.getTextContent().equalsIgnoreCase(teacher))
				{
					System.out.println(teacher+" is "+ element.getAttribute("name")+" class teacher");
					break;
				}
			}
		}
	}
}
