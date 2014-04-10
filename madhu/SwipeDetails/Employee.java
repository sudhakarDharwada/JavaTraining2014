package org.employee.detailes;

import java.sql.Date;
import java.sql.Time;

public class Employee {
	int id;
	Date d;
	Time t;
	boolean in;

	public Employee(int id,String time,String date,boolean in){
		this.id=id;
		this.t=Time.valueOf(time);
		this.d=Date.valueOf(date);
		this.in=in;
	}
	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}
	public Time getT() {
		return t;
	}

	public void setT(Time t) {
		this.t = t;
	}

	public void setId(int id) {
		this.id= id;
	}

	public int getId() {
		return id;
	}
	public void setD(Date d) {
		this.d = d;
	}

	public Date getD() {
		return d;
	}
}
