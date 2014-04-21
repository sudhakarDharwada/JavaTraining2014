package com.val.programs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestExpression 
{
   public static void main(String ags[]) throws Exception
   {
	   String choice=null;
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   do
	   {
	     System.out.println("Enter an Expression:");
	     String s=br.readLine();
	     System.out.println(s+"= "+Evaluate.getResult(s));
	     System.out.println("Do you want to Evaluate any other Expression(y/n):");
	     choice=br.readLine();
	   }while("y".equalsIgnoreCase(choice));
	   
   }
}
