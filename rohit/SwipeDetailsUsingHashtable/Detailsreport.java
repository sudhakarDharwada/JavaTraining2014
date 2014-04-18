package fileobjectread;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Detailsreport 
{
	public static void main(String[] args) 
	{
		try
		{
			Fileread f=new Fileread();
			Detailsreport dr=new Detailsreport();
			String file=args[0];
			Scanner sc1=new Scanner(System.in);
			Date d;
			String cont="y";
			while(cont.equalsIgnoreCase("y"))
			{
				System.out.println("enter your choice \n1.workinghours of the student\n2.no. of students on that day\n3.maximum working time\n4.minimum working time");
				int choice=sc1.nextInt();
				if(choice==1)
				{
					System.out.println("enter id:");
					int id=sc1.nextInt();
					dr.workingtime(f.idtableread(file),id);
				}
				else if(choice==2)
				{
					System.out.println("enter date in 'yyyy-MM-dd' format:");
					d=Date.valueOf(sc1.next().trim());
					dr.studentpresent(f.datetableread(file), d);
				}
				else if(choice==3)
				{
					TreeMap<Time,Integer> tm=dr.workinghours(f.idtableread(file));
					System.out.println(tm.lastEntry().getValue()+" worked maximum time : "+tm.lastEntry().getKey());
				}
				else if(choice==4)
				{
					TreeMap<Time,Integer> tm=dr.workinghours(f.idtableread(file));
					System.out.println(tm.firstEntry().getValue()+" worked minimum time : "+tm.firstEntry().getKey());
				}
				else
					System.out.println("not a vidtableid choice.");
				System.out.println("do you want to continue[y/n] :");
				cont=sc1.next();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public void workingtime(Hashtable<Integer,ArrayList<Student>> idtable,int id)
	{
		int i=0;int in=0;
		int out=0;
		int work_time=0;
		Time t=Time.valueOf("11:00:00");
		if(idtable.containsKey(id))
		{
			while(i<idtable.get(id).size())
			{
				if(idtable.get(id).get(i).flag)
					in=i;
				else 
					out=i;
				if(out!=0)
				{
					work_time+=idtable.get(id).get(out).getTime().getTime()-idtable.get(id).get(in).getTime().getTime();
					out=0;
				}
				i++;
			}
			System.out.println("working hours "+new Time(work_time-t.getTime()));
		}
		else
			System.out.println("student not present on that date");
	}
	
	public void studentpresent(Hashtable<Date,ArrayList<Student>> datetable,Date d)
	{
		int i=0;
		Set<Integer> studentprsntids=new HashSet<Integer>();
		if(datetable.containsKey(d))
		{
			while(i<datetable.get(d).size())
			{
				studentprsntids.add(datetable.get(d).get(i).id);
				i++;
			}
			System.out.println("no of students presented on date"+"  "+d+"  are"+"  "+studentprsntids.size());
		}
		else
			System.out.println("students not present on that date");
	}

	public TreeMap<Time,Integer> workinghours(Hashtable<Integer,ArrayList<Student>> idtable)
	{
		int work_time=0;
		Time t=Time.valueOf("11:00:00");
		Set<Integer> is=idtable.keySet();
		TreeMap<Time,Integer> timeset=new TreeMap<Time,Integer>();
		Iterator<Integer> ir=is.iterator();
		while(ir.hasNext())
		{
			int i=0;int in=0;int out=0;
			int j=ir.next();
			while(i<idtable.get(j).size())
			{
				if(idtable.get(j).get(i).flag)
					in=i;
				else 
					out=i;
				if(out!=0)
				{
					work_time+=idtable.get(j).get(out).getTime().getTime()-idtable.get(j).get(in).getTime().getTime();
					out=0;
				}
				i++;
			}
			timeset.put(new Time(work_time-t.getTime()),j);
			work_time=0;
		}
		return timeset;
	}
}