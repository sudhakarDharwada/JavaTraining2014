package com.temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRead {

	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String filename=" ";



	public String readfile() throws IOException  {
		System.out.println("Enter file name including full path");

	
			filename = br.readLine();

		
		if(filename == null){
			System.out.println("sorry! you have not entered name...");
			filename = null;

		}
		return filename;
	}

	
}


