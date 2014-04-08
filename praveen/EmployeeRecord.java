package com.vlabs.employee.bean;
import java.util.Date;
/*The employee bean class*/
public class EmployeeRecord {
	private int Id;
	private String status;
	private Date d;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	public EmployeeRecord(int Id,String status,Date d)
	{
		this.Id=Id;
		this.status=status;
		this.d=d;
	}
}
