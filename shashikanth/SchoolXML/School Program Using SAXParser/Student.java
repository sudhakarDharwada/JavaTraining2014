package com.val.xml;

import java.sql.Date;


public class Student
{
	private String name;
	private Date DOB;
	private String address;
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Date getDOB() 
	{
		return DOB;
	}
	public void setDOB(Date dOB) 
	{
		DOB = dOB;
	}
	public String getAddress() 
	{
		return address;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}
	public String toString() 
	{
		return name+" "+DOB+" "+address;
	}

}
