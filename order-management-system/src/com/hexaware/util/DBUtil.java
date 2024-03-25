package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static Connection conn;

	public static Connection getDBConn() {

		String usernameDb = "root";
		String passwordDb = "12345678";
		String urlDb = "jdbc:mysql://localhost:3306/OrderManagementSystem";
		try {
			conn = DriverManager.getConnection(urlDb, usernameDb, passwordDb);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void dbClose() throws SQLException {
		conn.close();
	}

}
