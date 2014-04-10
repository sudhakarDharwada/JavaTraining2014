package com.temp;

import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

public class ReadFileExample {

	public static void main(String[] args) throws IOException, ParseException {

		Scanner s = new Scanner(System.in);
		Date date = null;

		///home/valuelabs/workspace/Bs/src/com/temp/abc.txt
		FileRead fr = new FileRead();
		String file1 =fr.readfile();

		File file = new File(file1);
		FileToObject fto = new FileToObject();
		Map<Emp,Integer> map =fto.filetoobj(file);
		String ch="";

		do{
			System.out.println("Enter your choice: 1.to find number of Emp's  2.to find Emp Time");
			int choice= s.nextInt();

			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

			switch(choice){
			case 1:
				//to find number of Emp's on entered date
				s.nextLine();
				System.out.println("Enter Date : ");
				String ndate = s.nextLine();


				date = stringToDate(ndate);

				CountingEmps ce = new CountingEmps();

				System.out.println("Number of Emp's on "+ formatter.format(date) +" are");
				ce.EmpsCount(map,date);

				System.out.println("Do you want to continue(y/n):");
				ch= s.next();

				break;

			case 2:

				//to find Emp Time
				System.out.println("Enter Emp Id : ");
				int tid = s.nextInt();
				System.out.println("Enter Date :");
				String tdate = s.next();

				date = stringToDate(tdate);

				CopyingDataToAL cdta = new CopyingDataToAL();
				cdta.textfileToAL(map, date,tid);

				System.out.println("Entered date is "+ formatter.format(date) );
				System.out.println("Do you want to continue(y/n):");
				ch= s.next();

				break;


			}
		}while(ch.equals("y"));
		//System.out.println("Map object is "+map);

	}



	public static Date stringToDate(String sdate){

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		Date date=null;

		try {

			date =  formatter.parse(sdate);

			//System.out.println(formatter.format(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}



		return date;

	}

}


