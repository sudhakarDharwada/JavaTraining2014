package com.intendation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadingFile {

	Scanner s = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String filename=" ";



	public String readfile() throws FileNotFoundException {
		System.out.println("Enter file name");

		try {
			filename = br.readLine();
			

		}catch (IOException e) {

			e.printStackTrace();
		}
		if(filename == null){
			System.out.println("sorry! you have not entered name...");
			filename = null;

		}
		return filename;
	}

}

