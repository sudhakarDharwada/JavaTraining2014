package com.binarysearch;

import java.util.Comparator;

public class StringBinaryLogic extends MyCriteria implements Comparator<Object>{

	public int compare(Object o1,Object o2)
	{
		Emp e1=(Emp)o1;
		Emp e2=(Emp)o2;
		return e1.getName().compareTo(e2.getName());
	}

	
	

}
