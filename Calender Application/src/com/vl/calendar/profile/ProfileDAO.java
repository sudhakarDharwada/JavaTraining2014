package com.vl.calendar.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.vl.calendar.event.DbConnection;

public class ProfileDAO 
{
	public Map<Integer,UserProfile> getUserProfile(int userid) 
	{
		Connection con =null;
		Map<Integer,UserProfile> userdetails = null;
		try {
			con = DbConnection.getConnection();
			String sql = "select * from calendar_user_teams where TEAMS_USER_SEQID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.executeQuery();
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				UserProfile profile = new UserProfile(rs.getString("ID"),rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("MOBILE_NUMBER"),rs.getString("DESIGNATION"));
				userdetails.put(rs.getInt("TEAMS_USER_SEQID"),profile );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbConnection.close(con);
		}
		return userdetails;
	}
}
