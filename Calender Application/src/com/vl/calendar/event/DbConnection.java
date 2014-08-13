package com.vl.calendar.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbConnection 
{

	public static Connection getConnection() throws SQLException {
		try {
			// DriverManager.registerDriver((Driver)(Class.forName("oracle.jdbc.driver.OracleDriver")).newInstance() );
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			return DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", "training", "training");
			} catch (Exception e) {
			// TODO Auto-generated catch block
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
