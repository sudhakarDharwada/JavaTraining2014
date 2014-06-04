import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.FactoryConfigurationError; 
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException; 
import org.xml.sax.SAXParseException; 
import java.io.File;
import java.io.IOException; 
import org.w3c.dom.Document;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.util.concurrent.TimeUnit;

class UsingXMLSchema
{
	static final String JAXP_SCHEMA_LANGUAGE ="http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	static final String W3C_XML_SCHEMA ="http://www.w3.org/2001/XMLSchema";
	static final String JAXP_SCHEMA_SOURCE ="http://java.sun.com/xml/jaxp/properties/schemaSource";
	static Document document;
	static DocumentBuilder builder;
	static DocumentBuilderFactory factory;
	static NodeList nodelist;
	static Scanner s=new Scanner(System.in);
	
	public static void main(String args[])
	{
		String filename = null;
		boolean dtdValidate = false;
		boolean xsdValidate = false;
		String schemaSource = args[1];
		factory=DocumentBuilderFactory.newInstance();	
		try
		{
			factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
			factory.setAttribute(JAXP_SCHEMA_SOURCE,new File(schemaSource));
			factory.setFeature("http://apache.org/xml/features/validation/schema", true);
			factory.setValidating(true);
			builder = factory.newDocumentBuilder();
			factory.setNamespaceAware(true);
			document = builder.parse( new File(args[0]) );			
			System.out.println("Enter 1 to get no.of students from a class\n 2 for to get class name for a given teacher and\n 3 for a given class to get the oldest age.");
			int i=s.nextInt();
			switch(i)
			{
				case 1: noOfStudents();
						break;
				case 2: getClassName();
						break;
				case 3: getOldestAge();
						break;
				default:System.out.println("please enter 1, 2 or 3 only");
			}
		} 
		catch(SAXParseException spe)
		{
			spe.printStackTrace();
		}
		catch (SAXException sxe)
		{
			sxe.printStackTrace();
		} 
		catch(ParserConfigurationException pce) 
		{  
			pce.printStackTrace();
		} 
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}		
	
	}
	public static void noOfStudents()
	{
		nodelist=document.getElementsByTagName("classes");
		System.out.println("enter a class name");
		String class_name=s.next();
		int count=0;
		
		for(int k=0;k<nodelist.getLength();k++)
		{
			Node n=nodelist.item(k);
			if(n instanceof Element)
			{
				if(((Element)n).getAttribute("standard").equalsIgnoreCase(class_name))
				{
					NodeList childs=n.getChildNodes();
					for(int m=0;m<childs.getLength();m++)
					{
						Node b=childs.item(m);
						if(b.getNodeName().equals("student"))
						{
							count++;
						}	
					}
				}
			}
		}
		System.out.println("the no.of students in class "+class_name+" are "+count);		
	}
	public static void getClassName()
	{
		nodelist=document.getElementsByTagName("classes");
		System.out.println("enter a first name of the teacher");
		String t_name=s.next();
		for(int k=0;k<nodelist.getLength();k++)
		{
			Node n=nodelist.item(k);
			if(n instanceof Element)
			{
				NodeList childs=n.getChildNodes();
				for(int m=0;m<childs.getLength();m++)
				{
					Node c=childs.item(m);
					if(c.getNodeName().equals("teacher"))
					{
						if(c.getTextContent().equalsIgnoreCase(t_name))
						{
							System.out.println(t_name+" belongs to "+ ((Element)n).getAttribute("standard"));
							break;
						}
					}
				}
			}
		}
	}
	public static void getOldestAge()
	{
		nodelist=document.getElementsByTagName("classes");
		System.out.println("enter the class name to get the oldest age");
		String cls=s.next();		
		Date current=new Date();
		long highest_age=0,age=0;
		for(int k=0;k<nodelist.getLength();k++)
		{
			String d=null;
			Node n=nodelist.item(k);
			if(n instanceof Element)
			{
				if(((Element)n).getAttribute("standard").equalsIgnoreCase(cls))
				{
					NodeList childs=n.getChildNodes();
					for(int m=0;m<childs.getLength();m++)
					{
						Node c=childs.item(m);
						
						if(c.getNodeName().equals("student"))
						{
							NodeList birth=c.getChildNodes();
							for(int v=0;v<birth.getLength();v++)
							{
								Node q=birth.item(v);
								if(q.getNodeName().equals("dob"))
								{
									d=q.getTextContent();									
								}
							}
							try
							{	
								age=GetAge.ageCal(d); 
							}
							catch(ParseException e)
							{
								e.printStackTrace();
							}
							if(age>highest_age)
								highest_age=age;
						}
					}
				}
			}		
		}
		System.out.println("oldest age is "+TimeUnit.MILLISECONDS.toDays(highest_age)/365 +" in "+cls);
	}
}


