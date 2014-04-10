package com.temp;

import java.util.Calendar;
import java.util.Date;

public class Emp implements Comparable<Emp>{

	int id;
	Date time;
	Date date;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode(){

		return id;
	}

	public int compareTo(Emp o) {

		if(o.hashCode()==this.hashCode())

			return 1;
		else
			return 0;
	}

}
