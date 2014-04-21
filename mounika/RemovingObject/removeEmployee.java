package Employees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class removeEmployee {

	public List<Employee1> values(List employeelist) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter number of employee objects to the list");
		int listsize = scanner.nextInt();
		for (int i = 0; i < listsize; i++) {
			employeelist.add(Employee1.Employee());
		}
		Iterator<Employee1> itr = employeelist.iterator();
		System.out.println("ENTER WHICH DEPARTMENT U WANT TO REMOVE");
		String Name = scanner.next();
		System.out.println("list of employees present");
		while (itr.hasNext()) {
			Employee1 emp = (Employee1) itr.next();
			System.out.println("employee id" + emp.getEmpid());
			System.out.println("employee name" + emp.getEmployeeName());
			System.out.println("employee depatment" + emp.getDepratment());
			// removing same department objects

			boolean removeobject = (emp.getEmployeeName().equals(Name));
			{
				if (removeobject == true) {
					itr.remove();
				}
			}
		}

		return employeelist;

	}

	public static void main(String[] args) {
		List<Employee1> list = new ArrayList<Employee1>();
		removeEmployee empr = new removeEmployee();
		list = empr.values(list);

		for (Employee1 removedlist : list) {
			Employee1 emp = (Employee1) removedlist;
			System.out.println("List after deleting the duplicate object");
			System.out.println("employee id" + emp.getEmpid());
			System.out.println("employee name" + emp.getEmployeeName());
			System.out.println("employee depatment" + emp.getDepratment());

		}

	}

}
