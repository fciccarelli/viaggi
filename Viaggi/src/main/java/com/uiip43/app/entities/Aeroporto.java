/**
 * 
 */
package com.uiip43.app.entities;

/**
 * @author fabiosessa
 *
 */
public class Aeroporto {
	private String id;
	private String citta;
	private String nazione;
	private int nPiste;

	/**
	 * default constructor
	 */
	public Aeroporto() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	public int getnPiste() {
		return nPiste;
	}

	public void setnPiste(int nPiste) {
		this.nPiste = nPiste;
	}

}
