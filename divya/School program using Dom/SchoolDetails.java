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
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


public class SchoolDetails{
 static Scanner s=new Scanner(System.in);
 static int count=0;	
 static Document document;
 static DocumentBuilder builder;
 static DocumentBuilderFactory factory;

 public static void main(String[] args) {
  try {
   factory = DocumentBuilderFactory.newInstance();
   factory.setValidating(true);
   System.out.println("Enter an xml file :");
   File file = new File(s.next());
   builder=factory.newDocumentBuilder();
   document = builder.parse(file);
  } 
  catch(SAXParseException spe){
     System.out.println("spe");
   }
   catch (SAXException sxe){
     System.out.println("sxe");
   }
   catch(ParserConfigurationException pce){
     System.out.println("pce");
   }
   catch(IOException ioe){
     System.out.println("ioe");
   }	
  System.out.println("Enter \n1 to get the oldest age for a given class \n2 to get no.of students from a class\n3  to get class name for a given teacher \n ");
  int choice=s.nextInt();
  switch(choice){
    case 1: getOldestAge();
      break;
    case 2: noOfStudents();
      break;
    case 3: getClassName();
      break;
    default:System.out.println("Invalid selection");
  }
 }

 public static void getOldestAge(){
   System.out.println("enter standard");
   String std=s.next();
   NodeList nodelist = document.getElementsByTagName("standard");
   long time=0;
   for(int i=0;i<nodelist.getLength();i++){
     Node n=nodelist.item(i);
     if(std.equalsIgnoreCase(n.getTextContent())){
       Node n1=n.getParentNode();
       NodeList nodelist1=n1.getChildNodes();
       for(int j=0;j<nodelist1.getLength();j++){
         Node n2=nodelist1.item(j);
         if(n2.getNodeName().equalsIgnoreCase("student")){
           NodeList nodelist2=n2.getChildNodes();
           for(int a=1;a<nodelist2.getLength();a++){
             Node n3=nodelist2.item(a);
             if(n3.getNodeName().equalsIgnoreCase("dob")){
               long time1=SchoolDetails.convert(n3.getTextContent());
               if(time1>time)
                time=time1;
             }
           }
        }
      }
      System.out.println("oldest age is "+TimeUnit.MILLISECONDS.toDays(time)/365+" years "+(TimeUnit.MILLISECONDS.toDays(time)%365)/30+" months "+((TimeUnit.MILLISECONDS.toDays(time)%365)%30)+" days");
    }
   }
 }
 
 public static long convert(String t){
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
   Date date=null;
   try{
     date = formatter.parse(t);
   }
   catch (ParseException e){
     e.printStackTrace();
   }
   return System.currentTimeMillis()-date.getTime();
 }


 public static void noOfStudents(){
   System.out.println("Enter standard");
   String std1=s.next();
   int count=0;
   NodeList nodelist=document.getElementsByTagName("class");
   for(int i=0;i<nodelist.getLength();i++){
    Node n=nodelist.item(i);
    if(n instanceof Element){
      if(((Element)n).getAttribute("standard").equalsIgnoreCase(std1)){
        NodeList childs=n.getChildNodes();
        for(int j=0;j<childs.getLength();j++){
          Node b=childs.item(j);
          if(b.getNodeName().equals("student")){
            count++;
          }	
        }
      }
    }
  }
  System.out.println("the no.of students in class "+std1+" are "+count);	
 }

 public static void getClassName(){
   System.out.println("Enter name of a teacher");
   String tname=s.next();
   NodeList nodelist=document.getElementsByTagName("teacher");
   for(int i=0;i<nodelist.getLength();i++){
    Node n=nodelist.item(i);
    if(n instanceof Element){
      NodeList childs=n.getChildNodes();
      for(int j=0;j<childs.getLength();j++){
        Node c=childs.item(j);
        if(c.getNodeName().equals("tname")){
          if(c.getTextContent().equalsIgnoreCase(tname)){
            System.out.println(tname+" belongs to "+ ((Element)n).getAttribute("standard"));
            break;
          }
        }
      }
    }
   }
 }
}
 

