package com.val.Files;

import java.sql.Date;
import java.sql.Time;

public class Emp 
{
	private int id;
	private boolean isIn;
	private Date date;
	private Time time;
	public Time getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = Time.valueOf(time);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date =Date.valueOf(date);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isIn() {
		return isIn;
	}
	public void setIn(boolean isIn) {
		this.isIn = isIn;
	}
	public boolean equals(Object obj)
	{
		if(obj==null|| !(obj instanceof Emp))
		{
		  return false;
		}
		Emp emp=(Emp)obj;
		if(this.id !=emp.id)  return false;
		return true;
			
	}
	public int hashCode()
	{
	    return (int) this.id;
	}
}
