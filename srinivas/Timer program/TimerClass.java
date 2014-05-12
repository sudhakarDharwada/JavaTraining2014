package com.files;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class TimerClass 
{


	public static void main(String[] args) throws NumberFormatException, IOException, ParseException 
	{

		
		System.out.println("Enter file name:");
		Scanner s = new Scanner(System.in);
		String path = s.next();
		//String path = "/home/valuelabs/workspace/Threads/src/com/files/a.txt";
		File file = new File(path);

		FileToObject fto = new FileToObject();
		List<EmpRemainder> list = fto.filetoobj(file);
		
		Collections.sort(list,new Sort());
		
		fto.remainder();
		
	}
	
}

class Sort implements Comparator<EmpRemainder>{

	public int compare(EmpRemainder o1, EmpRemainder o2) {
		
		return o1.timestamp.compareTo(o2.timestamp);
	}

	
	
}