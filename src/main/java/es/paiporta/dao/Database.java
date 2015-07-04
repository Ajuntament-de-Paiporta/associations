package es.paiporta.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

	public Connection GetConnection() throws Exception
	{
		try {
			
			String connectionURL = "jdbc:mysql://localhost:3306/associations";
			Connection connection = null;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "admin_assoc", "assoc2015");
			return connection;
			
		} catch (Exception e) {
			throw e;	
		}
	}
}
