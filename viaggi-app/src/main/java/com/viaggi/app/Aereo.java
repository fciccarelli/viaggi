/**
 * 
 */
package com.viaggi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * @author Luigi
 *
 * Classe che definisce l'oggetto di tipo Aereo ed implementa le funzionalità di inserimento, selezione e modifica di un oggetto.
 */
public class Aereo {

	private String tipoAereo;
	private int nPass;
	private int quantitaMerci;

	private String serverDB = "jdbc:mysql://localhost:3306/viaggi";
	private String accessoDB = "?user=root&password=root&serverTimezone=Europe/Rome";

	private String connectionString = serverDB + accessoDB;
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection connection = null;

	/**
	 * Costeruttore vuoto.
	 */
	public Aereo() {

	}
	
	/**
	 * Costruttore che definisce un oggetto di tipo Aereo.
	 * @param tipoAereo modello dell'aereo.
	 * @param nPass numero di passeggeri che l'aereo trasporta.
	 * @param quantitaMerci quantità di merci che l'aereo trasporta.
	 */
	public Aereo(String tipoAereo, int nPass, int quantitaMerci) {
		this.tipoAereo = tipoAereo;
		this.nPass = nPass;
		this.quantitaMerci = quantitaMerci;
	}

	/**
	 * Costruttore che definisce un oggetto di tipo Aereo.
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void insertAereo(Scanner inputK) {

		try {

			connection = DriverManager.getConnection(connectionString);

			Statement stm = connection.createStatement();

			PreparedStatement prepared = connection
					.prepareStatement("insert into Aereo (tipoAereo, nPass, quantitaMerci) values (?,?,?)");

			System.out.println("inserisci il modello dell'aereo: ");
			tipoAereo = inputK.nextLine();
			prepared.setString(1, tipoAereo);

			System.out.println("inserisci il numero di passeggeri: ");
			nPass = inputK.nextInt();
			prepared.setInt(2, nPass);

			System.out.println("inserisci la quantità di merci");
			quantitaMerci = inputK.nextInt();
			prepared.setInt(3, quantitaMerci);

			prepared.executeUpdate();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aereo WHERE tipoAereo = '" + tipoAereo + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			/**
			 * Visualizzazione dell'operazione appena eseguita.
			 */
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + " " + rs.getString(1) + ", " + rsmd.getColumnName(2) + " "
						+ rs.getInt(2) + ", " + rsmd.getColumnName(3) + " " + rs.getInt(3));
			}

			System.out.println("Operazione effettuata.");
			System.out.println("");

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			System.out.println("Problema con le foreign key, operazione non eseguita!");
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

	/**
	 * Metodo che implementa la funzionalità di ricerca di un aereo, dato il modello.
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void cercaAereo(Scanner inputK) {

		try {

			connection = DriverManager.getConnection(connectionString);

			Statement stm = connection.createStatement();

			System.out.println("Inserisci il modello dell'aereo del quale vuoi vedere le caratteristiche: ");
			tipoAereo = inputK.nextLine();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aereo WHERE tipoAereo = '" + tipoAereo + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + " " + rs.getString(1) + ", " + rsmd.getColumnName(2) + " "
						+ rs.getString(2) + ", " + rsmd.getColumnName(3) + " " + rs.getString(3));
			}

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

	/**
	 * Metodo che implementa la funzionalità di aggiornamento del numero di passeggeri di un aereo, dato il modello (tipoAereo).
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void updatePassengers(Scanner inputK) {

		try {

			connection = DriverManager.getConnection(connectionString);

			Statement stm = connection.createStatement();

			System.out.println("Di quale modello di aereo vuoi aggiornare il numero di passeggeri?");
			tipoAereo = inputK.nextLine();

			System.out.println("Quale numero di passeggeri devo settare?");
			nPass = inputK.nextInt();

			String query = "UPDATE aereo SET nPass = ? WHERE tipoAereo = ?";
			PreparedStatement prepared = connection.prepareStatement(query);

			prepared.setInt(1, nPass);
			prepared.setString(2, tipoAereo);

			prepared.executeUpdate();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aereo WHERE tipoAereo = '" + tipoAereo + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			/**
			 * Visualizzazione dell'operazione appena eseguita.
			 */
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + " " + rs.getString(1) + ", " + rsmd.getColumnName(2) + " "
						+ rs.getInt(2) + ", " + rsmd.getColumnName(3) + " " + rs.getInt(3));
			}

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
