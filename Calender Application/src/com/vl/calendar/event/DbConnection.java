package com.vl.calendar.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
	public static Connection getConnection() throws SQLException 
	{
		try 
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			return DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", "training", "training");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Connection connection)
	{
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
