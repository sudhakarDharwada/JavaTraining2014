package com.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int size,criteria;
		boolean flag=false;
		String value="y";
		Scanner sc = new Scanner(System.in);
		System.out.println("enter no. of objects");
		size=sc.nextInt();
		Emp[] emp = new Emp[size];
		for(int i=0;i<size;i++)
		{
			emp[i]=new Emp();
			emp[i].read();
		}
		System.out.println("enter your criteria 1.Id 2.Name :");
		criteria=sc.nextInt();
		Emp e1 =new Emp();
		BinaryScrh bs= new BinaryScrh();
		while(value.equals("y"))
		{
			if(criteria==1)
			{
				System.out.println("enter id :");	
				e1.setId(sc.nextInt());
				Arrays.sort(emp,new IntegerBinaryLogic());
				flag=bs.isfound(emp,e1,new IntegerBinaryLogic());
			}
			else if(criteria==2)
			{
				System.out.println("enter name :");
				e1.setName(sc.next());
				Arrays.sort(emp,new StringBinaryLogic());
				flag=bs.isfound(emp,e1,new StringBinaryLogic());
			}
			else
				System.out.println("not a option");
			for(Emp temp:emp)
				System.out.println(temp.getId() +" "+ temp.getName());
			if(flag)
				System.out.println("elemnet found");
			else
				System.out.println("element not found");
			System.out.println("do you want to continue (y/n) :");
			value=sc.next();
			
		
		}
	}
}
