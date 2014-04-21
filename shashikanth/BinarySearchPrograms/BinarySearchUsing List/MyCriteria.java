package com.val.programs;

public abstract class MyCriteria 
{
	abstract int criteriaMethod(Employee e1,Employee e2);

}

class IdCriteria extends MyCriteria
{
	int criteriaMethod(Employee e1, Employee e2)
	{
		if(e1.getId()>e2.getId())
		{
			return 1;
		}
		else if(e1.getId()<e2.getId())
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	
}
class NameCriteria extends MyCriteria
{
	int criteriaMethod(Employee e1, Employee e2)
	{	
		return e1.getName().compareTo(e2.getName());
	}
	
}