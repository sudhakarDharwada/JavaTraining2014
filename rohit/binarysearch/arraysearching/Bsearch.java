package com.vl.arraysearching;

public class Bsearch 
{
	public boolean isfound(Object[] obj,Object o1,Mycriteria m)
	{
		int first,last,middle,result;
		boolean flag=false;
		first=0;
		last=obj.length-1;
		while(first<=last)
		{
			middle=(first+last)/2;
			result=m.compare(o1,obj[middle]);
			if(result>0)
				first=middle+1;
			else if(result==0)
			{
				flag=true;
				break;
			}
			else
				last=middle-1;
		}
	return flag;
	}
}
