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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Luigi
 * 
 * Classe che definisce l'oggetto di tipo Aeroporto ed implementa le funzionalità di inserimento, selezione e modifica di un oggetto.
 *
 */
public class Aeroporto {

	private String id;
	private String citta;
	private String nazione;
	private int nPiste;

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
	 * Costruttore vuoto.
	 */
	public Aeroporto() {

	}

	/**
	 * Costruttore che inizializza oggetti di tipo Aeroporto.
	 * @param id id dell'aeroporto.
	 * @param citta città in cui si trova l'aeroporto.
	 * @param nazione nazione in cui si trova l'aeroporto.
	 * @param nPiste numero di piste dell'aeroporto. 
	 */
	public Aeroporto(String id, String citta, String nazione, int nPiste) {
		this.id = id;
		this.citta = citta;
		this.nazione = nazione;
		this.nPiste = nPiste;
	}

	/**
	 * Metodo che effettua l'inserimento nel database di un oggetto di tipo Aeroporto.
	 * (PRE: l'operazione di Scanner deve andare a buon fine.).
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void insertAeroporto(Scanner inputK) {

		try {

			connection = DriverManager.getConnection(connectionString);

			Statement stm = connection.createStatement();

			PreparedStatement prepared = connection
					.prepareStatement("INSERT INTO Aeroporto (id,citta,nazione,nPiste) VALUES (?,?,?,?)");

			System.out.println("Inserisci l'id dell'Aeroporto: ");
			id = inputK.nextLine();
			prepared.setString(1, id);

			System.out.println("Inserisci la citta: ");
			citta = inputK.nextLine();
			prepared.setString(2, citta);

			System.out.println("Inserisci la nazione: ");
			nazione = inputK.nextLine();
			prepared.setString(3, nazione);

			System.out.println("Inserisci il numero di piste: ");
			nPiste = inputK.nextInt();			
			prepared.setInt(4, nPiste);

			prepared.executeUpdate();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aeroporto WHERE citta = '" + citta + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			/**
			 * Visualizzazione in console del volo appena inserito
			 */
			while (rs.next()) {
				System.out.println(rsmd.getColumnName(1) + " " + rs.getString(1) + ", " + rsmd.getColumnName(2) + " "
						+ rs.getString(2) + ", " + rsmd.getColumnName(3) + " " + rs.getString(3) + ", "
						+ rsmd.getColumnName(4) + " " + rs.getInt(4));
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

	/** Metodo che implementa la funzionalità di ricerca di un aeroporto, dato l'id.
	 * (PRE: l'operazione di Scanner deve andare a buon fine.).
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void cercaAeroporto(Scanner inputK) throws SQLException {

			connection = DriverManager.getConnection(connectionString);

			Statement stm = connection.createStatement();

			System.out.println("inserisci l'id dell'Aeroporto che vuoi cercare");
			id = inputK.nextLine();

			ResultSet rs = stm.executeQuery("SELECT * FROM Aeroporto Where id = '" + id + "'");
			ResultSetMetaData rsmd = rs.getMetaData();

			while (rs.next()) {
				System.out.println(rsmd.getColumnName(2) + " " + rs.getString(2) + ", " + rsmd.getColumnName(3) + " "
						+ rs.getString(3) + ", " + rsmd.getColumnName(4) + " " + rs.getInt(4));
			}
			
			if (!rs.next()) {
				System.out.println("Operazione non effettuata.");
				System.out.println("");
			} else {
				System.out.println("Operazione effettuata.");
				System.out.println("");
			}

//			try {
//				if (connection != null)
					connection.close();
//			} catch (SQLException e) {
////				gestione errore in chiusura
//				e.printStackTrace();
//			}
	}


	/**
	 * Metodo che implementa la funzionalità di aggiornamento del numero di piste di un aeroporto, dato l'id.
	 * @param inputK oggetto di tipo Scanner.
	 */
	public void updatePiste(Scanner inputK) {

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
				System.out.println(rsmd.getColumnName(2) + " " + rs.getString(2) + ", " + rsmd.getColumnName(3) + " "
						+ rs.getString(3) + ", " + rsmd.getColumnName(4) + " " + rs.getInt(4));
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