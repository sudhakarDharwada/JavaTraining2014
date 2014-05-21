package com.vl.school.testclasses;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.vl.handlers.Compare;
import com.vl.handlers.MyErrorHandler;
import com.vl.handlers.MyThreadLocal;
import com.vl.handlers.SaxHandler;
import com.vl.school.bean.Class;
import com.vl.school.bean.School;
import com.vl.school.bean.Student;
import com.vl.school.bean.Teacher;

public class SchoolSearch 
{
	static School school=null;
	static boolean isValidate=false;
	public static void main(String[] args) 
	{
		SchoolSearch ss=new SchoolSearch();
		ss.MainLogic();
	}
	public void MainLogic()
	{

		Scanner s=new Scanner(System.in);
		int option;
		MyThreadLocal.set(isValidate);
		boolean condition=true;
		while (condition) {
			System.out.println("\n\nMenu");
			System.out.println("1)Enter New file");
			System.out.println("2)search teacher");
			System.out.println("3)search oldest student");
			System.out.println("4)Exit");
			System.out.print("option:");
			option=s.nextInt();
			if(option==1){
				System.out.println("Enter the file path:");
				String filePath=s.next();
				isValidate=true;
				MyThreadLocal.set(isValidate);
				school=null;
				SAXParserFactory factory=SAXParserFactory.newInstance();
				try {
					factory.setValidating(true);
					factory.setNamespaceAware(true);
					SAXParser parser=factory.newSAXParser();
					
					XMLReader reader=parser.getXMLReader();
					reader.setErrorHandler(new MyErrorHandler());
					reader.parse(new InputSource(filePath));
					SaxHandler handler=new SaxHandler();
					reader.setContentHandler(handler);
					reader.parse(new InputSource(filePath));
					school=handler.getSchool();
					//System.out.println(school);
					//handler.display();
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else if (option==2) {
				searchTeacher();
			}
			else if (option==3) {
				oldestStudent();
			}
			else if (option==4) {
				condition=false;
			}

			else {
				System.out.println("wrong option");
			}
		}
	}
	public void searchTeacher(){
		Scanner s=new Scanner(System.in);
		isValidate=MyThreadLocal.get();
		if(isValidate||school!=null){
			String trep=null;
			System.out.println("Enter the teacher name:");
			String teacher=s.next();
			List<Teacher> teachers=school.getStaff().getTeachers();
			for(Teacher t:teachers){
				if(t.getName().equalsIgnoreCase(teacher)){
					trep=t.getClassResponesable();
					System.out.println(t.getName()+" is reponsible for class "+t.getClassResponesable());
				}
			}

			List<Class> classes=school.getClasses().getClasses();
			for(Class c:classes){
				if(c.getClassName().equalsIgnoreCase(trep)){
					System.out.println("The no of students in the "+c.getClassName()+" class are:"+c.getStudents().size());
				}
			}
		}
		else {
			System.out.println("file not found or invalid");
		}
	}
	public void oldestStudent(){
		Scanner s=new Scanner(System.in);
		isValidate=MyThreadLocal.get();
		List<Student> students=null;
		if(isValidate||school!=null){
			System.out.println("Enter the class Name");
			String cls=s.next();
			List<Class> classes=school.getClasses().getClasses();
			for(Class c:classes){
				if(c.getClassName().equalsIgnoreCase(cls))
				{
					students=c.getStudents();
				}
			}
			Collections.sort(students, new Compare());
			System.out.println("The Oldest student in "+cls+" class is "+students.get(0).getSName());
		}
		else {
			System.out.println("file not found or invalid");
		}
	}
}

