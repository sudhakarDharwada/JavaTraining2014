package com.pack;

public class BinarySearch 
{
	public boolean isFound(Object[] obj,Object key,MyCriteria m)
	{
		int start=0,end=obj.length-1;
		while(start<=end)
		{
			int mid=(start+end)/2;
			int value=m.criteriaMethod(key,obj[mid]);
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
