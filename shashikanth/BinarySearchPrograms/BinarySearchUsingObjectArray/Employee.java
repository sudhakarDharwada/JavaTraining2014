package com.pack;

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
	public static Employee readEmployee()
	{
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		System.out.println("Enter Id:");
		e.setId(sc.nextInt());
		System.out.println("Enter Name:");
        e.setName(sc.next());
		return e;
	}

}
