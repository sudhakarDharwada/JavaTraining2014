package com.vl.calendar.event;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalendarEvent 
{

	int id;
	String title;
	String eventPlace;
	String start;
	public CalendarEvent() {

	}

	public CalendarEvent(int id,String title,String eventPlace,String start)
	{
		this.id = id;
		this.title = title;
		this.eventPlace = eventPlace;
		this.start = start;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEventPlace() {
		return eventPlace;
	}

	public void setEventPlace(String eventPlace) {
		this.eventPlace = eventPlace;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

}
