package com.vl.calendar.event;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class Event_DAO 
{
	@SuppressWarnings("null")
	public Map<Integer,CalendarEvent> getevents(int userid) 
	{
		Connection con =null;
		
		Map<Integer,CalendarEvent> eventsmap =new HashMap<Integer, CalendarEvent>();
		try {
			con = DbConnection.getConnection();
			String sql1="select TEAM_SEQUENCE from calendar_teams_user where TEAMS_USER_SEQID=?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			String sql = "select * from calendar_events where TEAM_SEQUENCE=?";
			PreparedStatement ps1 = con.prepareStatement(sql);
			//ps.executeQuery();
			while(rs.next())
			{
				ps1.setInt(1,rs.getInt("TEAM_SEQUENCE"));
			}
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				CalendarEvent event = new CalendarEvent(rs1.getInt("EVENT_SEQUENCE_ID"),rs1.getString("EVENT_TITLE"),rs1.getString("EVENT_PLACE"),rs1.getDate("EVENT_DATE").toString());
				eventsmap.put(rs1.getInt("EVENT_SEQUENCE_ID"),event );
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
		
		try {
			con = DbConnection.getConnection();
			String sql1 = "select TEAM_SEQUENCE from calendar_teams_user where TEAMS_USER_SEQID=?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			String sql = "insert into calendar_events values (?,?,?,?,?,calendar_EVENT_SEQUENCE.nextval) ";
			@SuppressWarnings("null")
			int teamsequence=0;
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, event.getTitle());
            ps1.setDate(2, Date.valueOf(event.getStart()));
            ps1.setString(3, event.getEventPlace());
            while(rs.next())
            {
            	
            	teamsequence=rs.getInt("TEAM_SEQUENCE");
            }
            System.out.println("teamsequence "+teamsequence);
            ps1.setInt(4,teamsequence);
            ps1.setInt(5, userid);
            ps1.executeUpdate();
            
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
			String sql = "update calendar_events set EVENT_TITLE=?,EVENT_DATE=?,EVENT_PLACE=? where EVENT_SEQUENCE_ID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,event.getTitle());
			ps.setDate(2,Date.valueOf(event.getStart()));
			ps.setString(3,event.getEventPlace());
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
			String sql = "delete from calendar_events where EVENT_SEQUENCE_ID=?";
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
