package com.vl.handlers;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.vl.school.bean.Class;
import com.vl.school.bean.Classes;
import com.vl.school.bean.Details;
import com.vl.school.bean.School;
import com.vl.school.bean.Staff;
import com.vl.school.bean.Student;
import com.vl.school.bean.Teacher;

public class SaxHandler extends DefaultHandler{
	private School school;
	private Details details;
	private Staff staff;
	private Teacher teacher;
	private Classes classes;
	private com.vl.school.bean.Class class1;
	private Student student;
	
	private Date date;

	boolean schoolName=false;
	boolean address=false;
	boolean name=false;
	boolean classRes=false;
	boolean className=false;
	boolean studentName=false;
	boolean dob=false;
	boolean studentAddr=false;
	boolean year;
	boolean month;
	boolean day;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		if(qName.equalsIgnoreCase("Details")){
			if(school==null)
			{
				school=new School();
			}
			if (details==null) {
				details=new Details();
			}
		}
		else if (qName.equalsIgnoreCase("SchoolName")) {
			schoolName=true;
		}
		else if (qName.equalsIgnoreCase("Address")) {
			address=true;
		}
		else if (qName.equalsIgnoreCase("Staff")) {
			if(staff==null)
			{
				staff=new Staff();
			}
		}
		else if (qName.equalsIgnoreCase("Teacher")) {
			teacher=new Teacher();
		}
		else if (qName.equalsIgnoreCase("Name")) {
			name=true;
		}
		else if (qName.equalsIgnoreCase("ClassResponesable")) {
			classRes=true;
		}
		else if (qName.equalsIgnoreCase("Classes")) {
			if(classes==null)
			{
				classes=new Classes();
			}
		}
		else if (qName.equalsIgnoreCase("Class")) {
			if(class1==null){
				class1=new com.vl.school.bean.Class();
			}
		}
		else if (qName.equalsIgnoreCase("ClassName")) {
			className=true;
		}
		else if (qName.equalsIgnoreCase("Student")) {
			student=new Student();
		}
		else if (qName.equalsIgnoreCase("SName")) {
			studentName=true;
		}
		else if (qName.equalsIgnoreCase("SDOB")) {
//			System.out.println("dob started");
			TimeZone.setDefault(TimeZone.getTimeZone("GMT+05:30"));
			if(date==null){
				date=new Date();
			}

		}
		else if (qName.equalsIgnoreCase("year")) {
//			System.out.println("year 1");
			year=true;
		}
		else if (qName.equalsIgnoreCase("month")) {
//			System.out.println("month");
			month=true;
		}
		else if (qName.equalsIgnoreCase("date")) {
//			System.out.println("date");
			day=true;
		}
		else if (qName.equalsIgnoreCase("SAddress")) {
			studentAddr=true;
		}
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equalsIgnoreCase("Details")){
			school.setDetails(details);
		}
		else if (qName.equalsIgnoreCase("Teacher")) {
			staff.addTeachers(teacher);
		}
		else if (qName.equalsIgnoreCase("Staff")) {
			school.setStaff(staff);
		}
		else if (qName.equalsIgnoreCase("SDOB")) {	
//			System.out.println(date);
			student.setSDOB(date);
			date=null;
//			System.out.println("dob ended");
		}
		else if (qName.equalsIgnoreCase("Student")) {
			class1.addStudent(student);
		}
		else if (qName.equalsIgnoreCase("Class")) {
			classes.addClass(class1);
			class1=null;
		}
		else if (qName.equalsIgnoreCase("Classes")) {
			school.setClasses(classes);
		}
	}
	public void characters(char ch[], int start, int length) throws SAXException {
/*		if(year||month||day){
			System.out.println("y:"+year+" m:"+month+" day"+day);
		}*/
		if(schoolName){
			details.setSchoolName(new String(ch,start,length));
			schoolName=false;
		}
		else if (address) {
			details.setAddress(new String(ch,start,length));
			address=false;
		}
		else if (name) {
			teacher.setName(new String(ch,start,length));
			name=false;
		}
		else if (classRes) {
			teacher.setClassResponesable(new String(ch,start,length));
			classRes=false;
		}
		else if (className) {
			class1.setClassName(new String(ch,start,length));
			className=false;
		}
		else if (studentName) {
			student.setSName(new String(ch,start,length));
			studentName=false;
		}
		else if (year) {
//			System.out.println("year2");
			date.setYear(Integer.parseInt(new String(ch,start,length))-1900);
			year=false;
		}
		else if (month) {
			date.setMonth(Integer.parseInt(new String(ch,start,length))-1);
			month=false;
		}
		else if(day) {
			date.setDate(Integer.parseInt(new String(ch,start,length)));
			day=false;
		}
		else if (studentAddr) {
			student.setSAddress(new String(ch,start,length));
			address=false;
		}

	}
	public void display(){
		List<Teacher> list;
		List<com.vl.school.bean.Class> classList;
		List<Student> stuList;
		System.out.println("School Name:"+school.getDetails().getSchoolName());
		System.out.println("School Address:"+school.getDetails().getAddress());
		System.out.println("staff");
		list=school.getStaff().getTeachers();
		for(Teacher t:list){
			System.out.println("Teacher Name:"+t.getName());
			System.out.println("Responsible for:"+t.getClassResponesable());
		}
		classList=school.getClasses().getClasses();
		for(Class c:classList){
			System.out.println("class Name:"+c.getClassName());
			stuList=c.getStudents();
			for(Student s:stuList){
				System.out.println("Student Name:"+s.getSName());
				System.out.println("Student DOB:"+s.getSDOB());
				System.out.println("student Address:"+s.getSAddress());
			}
		}
	}
}
