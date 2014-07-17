package com.test.connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class CTestConnection {

    public void query()
    {
        Connection con = getConnection();
        if(null == con)
        {
            System.err.println("unable to create a connection");
            return;
        }
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select sysdate from dual");
            if(rs.next())
            {
                Date date = rs.getDate(1);
                System.out.println(date);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection()
    {

        try {
            //          DriverManager.registerDriver((Driver)(Class.forName("oracle.jdbc.driver.OracleDriver")).newInstance() );
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            return DriverManager.getConnection("jdbc:oracle:thin:@sfodev01.snapfish.valuelabs.net:1521:SFODEV01", "training", "training");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        return null;
    }

    public static void main(String[] args) {
        CTestConnection c = new CTestConnection();
        c.query();
    }
}
