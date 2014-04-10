package lists;

import java.util.Scanner;

public class Employee 
{
	int id;
	String name;
	String dept;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static Employee read() 
	{
		Scanner sc=new Scanner(System.in);
		Employee e =new Employee();
		System.out.println("enter emp details :");
		e.setId(sc.nextInt());
		e.setName(sc.next());	
		e.setDept(sc.next());
		return e;
	}

}
