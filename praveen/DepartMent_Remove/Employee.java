package com.employee.beans;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Employee {
	private String EmployeeName;
	private int EmployeeId;
	private String EmployeeDesignation;

	public Employee() {

	}

	public Employee(String EmployeeName, int EmployeeId,
			String EmployeeDesignation) {
		this.EmployeeName = EmployeeName;
		this.EmployeeId = EmployeeId;
		this.EmployeeDesignation = EmployeeDesignation;
	}
	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}
	public static Employee setEmployee() {
		Scanner s = new Scanner(System.in);
		int id = 0;
		String Name = null;
		String Desig = null;
		Employee e=null;
		System.out.print("\nEnter the Employee Id:\t");

		try {
			id = s.nextInt();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Id should be Number\n");
			return null;
		}
		System.out.print("\nEnter The Employee Name:\t");
		try {
			Name = s.next();
		} catch (InputMismatchException e1) {
			System.out
					.println("\nThe Name Should not Be Number\n");
			return null;
		}
		System.out.print("\nEnter The Employee Designation:");
		try {
			Desig = s.next();
		} catch (InputMismatchException e1) {
			System.out.print("\nThe Desigation sholud be \n");
			return null;
		}
		if((id!=0)&&(Name!=null)&&(Desig!=null)){
			e = new Employee(Name, id, Desig);
		}
		return e;
	}
	public static void displayEmployee(Employee e) {
		System.out.println("\n\nEmployee ID:"+e.EmployeeId);
		System.out.print("\tEmployee Name:"+e.EmployeeName);
		System.out.println("\tEmployee Designation:"+e.EmployeeDesignation);
	}
}
