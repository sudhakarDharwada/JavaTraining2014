package com.val.programs;

import java.util.List;

public class BinarySearch
{
	public boolean isFound(List<Employee> el,Employee e,MyCriteria m)
	{
		int start=0,end=el.size()-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			int value=m.criteriaMethod(e, el.get(mid));
			if(value==0)
			{
				return true;
			}
			else if(value>0)
			{
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
		}
		return false;
	}
}
