package fileobjectread;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;



public class Fileread 
{
	public Hashtable<Integer,ArrayList<Student>> idtableread(String file) throws FileNotFoundException
	{
		FileReader re = new FileReader(file);
	   	Scanner sc =new Scanner(new BufferedReader(re));
	   	Hashtable<Integer,ArrayList<Student>> idtable=new Hashtable<Integer,ArrayList<Student>>();
	   	while(sc.hasNext())
	   	{
	   		int i=Integer.parseInt(sc.useDelimiter(" ").next().trim());
	   		String s3=sc.useDelimiter(" ").next();
	   		String s1=sc.useDelimiter(" ").next();
	   		String s2=sc.useDelimiter("\n").next().trim();
	   		Student st=new Student(s3,s1,s2);
	   		if(!(idtable.containsKey(i)))
	   		{
	   			List<Student> al1=new ArrayList<Student>();
	   			al1.add(st);
	   			idtable.put(i,(ArrayList<Student>) al1);
	   		}
	   		else
	   		{
	   			idtable.get(i).add(st);
	   			idtable.put(i,idtable.get(i));
	   		}
	   	}
	   	return idtable;
	}
	public Hashtable<Date,ArrayList<Student>> datetableread(String file) throws FileNotFoundException
	{
		FileReader re = new FileReader(file);
	   	Scanner sc =new Scanner(new BufferedReader(re));
	   	Hashtable<Date,ArrayList<Student>> datetable=new Hashtable<Date,ArrayList<Student>>();
	   	while(sc.hasNext())
	   	{
	   		int i=Integer.parseInt(sc.useDelimiter(" ").next().trim());
	   		String s3=sc.useDelimiter(" ").next();
	   		String s1=sc.useDelimiter(" ").next();
	   		String s2=sc.useDelimiter("\n").next().trim();
	   		Date d=Date.valueOf(s3);
	   		Student st1=new Student(i, s1, s2);
	   		if(!(datetable.containsKey(d)))
	   		{
	   			List<Student> al1=new ArrayList<Student>();
	   			al1.add(st1);
	   			datetable.put(d,(ArrayList<Student>) al1);
	   		}
	   		else
	   		{
	   			datetable.get(d).add(st1);
	   			datetable.put(d,datetable.get(d));
	   		}
	   	}
	   	return datetable;
	}
}