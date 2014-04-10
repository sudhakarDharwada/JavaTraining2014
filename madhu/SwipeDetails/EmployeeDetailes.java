package org.employee.detailes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeDetailes {
	
	public void readEmployee(String path) throws FileNotFoundException, ParseException{

		FileReader re = new FileReader(path);
		Scanner sc =new Scanner(new BufferedReader(re));
		List<Employee> list=new ArrayList<Employee>();
		while(sc.hasNext())
		{	
			String i=sc.useDelimiter(" ").next().trim();
			int j=Integer.parseInt(i);
			String s1=sc.useDelimiter(" ").next();
			String s3=sc.useDelimiter(" ").next();
			String s2=sc.useDelimiter("\n").next().trim();
			boolean result=Boolean.parseBoolean(s2);
	
			Employee st=new Employee(j,s1,s3,result);
			list.add(st);

		}
		EmployeeSearch(list);
		sc.close();
	}

	public void EmployeeSearch(List<Employee> list) throws ParseException{
		List<Employee> li=new ArrayList<Employee>(list);
		Scanner sc=new Scanner(System.in);
		int count=0,choice;

		Iterator<Employee> ite=li.iterator();
		while(ite.hasNext()){
			Employee s=ite.next();
			java.sql.Date date=s.getD();
			System.out.println(s.getId()+" "+s.getT()+" "+date+" "+s.isIn());
		}
		System.out.println("Enter Searching Employee on Date basis give:1 Time basis give:2 ");
		choice=sc.nextInt();

		if(choice==1){
			System.out.println("Enter date formate for no.of elements present on the day,date formate is yyyy-MM-dd");
			String search=sc.next();
			for(Employee Employee:li){
				Employee stu=(Employee)Employee;
				java.sql.Date reportDate = stu.getD();
				if(reportDate.compareTo(java.sql.Date.valueOf(search))==0)
					count++;
			}
			System.out.println("Number of Employee's present on the day is: "+count);
		}

		else if(choice==2){
			List<Employee>  lwh=new ArrayList<Employee>();

			System.out.println("Enter employee Date and Id.in order to find no.of working hours");
			String ds=sc.next();
			int search=sc.nextInt();

			for(Employee Employee:li){
				Employee stu=(Employee)Employee;
				if((stu.getId()==search) && (stu.getD().compareTo(java.sql.Date.valueOf(ds))==0))
					lwh.add(stu);
			}
			long time=0;
			long inTime=0,outTime=0,diff=0;Time t=Time.valueOf("11:00:00");
			
			for(int i=0;i<lwh.size();i++)
			{
				if((lwh.get(i).getId()==search)&&(lwh.get(i).isIn()))
				{
					inTime+=lwh.get(i).getT().getTime();
				}
				else if((lwh.get(i).getId()==search)&&(!lwh.get(i).isIn()))
				{
					outTime+=lwh.get(i).getT().getTime();
				}
				diff=Math.abs(outTime-inTime);
			}
			Time t1=new Time(diff-t.getTime());
			System.out.println("Number of Working hours of the Employee:"+t1);
		}
		else
			System.out.println("Invalid Entry");	
	}
	public static void main(String[] args) {

		EmployeeDetailes f=new EmployeeDetailes();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter File Location");
		String path=sc.next();
		try {
			f.readEmployee(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
