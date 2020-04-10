package com.capg.assign.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect 
{
	static Connection connection;
	
	public static Connection getConnection() 
	{
		 try 
		 {
			 Class.forName("oracle.jdbc.driver.OracleDriver");

			 connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","tanya","password123");

//             System.out.println("connection established successfully...!!"); 
             
		 } 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return connection;
	}
}
