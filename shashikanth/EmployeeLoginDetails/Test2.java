package com.val.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test2 
{
	public static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws IOException
	{
		String fileName=args[0],choice=null;
	    List<Emp> elist=createEmpLoginList(fileName);
	    do{
	    System.out.println("Reports");
	    System.out.println("1.No of Employees Present On a Particular Day");
	    System.out.println("2.Total Working Hours of an Employee");
	    System.out.println("choose any one of the above criteria:");
	    int criteria=sc.nextInt();
	    if(criteria==1)
	    {
	     calculateNoOfEmployeesPresent(elist);
	    }
	    else
	    {
	      calculateWorkingHoursOfEmployee(elist);
	    }
	    System.out.println("Do u want to proceed(y/n):");
	    choice=sc.next();
	    }while(choice.equalsIgnoreCase("y"));
	}
	private static void calculateWorkingHoursOfEmployee(List<Emp> elist) 
	{
		System.out.println("Enter Emp Id:");
		int empId=sc.nextInt();long inTime = 0,outTime = 0,diff = 0;Time time=Time.valueOf("11:00:00");
		for(int i=0;i<elist.size();i++)
		{
			if((elist.get(i).getId()==empId) && (elist.get(i).isIn()) )
			{
				inTime+=elist.get(i).getTime().getTime();
			}
			if((elist.get(i).getId()==empId) && (!elist.get(i).isIn()))
			{
				outTime+=elist.get(i).getTime().getTime();
			}
		}
		diff=Math.abs(outTime-inTime);
		Time t=new Time(diff-time.getTime());
		System.out.println("Total Working Hours Of Employee:"+t);
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


