package vl.com.threads;

import java.io.IOException;
import java.util.Scanner;


public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the filepath :");
		String file=sc.next();
		Timer t=new Timer();
		t.readdtls(file);
		t.generatealert();
	}
}
