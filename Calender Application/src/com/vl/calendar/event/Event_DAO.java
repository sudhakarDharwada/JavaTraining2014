package com.vl.calendar.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class Event_DAO 
{
	@SuppressWarnings("null")
	public List<CalendarEvent> getevents() 
	{
		Connection con =null;
		Statement st = null;
		List<CalendarEvent> eventlist = null;
		try {
			con = DbConnection.getConnection();
			String sql = "select * from Events";
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				CalendarEvent event = new CalendarEvent(rs.getNString("EVENT_TITLE"),rs.getString("EVENT_PLACE"),rs.getDate("EVENT_DATE"));
				eventlist.add(event);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventlist;
	}
	public void addevent(CalendarEvent event,int id)
	{
		Connection con = null;
		Statement st = null;
		try {
			con = DbConnection.getConnection();
			String sql = "insert into Events values (?,?,?,EVENT_SEQUENCE.nextval) ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, event.getEvent_name());
            ps.setDate(2, event.getEvent_date());
            ps.setString(3, event.getEvent_location());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
