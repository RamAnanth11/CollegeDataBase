package com.college.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CollegeUtil {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/college";
			String user = "root";
			String pass = "root";

			Connection connection = DriverManager.getConnection(url, user, pass);
			return connection;

		} catch (ClassNotFoundException | SQLException e) {
		}

		return null;
	}
}
