package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/* Final utility class to obtain connections in a modular way */
public final class ConnectionUtil {
	
	/* Get connection to JDBC */
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@LINK_TO_RDS:1521:ORCL";
		String username = "LOGIN_TEST_DB";
		String password = "p4ssw0rd";
		
		return DriverManager.getConnection(url, username, password);
	}
}
