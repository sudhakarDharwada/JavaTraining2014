package com.inputfiles.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import com.vlabs.employee.bean.EmployeeRecord;

public class EmployeeRecordFilter {

	public static void main(String[] args) {
		EmployeeRecordFilter eRecordFilter = new EmployeeRecordFilter();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter The File Path To process:");
		String path = null;
		int condition = 1;
		int option = 0;
		try {
			path = s.next();
			while (condition != 3) {
				System.out
						.println("\n\n  Menu\n 1)search by Date \n 2)Working hours \n 3)EXIT");
				System.out.println("\n\nEnter your Option:");
				option = s.nextInt();
				if (option == 1) {
					eRecordFilter.searchByDate(path);

				} else if (option == 2) {
					System.out.print("\n\nEnter The Employee ID:");
					int Eid = s.nextInt();
					eRecordFilter.workingHours(path, Eid);

				}  else if (option == 3) {
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

	public void searchByDate(String path) throws NumberFormatException,
			IOException {
		Scanner s = new Scanner(System.in);
		System.out.print("\nEnter the Date to serach\nYear:");
		int yyyy = s.nextInt();
		System.out.print("\nMonth:");
		int mm = s.nextInt();
		System.out.println("\ndate");
		int dd = s.nextInt();
		Date requieDate = new Date(yyyy, mm, dd);
		BufferedReader input = new BufferedReader(new FileReader(path));
		String str = null;
		String arg[] = new String[3];
		StringTokenizer sTokenizer = null;
		EmployeeRecord eRecord = null;
		Set<Integer> set = new HashSet<Integer>();
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
				eRecord = new EmployeeRecord(id, status, date);
				if (eRecord.compareTo(requieDate)) {
					set.add(eRecord.getId());
				}
			}
		}
		if (set.isEmpty()) {
			System.out.println("No people present on the date mentioned");
		} else {
			System.out.println("The People present on the date \n" + set);
		}
	}

	public void workingHours(String path, int eid)
			throws NumberFormatException, IOException {
		int hour = 0, minutes = 0;
		BufferedReader input = new BufferedReader(new FileReader(path));
		String str = null;
		String arg[] = new String[3];
		StringTokenizer sTokenizer = null;
		EmployeeRecord eRecord = null;
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
				eRecord = new EmployeeRecord(id, status, date);
				if (((eRecord.getId()) == eid)
						&& ((eRecord.getStatus()).equalsIgnoreCase("in"))) {
					String str2 = null;
					String arg1[] = new String[3];
					StringTokenizer sTokenizer2 = null;
					EmployeeRecord eRecord2 = null;
					while ((str2 = input.readLine()) != null) {
						sTokenizer2 = new StringTokenizer(str2, ",");
						for (int i = 0; sTokenizer2.hasMoreTokens(); i++) {
							arg1[i] = sTokenizer2.nextToken();
						}
						if (arg1[0] != null) {
							int empid = Integer.parseInt(arg1[0]);
							String estatus = arg1[1];
							long etime = Date.parse(arg1[2]);
							Date edate = new Date(etime);
							eRecord2 = new EmployeeRecord(empid, estatus, edate);
							if (((eRecord2.getStatus().equalsIgnoreCase("out")))
									&& ((eRecord2.getD().getDate()) == eRecord
											.getD().getDate())
									&& ((eRecord2.getId()) == eid)) {
								hour += eRecord2.getD().getHours()
										- eRecord.getD().getHours();
								minutes += Math.abs(eRecord2.getD()
										.getMinutes()
										- eRecord.getD().getMinutes());
								break;
							}
						}
					}
				}
			}
		}

		if (minutes > 60) {
			hour += minutes / 60;
			minutes = minutes % 60;
			System.out.println("Working hours : " + hour + " hours " + minutes
					+ " Minutes");
		} else {
			System.out.println("Working hours : " + hour + " hours " + minutes
					+ " Minutes");
		}
	}

}
/*
 * /home/praveen/Desktop/training/EmployeeRecordsFilter/src/com/vlabs/employee/bean
 * /Myinputfile
 */
