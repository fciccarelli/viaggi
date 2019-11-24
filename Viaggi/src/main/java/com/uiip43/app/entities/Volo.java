/**
 * 
 */
package com.uiip43.app.entities;

import java.sql.Time;

/**
 * @author fabiosessa
 *
 */
public class Volo {
	private int idVolo;
	private String giorniSett;
	private String nazione;
	private String aeroportoPart;
	private String aeroportoArr;
	private String tipoAereo;
	private Time oraPartenza;
	private Time oraArrivo;

	/**
	 * default constructor
	 */
	public Volo() {
		// TODO Auto-generated constructor stub
	}

	public int getIdVolo() {
		return idVolo;
	}

	public void setIdVolo(int idVolo) {
		this.idVolo = idVolo;
	}

	public String getGiorniSett() {
		return giorniSett;
	}

	public void setGiorniSett(String giorniSett) {
		this.giorniSett = giorniSett;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public String getAeroportoPart() {
		return aeroportoPart;
	}

	public void setAeroportoPart(String aeroportoPart) {
		this.aeroportoPart = aeroportoPart;
	}

	public String getAeroportoArr() {
		return aeroportoArr;
	}

	public void setAeroportoArr(String aeroportoArr) {
		this.aeroportoArr = aeroportoArr;
	}

	public String getTipoAereo() {
		return tipoAereo;
	}

	public void setTipoAereo(String tipoAereo) {
		this.tipoAereo = tipoAereo;
	}

	public Time getOraPartenza() {
		return oraPartenza;
	}

	public void setOraPartenza(Time oraPartenza) {
		this.oraPartenza = oraPartenza;
	}

	public Time getOraArrivo() {
		return oraArrivo;
	}

	public void setOraArrivo(Time oraArrivo) {
		this.oraArrivo = oraArrivo;
	}

}
