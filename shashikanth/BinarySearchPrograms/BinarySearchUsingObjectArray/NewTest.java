package com.pack;

import java.util.Scanner;

public class NewTest
{
	public static void main(String[] args)
	{
		System.out.println("Enter number of Employees:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Object[] obj=new Object[n];
		for(int i=0;i<n;i++)
		{
			obj[i]=Employee.readEmployee();
		}
		start(obj);
	}

	public static void start(Object[] obj)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose criteria:\n1:Id\n2:Name");
		int choice;
		choice=sc.nextInt();
		MyCriteria mc=Factory.getCriteriaObject(choice,obj);
		Employee e1=new Employee();
		if(choice==1)
		{
		   Sort ids=new IdSort();
		   Object[] obj1=ids.sortObjects(obj);
		   System.out.println("Enter Employee Id:");
		   e1.setId(sc.nextInt());
		   search(obj1,e1,mc);
		}
		else if(choice==2)
		{
		   Sort nds=new NameSort();
		   Object[] obj1=nds.sortObjects(obj);
		   System.out.println("Enter Employee Name:");
		   e1.setName(sc.next());
		   search(obj1,e1,mc);
		}
		else
		{
			System.out.println("Enter valid Criteria! ");
			start(obj);
		}
	}

	private static void search(Object[] obj, Object e1, MyCriteria mc)
	{
		boolean result;
		BinarySearch bs=new BinarySearch();
		result=bs.isFound(obj, e1, mc);	
		if(result)
		{
			System.out.println("Employee found");
			continueSearch(obj);
		}
		else
		{
			System.out.println("Employee Not Found");
			continueSearch(obj);
		}
	}

	public static void continueSearch(Object[] obj)
	{
		Scanner sc=new Scanner(System.in);
		String ch=null;
		System.out.println("Do you want to continue Search(y/n)");
		ch=sc.next();
		if(ch.equalsIgnoreCase("y"))
		{
			start(obj);
		}
		
	}
}
