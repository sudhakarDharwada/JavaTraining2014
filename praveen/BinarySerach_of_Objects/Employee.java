package com.binarysearch.bean;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
	private int empId;
	private String empName;

	public Employee() {

	}

	public Employee(String empName) {
		this.empName = empName;
	}

	public Employee(int empId) {
		this.empId = empId;
	}

	public Employee(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public static Employee setEmployee() {
		Scanner s = new Scanner(System.in);
		int id = 0;
		String Name = null;

		System.out.print("\n\nEnter the Employee Id:\t");

		try {
			id = s.nextInt();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Id should be Number\n\nSorry try again...!");
			System.exit(0);
		}
		System.out.print("\n\nEnter The Employee Name:\t");
		try {
			Name = s.next();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Name Should not Be Number\n\nSorry try again...!");
			return null;
		}
		Employee e = new Employee(id, Name);
		return e;
	}

}
