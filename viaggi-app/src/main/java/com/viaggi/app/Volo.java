/**
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
 *         Classe che definisce l'oggetto di tipo Volo ed implementa le
 *         funzionalità di inserimento e selezione.
 *
 */
public class Volo {

	@SuppressWarnings("unused")
	private int idVolo;
	private String giornoSett;
	private String aeroportoPart;
	private String aeroportoArr;
	private String tipoAereo;
	private String oraPartenza;
	private String oraArrivo;

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
	 * Costruttore vuoto
	 */
	public Volo() {

	}

	/**
	 * Costruttore che inizializza oggetti di tipo Volo.
	 * 
	 * @param idVolo        è l'id del volo, chiave primaria della tabella nel
	 *                      database.
	 * @param giornoSett    giorno di partenza del volo.
	 * @param aeroportoPart aeroporto di partenza.
	 * @param aeroportoArr  aeroporto di arrivo.
	 * @param tipoAereo     modello dell'aereo.
	 * @param oraPartenza   ora di partenza.
	 * @param oraArrivo     ora di arrivo.
	 */
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

	/**
	 * Metodo che effettua l'inserimento nel database di un oggetto di tipo Volo.
	 * (PRE: l'operazione di Scanner deve andare a buon fine.).
	 * 
	 * @param inputK oggetto di tipo Scanner.
	 * @throws SQLException
	 */
	public void insertVolo(Scanner inputK) throws SQLException, SQLIntegrityConstraintViolationException {

		connection = DriverManager.getConnection(connectionString);

		Statement stm = connection.createStatement();

		String query = "INSERT INTO Volo (giornoSett,aeroportoPart,aeroportoArr,tipoAereo,oraPartenza,oraArrivo) VALUES (?,?,?,?,?,?)";

		PreparedStatement prepared = connection.prepareStatement(query);

		System.out.println("Inserisci il giorno della settimana: ");
		giornoSett = inputK.nextLine();
		prepared.setString(1, giornoSett);

		System.out.println("Inserisci la sigla dell'aeroporto di partenza: ");
		aeroportoPart = inputK.nextLine();
		prepared.setString(2, aeroportoPart.toUpperCase());

		System.out.println("Inserisci la sigla dell'aeroporto di arrivo: ");
		aeroportoArr = inputK.nextLine();
		prepared.setString(3, aeroportoArr.toUpperCase());

		System.out.println("Inserisci il modello dell'aereo: ");
		tipoAereo = inputK.nextLine();
		prepared.setString(4, tipoAereo);

		System.out.println("Inserisci l'orario di partenza (HH:MM:SS): ");
		oraPartenza = inputK.nextLine();
		prepared.setString(5, oraPartenza);

		System.out.println("Inserisci l'orario di arrivo (HH:MM:SS): ");
		oraArrivo = inputK.nextLine();
		prepared.setString(6, oraArrivo);

		prepared.executeUpdate();

		/**
		 * Visualizzazione in console del volo appena inserito
		 */
		ResultSet rs = stm.executeQuery("SELECT * FROM Volo ORDER BY idVolo DESC LIMIT 1;");
		ResultSetMetaData rsmd = rs.getMetaData();

		while (rs.next()) {
			System.out.println(rsmd.getColumnName(2) + " " + rs.getString(2) + ", " + rsmd.getColumnName(3) + " "
					+ rs.getString(3) + ", " + rsmd.getColumnName(4) + " " + rs.getString(4) + ", "
					+ rsmd.getColumnName(5) + " " + rs.getString(5) + ", " + rsmd.getColumnName(6) + " "
					+ rs.getString(6) + ", " + rsmd.getColumnName(7) + " " + rs.getString(7));
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Metodo che implementa la funzionalità di ricerca di un volo, dato l'id. (PRE:
	 * l'operazione di Scanner deve andare a buon fine.).
	 * 
	 * @param inputK oggetto di tipo Scanner.
	 * @throws SQLException
	 */
	public void cercaVolo(Scanner inputK) throws SQLException, InputMismatchException, SQLIntegrityConstraintViolationException {

		connection = DriverManager.getConnection(connectionString);

		Statement stm = connection.createStatement();

		System.out.println("Inserisci l'id del volo che vuoi cercare: ");
		int idVolo = inputK.nextInt();

		ResultSet rs = stm.executeQuery("SELECT * FROM Volo WHERE idVolo = " + idVolo);
		ResultSetMetaData rsmd = rs.getMetaData();

		while (rs.next()) {
			System.out.println(rsmd.getColumnName(2) + " " + rs.getString(2) + ", " + rsmd.getColumnName(3) + " "
					+ rs.getString(3) + ", " + rsmd.getColumnName(4) + " " + rs.getString(4) + ", "
					+ rsmd.getColumnName(5) + " " + rs.getString(5) + ", " + rsmd.getColumnName(6) + " "
					+ rs.getString(6) + ", " + rsmd.getColumnName(7) + " " + rs.getString(7));
		}

		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
