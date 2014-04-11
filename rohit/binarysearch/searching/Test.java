package com.vl.searching;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;


public class Test 
{
	public static void main(String[] args)
	{
	int size,criteria;
	boolean flag=false;
	List<Employee> ar = new ArrayList<Employee>();
	Scanner sc = new Scanner(System.in);
	System.out.println("enter no of objects :");
	size=sc.nextInt();
	for(int i=0;i<size;i++)
	{
		Employee e = new Employee();
		System.out.println("enter id");
		e.setId(sc.nextInt());
		System.out.println("enter name");
		e.setName(sc.next());
		ar.add(e);
	}
	System.out.println("enter your criteria 1.Id 2.Name :");
	criteria=sc.nextInt();
	Employee e1 =new Employee();
	Bsearch bs = new Bsearch();
	if(criteria==1)
	{
		System.out.println("enter id :");	
		e1.setId(sc.nextInt());
		Collections.sort(ar,new Myidcomp());
		flag=bs.isfound(ar,e1,new Idcriteria());
	}
	else if(criteria==2)
	{
		System.out.println("enter name :");
		e1.setName(sc.next());
		Collections.sort(ar,new Mynamecomp());
		flag=bs.isfound(ar,e1,new Namecriteria());
	}
	else
		System.out.println("not existed");
	if(flag)
		System.out.println("elemnet found");
	else
		System.out.println("element not found");
	}
}
class Myidcomp implements Comparator<Employee>
{
	public int compare(Employee e1,Employee e2)
	{
		if(e1.id>e2.id)
			return 1;
		else
			return -1;
	}
}
class Mynamecomp implements Comparator<Employee>
{
	public int compare(Employee e1,Employee e2)
	{
		return e1.name.compareTo(e2.name);
	}
}



