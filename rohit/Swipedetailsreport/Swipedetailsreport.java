package fileios;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Swipedetailsreport 
{
	public static void main(String[] args) 
	{
		try
		{
			Swipedetailsreport sr=new Swipedetailsreport();
			String file=args[0];
			List<Student> al=f.read(file);
			Scanner sc1=new Scanner(System.in);
			Date d;
			String cont="y";
			while(cont.equalsIgnoreCase("y"))
			{
				System.out.println("enter your choice \n1.workinghours of the employee\n2.no. of employee on that day");
				int choice=sc1.nextInt();
				System.out.println("enter date in 'yyyy-MM-dd' format:");
				d=Date.valueOf(sc1.next().trim());
				if(choice==1)
				{
					System.out.println("enter id:");
					int id=sc1.nextInt();
					sr.workingtime(al,id,d);
				}
				else if(choice==2)
					sr.employeepresent(al, d);
				else
					System.out.println("not a valid choice.");
				System.out.println("do you want to continue[y/n] :");
				cont=sc1.next();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public List<Student> read(String file) throws FileNotFoundException
	{		
		FileReader re = new FileReader(file);
	   	Scanner sc =new Scanner(new BufferedReader(re));
	   	List<Student> al=new ArrayList<Student>();
	   	while(sc.hasNext())
	   	{
	   		int i=Integer.parseInt(sc.useDelimiter(" ").next().trim());
	   		String s3=sc.useDelimiter(" ").next();
	   		String s1=sc.useDelimiter(" ").next();
	   		String s2=sc.useDelimiter("\n").next().trim();
	   		Student st=new Student(i,s3,s1,s2);
	   		al.add(st);
	  	}
	   	return al;
	}
	public void workingtime(List<Student> al,int id,Date d)
	{
		int i=0;int in=0;
		int out=0;
		int work_time=0;
		Time t=Time.valueOf("11:00:00");
		while(i<al.size())
		{
			if((id==al.get(i).id)&&(d.compareTo(al.get(i).date)==0))
			{
				if(al.get(i).flag)
					in=i;
				else 
					out=i;
			}
			if(out!=0)
			{
				work_time+=al.get(out).getTime().getTime()-al.get(in).getTime().getTime();
				out=0;
			}
			i++;
		}
		if(work_time==0)
			System.out.println("employee not present on that date");
		else
			System.out.println(new Time(work_time-t.getTime()));
	}
	public void employeepresent(List<Student> al,Date d)
	{
		int i=0;
		int count=0;
		while(i<al.size())
		{
			if(d.compareTo(al.get(i).date)==0)
			{
				count++;
				if(!(al.get(i).flag))
					count--;
			}
			i++;
		}
		if(count==0)
			System.out.println("Employees not present on that date");
		else
			System.out.println("no of employees presented on date"+"  "+d+"  are"+"  "+count);
	}
}

