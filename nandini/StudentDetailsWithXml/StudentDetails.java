import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.FactoryConfigurationError; 
import javax.xml.parsers.ParserConfigurationException; 
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException; 
import java.io.File;
import java.io.IOException; 
import org.w3c.dom.Document; 
import java.util.Scanner;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

public class StudentDetails
{
	static Document document;
	static DocumentBuilder builder;
	static DocumentBuilderFactory factory;
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String args[])
	{
		if(args.length!=1)
		{
			System.err.println("Usage:java StudentDetails filename");
			System.exit(1);
		}
		factory=DocumentBuilderFactory.newInstance();
		try
		{
			int count=0;
			builder=factory.newDocumentBuilder();
			document=builder.parse(new File(args[0]));
		}
		catch (SAXParseException spe) {
			spe.printStackTrace();
		}
		catch (SAXException sxe) {
			sxe.printStackTrace();
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		}	
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("1.Enter 1 to know no of students in a class \n 2.enter 2 to know the name of class teacher \n 3.Enter 3 to know the oldest age in the class ");
			int option=sc.nextInt();
			switch(option)
			{
			case 1:getNoOfstudentsInClass();
			break;
			case 2:getClassName();
			break;
			case 3:getOldestAge();
			break;
			default : System.out.println("No Option Choosed");
		}
	}
	public static void getNoOfstudentsInClass(){
		int count=0;
		System.out.println("Enter class name");
		NodeList nList=document.getElementsByTagName("class1");
		String name_of_class=sc.next();
		for(int i=0;i<nList.getLength();i++)
		{
			Node node=nList.item(i);
			if(node.hasAttributes())
			{
				NamedNodeMap attrs = node.getAttributes();  
				for(int j = 0 ; j<attrs.getLength() ; j++) 
				{
					Attr attribute = (Attr)attrs.item(j);     
					if(name_of_class.equals(attribute.getValue())){
						NodeList nList1=node.getChildNodes();
						for(int k=0;k<nList1.getLength();k++){
							Node node1=nList1.item(k);
							if(node1.getNodeName().equals("student"))
								count++;
						}
					}
				}
			}
		}
		System.out.println("Total number of students in the given class are "+count); 
	}
	public static void getClassName(){
		System.out.println("Enter Teacher name");
		String name_of_teacher=sc.next();
		NodeList nList=document.getElementsByTagName("class1");
		for(int i=0;i<nList.getLength();i++){
			Node node=nList.item(i);
			if(node.hasAttributes())
			{
				NamedNodeMap attrs = node.getAttributes(); 
				for(int k = 0 ; k<attrs.getLength() ; k++) 
				{
					Attr attribute = (Attr)attrs.item(k); 
					NodeList nList1=node.getChildNodes();
					for(int j=0;j<nList1.getLength();j++){
						Node node1=nList1.item(j);
						if((node1.getNodeName()).equals("teacher"))
						{
							String s=node1.getTextContent();
							s=s.replaceAll("\\s","");
							if(s.equals(name_of_teacher))
								System.out.println(name_of_teacher+" is the class teacher of " +attribute.getValue()+ " class");
							}
						}
				}
			}
		}
	}
	public static void getOldestAge(){
		System.out.println("Enter class name");
		String class_name=sc.next();
		long time=0;
		NodeList nList=document.getElementsByTagName("class1");
		try{
		for(int i=0;i<nList.getLength();i++){
			Node node=nList.item(i);
			if(node.hasAttributes())
			{
				NamedNodeMap attrs = node.getAttributes(); 
				for(int k = 0 ; k<attrs.getLength() ; k++) 
				{
					Attr attribute = (Attr)attrs.item(k);
					NodeList nList1=node.getChildNodes();
					for(int j=0;j<nList1.getLength();j++){
						Node node1=nList1.item(j);
						
						NodeList nList2=node1.getChildNodes();
						for(int m=0;m<nList2.getLength();m++){
							Node node2=nList2.item(m);
							if((node2.getNodeName()).equals("DOB")){
								
								long dtime=StudentDetails.convertToDate(node2.getTextContent());
								if(dtime>time)
									time=dtime;
								
							}
						}
					}
				}
			}
		}
	}
	catch(Exception pe){}
		System.out.println("oldest age of" +TimeUnit.MILLISECONDS.toDays(time)/365+" years "+(TimeUnit.MILLISECONDS.toDays(time)%365)/30+" months "+((TimeUnit.MILLISECONDS.toDays(time)%365)%30)+" days");
	}
	public static long convertToDate(String t)
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date=null;
		try {
			t=t.replaceAll("\\s","");
			date = sdf.parse(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis()-date.getTime();
	}

}
