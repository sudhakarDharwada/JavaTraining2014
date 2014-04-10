package com.binarysearch.emp;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.binarysearch.bean.Employee;
import com.binarysearch.rules.MyCondition;
import com.binarysearch.search.BinarySearch;

public class EmployeeDetails {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EmployeeDetails ed = new EmployeeDetails();
		BinarySearch bs = new BinarySearch();
		Object[] emp = ed.input();
		String option = "y";
		while (option.equals("y")) {
			Object SearchKey = ed.inputOfSearchKey();
			if (SearchKey != null) {
				if (bs.isExist(emp, SearchKey, new MyCondition())) {
					System.out.println("The Employee found");
				} else {
					System.out.println("The Employee Not found");
				}
			} else {
				System.out.println("Sorry try again...!");
			}
			System.out.println("Do you want to Try again........(y/n)");
			option = s.next();
		}

	}
	/*This Method Reads the Search key For User*/
	public Object inputOfSearchKey() {
		Scanner s = new Scanner(System.in);
		boolean condition = true;
		Object searchkey = null;
		while (condition) {
			System.out.println("\n\n1.Search through ID:");
			System.out.println("\n\n2.Search through Name:");
			System.out.println("\n\n\n");
			System.out.print("Enter the Option:\t");
			int option = s.nextInt();
			if (option == 1) {
				System.out.print("\nEnter Key To Search:\t");
				int key = s.nextInt();
				searchkey = new Employee(key);
				condition = false;
			} else if (option == 2) {
				System.out.print("\nEnter Key To Search:\t");
				String key = s.next();
				searchkey = new Employee(key);
				condition = false;
			} else {
				System.out.println("\n Wrong Option \n");
				condition = false;
			}
		}
		return searchkey;
	}
	/*This read the List of Employees from User*/
	public Object[] input() {
		Scanner s = new Scanner(System.in);
		System.out.print("How many records do you want to Enter:\t");
		int len = 0;
		try {
			len = s.nextInt();
		} catch (InputMismatchException e) {
			System.out
					.println("\n\nnumber of records should me Number\n\n sorry try again...!");
			System.exit(0);
		}
		Object[] emp = new Employee[len];
		for (int i = 0; i < emp.length; i++) {
			System.out.print("\n\nEnter Employee " + (i + 1) + " Details");
			emp[i] = Employee.setEmployee();
		}

		return emp;
	}

}
