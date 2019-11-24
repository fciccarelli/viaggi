package com.viaggi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Volo {

	int idVolo;
	private String giornoSett;
	private String aeroportoPart;
	private String aeroportoArr;
	private String tipoAereo;
	private String oraPartenza;
	private String oraArrivo;

	public Volo() {

	}

	public Volo(int idVolo, String giornoSett, String aeroportoPart, String aeroportoArr, String tipoAereo,
			String oraPartenza, String oraArrivo) {
		this.idVolo = idVolo;
		this.giornoSett = giornoSett;
		this.aeroportoPart = aeroportoPart;
		this.aeroportoArr = aeroportoArr;
		this.tipoAereo = tipoAereo;
		this.oraPartenza = oraPartenza;
		this.oraArrivo = oraArrivo;
	}

	public void insertVolo(Scanner inputKey) {
		String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {

			connection = DriverManager.getConnection(connectionString);
			PreparedStatement prepared = connection.prepareStatement(
					"insert into volo (giornoSett,aeroportoPart,aeroportoArr,tipoAereo,oraPartenza,oraArrivo) values (?,?,?,?,?,?)");
			System.out.println("inserisci giorno della settimana: ");
			giornoSett = inputKey.nextLine();
			prepared.setString(1, giornoSett);
			System.out.println("inserisci sigla aeroporto di partenza");
			aeroportoPart = inputKey.nextLine();
			prepared.setString(2, aeroportoPart.toUpperCase());
			System.out.println("inserisci sigla aeroporto di arrivo");
			aeroportoArr = inputKey.nextLine();
			prepared.setString(3, aeroportoArr.toUpperCase());
			System.out.println("inserisci il modello dell'aereo");
			tipoAereo = inputKey.nextLine();
			prepared.setString(4, tipoAereo);
			System.out.println("orario di partenza (HH:MM:SS)");
			oraPartenza = inputKey.nextLine();
			prepared.setString(5, oraPartenza);
			System.out.println("orario di arrivo (HH:MM:SS)");
			oraArrivo = inputKey.nextLine();
			prepared.setString(6, oraArrivo);
			prepared.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void cercaVolo(Scanner inputKey) {

		String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection = null;
		try {

			connection = DriverManager.getConnection(connectionString);
			Statement stm = connection.createStatement();
			System.out.println("inserisci l'id del volo che vuoi cercare");
			int id = inputKey.nextInt();
			ResultSet rs = stm.executeQuery("SELECT * FROM Volo where idvolo = " + id);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(2) + "= " + rs.getString(2) + ", " + rsmd.getColumnName(3) + "= "
						+ rs.getString(3) + ", " + rsmd.getColumnName(4) + "= " + rs.getString(4) + ", "
						+ rsmd.getColumnName(5) + "= " + rs.getString(5) + ", " + rsmd.getColumnName(6) + "= "
						+ rs.getString(6) + ", "+rsmd.getColumnName(7)+"= " + rs.getString(7));
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
				e.printStackTrace();
			}
		}

	}

}
