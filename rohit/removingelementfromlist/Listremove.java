package lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Listremove 
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		List<Employee> emplist=new ArrayList<Employee>();
		System.out.println("enter the no. of elemnets :");
		int size=sc.nextInt();
		for(int i=0;i<size;i++)
		{
			emplist.add(Employee.read());
		}
		for(Employee e4:emplist)
		{
			System.out.println(e4.getId()+"  "+e4.getName()+"  "+e4.getDept());
		}
		System.out.println("enter the department u want to remove :");
		Employee e1=new Employee();
		e1.setDept(sc.next());
		List<Employee> newemplist=Listremove.remove(emplist,e1);
		System.out.println("new list");
		for(Employee emp:newemplist)
		{
			System.out.println(emp.getId()+"  "+emp.getName()+"  "+emp.getDept());
		}
	}
	public static List<Employee> remove(List<Employee> objectlist,Object o1)
	{
		Employee e1=(Employee)o1;
		for(Employee e4:objectlist)
			System.out.println(e4.getId()+"  "+e4.getName()+"  "+e4.getDept());
		Iterator<Employee> ir=objectlist.iterator();
		while(ir.hasNext())
		{
			Employee e2=(Employee)ir.next();
			if(e2.getDept().equals(e1.getDept()))
				ir.remove();
		}
		return objectlist;
	}

}
