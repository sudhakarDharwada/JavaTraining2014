package com.intendation;

import java.io.IOException;
import java.util.Scanner;

public class Indentation1 
{
	public static void main(String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);

		System.out.println("Enter file name : ");
		String file = s.next();

		Indentation2 i = new Indentation2();
		i.indentFile(file);


	}

}

