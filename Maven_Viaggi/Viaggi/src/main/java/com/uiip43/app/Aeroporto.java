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
 * Classe che modella un aeroporto
 */
public class Aeroporto implements DbOperations {

	private String id;
	private String citta;
	private String nazione;
	private int nPiste;
	public static final int LENGTH_ID_AEROPORTO = 4;
	public static final int LENGTH_CITTA = 64;
	public static final int LENGTH_NAZIONE = 64;
	
	
	/**
	 * Costruttore vuoto
	 */
	public Aeroporto() {
		this("","","",0);
	}
	
	/**
	 * Costruttore che inizializza un aeroporto
	 * @param id rappresenta lìid di un aeroporto
	 * @param citta rappresenta la città in cui è presente l'aeroporto
	 * @param nazione rappresenta la nazione in cui è presente l'aeroporto
	 * @param nPiste rappresenta il numero di piste dell'aeroporto
	 */
	public Aeroporto(String id, String citta, String nazione, int nPiste) {
		this.id = id;
		this.citta = citta;
		this.nazione = nazione;
		this.nPiste = nPiste;
	}

	/**
	 * Restituisce l'id dell'aeroporto
	 * @return the id
	 * (POST: la variabile id non viene modificata)
	 */
	public String getId() {
		return id;
	}

	/**
	 * Consente di settare l'Id di un aeroporto
	 * (PRE: id deve essere una stringa non vuota di lunghezza minore o uguale di 4)
	 * @param id l'id da settare
	 * (POST: il metodo getId() restituisce id)
	 */	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Restituisce la citta dell'aeroporto
	 * @return the citta
	 * (POST: la variabile citta non viene modificata)
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * Consente di settare la città di un aeroporto
	 * (PRE: citta deve essere una stringa non vuota di lunghezza minore o uguale di 64)
	 * @param citta la citta da settare
	 * (POST: il metodo getCitta() restituisce citta)
	 */	
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * Restituisce la nazione dell'aeroporto
	 * @return the nazione
	 * (POST: la variabile nazione non viene modificata)
	 */
	public String getNazione() {
		return nazione;
	}

	/**
	 * Consente di settare la nazione di un aeroporto
	 * (PRE: nazione deve essere una stringa non vuota di lunghezza minore o uguale di 64)
	 * @param nazione la nazione da settare
	 * (POST: il metodo getNazione() restituisce nazione)
	 */	
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	/**
	 * Restituisce il numero di piste dell'aeroporto
	 * @return the nPiste
	 * (POST: la variabile nPiste  non viene modificata)
	 */
	public int getnPiste() {
		return nPiste;
	}

	/**
	 * Consente di settare il numero di piste di un aeroporto
	 * (PRE: nPiste deve essere una int not null)
	 * @param nPiste il numero di piste da settare
	 * (POST: il metodo getnPiste() restituisce nPiste)
	 */	
	public void setnPiste(int nPiste) {
		this.nPiste = nPiste;
	}

	/**
	 * Override metodo toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", citta=" + citta + ", nazione=" + nazione + ", nPiste=" + nPiste + "]";
	}

	/**
	 * Override del metodo hashCode() (auto-generated)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((citta == null) ? 0 : citta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + nPiste;
		result = prime * result + ((nazione == null) ? 0 : nazione.hashCode());
		return result;
	}

	/**
	 * Override del metodo equals() (auto-generated)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeroporto other = (Aeroporto) obj;
		if (citta == null) {
			if (other.citta != null)
				return false;
		} else if (!citta.equals(other.citta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nPiste != other.nPiste)
			return false;
		if (nazione == null) {
			if (other.nazione != null)
				return false;
		} else if (!nazione.equals(other.nazione))
			return false;
		return true;
	}
	
	/**
	 * Consente di effettuare un inserimento nella tabella aeroporto
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati per l'inserimento
	 * @param oggetto di tipo connection
	 * @return result intero che rappresento l'esito della query
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * la tabella aeroporto ha una riga in più 
	 */
	public int insert(DbOperations db, Connection connection) throws IllegalArgumentException, SQLException {
		
		int result = -1;
		Aeroporto aeroporto = null;
		String insertQuery = "";
		PreparedStatement preparedStmt = null;
		
		aeroporto = (Aeroporto) db;
		
		if(aeroporto.getId().length() > LENGTH_ID_AEROPORTO) {
			throw new IllegalArgumentException("L'Id inserito non è valido.");
		} else {
			this.setId(aeroporto.getId());
		}
		
		if(aeroporto.getCitta().length() > LENGTH_CITTA) {
			throw new IllegalArgumentException("La città inserita ha un nome troppo lungo.");
		} else {
			this.setCitta(aeroporto.getCitta());
		}
		
		if(aeroporto.getNazione().length() > LENGTH_NAZIONE) {
			throw new IllegalArgumentException("La nazione inserita ha un nome troppo lungo.");
		} else {
			this.setCitta(aeroporto.getNazione());
		}
		
		this.setnPiste(aeroporto.getnPiste());
		
		insertQuery = "insert into aeroporto (id, citta, nazione, nPiste) values"
							+ "(?, ?, ?, ?);";
		
		preparedStmt = connection.prepareStatement(insertQuery);
		
		preparedStmt.setString(1, aeroporto.getId());
		preparedStmt.setString(2, aeroporto.getCitta());
		preparedStmt.setString(3, aeroporto.getNazione());
		preparedStmt.setInt(4, aeroporto.getnPiste());

		result = preparedStmt.executeUpdate();
		
		return result;

	}

	
	/**
	 * Consente di effettuare una select da tabella aeroporto
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati
	 * @param oggetto di tipo connection
	 * @return ResultSet che contiene le informazioni cercate
	 * @throws SQLException
	 * la tabella aeroporto non viene modificata 
	 */
	public ResultSet select(DbOperations db, Connection conn) throws SQLException {
		
		ResultSet result = null;
		PreparedStatement preparedStmt = null;
		String selectQuery = "";
		
		Aeroporto aeroporto = (Aeroporto) db;
		
		selectQuery = "Select * from aeroporto "
						+ "Where id = ?;";
		
		
		preparedStmt = conn.prepareStatement(selectQuery);
		
		preparedStmt.setString(1, aeroporto.getId());

		result = preparedStmt.executeQuery();
		
		return result;
	}

	/**
	 * Consente di effettuare un update nella tabella aeroporto
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati
	 * @param oggetto di tipo connection
	 * @return result che rappresenta l'esito della query
	 * @throws SQLException
	 * il numero di piste nella riga corrispondente all'Id aeroporto viene modificato
	 */
	public int update(DbOperations db, Connection conn) throws SQLException {
		
		int result = -1;
		Aeroporto aeroporto = (Aeroporto) db;
		PreparedStatement preparedStmt = null;
		
		String updateQuery = "Update aeroporto "
				+ "Set nPiste = ? "
				+ "where id = ?;";
		
		
		preparedStmt = conn.prepareStatement(updateQuery);
		
		preparedStmt.setInt(1, aeroporto.getnPiste());
		preparedStmt.setString(2, aeroporto.getId());

		result = preparedStmt.executeUpdate();
		
		return result;
	}

	
	
}
