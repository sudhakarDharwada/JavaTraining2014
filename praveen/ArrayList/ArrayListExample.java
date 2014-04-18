package com.employee.logics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.employee.beans.Employee;

public class ArrayListExample {

	public static void main(String[] args) throws IOException {

		List<Employee> list = new ArrayList<Employee>();
		myLogic(list);
	}

	public static void myLogic(List<Employee> list) throws IOException {
		ArrayListExample ale = new ArrayListExample();
		Scanner s = new Scanner(System.in);
		Iterator<Employee> itr = null;
		String condition = "y";
		int option = 0;
		while (condition.equals("y")) {

			Runtime.getRuntime().exec("clear");
			System.out.println("\n\tMenu");
			System.out.println("\n1)Add");
			System.out.println("\n2)Remove all by Designation");
			System.out.println("\n3)Display all");
			System.out.println("\n4)EXIT");
			System.out.print("\nOPTION IS:");
			try {
				option = s.nextInt();
				ale.myCondition(list, option, itr);
			} catch (InputMismatchException e) {
				System.out
						.println("The Option Should be Number\n\n Try Again ...!");
			}
		}
	}

	public String myCondition(List<Employee> list, int option,
			Iterator<Employee> itr) {
		String condition = "y";
		Scanner s = new Scanner(System.in);
		String desig = null;
		if (option == 1) {
			Employee e = Employee.setEmployee();
			if (e != null) {
				list.add(e);
			} else {
				System.out.println("sorry try again...!");
			}

		} else if (option == 2) {
			if (list.isEmpty()) {
				System.out.println("The List Is Empty");
			} else {
				int count = 0;
				System.out.print("\n\nEnter The Employee Designation:");
				desig = s.next();
				itr = list.iterator();
				while (itr.hasNext()) {
					Employee employee = (Employee) itr.next();
					if (desig.equals(employee.getEmployeeDesignation())) {
						count++;
						list.remove(employee);
						itr = list.iterator();
					}
				}
				if (count <= 0) {
					System.out
							.println("\nNO EMPLOYEES FOUND WITH THIS DESIGNATION:"
									+ desig);
				} else if (count == 1) {
					System.out.println("\n" + count
							+ " Employee was Deleted Sucessfully");

				} else {
					System.out.println("\n" + count
							+ " Employees Were Deleted Sucessfully");

				}

			}

		} else if (option == 3) {
			if (list.isEmpty()) {
				System.out.println("\nThe List Is Empty");
			} else {
				itr = list.iterator();
				while (itr.hasNext()) {
					Employee employee = (Employee) itr.next();
					Employee.displayEmployee(employee);
				}
			}
		} else if (option == 4) {
			condition = "n";
		} else {
			System.out.println("\nworng Option \n\nTrain again...!");
		}
		return condition;
	}

}

