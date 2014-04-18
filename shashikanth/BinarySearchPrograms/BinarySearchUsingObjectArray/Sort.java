package com.pack;

public abstract class Sort
{
    abstract Object[] sortObjects(Object[] obj);
}
class IdSort extends Sort
{
	Object[] sortObjects(Object[] obj) 
	{
		Object temp;int n=obj.length,c;
		IdCriteria idc=new IdCriteria();
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
			  c=idc.criteriaMethod(obj[i],obj[j]);
			  if(c>0)
			  {
				temp=obj[i];
				obj[i]=obj[j];
				obj[j]=temp;			
			  }
			}
		}
		return obj;
	}	
}
class NameSort extends Sort
{
	Object[] sortObjects(Object[] obj)
	{
		Object temp;int n=obj.length,c;
		NameCriteria ndc=new NameCriteria();
		for(int i=0;i<n-1;i++)
		{
			for(int j=i+1;j<n;j++)
			{
			  c=ndc.criteriaMethod(obj[i],obj[j]);
			  if(c>0)
			  {
				temp=obj[i];
				obj[i]=obj[j];
				obj[j]=temp;			
			  }
			}
		}
		return obj;
	}	
}