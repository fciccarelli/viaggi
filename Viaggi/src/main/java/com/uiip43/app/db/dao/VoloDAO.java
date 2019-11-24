/**
 * 
 */
package com.uiip43.app.db.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import com.uiip43.app.db.DBManager;
import com.uiip43.app.entities.Volo;

/**
 * @author fabiosessa
 *
 */
public class VoloDAO {
	private static Connection connection;

	/**
	 * default constructor
	 */
	public VoloDAO() {
		// TODO Auto-generated constructor stub
	}

	public static void inserimento(Volo v) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		String query = "insert into volo (giornoSett, aeroportoPart, aeroportoArr, tipoAereo, oraPartenza, oraArrivo) values"
				+ "(?, ?, ?, ?, ?, ?);";
		try {
			s = connection.prepareStatement(query);
			s.setString(1, v.getGiorniSett());
			s.setString(2, v.getAeroportoPart());
			s.setString(3, v.getAeroportoArr());
			s.setString(4, v.getTipoAereo());
			s.setTime(5, v.getOraPartenza());
			s.setTime(6, v.getOraArrivo());
			s.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore inserimento nel database \n");
		}

		DBManager.closeConnection(connection);
	}

	public static Volo selezione(int idVolo) {
		connection = DBManager.getConnection();
		PreparedStatement s = null;
		Volo v = new Volo();
		String query = "SELECT * FROM Volo WHERE idVolo=?";
		try {
			s = connection.prepareStatement(query);
			s.setInt(1, idVolo);
			ResultSet r = s.executeQuery();
			if (!r.isBeforeFirst())
				System.out.println("Nessun risultato trovato\n");
			while (r.next()) {
				int idVolo1 = r.getInt(1);
				if (r.wasNull())
					System.out.println("idvolo nullo");
				String giornoSett = r.getString(2);
				if (r.wasNull())
					System.out.println("giorno nullo");
				String areoportoPart = r.getString(3);
				if (r.wasNull())
					System.out.println("aeroportoPart nullo");
				String areoportoArr = r.getString(4);
				if (r.wasNull())
					System.out.println("aeroportoArr nullo");
				String tipoAereo = r.getString(5);
				if (r.wasNull())
					System.out.println("tipoAereo nullo");
				Time oraPartenza = r.getTime(6);
				if (r.wasNull())
					System.out.println("oraPartenza nullo");
				Time oraArrivo = r.getTime(7);
				if (r.wasNull())
					System.out.println("oraArrivo nullo");
				v.setIdVolo(idVolo1);
				v.setGiorniSett(giornoSett);
				v.setAeroportoPart(areoportoPart);
				v.setAeroportoArr(areoportoArr);
				v.setTipoAereo(tipoAereo);
				v.setOraPartenza(oraPartenza);
				v.setOraArrivo(oraArrivo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.print("Errore inserimento nel database \n");
		}
		DBManager.closeConnection(connection);
		return v;
	}
}
