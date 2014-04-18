package com.binarysearch;

import java.util.Scanner;

public class Emp {

	int Id;
	String Name;

	Scanner s =  new Scanner(System.in);

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void read(){

		Emp e = new Emp();

		System.out.println("Enter ID");
		Id = s.nextInt();
		e.setId(Id);

		System.out.println("Enter Name:");
		Name = s.next();
		e.setName(Name);

	}

}
