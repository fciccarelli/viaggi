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
 * Classe che modella un volo
 */
public class Volo implements DbOperations {

	private int idVolo;
	private String giornoSett;
	private String aeroportoPart;
	private String aeroportoArr;
	private String tipoAereo;
	private String oraPartenza;
	private String oraArrivo;
	public static final int LENGTH_GIORNO_SETT = 16;
	public static final int LENGTH_AEROPORTO_PART = 4;
	public static final int LENGTH_AEROPORTO_ARR = 4;
	public static final int LENGTH_TIPO_AEREO = 16;
	public static final int LENGTH_ORARIO = 8;

	public Volo() {
		this(0,"","","","","","");
	}
	
	public Volo(int idVolo, String giornSett, String aeroportoPart, String aeroportoArr, String tipoAereo, String oraPartenza, String oraArrivo) {
		this.idVolo = idVolo;
		this.giornoSett = giornSett;
		this.aeroportoPart = aeroportoPart;
		this.aeroportoArr = aeroportoArr;
		this.tipoAereo = tipoAereo;
		this.oraPartenza = oraPartenza;
		this.aeroportoArr = oraArrivo;
	}

	/**
	 * Restituisce l'id del volo
	 * @return the idVolo
	 * (POST: la variabile idVolo non viene modificata)
	 */
	public int getIdVolo() {
		return idVolo;
	}

	/**
	 * Consente di settare l'id di un volo
	 * (PRE: isVolo deve essere intero)
	 * @param isVolo rappresenta l'id di un volo
	 * (POST: il metodo getIdVolo() restituisce idVolo)
	 */	
	public void setIdVolo(int idVolo) {
		this.idVolo = idVolo;
	}

	/**
	 * Restituisce il giorno di progrmmazione di un volo
	 * @return the giornoSett
	 * (POST: la variabile giornoSett non viene modificata)
	 */
	public String getGiornoSett() {
		return giornoSett;
	}

	/**
	 * Consente di settare giornoSett di un volo
	 * (PRE: giornoSett deve essere una stringa non vuota di lunghezza minore o uguale di 16)
	 * @param giornoSett the il giorno della settimana da settare
	 * (POST: il metodo getGiornoSett() restituisce giornoSett)
	 */	
	public void setGiornoSett(String giornoSett) {
		this.giornoSett = giornoSett;
	}

	/**
	 * Restituisce il l'aeroporto di partenza di un volo
	 * @return the aeroportoPart
	 * (POST: la variabile aeroportoPart non viene modificata)
	 */
	public String getAeroportoPart() {
		return aeroportoPart;
	}

	/**
	 * Consente di settare l'aeroporto di partenza di un volo
	 * (PRE: aeroportoPart deve essere una stringa non vuota di lunghezza minore o uguale di 4)
	 * @param aeroportoPart l'aeroporto di partenza da settare
	 * (POST: il metodo getAeroportoPart() restituisce aeroportoPart)
	 */	
	public void setAeroportoPart(String aeroportoPart) {
		this.aeroportoPart = aeroportoPart;
	}

	/**
	 * Restituisce il l'aeroporto di arrivo di un volo
	 * @return the aeroportoArr
	 * (POST: la variabile aeroportoArr non viene modificata)
	 */
	public String getAeroportoArr() {
		return aeroportoArr;
	}

	/**
	 * Consente di settare l'aeroporto di arrivo di un volo
	 * (PRE: aeroportoArr deve essere una stringa non vuota di lunghezza minore o uguale di 4)
	 * @param aeroportoArr è l' aeroporto di arrivo da settare
	 * (POST: il metodo getAeroportoArr() restituisce aeroportoArr)
	 */	
	public void setAeroportoArr(String aeroportoArr) {
		this.aeroportoArr = aeroportoArr;
	}

	/**
	 * Restituisce il tipo di aereo usato in un volo
	 * @return the tipoAereo
	 * (POST: la variabile tipoAereo non viene modificata)
	 */
	public String getTipoAereo() {
		return tipoAereo;
	}

	/**
	 * Consente di settare il tipo di aereo usato in un volo
	 * (PRE: tipoAereo deve essere una stringa non vuota di lunghezza minore o uguale di 16)
	 * @param tipoAereo è il tipo di aereo da settare
	 * (POST: il metodo getTipoAereo() restituisce tipoAereo)
	 */	
	public void setTipoAereo(String tipoAereo) {
		this.tipoAereo = tipoAereo;
	}

	/**
	 * Restituisce l'ora di partenza in un volo
	 * @return the oraPartenza
	 * (POST: la variabile oraPartenza non viene modificata)
	 */
	public String getOraPartenza() {
		return oraPartenza;
	}

	/**
	 * Consente di settare l'ora di partenza in un volo
	 * (PRE: oraPartenza deve essere una stringa non vuota di lunghezza minore o uguale di 16)
	 * @param oraPartenza è l'ora di partenza da settare
	 * (POST: il metodo setOraPartenza() restituisce oraPartenza)
	 */	
	public void setOraPartenza(String oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	/**
	 * Restituisce l'ora di arrivo in un volo
	 * @return the oraArrivo
	 * (POST: la variabile oraArrivo non viene modificata)
	 */
	public String getOraArrivo() {
		return oraArrivo;
	}

	/**
	 * Consente di settare l'ora di arrivo in un volo
	 * (PRE: oraArrivo deve essere una stringa non vuota di lunghezza minore o uguale di 16)
	 * @param oraArrivo è l'ora di arrivo da settare
	 * (POST: il metodo setOraArrivo() restituisce oraArrivo)
	 */	
	public void setOraArrivo(String oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

	/**
	 * Override del metodo toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [idVolo=" + idVolo + ", giornoSett=" + giornoSett + ", aeroportoPart=" + aeroportoPart
				+ ", aeroportoArr=" + aeroportoArr + ", tipoAereo=" + tipoAereo + ", oraPartenza=" + oraPartenza
				+ ", oraArrivo=" + oraArrivo + "]";
	}

	/**
	 * Override del metodo hashCode() (auto-generated)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroportoArr == null) ? 0 : aeroportoArr.hashCode());
		result = prime * result + ((aeroportoPart == null) ? 0 : aeroportoPart.hashCode());
		result = prime * result + ((giornoSett == null) ? 0 : giornoSett.hashCode());
		result = prime * result + idVolo;
		result = prime * result + ((oraArrivo == null) ? 0 : oraArrivo.hashCode());
		result = prime * result + ((oraPartenza == null) ? 0 : oraPartenza.hashCode());
		result = prime * result + ((tipoAereo == null) ? 0 : tipoAereo.hashCode());
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
		Volo other = (Volo) obj;
		if (aeroportoArr == null) {
			if (other.aeroportoArr != null)
				return false;
		} else if (!aeroportoArr.equals(other.aeroportoArr))
			return false;
		if (aeroportoPart == null) {
			if (other.aeroportoPart != null)
				return false;
		} else if (!aeroportoPart.equals(other.aeroportoPart))
			return false;
		if (giornoSett == null) {
			if (other.giornoSett != null)
				return false;
		} else if (!giornoSett.equals(other.giornoSett))
			return false;
		if (idVolo != other.idVolo)
			return false;
		if (oraArrivo == null) {
			if (other.oraArrivo != null)
				return false;
		} else if (!oraArrivo.equals(other.oraArrivo))
			return false;
		if (oraPartenza == null) {
			if (other.oraPartenza != null)
				return false;
		} else if (!oraPartenza.equals(other.oraPartenza))
			return false;
		if (tipoAereo == null) {
			if (other.tipoAereo != null)
				return false;
		} else if (!tipoAereo.equals(other.tipoAereo))
			return false;
		return true;
	}
	
	/**
	 * Consente di effettuare un inserimento nella tabella volo
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati per l'inserimento
	 * @param oggetto di tipo connection
	 * @return result intero che rappresento l'esito della query
	 * @throws IllegalArgumentException
	 * @throws SQLException
	 * la tabella volo ha una riga in più 
	 */
	public int insert(DbOperations db, Connection connection) throws IllegalArgumentException, SQLException {
		
		int result = -1;
		Volo volo = null;
		String insertQuery = "";
		PreparedStatement preparedStmt = null;
		
		volo = (Volo) db;
		
		if(volo.getGiornoSett().length()> LENGTH_GIORNO_SETT) {
			throw new IllegalArgumentException("Il giorno settimana inserito non è valido.");
		} else {
			this.setGiornoSett(volo.getGiornoSett());
		}
		
		if(volo.getAeroportoPart().length() > LENGTH_AEROPORTO_PART) {
			throw new IllegalArgumentException("L'aeroporto di partenza inserito non è valido.");
		} else {
			this.setAeroportoPart(volo.getAeroportoPart());
		}
		
		if(volo.getAeroportoArr().length() > LENGTH_AEROPORTO_ARR) {
			throw new IllegalArgumentException("L'aeroporto di arrivo inserito non è valido.");
		} else {
			this.setAeroportoArr(volo.getAeroportoArr());
		}
		
		if(volo.getTipoAereo().length() > LENGTH_TIPO_AEREO) {
			throw new IllegalArgumentException("Il tipo di aereo inserito non è valido.");
		} else {
			this.setTipoAereo(volo.getTipoAereo());
		}
		
		this.setOraPartenza(volo.getOraPartenza());
		
		this.setOraArrivo(volo.getOraArrivo());
		
		insertQuery = "insert into volo (giornoSett, aeroportoPart, aeroportoArr, tipoAereo, oraPartenza, oraArrivo) values"
							+ "(?, ?, ?, ?, ?, ?);";
		
		preparedStmt = connection.prepareStatement(insertQuery);
		
		preparedStmt.setString(1, volo.getGiornoSett());
		preparedStmt.setString(2, volo.getAeroportoPart());
		preparedStmt.setString(3, volo.getAeroportoArr());
		preparedStmt.setString(4, volo.getTipoAereo());
		preparedStmt.setString(5, volo.getOraPartenza());
		preparedStmt.setString(6, volo.getOraArrivo());

		result = preparedStmt.executeUpdate();
		
		return result;

	}

	
	/**
	 * Consente di effettuare una select da tabella volo
	 * @param db oggetto tipo interfaccia che consente di prelevare i dati
	 * @param oggetto di tipo connection
	 * @return ResultSet che contiene le informazioni cercate
	 * @throws SQLException
	 * la tabella volo non viene modificata 
	 */
	public ResultSet select(DbOperations db, Connection conn) throws SQLException {
		
		ResultSet result = null;
		PreparedStatement preparedStmt = null;
		String selectQuery = "";
		
		Volo volo = (Volo) db;
		
		selectQuery = "Select * from volo "
						+ "Where idVolo = ?;";
		
		
		preparedStmt = conn.prepareStatement(selectQuery);
		
		preparedStmt.setInt(1, volo.getIdVolo());

		result = preparedStmt.executeQuery();
		
		return result;
	}

	public int update(DbOperations db, Connection conn) throws SQLException {
		return 0;
	}
	
}
