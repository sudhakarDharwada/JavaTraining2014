package com.val.xml;

import java.util.Comparator;

public class AgeCompare implements Comparator< Student>
{
	public int compare(Student s1, Student s2) 
	{
		return s1.getDOB().compareTo(s2.getDOB());
	}
}
