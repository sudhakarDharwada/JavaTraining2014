package com.vl.arraysearching;

import java.util.Comparator;

public abstract class Mycriteria 
{
	abstract int compare(Object o1,Object o2);
}

class Namecriteria extends Mycriteria implements Comparator<Object>
{
	public int compare(Object o1,Object o2)
	{
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		return e1.getName().compareTo(e2.getName());
	}
}

class Idcriteria extends Mycriteria implements Comparator<Object>
{
	public int compare(Object o1,Object o2)
	{
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
		if(e1.getId()>e2.getId())
			return 1;
		else if(e1.getId()==e2.getId()) 
			return 0;
		else
			return -1;
	}
}
