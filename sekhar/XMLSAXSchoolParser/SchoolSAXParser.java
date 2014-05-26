package SchoolXml;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class SchoolSAXParser extends DefaultHandler
{
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxBuilder = factory.newSAXParser();
		File file = new File("/home/administrator/Desktop/javapgms/SchoolXml/school.xml");
		SchoolSAXParser handler=new SchoolSAXParser();
		saxBuilder.parse(file, handler);
		Scanner sc=new Scanner(System.in);
		String ch="y";
		do
		{
			System.out.println("enter your choice");
			System.out.println("1.getting classname");
			System.out.println("2.getting no.of students");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("enter the teachername:");
				String teacher=sc.next();
				for(SchoolDetails sd:schoollist){
					if(teacher.equalsIgnoreCase(sd.getTeachername())){
						System.out.println(sd.getClassname());
					}
				}
				break;
			case 2:
				System.out.println("enter classname");
				String classname=sc.next();
				for(SchoolDetails sd:schoollist){
					if(classname.equalsIgnoreCase(sd.getClassname())){
						System.out.println(sd.getStds().size());
					}
				}
				break;
			default:
				System.out.println("enter either 1 or 2");
				break;
			}
			System.out.println("do you want to continue press y");
			ch=sc.next();
		}while(ch.equals("y"));
	}
	public static List<SchoolDetails>schoollist=new ArrayList<SchoolDetails>();
	public static List<Students>stdslist;
	public static List<Subjects>sublist;
	static Students stds=null;
	static Subjects subs=null;
	static SchoolDetails scl=null;
	boolean bclass=false;
	boolean bstudent=false;
	boolean bsubjects=false;
	boolean bteacher=false;
	String info=null;
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException
	{
		if(qName.equalsIgnoreCase("class")){
			stdslist=new ArrayList<Students>();
			sublist=new ArrayList<Subjects>();
			scl=new SchoolDetails();
			String name = attributes.getValue("name");
			scl.setClassname(name);
			bclass=true;
		}
		else if(qName.equalsIgnoreCase("student"))
		{
			stds=new Students();
			bstudent=true;
		}
		else if(qName.equalsIgnoreCase("teacher"))
		{
			bteacher=true;
		}
		else if(qName.equalsIgnoreCase("subjects"))
		{
			subs=new Subjects();
			bsubjects=true;
		}
		super.startElement(uri, localName, qName, attributes);
	}

	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException
	{
		if(qName.equalsIgnoreCase("class")){
			schoollist.add(scl);
			scl.setStds(stdslist);
			scl.setSub(sublist);
			bclass=false;
		}
		else if(qName.equalsIgnoreCase("student")){
			stdslist.add(stds);
			bstudent=false;
		}
		else if(qName.equalsIgnoreCase("teacher"))
		{
			scl.setTeachername(info);
			bteacher=false;
		}
		else if(qName.equalsIgnoreCase("subjects")){
			sublist.add(subs);
			bsubjects=false;
		}
		else if(qName.equalsIgnoreCase("firstname")){
			stds.setFirstname(info);
		}
		else if(qName.equalsIgnoreCase("lastname")){
			stds.setLastname(info);
		}
		else if(qName.equalsIgnoreCase("dateofbirth")){
			stds.setDateofbirth("dateofbirth");
		}
		else if(qName.equalsIgnoreCase("address")){
			stds.setAddress(info);
		}
		else if(qName.equalsIgnoreCase("sub1")){
			subs.setSub1(info);
		}
		else if(qName.equalsIgnoreCase("sub2")){
			subs.setSub2(info);
		}
		else if(qName.equalsIgnoreCase("sub3")){
			subs.setSub3(info);
		}
		else if(qName.equalsIgnoreCase("sub4"))
		{
			subs.setSub4(info);
		}
		super.endElement(uri, localName, qName);
	}
	@Override
	public void characters(char[] ch, int start, int length)	throws SAXException {
		info=new String(ch,start,length);
		super.characters(ch, start, length);
	}
}

