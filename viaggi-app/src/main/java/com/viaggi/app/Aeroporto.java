package com.viaggi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aeroporto {

	String id;
	String citta;
	String nazione;
	int nPiste;

	public Aeroporto() {

	}

	public Aeroporto(String id, String citta, String nazione, int nPiste) {
		this.id = id;
		this.citta = citta;
		this.nazione = nazione;
		this.nPiste = nPiste;
	}

	public void insertAeroporto(Scanner inputKey) {
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

			PreparedStatement prepared = connection
					.prepareStatement("insert into Aeroporto (id,citta,nazione,nPiste) values (?,?,?,?)");

			System.out.println("inserisci l'id dell'Aeroporto: ");
			id = inputKey.nextLine();
			prepared.setString(1, id);

			System.out.println("inserire la citta");
			citta = inputKey.nextLine();
			prepared.setString(2, citta);

			System.out.println("inserire la nazione");
			nazione = inputKey.nextLine();
			prepared.setString(3, nazione);

			System.out.println("inserisci il numero di piste");
			nPiste = inputKey.nextInt();
			prepared.setInt(4, nPiste);

			prepared.executeUpdate();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aeroporto WHERE id = '" + id + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			/**
			 * Visualizzazione dell'operazione appena effettuata.
			 */
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + "= " + rs.getString(1) + ", " + rsmd.getColumnName(2) + "= "
						+ rs.getString(2) + ", " + rsmd.getColumnName(3) + "= " + rs.getString(3) + ", "
						+ rsmd.getColumnName(4) + "= " + rs.getInt(4));
			}

			System.out.println("");
			System.out.println("Operazione effettuata.");
			System.out.println("");

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

	public void cercaAeroporto(Scanner inputKey) {

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

			System.out.println("inserisci l'id dell'Aeroporto che vuoi cercare");
			id = inputKey.nextLine();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aeroporto Where id = '" + id + "'");
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + "= " + rs.getString(1) + ", " + rsmd.getColumnName(2) + "= "
						+ rs.getString(2) + ", " + rsmd.getColumnName(3) + "= " + rs.getString(3) + ", "
						+ rsmd.getColumnName(4) + "= " + rs.getString(4));
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

	public void updatePiste(Scanner inputK) {
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

			System.out.println("Di quale aeroporto (id) vuoi aggiornare il numero di piste?");
			id = inputK.nextLine();

			System.out.println("Quale numero di piste devo settare?");
			nPiste = inputK.nextInt();

			String query = "UPDATE aeroporto SET nPiste = ? WHERE id = ?";
			PreparedStatement prepared = connection.prepareStatement(query);

			prepared.setInt(1, nPiste);
			prepared.setString(2, id);

			prepared.executeUpdate();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aeroporto WHERE id = '" + id + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			/**
			 * Visualizzazione dell'operazione appena effettuata.
			 */
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(2) + "= " + rs.getString(2) + ", " + rsmd.getColumnName(3) + "= "
						+ rs.getString(3) + ", " + rsmd.getColumnName(4) + "= " + rs.getInt(4));
			}

			System.out.println("");
			System.out.println("Operazione effettuata.");
			System.out.println("");

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
				e.printStackTrace();
			}
		}
	}

}
