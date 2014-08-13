package com.rest.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.rest.entity.TeamUser;

public class TeamUserStore {

	//private static Map<String,Contact> map;
	private static Map<String,TeamUser> map = new HashMap<String,TeamUser>();

	/*private ContactStore() {

		Contact contact = new Contact("1", "Learn REST");
		//contact.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
		map.put("1", contact);
		contact = new Contact("2", "Do something");
		//contact.setDescription("Read complete http://www.vogella.com");
		map.put("2", contact);

	}*/
	/*public static Map<String,TeamUser> getDetailes(){
		Team contact = new Team("1", "Learn REST");
		//contact.setDescription("Read http://www.vogella.com/tutorials/REST/article.html");
		map.put("1", contact);
		contact = new Team("2", "Do something");
		//contact.setDescription("Read complete http://www.vogella.com");
		map.put("2", contact);
		//DataConnectivity();
		return map;
	}*/
	public static Map DataRetrive(){
		Statement st=(Statement) DataConnectivity();
		ResultSet rs;
		try {
			rs = st.executeQuery("select * from TEAM");
			while(rs.next())
			{
				String id=rs.getString("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				int mobile_number=rs.getInt("mobile_number");
				String designation=rs.getString("designation");
				String password=rs.getString("password");
				
				TeamUser team=new TeamUser(id,name,email,mobile_number,designation,password);
				map.put(id, team);
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
			Map.Entry<String, TeamUser>entry=(Map.Entry<String, TeamUser>)it.next();
			System.out.println(entry.getKey()+" "
					+ ""+entry.getValue().getName()+" "+entry.getValue().getEmail()+""+entry.getValue().getMobile_number()
					+""+entry.getValue().getId()+""+entry.getValue().getDesignation()+""+entry.getValue().getPassword());
			try {
				st.executeUpdate("insert into TEAMS_USER"+"values(entry.getKey(),entry.getValue().getname(),entry.getValue().getEmail(),entry.getValue().getMobile_number,entry.getValue().getDesignation(),entry.getValue().getPassword(),USER_SEQUENCE.nextval)");
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
