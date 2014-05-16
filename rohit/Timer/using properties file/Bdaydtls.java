package vl.com.threads;

import java.sql.Timestamp;
import java.util.Calendar;

public class Bdaydtls 
{
	String name;
	Timestamp date;
	Calendar c;
	public Calendar getC() {
		return c;
	}
	public void setC(Calendar c) {
		this.c = c;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}
