package com.val.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee 
{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static List<Employee> readEmployee()
	{
		List<Employee> elist=new ArrayList<Employee>();
		System.out.println("Enter number of Employees:");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
		   Employee e=new Employee();
		   System.out.println("Enter Id:");
		   e.setId(sc.nextInt());
		   System.out.println("Enter Name:");
		   e.setName(sc.next());
		   elist.add(e);
		}
		return elist;
	}
}
