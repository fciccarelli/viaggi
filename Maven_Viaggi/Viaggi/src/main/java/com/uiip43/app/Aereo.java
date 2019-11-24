/**
 * 
 */
package com.uiip43.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pasop
 * Classe che modella un Aereo
 */
public class Aereo implements DbOperations {
	
	private String tipoAereo;
	private int nPass;
	private int quantitaMerci;
	public static final int LENGTH_TIPO_AEREO = 16;
	
	
	/**
	 * Costruttore vuoto
	 */
	public Aereo() {
		this("",0,0);
	}
	
	/**
	 * Costruttore che inizializza un Aereo
	 * @param tipoAereo rappresenta il modello di aereo
	 * @param nPass rappresenta il numero di passeggero
	 * @param quantitaMerci rappresenta la quantità di merci
	 * (POST: un aereo con tipo, numero passeggeri e quantità merci viene inizializzato)
	 */
	public Aereo(String tipoAereo, int nPass, int quantitaMerci) {
		this.tipoAereo = tipoAereo;
		this.nPass = nPass;
		this.quantitaMerci = quantitaMerci;
	}

	/**
	 * Restituisce il tipo di aereo
	 * @return the tipoAereo
	 * (POST: la variabile tipoAereo non viene modificata)
	 */
	public String getTipoAereo() {
		return tipoAereo;
	}

	/**
	 * Consente di settare il tipo di aereo
	 * (PRE: tipoAereo deve essere una stringa non vuota di lunghezza minore o uguale di 16)
	 * @param tipoAereo the tipoAereo to set
	 * (POST: il metodo getTipoAereo() restituisce tipoAereo)
	 */
	public void setTipoAereo(String tipoAereo) {
		this.tipoAereo = tipoAereo;
	}

	/**
	 * Restituisce il numero di passeggeri di un aereo
	 * @return nPass
	 * (POST: la variabile nPass non viene modificata)
	 */
	public int getnPass() {
		return nPass;
	}

	/**
	 * Consente di settare il numero massimo di passeggeri di un aereo
	 * (PRE: nPass deve essere int not null)
	 * @param nPass il massimo numero di passeggeri di un aereo
	 * (POST: il metodo getnPass() restituisce nPass)
	 */
	public void setnPass(int nPass) {
		this.nPass = nPass;
	}

	/**
	 * Restituisce la quantita merci trasportabile da un aereo
	 * @return the quantitaMerci
	 * (POST: la variabile nPass non viene modificata)
	 */
	public int getQuantitaMerci() {
		return quantitaMerci;
	}

	/**
	 * Consente di settare la quantitaMerci trasportabile da un un aereo
	 * (PRE: quantitaMerci deve essere int not null)
	 * @param quantitaMerci the quantitaMerci to set
	 * (POST: il metodo getnQuantitaMerci() restituisce quantitaMerci)
	 */
	public void setQuantitaMerci(int quantitaMerci) {
		this.quantitaMerci = quantitaMerci;
	}

	/**
	 * Override del metodo toString() 
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [tipoAereo=" + tipoAereo + ", nPass=" + nPass + ", quantitaMerci=" + quantitaMerci + "]";
	}

	/**
	 * Override hashCode() (auto-generated)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nPass;
		result = prime * result + quantitaMerci;
		result = prime * result + ((tipoAereo == null) ? 0 : tipoAereo.hashCode());
		return result;
	}

	/**
	 * Override equals() (auto-generated)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aereo other = (Aereo) obj;
		if (nPass != other.nPass)
			return false;
		if (quantitaMerci != other.quantitaMerci)
			return false;
		if (tipoAereo == null) {
			if (other.tipoAereo != null)
				return false;
		} else if (!tipoAereo.equals(other.tipoAereo))
			return false;
		return true;
	}

	
	/**
	 * Consente di effettuare un inserimento nella tabella aereo
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati per l'inserimento
	 * @param oggetto di tipo connection
	 * @return result intero che rappresento l'esito della query
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * la tabella aereo ha una riga in più 
	 */
	public int insert(DbOperations db, Connection connection) throws IllegalArgumentException, SQLException {
		
		int result = -1;
		Aereo aereo = null;
		String insertQuery = "";
		PreparedStatement preparedStmt = null;
		
		aereo = (Aereo) db;
		
		if(aereo.getTipoAereo().length() > LENGTH_TIPO_AEREO) {
			throw new IllegalArgumentException("Il tipo di aereo inserito non è valido");
		} else {
			this.setTipoAereo(aereo.getTipoAereo());
		}
		
		this.setnPass(aereo.getnPass());
		
		this.setQuantitaMerci(aereo.getQuantitaMerci());
		
		insertQuery = "insert into aereo (tipoAereo, nPass, quantitaMerci) values"
							+ "(?, ?, ?);";
		
		preparedStmt = connection.prepareStatement(insertQuery);
		
		preparedStmt.setString(1, aereo.getTipoAereo());
		preparedStmt.setInt(2, aereo.getnPass());
		preparedStmt.setInt(3, aereo.getQuantitaMerci());

		result = preparedStmt.executeUpdate();
		
		return result;

	}

	
	/**
	 * Consente di effettuare una select da tabella aereo
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati
	 * @param oggetto di tipo connection
	 * @return ResultSet che contiene le informazioni cercate
	 * @throws SQLException
	 * la tabella aereo non viene modificata 
	 */
	public ResultSet select(DbOperations db, Connection conn) throws SQLException {
		
		ResultSet result = null;
		PreparedStatement preparedStmt = null;
		String selectQuery = "";
		
		Aereo aereo = (Aereo) db;
		
		selectQuery = "Select * from aereo "
						+ "Where tipoAereo = ?;";
		
		
		preparedStmt = conn.prepareStatement(selectQuery);
		
		preparedStmt.setString(1, aereo.getTipoAereo());

		result = preparedStmt.executeQuery();
		
		return result;
	}

	/**
	 * Consente di effettuare un update nella tabella aereo
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati
	 * @param oggetto di tipo connection
	 * @return result che rappresenta l'esito della query
	 * @throws SQLException
	 * il numero di passeggeri nella riga corrispondente a tipoAereo viene modificato
	 */
	public int update(DbOperations db, Connection conn) throws SQLException {
		
		int result = -1;
		Aereo a = (Aereo) db;
		PreparedStatement preparedStmt = null;
		
		String updateQuery = "Update aereo "
				+ "Set nPass = ? "
				+ "where tipoAereo = ?;";
		
		
		preparedStmt = conn.prepareStatement(updateQuery);
		
		preparedStmt.setInt(1, a.getnPass());
		preparedStmt.setString(2, a.getTipoAereo());

		result = preparedStmt.executeUpdate();
		
		return result;
	}

	

}
