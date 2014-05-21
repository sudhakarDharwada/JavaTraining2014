package com.val.xml;

import java.util.List;

public class Classes
{
	private String className;
	private List<Student> sd;
	public List<Student> getSd() {
		return sd;
	}
	public void setSd(List<Student> sd) {
		this.sd = sd;
	}
	private String teacherName;
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public List<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}
	private List<String> subjects;
}
