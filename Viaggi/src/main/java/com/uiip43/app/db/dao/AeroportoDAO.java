/**
 * 
 */
package com.uiip43.app.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.uiip43.app.db.DBManager;
import com.uiip43.app.entities.Aeroporto;

/**
 * @author fabiosessa
 *
 */
public class AeroportoDAO {
	private static Connection connection;

	/**
	 * default constructor
	 */
	public AeroportoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void inserimento(Aeroporto a) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		String query = "INSERT INTO Aeroporto (id,citta,nazione,nPiste)" + "values (?,?,?,?);";
		try {
			s = connection.prepareStatement(query);
			s.setString(1, a.getId());
			s.setString(2, a.getCitta());
			s.setString(3, a.getNazione());
			s.setInt(4, a.getnPiste());
			s.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore inserimento nel database \n");
		}
		DBManager.closeConnection(connection);
	}

	public static Aeroporto selezione(String id) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		Aeroporto a = new Aeroporto();
		String query = "SELECT * FROM Aeroporto WHERE id=?";
		try {
			s = connection.prepareStatement(query);
			s.setString(1, id);
			ResultSet r = s.executeQuery();
			if (!r.isBeforeFirst())
				System.out.println("Nessun risultato trovato\n");
			while (r.next()) {
				String id1 = r.getString(1);
				if (r.wasNull())
					System.out.println("id nullo");
				String citta = r.getString(2);
				if (r.wasNull())
					System.out.println("citta nullo");
				String nazione = r.getString(3);
				if (r.wasNull())
					System.out.println("nazione nullo");
				int nPiste = r.getInt(4);
				if (r.wasNull())
					System.out.println("nPiste nullo");
				a.setId(id1);
				a.setCitta(citta);
				a.setNazione(nazione);
				a.setnPiste(nPiste);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore inserimento nel database \n");
		}
		DBManager.closeConnection(connection);
		return a;
	}

	public static void aggiornamento(String id, int nPiste) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		String query = "UPDATE Aeroporto SET nPiste=? WHERE id=?";
		try {
			s = connection.prepareStatement(query);
			s.setInt(1, nPiste);
			s.setString(2, id);
			s.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore aggionramento nel database \n");
		}
		DBManager.closeConnection(connection);

	}

}
