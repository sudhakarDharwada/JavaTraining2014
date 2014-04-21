package com.val.programs;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Factory 
{
	public static MyCriteria getCriteriaObject(int choice,List<Employee> list)
	{
		
		if(choice==1)
		{
			Collections.sort(list,new IdCompare());
			return new IdCriteria();
		}
		else
		{
			Collections.sort(list,new NameCompare());
			return new NameCriteria();
		}
	}

}
class NameCompare implements Comparator<Employee>
{
	public int compare(Employee o1, Employee o2) 
	{
		return o1.getName().compareTo(o2.getName());
	}
	
}
class IdCompare implements Comparator<Employee>
{
	public int compare(Employee o1, Employee o2)
	{	
		return o1.getId()-o2.getId();
	}
	
}