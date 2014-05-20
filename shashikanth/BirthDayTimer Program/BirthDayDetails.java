package com.val.Timer;

import java.sql.Timestamp;

public class BirthDayDetails 
{
	private String name;
	private Timestamp dateTime;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
}
