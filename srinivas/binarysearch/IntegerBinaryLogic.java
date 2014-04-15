package com.binarysearch;

import java.util.Comparator;


class IntegerBinaryLogic extends MyCriteria implements Comparator<Object>
	{
	public int compare(Object o1,Object o2)
	{
		Emp e1=(Emp)o1;
		Emp e2=(Emp)o2;
		if(e1.getId()>e2.getId())
			return 1;
		else if(e1.getId()==e2.getId()) 
			return 0;
		else
			return -1;
	}
	}