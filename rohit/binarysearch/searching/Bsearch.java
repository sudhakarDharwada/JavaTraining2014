package com.vl.searching;
import java.util.List;

public class Bsearch 
{
	public boolean isfound(List<Employee> ar,Employee e2,Mycriteria m)
	{
		int first,last,middle;
		boolean flag=false;
		first=0;
		last=ar.size();
			while(first<=last)
			{
				middle=(first+last)/2;
				int i=m.compare(e2,ar.get(middle));
				if(i>0)
					first=middle+1;
				else if(i==0)
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
