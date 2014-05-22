package com.vl.school.testclasses;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.vl.school.adstractclasses.Parsers;
import com.vl.school.adstractclasses.SchoolSaxParser;
import com.vl.school.beans.School;
import com.vl.school.beans.Student;
import com.vl.school.beans.Teacher;
import com.vl.school.handlers.Compare;
import com.vl.school.handlers.MyThreadLocal;
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
				Parsers p= new SchoolSaxParser();
//				Parsers p= new SchoolDomParser();
				school=p.parser(filePath);
				
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

			List<com.vl.school.beans.Class> classes=school.getClasses().getClasses();
			for(com.vl.school.beans.Class c:classes){
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
			List<com.vl.school.beans.Class> classes=school.getClasses().getClasses();
			for(com.vl.school.beans.Class c:classes){
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
