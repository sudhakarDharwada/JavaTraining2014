package com.val.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test2 
{
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		String fileName=args[0];
	    List<Emp> elist=createEmpLoginList(fileName);
	    for(Emp e:elist)
	    {
	    	System.out.println(e.getId()+" "+e.isIn()+" "+e.getDate()+" "+e.getTime());
	    }
	    calculateNoOfEmployeesPresent(elist);
	}
	private static void calculateNoOfEmployeesPresent(List<Emp> elist) 
	{
	    Emp e=new Emp();int inCount=0;
	    System.out.println("Enter a Date:");
	    String day=sc.next();
	    e.setDate(day);
	    for(int i=0;i<elist.size();i++)
	    {
	    	DateCompare dc=new DateCompare();
	    	if(elist.get(i).isIn())
	    	{
	    	  int k=dc.compare(elist.get(i),e);
	    	  if(k==0)
	    	  {
	    	    inCount++;
	    	  }
	    	}
	    }
	    System.out.println("No of Emp Present on "+day+" :"+inCount);
		
	}
	private static List<Emp> createEmpLoginList(String filename) throws NumberFormatException, IOException
	{
		List<Emp> elist=new ArrayList<Emp>();
		File file=new File(filename);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String read=null;boolean isFirstLine=true;
		while((read=br.readLine())!=null)
		{
			if(!isFirstLine)
			{
				StringTokenizer token=new StringTokenizer(read.trim());
				 while(token.hasMoreTokens())
				 {
					Emp e=new Emp();
					e.setId(Integer.parseInt(token.nextToken()));
					e.setIn(Boolean.parseBoolean(token.nextToken()));
					e.setDate(token.nextToken());
					e.setTime(token.nextToken());
					elist.add(e);
				 }  
			 }
			 isFirstLine=false;
		}
		return elist;
	}
}


