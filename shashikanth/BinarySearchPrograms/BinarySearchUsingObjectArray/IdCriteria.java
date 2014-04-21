package com.pack;

public class IdCriteria extends MyCriteria
{
	int criteriaMethod(Object o1, Object o2)
	{
		Employee e1=(Employee)o1;
		Employee e2=(Employee)o2;
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
