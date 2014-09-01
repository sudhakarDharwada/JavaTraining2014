package com.val.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Credentials 
{
	 HashMap<String, Login> hp=new HashMap<String, Login>();
	private static Connection getConnection() 
	{
		try
		{
			//load driver
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			//connecting to data base
            return DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", "training", "training");
		}
		catch(SQLException sqlex)
		{
			sqlex.printStackTrace();
		}
		return null;
	}
	public HashMap<String, Login> getCredentials() throws SQLException
	{
		Connection con=getConnection();
		Statement st=null;
		ResultSet rs=null;
		if(null==con)
		{
			System.out.println("The Connection is not Established");
		}
		try
		{
			st=con.createStatement();
			
			rs=st.executeQuery("select * from calendar_user_login");
			
			while(rs.next())
			{
				String email=rs.getString("EMAIL");
				String password=rs.getString("PASSWORD");
				int loginid = rs.getInt("USER_SEQ_ID");
				Login login = new Login();
				login.setLoginid(loginid);
				login.setPassword(password);
				hp.put(email, login);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				con.close();
			}
			if(rs!=null && st!=null)
			{
				st.close();
				rs.close();
			}
		}
		return hp;
	}
}
