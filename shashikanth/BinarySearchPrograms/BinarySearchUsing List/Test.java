package com.val.programs;

import java.util.List;
import java.util.Scanner;


public class Test
{

	public static void main(String[] args)
	{
		List<Employee> elist=Employee.readEmployee();
		System.out.println("Choose criteria:\n1:Id\n2:Name");
		Scanner sc=new Scanner(System.in);
		int choice;
		choice=sc.nextInt();
		MyCriteria mc=Factory.getCriteriaObject(choice,elist);
		
		Employee e1=new Employee();
		if(choice==1)
		{
		   System.out.println("Enter Employee Id:");
		   e1.setId(sc.nextInt());
		   search(elist,e1,mc);
		}
		else
		{
		   System.out.println("Enter Employee Name:");
		   e1.setName(sc.next());
		   search(elist,e1,mc);
	    }
	}
	public static void search(List<Employee> elist,Employee e1,MyCriteria mc)
	{
		
		BinarySearch bs=new BinarySearch();
		boolean  result=bs.isFound(elist, e1, mc);
		if(result)
		{
			System.out.println("Employee Found");
		}
		else
		{
			System.out.println("Employee Not Found");
		}
	}

}
