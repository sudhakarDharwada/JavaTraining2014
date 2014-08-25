package com.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.rest.entity.Team;

public class TeamStore {

	//private static Map<String,Contact> map;
	private static Map<String,Team> map = new HashMap<String,Team>();
	static Connection con=null;

	public static Map DataRetrive(){
		Connection con=(Connection) DataConnectivity();
		
		ResultSet rs;
		//System.out.println("data retrive........................");
		try {
			Statement st = con.createStatement();
			st.executeQuery("commit");
			rs = st.executeQuery("select TEAM_NAME,CLIENT_NAME,CLIENT_LOCATION from TEAM_admin");
			
			while(rs.next())
			{
				//System.out.println("checking.....................,"+rs);
				
				String tname=rs.getString("TEAM_NAME");
				String cname=rs.getString("CLIENT_NAME");
				String clocation=rs.getString("CLIENT_LOCATION");
				
				System.out.println(tname+" "+cname+" "+clocation);
				
				Team team=new Team(tname,cname,clocation);
				map.put(tname, team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static Map DataDelete(String tname){
		Connection con=(Connection) DataConnectivity();
		try {
			Statement st = con.createStatement();
			int delete=st.executeUpdate("DELETE FROM team_admin WHERE tname = 'tname'");
			if(delete==1)
				System.out.println("record deleted");
			else
				System.out.println("record not deleted");
			st.executeQuery("commit");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;	
	}
	public static void DataInsert(Team team){
		Connection con=(Connection) DataConnectivity();
		
		System.out.println("in datainsert");
		
		String tname=team.getTname();
		String cname=team.getCname();
		String clocation=team.getClocation();
		
		System.out.println(tname+","+cname+","+clocation);
		
		try{
			con.commit();
			PreparedStatement st=con.prepareStatement("insert into team_admin values(?,team_seq.nextval,?,?)");
			st.setString(1, tname);
			st.setString(2, cname);
			st.setString(3, clocation);
			
			st.executeUpdate();
			con.commit();
			//st.executeQuery("commit");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public static Object DataConnectivity(){
		//PreparedStatement st=null;
		//System.out.println("debuging............................");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", 
					"training", "training");
			//System.out.println("connection k..........................................");
			//st = con.createStatement();
			
			
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
