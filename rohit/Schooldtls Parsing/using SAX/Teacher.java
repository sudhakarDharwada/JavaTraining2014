package com.vl.parserexamples;

public class Teacher {
	String teacher_Name;

	public String getTeacher_Name() {
		return teacher_Name;
	}
	public void setTeacher_Name(String teacher_Name) {
		this.teacher_Name = teacher_Name;
	}
	public String toString() {
        return "[Teacher:: "+this.teacher_Name+"]";
    }
}
