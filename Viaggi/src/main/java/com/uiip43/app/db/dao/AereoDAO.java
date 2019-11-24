/**
 * 
 */
package com.uiip43.app.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.uiip43.app.db.DBManager;
import com.uiip43.app.entities.Aereo;

/**
 * @author fabiosessa
 *
 */
public class AereoDAO {
	private static Connection connection;

	/**
	 * default constructor
	 */
	public AereoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void inserimento(Aereo a) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		String query = "INSERT INTO Aereo (tipoAereo,nPass,quantitaMerci)" + "values (?,?,?);";
		try {
			s = connection.prepareStatement(query);
			s.setString(1, a.getTipoAereo());
			s.setInt(2, a.getNpass());
			s.setInt(3, a.getQuantitaMerci());
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore inserimento nel database \n");
		}
		DBManager.closeConnection(connection);
	}

	public static Aereo selezione(String tipoAereo) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		Aereo a = new Aereo();
		String query = "SELECT * FROM Aereo WHERE tipoAereo=?";
		try {
			s = connection.prepareStatement(query);
			s.setString(1, tipoAereo);
			ResultSet r = s.executeQuery();
			if (!r.isBeforeFirst())
				System.out.println("Nessun risultato trovato\n");
			while (r.next()) {

				String tipoAereo1 = r.getString(1);
				if (r.wasNull())
					System.out.println("tipo nullo");
				int nPass = r.getInt(2);
				if (r.wasNull())
					System.out.println("npass nullo");
				int quantitaMerci = r.getInt(3);
				if (r.wasNull())
					System.out.println("qmerci nullo");
				a.setTipoAereo(tipoAereo1);
				a.setNpass(nPass);
				a.setQuantitaMerci(quantitaMerci);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore ricerca nel database \n");
		}
		DBManager.closeConnection(connection);
		return a;
	}

	public static void aggiornamento(String tipoAereo, int nPass) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		String query = "UPDATE Aereo SET nPass=? WHERE tipoAereo=?";
		try {
			s = connection.prepareStatement(query);
			s.setInt(1, nPass);
			s.setString(2, tipoAereo);
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore aggionramento nel database \n");
		}
		DBManager.closeConnection(connection);

	}

}
