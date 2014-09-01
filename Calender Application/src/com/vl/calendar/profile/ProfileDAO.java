package com.vl.calendar.profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.vl.calendar.event.DbConnection;

public class ProfileDAO 
{
	public UserProfile getUserProfile(int userid) 
	{
		Connection con =null;
		UserProfile profile=new UserProfile();
		try {
			con = DbConnection.getConnection();
			String sql = "select * from calendar_teams_user where TEAMS_USER_SEQID=?";
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.executeQuery();
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				//UserProfile profile = new UserProfile(rs.getString("ID"),rs.getString("NAME"),rs.getString("EMAIL"),rs.getString("MOBILE_NUMBER"),rs.getString("DESIGNATION"));
				//userdetails.put(rs.getInt("TEAMS_USER_SEQID"),profile );
				profile.setId(rs.getString("ID"));
				profile.setName(rs.getString("NAME"));
				profile.setEmail(rs.getString("EMAIL"));
				profile.setPhone(rs.getString("MOBILE_NUMBER"));
				profile.setDesignation(rs.getString("DESIGNATION"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			DbConnection.close(con);
		}
		return profile;
	}
}
