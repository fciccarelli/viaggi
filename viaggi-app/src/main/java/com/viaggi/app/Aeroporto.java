package com.viaggi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aeroporto {
	String id;
	private String citta;
	private String nazione;
	private int npiste;


	public Aeroporto() {

	}

	public Aeroporto(String id, String citta,String nazione,int npiste) {
	this.id = id;
	this.citta = citta;
	this.nazione = nazione;
	this.npiste = npiste;

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
	PreparedStatement prepared = connection.prepareStatement(
	"insert into aeroporto ( id,  citta, nazione, npiste) values (?,?,?,?)");
	System.out.println("inserisci ID dell'aeroporto: ");
	id = inputKey.nextLine();
	prepared.setString(1, id);
	System.out.println("inserisci citta' dell'aeroporto: ");
	citta = inputKey.nextLine();
	prepared.setString(2, citta);
	System.out.println("inserisci nazione dell'aeroporto");
	nazione = inputKey.nextLine();
	prepared.setString(3, nazione.toUpperCase());
	System.out.println("inserisci numero piste dell'aeroporto");
	npiste = inputKey.nextInt();
	prepared.setInt(4, npiste);
	prepared.executeUpdate();
	Statement stm = connection.createStatement();
	ResultSet rs = stm
	.executeQuery("select * from aeroporto; ");
	while (rs.next()) {
	System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
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
		while (rs.next()) {
		System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
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
	
	
	public void updatePiste(Scanner inputKey) {
		String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
		Connection connection = null;
		try {
			
				connection = DriverManager.getConnection(connectionString);
								
				System.out.println("Quale numero l'ID dell'aereoporto di cui aggiornare le piste?");
				id = inputKey.next();
				
				System.out.println("Quale è il nuovo numero di piste da settare?");
				npiste = inputKey.nextInt();
				
				System.out.println();
				
				String query = "UPDATE aeroporto SET npiste =? " +  " WHERE id =?" +  " ";
				PreparedStatement prepared = connection.prepareStatement(query);
				
				
				prepared.setInt(1, npiste);
				prepared.setString(2, id);
				
					
				prepared.executeUpdate();
				
				Statement stm = connection.createStatement();
				ResultSet rs = stm
				.executeQuery("select * from aeroporto; ");
				while (rs.next()) {
				System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
				System.out.println();
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