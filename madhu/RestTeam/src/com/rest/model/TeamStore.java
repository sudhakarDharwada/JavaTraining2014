package com.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.rest.entity.Team;

public class TeamStore {

	//private static Map<String,Contact> map;
	private static Map<String,Team> map = new HashMap<String,Team>();

	/*private ContactStore() {

		Contact contact = new Contact("1", "Learn REST");
		//contact.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
		map.put("1", contact);
		contact = new Contact("2", "Do something");
		//contact.setDescription("Read complete http://www.vogella.com");
		map.put("2", contact);

	}*/
	/*public static Map<String,Team> getDetailes(){
		Team contact = new Team("1", "Learn REST");
		//contact.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
		map.put("1", contact);
		contact = new Team("2", "Do something");
		//contact.setDescription("Read complete http://www.vogella.com");
		map.put("2", contact);
		return map;
	}*/
	public static Map DataRetrive(){
		Statement st=(Statement) DataConnectivity();
		ResultSet rs;
		try {
			rs = st.executeQuery("select * from TEAM");
			while(rs.next())
			{
				String tname=rs.getString("TEAM_NAME");
				String cname=rs.getString("CLIENT_NAME");
				String clocation=rs.getString("CLIENT_LOCATION");
				
				Team team=new Team(tname,cname,clocation);
				map.put(tname, team);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	public static Map DataInsert(){
		Statement st=(Statement) DataConnectivity();
		Iterator<?> it=map.entrySet().iterator();
		while(it.hasNext()){
			@SuppressWarnings("unchecked")
			Map.Entry<String, Team>entry=(Map.Entry<String, Team>)it.next();
			System.out.println(entry.getKey()+" "+entry.getValue().getCname()+" "+entry.getValue().getClocation());
			try {
				st.executeUpdate("insert into TEAM"+"values(entry.getKey(),TEAM_SEQUENCE.nextval,entry.getValue().getCname(),entry.getValue().getClocation())");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;		
	}
	public static Object DataConnectivity(){
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", 
					"training", "training");
			st = con.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}
}
