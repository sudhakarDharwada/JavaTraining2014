package com.vl.school.bean;

import java.util.ArrayList;
import java.util.List;

public class Class {
	private String ClassName;
	private List<Student> Students;
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public void addStudent(Student student){
		if(Students==null){
			Students=new ArrayList<Student>();
		}
		Students.add(student);
	}
	public List<Student> getStudents() {
		return Students;
	}
	public void setStudents(List<Student> students) {
		Students = students;
	}
	
}
