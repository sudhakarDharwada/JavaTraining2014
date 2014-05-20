package com.vl.parserexamples;

import java.util.List;

public class Classes
{
	//String class_Name;
	List<Student> s;
	Teacher t;
	List<String> sublist;
	
	public void setS(List<Student> s) {
		this.s = s;
	}
	/*public String getClass_Name() {
		return class_Name;
	}
	public void setClass_Name(String class_Name) {
		this.class_Name = class_Name;
	}*/
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public List<String> getSublist() {
		return sublist;
	}
	public void setSublist(List<String> sublist) {
		this.sublist = sublist;
	}
	public List<Student> getS() {
		return s;
	}
	public String toString() {
        return this.s.toString()+"|| "+this.t.toString()+"|| "+"list of subjects :"+this.sublist.toString();
    }
}
