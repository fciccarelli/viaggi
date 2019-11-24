package com.uiip43.app.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class DBManager {

	/**
	 * Default constructor
	 */
	public DBManager() {

	}

	/**
	 * 
	 */
	private static Connection connection;
	private static String url = "jdbc:mysql://localhost:3306/viaggi";
	private static String password = "root";
	private static String user = "root";

	/**
	 * @return
	 */
	public static Connection getConnection() {
		// TODO implement here
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Errore connessione al DATABASE\n");
			System.exit(0);
		}
		return connection;
	}

	/**
	 * 
	 */
	public static void closeConnection(Connection connection) {
		// TODO implement here
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Errore connessione al DATABASE\n");
				System.exit(0);
			}
		}
	}
}