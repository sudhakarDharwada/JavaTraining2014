import java.util.Date;
public class EmpList
{
	int id;
	boolean inout;
	Date date;
	EmpList()
	{
		
	}
	
	EmpList(int id,boolean inout,Date date)
	{
		this.id=id;
		this.inout=inout;
		this.date=date;
	}	
	public void setEmpId(int id){
		this.id=id;
	}
	public int getEmpId()
	{
		return id;
	} 
	
	public void setEmpInout(boolean inout){
		this.inout=inout;
	}
	public boolean getEmpInout()
	{
		return inout;
	} 
	
	void setEmpDate(Date date){
		this.date=date;
	}
	Date getEmpDate()
	{
		return date;
	} 
	public String toString()
	{
		//System.out.println("hello");
		return (" Employee Id: " +this.getEmpId()+ "Employee Inout:" +this.getEmpInout()+ " Date : " +this.getEmpDate());
	}
		
}		
