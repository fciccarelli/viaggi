/**
 * 
 */
package com.uiip43.app.entities;

/**
 * @author fabiosessa
 *
 */
public class Aereo {
	private String tipoAereo;
	private int nPass;
	private int quantitaMerci;

	/**
	 * default constructor
	 */
	public Aereo() {
		// TODO Auto-generated constructor stub
	}

	public String getTipoAereo() {
		return tipoAereo;
	}

	public void setTipoAereo(String tipoAereo) {
		this.tipoAereo = tipoAereo;
	}

	public int getNpass() {
		return nPass;
	}

	public void setNpass(int npass) {
		nPass = npass;
	}

	public int getQuantitaMerci() {
		return quantitaMerci;
	}

	public void setQuantitaMerci(int quantitaMerci) {
		this.quantitaMerci = quantitaMerci;
	}

}
