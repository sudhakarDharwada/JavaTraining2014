package com.vl.arraysearching;

import java.util.Arrays;
import java.util.Scanner;

public class Test 
{
	public static void main(String[] args) 
	{
		int size,criteria;
		boolean flag=false;
		String value="y";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no. of objects");
		size=sc.nextInt();
		Employee[] emp = new Employee[size];
		for(int i=0;i<size;i++)
		{
			emp[i]=Employee.read();
		}
		System.out.println("enter your criteria 1.Id 2.Name :");
		criteria=sc.nextInt();
		Employee e1 =new Employee();
		Bsearch bs= new Bsearch();
		while(value.equalsIgnoreCase("y"))
		{
			if(criteria==1)
			{
				System.out.println("enter id :");	
				e1.setId(sc.nextInt());
				Arrays.sort(emp,new Idcriteria());
				flag=bs.isfound(emp,e1,new Idcriteria());
			}
			else if(criteria==2)
			{
				System.out.println("enter name :");
				e1.setName(sc.next());
				Arrays.sort(emp,new Namecriteria());
				flag=bs.isfound(emp,e1,new Namecriteria());
			}
			else
			{
				System.out.println("not a valid option");
				break;
			}
			if(flag)
				System.out.println("elemnet found");
			else
				System.out.println("element not found");
			System.out.println("do you want to continue (y/n) :");
			value=sc.next();
		}
	}
}
