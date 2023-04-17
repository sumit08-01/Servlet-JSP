package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully!");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "admin");
			System.out.println("Connection established");
		}
		catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch(SQLException sql) {
			sql.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return conn;
	}
}
