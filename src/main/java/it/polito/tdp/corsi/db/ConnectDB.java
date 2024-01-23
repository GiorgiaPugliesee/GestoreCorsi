package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	
	public static Connection getConnection() throws SQLException {
		String jdbcURL = "jdbc:mariadb://localhost/iscritticorsi?user=root&password=root";
		Connection conn = DriverManager.getConnection(jdbcURL);
		return conn;
	}

}
