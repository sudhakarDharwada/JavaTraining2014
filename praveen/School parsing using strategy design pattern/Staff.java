package com.vl.school.beans;

import java.util.ArrayList;
import java.util.List;

public class Staff {
	private List<Teacher> teachers;

	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public void addTeachers(Teacher teacher){
		if(teachers==null)
		{
			teachers=new ArrayList<Teacher>();
		}
		teachers.add(teacher);
	}
}
