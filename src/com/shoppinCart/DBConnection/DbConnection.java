package com.shoppinCart.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection connection = null;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		if(connection == null)
		{
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/ShoppingCart","root","Lisha@1571");  
		}
		return connection;
		
	}
	

}
