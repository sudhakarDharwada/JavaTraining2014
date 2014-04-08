package com.vlabs.employee.mainclass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.vlabs.employee.bean.EmployeeRecord;

public class EmployeeRecordFilter {
        /*main*/
	public static void main(String[] args) {
		EmployeeRecordFilter eRecordFilter = new EmployeeRecordFilter();

		Scanner s = new Scanner(System.in);

		List<EmployeeRecord> list = null;

		System.out.println("Enter The File Path To process:");
		String path = null;
		try {
			path = s.next();
			list = eRecordFilter.fileInput(path);
			

		} catch (InputMismatchException e) {
			System.out
					.println("The path should not be number \n Try again ....!");
		} catch (FileNotFoundException e) {
			System.out.println("The file is not found \n try again ....!");
		} catch (IOException e) {
			System.out.println("File Read Error");
		}

	}
        /*This method takes file path and the enter the records into the list and returns the list*/
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
				int time = Integer.parseInt(arg[2]);
				Date date = new Date();
				date.setHours(time);
				eRecord = new EmployeeRecord(id, status, date);
				list.add(eRecord);
			}
		}
		return list;
	}

}
