package com.pack;

public class Factory
{
	public static IdCriteria idCriteria=new IdCriteria();
	public static NameCriteria nameCriteria=new NameCriteria();
	public static MyCriteria getCriteriaObject(int choice,Object[] obj)
	{
		if(choice==1)
		{		
			return idCriteria;
		}
		else if(choice==2)
		{
			return nameCriteria;
		}
		else
		{
			return null;
		}
	}
}
