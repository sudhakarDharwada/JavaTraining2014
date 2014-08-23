package com.vl.calendar.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Event_DAO 
{
	@SuppressWarnings("null")
	public Map<Integer,CalendarEvent> getevents(int teamid) 
	{
		Connection con =null;
		Map<Integer,CalendarEvent> eventsmap = null;
		try {
			con = DbConnection.getConnection();
			String sql = "select * from Events where TEAM_SEQUENCE=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.executeQuery();
			ps.setInt(1,teamid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				CalendarEvent event = new CalendarEvent(rs.getInt("EVENT_SEQUENCE_ID"),rs.getNString("EVENT_TITLE"),rs.getString("EVENT_PLACE"),rs.getDate("EVENT_DATE"));
				eventsmap.put(rs.getInt("EVENT_SEQUENCE_ID"),event );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbConnection.close(con);
		}
		return eventsmap;
	}
	public CalendarEvent addevent(CalendarEvent event,int userid) 
	{
		Connection con = null;
		Statement st = null ;
		try {
			con = DbConnection.getConnection();
			String sql1 = "select TEAM_SEQUENCE from TEAMS_USER where TEAMS_USER_SEQID=userid";
			String sql = "insert into Events values (?,?,?,?,?,EVENT_SEQUENCE.nextval) ";
			@SuppressWarnings("null")
			ResultSet rs = st.executeQuery(sql1);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, event.getEvent_name());
            ps.setDate(2, event.getEvent_date());
            ps.setString(3, event.getEvent_location());
            ps.setInt(4, userid);
            ps.setInt(5,rs.getInt("TEAM_SEQUENCE"));
            ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			DbConnection.close(con);
		}
		return event;
	}
	public CalendarEvent updateevent(CalendarEvent event,int eventid)  
	{
		Connection con = null;
		try {
			con = DbConnection.getConnection();
			String sql = "update events set EVENT_TITLE=?,EVENT_DATE=?,EVENT_PLACE=? where EVENT_SEQUENCE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,event.getEvent_name());
			ps.setDate(2,event.getEvent_date());
			ps.setString(3,event.getEvent_location());
			ps.setInt(4, eventid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnection.close(con);
		}
		return event;
	}
	public void deleteevent (int eventid) 
	{
		Connection con = null;
		try {
			con = DbConnection.getConnection();
			String sql = "delete from events where EVENT_SEQUENCE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,eventid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbConnection.close(con);
		}
	}
}
