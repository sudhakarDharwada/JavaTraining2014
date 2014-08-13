package com.vl.calendar.event;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalendarEvent 
{
	String Event_name;
	String Event_location;
	Date Event_date;
	
	public CalendarEvent(String Event_name,String Event_location,Date Event_date)
	{
		this.Event_name = Event_name;
		this.Event_location = Event_location;
		this.Event_date = Event_date;
	}
	public String getEvent_name() {
		return Event_name;
	}
	public void setEvent_name(String event_name) {
		Event_name = event_name;
	}
	public String getEvent_location() {
		return Event_location;
	}
	public void setEvent_location(String event_location) {
		Event_location = event_location;
	}
	public Date getEvent_date() {
		return Event_date;
	}
	public void setEvent_date(Date event_date) {
		Event_date = event_date;
	}

}
