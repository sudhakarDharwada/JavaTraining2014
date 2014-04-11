package com.vl.searching;

public abstract class Mycriteria 
{
	abstract int compare(Employee e1,Employee e2);

}

class Idcriteria extends Mycriteria
{
	int compare(Employee e1,Employee e2)
	{
		if(e1.getId()>e2.getId())
			return 1;
		else if(e1.getId()==e2.getId()) 
				return 0;
			else
				return -1;
	}

}
class Namecriteria extends Mycriteria
{
	int compare(Employee e1,Employee e2)
	{
		return e1.getName().compareTo(e2.getName());
	}

}
