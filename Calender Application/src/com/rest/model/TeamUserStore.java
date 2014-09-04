package com.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import com.rest.entity.TeamUser;

public class TeamUserStore {
	private static Map<String,TeamUser> map = new HashMap<String,TeamUser>();
	static Connection con=null;

	public static Map DataRetrive(){
		Connection con=(Connection) DataConnectivity();

		ResultSet rs;
		//System.out.println("data retrive........................");
		try {
			Statement st=con.createStatement();
			rs = st.executeQuery("select USERID,UNAME,EMAIL,MOBILE_NUMBER,DESIGNATION,PWD from team_user1");
			while(rs.next())
			{
				String id=rs.getString("USERID");
				String name=rs.getString("UNAME");
				String email=rs.getString("EMAIL");
				String mobile_number=rs.getString("MOBILE_NUMBER");
				String designation=rs.getString("DESIGNATION");
				String password=rs.getString("PWD");

				TeamUser team=new TeamUser(id,name,email,mobile_number,designation,password);
				System.out.print(team+"hello");
				map.put(id, team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static Map DataDelete(String id){
		Connection con=(Connection) DataConnectivity();
		try {
			Statement st = con.createStatement();
			int delete=st.executeUpdate("DELETE FROM team_user1 WHERE USERID = "+id);
			if(delete==1)
				System.out.println("record deleted");
			else
				System.out.println("record not deleted");
			//st.executeQuery("commit");
			con.commit();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return map;	
	}
	public static void DataInsert(TeamUser team, String tname) throws SQLException{
		Connection con=null;
		Connection con1=null;
		Statement st1=null ;
		System.out.println("in datainsert...");
		String uname=team.getName();
		String id=team.getId();
		String email=team.getEmail();
		String mnumber=team.getMobile_number();
		String designation=team.getDesignation();
		
		try{
			con=(Connection) DataConnectivity();
			con1=(Connection) DataConnectivity();
			con.commit();
			System.out.print(tname + " in data insert.....123");
			String sql1 = "select TEAM_SEQ from TEAM_ADMIN where team_name='"+tname+"'";
			st1=con1.createStatement();
			ResultSet rs = st1.executeQuery(sql1);
			PreparedStatement st=con.prepareStatement("insert into team_user1 values(?,?,?,?,?,'valuelabs',USER_SEQ.nextval,?)");

			st.setString(1, id);
			st.setString(2, uname);
			st.setString(3, email);
			st.setString(4, mnumber);
			st.setString(5, designation);
			while (rs.next()) {
				st.setInt(6, rs.getInt("TEAM_SEQ"));
				
			}
				
			
			
			int update=st.executeUpdate();
			if(update==1)
				System.out.println("record inserted");
			else
				System.out.println("record not inserted");
			con.commit();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			
			con.close();
		}
	}

	public static Map DataUpdate(TeamUser team){
		Connection con=(Connection)DataConnectivity();
		String id=team.getId();
		String password=team.getPassword();
		String mnumber=team.getMobile_number();
		String designation=team.getDesignation();
		System.out.println("debug........................."+id+" ... num.."+mnumber);

		try {
			PreparedStatement st=con.prepareStatement("update team_user1 set MOBILE_NUMBER=?,DESIGNATION=? where USERID=?");
			st.setString(1, mnumber);
			st.setString(2, designation);
			//st.setString(3, password);
			st.setString(3, id);
			int update=st.executeUpdate();
			System.out.println(mnumber+" "+designation+ "  ....     "+update);
			if(update==1)
				System.out.println("record not updated");
			else
				System.out.println("record updated");
				
			//st.executeQuery("commit");
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		}
		
		return map;
	}
	public static Object DataConnectivity(){
		//PreparedStatement st=null;
		//System.out.println("debuging............................");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", 
					"training", "training");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}