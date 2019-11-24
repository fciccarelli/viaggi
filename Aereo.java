package com.mycompany.app;

import java.sql.*;
/*
 * Classe che si connette al database viaggi
 */

public class Aereo {
	static {
		try {
			// caricamento e registrazione driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			//insert
			PreparedStatement prepared = connection.prepareStatement("insert into aereo (tipoAereo, nPass, quantitaMerci) values (?,?,?)");
			prepared.setString(1, "Airbus A340-318");
			prepared.setInt(2, 300);
			prepared.setInt(3, 10);
			prepared.executeUpdate();
			Statement stm = connection.createStatement();
			
			// query richiesta
			ResultSet rs = stm.executeQuery("select *from aereo where tipoAereo = 'Airbus A340-303'");
			
			// aggiorna il database viaggi
			System.out.println("\n\nUpdate the database viaggi ");
			stm = connection.createStatement();
			int rowsUpdated = stm.executeUpdate("UPDATE aereo SET nPass = 500 WHERE tipoAereo = 'Airbus A380-700'");
			ResultSet rs_all = stm.executeQuery("select *from aereo");
			System.out.print("Changed "+rowsUpdated);	
			if (1 == rowsUpdated) 
			System.out.println(" row.");
			else
			System.out.println(" rows.");
			
			System.out.println("Controlla gli aerei, quello aggiunto ed  il set nPass di A380-700 da 525 a 500");
			while (rs_all.next()) {
				System.out.println("Update: "+rs_all.getString("tipoAereo") + " " + rs_all.getInt("nPass") + " " + rs_all.getInt("quantitaMerci"));
			  }
			
			System.out.println("La query: ");
			while (rs.next()) {
				System.out.println(rs.getString("tipoAereo") + " " + rs.getInt("nPass") + " " + rs.getInt("quantitaMerci"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// gestione errore in chiusura
			}
		}
	}
}


//		('Airbus A340-300', 295, 10),
//		('Airbus A340-500', 372, 20),
//		('Airbus A340-600', 420, 30),
//		('Boeing 777-200', 440, 50),
//		('Airbus A380-700', 525, 60), cambio npass a 500
//		('Boeing 777-300', 550, 10),
//		('Boeing 747-400', 624, 60),
//		('Boeing 747-8', 700, 70),
//		('Airbus A380-800', 853, 80),
//		('Airbus A380-900', 900, 80);
