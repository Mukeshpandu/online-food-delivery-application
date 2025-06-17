package com.project.util;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static String URL = "jdbc:mysql://localhost:3306/foodapplication";
	private static String USERNAME = "root";
	private static String PASSWORD = "root";
	private static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
