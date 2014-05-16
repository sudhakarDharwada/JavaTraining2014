package com.timers;


import java.util.Calendar;
import java.util.Date;
public class BdayList 
{
	String value;
	Date date;
	Calendar c;
	public Calendar getC() {
		return c;
	}
	public void setC(Calendar c) {
		this.c = c;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Date getDate1() {
		return date;
	}
	public void setDate1(Date date) {
		this.date = date;
	}
}
