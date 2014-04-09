package com.vlabs.employee.mainclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import com.vlabs.employee.bean.EmployeeRecord;

public class EmployeeRecordFilter {
        /*The Main Method*/
	public static void main(String[] args) {
		EmployeeRecordFilter eRecordFilter = new EmployeeRecordFilter();
		Scanner s = new Scanner(System.in);
		List<EmployeeRecord> list = null;
		System.out.println("Enter The File Path To process:");
		String path = null;
		int condition = 1;
		int option = 0;
		try {
			path = s.next();
			list = eRecordFilter.fileInput(path);
			while (condition != 5) {
				System.out
						.println("\n\n  Menu\n 1)search by Date \n 2)search by Time\n 3)Working hours \n 4)display all \n 5)EXIT");
				System.out.println("\n\nEnter your Option:");
				option = s.nextInt();
				if (option == 1) {
					eRecordFilter.searchByDate(list);

				} else if (option == 2) {
					eRecordFilter.searchByTime(list);
				} else if (option == 3) {
					eRecordFilter.workingHours(list);
					
				} else if (option == 4) {
					eRecordFilter.displayAll(list);
				} else if (option == 5) {
					condition = option;
				} else {
					System.out.println("wrong option");
				}

			}
		} catch (InputMismatchException e) {
			System.out
					.println("The path should not be number \n Try again ....!");
		} catch (FileNotFoundException e) {
			System.out.println("The file is not found \n try again ....!");
		} catch (IOException e) {
			System.out.println("File Read Error");
		}
	}
        /*This method can read the file and store the recods ina collection*/
	public List<EmployeeRecord> fileInput(String path)
			throws FileNotFoundException, IOException {
		BufferedReader input = new BufferedReader(new FileReader(path));
		String str = null;
		String arg[] = new String[3];
		StringTokenizer sTokenizer = null;
		EmployeeRecord eRecord = null;
		List<EmployeeRecord> list = new ArrayList<EmployeeRecord>();
		while ((str = input.readLine()) != null) {
			sTokenizer = new StringTokenizer(str, ",");
			for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
				arg[i] = sTokenizer.nextToken();
			}
			if (arg[0] != null) {
				int id = Integer.parseInt(arg[0]);
				String status = arg[1];
				long time = Date.parse(arg[2]);
				Date date = new Date(time);
				// System.out.println(date);

				eRecord = new EmployeeRecord(id, status, date);
				list.add(eRecord);
			}
		}
		return list;
	}
        /*This method is used to search the Employee in a particular date*/
	public void searchByDate(List<EmployeeRecord> list) {
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter the Date to serach\nYear:");
		int yyyy = s.nextInt();
		System.out.print("\nMonth:");
		int mm = s.nextInt();
		System.out.println("\ndate");
		int dd = s.nextInt();
		Date date = new Date(yyyy, mm, dd);
		Iterator<EmployeeRecord> itr = list.iterator();
		Set<Integer> set=new HashSet<Integer>();
		while (itr.hasNext()) {
			EmployeeRecord employeeRecord = (EmployeeRecord) itr.next();
			if ((employeeRecord.compareTo(date))) {
				set.add(employeeRecord.getId());
			}

		}
		System.out.println("\n Employees present in this Date\n"+set);
	}
        /*This method is used to Search The Employee in a particular time*/
	public void searchByTime(List<EmployeeRecord> list) {
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter the Date to serach");
		System.out.println("\nHours:");
		int hours=s.nextInt();
		System.out.println("\nMintues:");
		int minutes=s.nextInt();
		Date date = new Date();
		date.setHours(hours);
		date.setMinutes(minutes);
		Iterator<EmployeeRecord> itr = list.iterator();
		Set<Integer> set=new HashSet<Integer>();
		while (itr.hasNext()) {
			EmployeeRecord employeeRecord = (EmployeeRecord) itr.next();
			if ((employeeRecord.compareTo(date))) {
				set.add(employeeRecord.getId());
			}

		}
		System.out.println("\n Employees present in this Time\n"+set);
	}
        /*This method is usefull to display all records in the file*/
	public void displayAll(List<EmployeeRecord> list) {
		java.util.Iterator<EmployeeRecord> itr = list.iterator();
		if (list.isEmpty()) {
			System.out.println("The List is empty");
		} else {
			System.out.println("EmploeeID   EmployeeStatus   EmployeeTime");
			while (itr.hasNext()) {
				EmployeeRecord employeeRecord = (EmployeeRecord) itr.next();
				System.out.println(employeeRecord.getId() + "\t\t"
						+ employeeRecord.getStatus() + "\t\t"
						+ employeeRecord.getD());

			}
		}

	}
        /*This method is used to find the employees working hours*/
	public void workingHours(List<EmployeeRecord> list) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter The Employee ID");
		int eid=s.nextInt();
		int hour=0,minutes=0;
		Iterator<EmployeeRecord> itr1 = list.iterator();
		Iterator<EmployeeRecord> itr2 = list.iterator();
		while (itr1.hasNext()) {
			EmployeeRecord employeeRecord1 = (EmployeeRecord) itr1.next();
				if(((employeeRecord1.getId())==eid)&&((employeeRecord1.getStatus()).equalsIgnoreCase("in")))
				{
					itr2=list.iterator();
					while(itr2.hasNext())
					{
						EmployeeRecord employeeRecord2 = (EmployeeRecord) itr2.next();
						if(((employeeRecord2.getStatus().equalsIgnoreCase("out")))&&((employeeRecord2.getD().getDate())==employeeRecord1.getD().getDate())&&((employeeRecord2.getId())==eid))
						{
							System.out.println("Im in in");
							hour+=employeeRecord2.getD().getHours()-employeeRecord1.getD().getHours();
							minutes+=Math.abs(employeeRecord2.getD().getMinutes()-employeeRecord1.getD().getMinutes());
							break;
						}
					}
				}
			}
		if(minutes>60)
		{
			hour+=minutes/60;
			minutes=minutes%60;
			System.out.println("Working hours : "+hour+" hours "+minutes+" Minutes");
		}
		else {
			System.out.println("Working hours : "+hour+" hours "+minutes+" Minutes");
		}
	}
}

