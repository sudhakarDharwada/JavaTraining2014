import java.util.*;
class EmpList
{
	String empName;
	int empId;
	String empDept;
	EmpList()
	{
		
	}
	
	EmpList(String empName,int empId,String empDept)
	{
		this.empName=empName;
		this.empId=empId;
		this.empDept=empDept;
	}	
	public void setEmpName(String empName){
		this.empName=empName;
	}
	public String getEmpName()
	{
		return empName;
	} 
	
	public void setEmpId(int empId){
		this.empId=empId;
	}
	public int getEmpId()
	{
		return empId;
	} 
	
	void setEmpDept(String empDept){
		this.empDept=empDept;
	}
	String getEmpDept()
	{
		return empDept;
	} 
	public String toString()
	{
		//System.out.println("hello");
		return (" Employee Name: " +this.getEmpName()+ "Employee ID:" +this.getEmpId()+ " Department : " +this.getEmpDept());
	}
		
}		
public class Vectormethod
{
	protected static List<EmpList> al = null;
    
	public static void main(String args[])
	{
		
		List<EmpList> al=new ArrayList<EmpList>();
		EmpList empList=new EmpList();
		
		System.out.println("Enter the no of employees to be added");
		Scanner s= new Scanner(System.in);
		int ip = s.nextInt();
		for(int i=0;i<ip;i++)
		{
			EmpList emp = new EmpList();
			System.out.println("Enter name");
			emp.setEmpName(s.next());
			System.out.println("Enter id");
			emp.setEmpId(s.nextInt());
			System.out.println("Enter Department" );
			emp.setEmpDept(s.next());
			al.add(emp);
		}
		
		Vectormethod arrayList=new Vectormethod();
		arrayList.employeeDetailsBeforeDeleting(al);				
		System.out.println("Enter the dept to be deleted");
		String dept = s.next();
		arrayList.employeeToBeDeleted(al,dept);
		arrayList.employeeDetailsToBePrinted(al);
	}
	void employeeDetailsBeforeDeleting(List al)
	{		
		Iterator<EmpList> in = al.iterator();
		while(in.hasNext()) 
		{
			EmpList emp= in.next();
			System.out.println(emp);
		}
	}
	
	void employeeToBeDeleted(List al,String dept)
	{
		Iterator<EmpList> i = al.iterator();
		EmpList e=new EmpList();
		while(i.hasNext())
		{
			e = i.next();
			if(e.getEmpDept().equals(dept))
				i.remove();
		}
	}
	void employeeDetailsToBePrinted(List al)
	{		
		Iterator<EmpList> ir = al.iterator();
		while(ir.hasNext()) 
		{
			EmpList emp= ir.next();
			System.out.println(emp);
		}
	}
}

		
	



