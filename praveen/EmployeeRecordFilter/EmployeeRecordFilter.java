
package com.inputfiles.tests;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
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
		path = s.next();
		while (condition != 3) {
			System.out.println("\n\n  Menu\n 1)search by Date \n 2)Working hours \n 3)EXIT");
			System.out.println("\n\nEnter your Option:");
			option = s.nextInt();
			if (option == 1) {
				eRecordFilter.searchByDate(path);

			} else if (option == 2) {
				System.out.print("\n\nEnter The Employee ID:");
				int Eid = s.nextInt();
				eRecordFilter.workingHours(path, Eid);

			} else if (option == 3) {
				condition = option;
			} else {
				System.out.println("wrong option");
			}
		}
	}

	public void searchByDate(String path) {
		Scanner s = new Scanner(System.in);
		BufferedReader input = null;
		System.out.print("\nEnter the Date to serach\nYear:");
		int yyyy = s.nextInt();
		System.out.print("\nMonth:");
		int mm = s.nextInt();
		System.out.println("\ndate");
		int dd = s.nextInt();
		Date requieDate = new Date(yyyy, mm, dd);
		Set<Integer> set = null;
		try {
			input = new BufferedReader(new FileReader(path));
			String str = null;
			String arg[] = new String[3];
			StringTokenizer sTokenizer = null;
			EmployeeRecord eRecord = null;
			set = new HashSet<Integer>();
			while ((str = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg[i] = sTokenizer.nextToken();
				}
				if (arg[0] != null) {
					int id = Integer.parseInt(arg[0]);
					String status = arg[1];
					long time = Date.parse(arg[2]);
					Date currentdate = new Date(time);
					if (compareTo(requieDate,currentdate)) {
						set.add(id);
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("File Formate In correct");
		} catch (IOException e) {
			System.out.println("file not found error");
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (set.isEmpty()) {
			System.out.println("No people present on the date mentioned");
		} else {
			System.out.println("The People present on the date \n" + set);
		}
	}

	public void workingHours(String path, int eid) {
		BufferedReader input = null;
		int hour = 0, minutes = 0;
		try {
			input = new BufferedReader(new FileReader(path));
			String str1 = null;
			String arg1[] = new String[3];
			StringTokenizer sTokenizer = null;
			while ((str1 = input.readLine()) != null) {
				sTokenizer = new StringTokenizer(str1, ",");
				for (int i = 0; sTokenizer.hasMoreTokens(); i++) {
					arg1[i] = sTokenizer.nextToken();
				}
				if (arg1[0] != null) {
					int id1 = Integer.parseInt(arg1[0]);
					String status1 = arg1[1];
					long time1 = Date.parse(arg1[2]);
					Date date1 = new Date(time1);
					if (((id1) == eid) && (status1.equalsIgnoreCase("in"))) {
						String str2 = null;
						String arg2[] = new String[3];
						StringTokenizer sTokenizer2 = null;
						while ((str2 = input.readLine()) != null) {
							sTokenizer2 = new StringTokenizer(str2, ",");
							for (int i = 0; sTokenizer2.hasMoreTokens(); i++) {
								arg2[i] = sTokenizer2.nextToken();
							}
							if (arg2[0] != null) {
								int empid = Integer.parseInt(arg2[0]);
								String status2 = arg2[1];
								long time2 = Date.parse(arg2[2]);
								Date date2 = new Date(time2);
								if (((status2.equalsIgnoreCase("out"))) && ((date2.getDate()) == date1.getDate()) && (id1== eid)) {
									hour += date2.getHours() - date1.getHours();
									minutes += Math.abs(date2.getMinutes() - date1.getMinutes());
									break;
								}
							}
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("File Formate In correct");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("File read error");
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (minutes > 60) {
			hour += minutes / 60;
			minutes = minutes % 60;
			System.out.println("Working hours : " + hour + " hours " + minutes + " Minutes");
		} else {
			System.out.println("Working hours : " + hour + " hours " + minutes + " Minutes");
		}
	}
	public boolean compareTo(Date requireDate,Date currentDate) {
		boolean status = false;
		if ((requireDate.getDate()) == (currentDate.getDate()) && ((requireDate.getMonth()) == (currentDate.getMonth()))  && ((requireDate.getYear()) == (currentDate.getYear() + 1900))) {
			status = true;
			return status;
		}
		else if (((requireDate.getHours())==(currentDate.getHours()))&&((requireDate.getMinutes())==(currentDate.getMinutes()))) {
			status=true;
			return status;
		}
		return status;
	}

}


