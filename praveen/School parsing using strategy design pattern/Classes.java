package com.vl.school.beans;

import java.util.ArrayList;
import java.util.List;

public class Classes {
	private List<Class> classes;

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}
	 
	public void addClass(Class class1){
		if(classes==null)
		{
			classes=new ArrayList<Class>();
		}
		classes.add(class1);
	}
}
