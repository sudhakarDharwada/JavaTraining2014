package com.vl.parserexamples;

import java.util.Comparator;
import java.util.Date;

public class Student
{
	String name;
	Date dob;
	String adress;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String toString() {
        return "Student:: "+this.name+", "+this.dob+", "+this.adress;
    }
}
class compare implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2) {
		
		return o1.dob.compareTo(o2.dob);
	}
	
	
}