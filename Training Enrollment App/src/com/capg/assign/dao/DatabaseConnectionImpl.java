package com.capg.assign.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionImpl implements DatabaseConnection 
{

	static Connection connection;

	public Connection getDatabaseConnection() 
	{
			 connection = DbConnect.getConnection();
		
			 return connection;
		
	}

	
}
