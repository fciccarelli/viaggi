/**
 * 
 */
package com.uiip43.app;

import junit.framework.TestCase;

/**
 * @author pasop
 *
 */
public class VoloTest extends TestCase {

	Volo volo1 = new Volo(1, "lunedì", "FCO", "AMS", "Jumbo 1000", "10:00:00", "11:30:00");
	Volo volo2 = new Volo(1, "lunedì", "FCO", "AMS", "Jumbo 1000", "10:00:00", "11:30:00");
	Volo volo3 = new Volo(5, "Giovedì", "NAP", "CPH", "Jumbo 300", "10:00:00", "12:00:00");
	
	
	/**
	 * Test method for {@link com.uiip43.app.Volo#hashCode()}.
	 */
	public void testHashCode() {
		assertEquals(volo1, volo2);
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getIdVolo()}.
	 */
	public void testGetIdVolo() {
		assertEquals(volo1.getIdVolo(), 1);
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setIdVolo(int)}.
	 */
	public void testSetIdVolo() {
		volo3.setIdVolo(10);
		assertEquals(volo3.getIdVolo(), 10);
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getGiornoSett()}.
	 */
	public void testGetGiornoSett() {
		assertEquals(volo1.getGiornoSett(), "lunedì");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setGiornoSett(java.lang.String)}.
	 */
	public void testSetGiornoSett() {
		volo3.setGiornoSett("domenica");
		assertEquals(volo3.getGiornoSett(), "domenica");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getAeroportoPart()}.
	 */
	public void testGetAeroportoPart() {
		assertEquals(volo1.getAeroportoPart(), "FCO");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setAeroportoPart(java.lang.String)}.
	 */
	public void testSetAeroportoPart() {
		volo3.setAeroportoPart("Nap");
		assertEquals(volo3.getAeroportoPart(), "Nap");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getAeroportoArr()}.
	 */
	public void testGetAeroportoArr() {
		assertEquals(volo1.getAeroportoArr(), "AMS");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setAeroportoArr(java.lang.String)}.
	 */
	public void testSetAeroportoArr() {
		volo3.setAeroportoArr("MOW");
		assertEquals(volo3.getAeroportoArr(), "MOW");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getTipoAereo()}.
	 */
	public void testGetTipoAereo() {
		assertEquals(volo1.getTipoAereo(), "Jumbo 1000");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setTipoAereo(java.lang.String)}.
	 */
	public void testSetTipoAereo() {
		volo3.setTipoAereo("Jumbo 120");
		assertEquals(volo3.getTipoAereo(), "Jumbo 120");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getOraPartenza()}.
	 */
	public void testGetOraPartenza() {
		assertEquals(volo1.getOraPartenza(), "10:00:00");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setOraPartenza(java.lang.String)}.
	 */
	public void testSetOraPartenza() {
		volo3.setOraPartenza("09:00:00");
		assertEquals(volo3.getOraPartenza(), "09:00:00");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#getOraArrivo()}.
	 */
	public void testGetOraArrivo() {
		assertEquals(volo1.getOraArrivo(), "11:30:00");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#setOraArrivo(java.lang.String)}.
	 */
	public void testSetOraArrivo() {
		volo3.setOraArrivo("11:45:00");
		assertEquals(volo3.getOraArrivo(), "11:45:00");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#toString()}.
	 */
	public void testToString() {
		assertEquals(volo1.toString(), "Volo [idVolo=" + volo1.getIdVolo() + ", giornoSett=" + volo1.getGiornoSett() + ", aeroportoPart=" + volo1.getAeroportoPart()
				+ ", aeroportoArr=" + volo1.getAeroportoArr() + ", tipoAereo=" + volo1.getTipoAereo() + ", oraPartenza=" + volo1.getOraPartenza()
				+ ", oraArrivo=" + volo1.getOraArrivo() + "]");
	}

	/**
	 * Test method for {@link com.uiip43.app.Volo#equals(java.lang.Object)}.
	 */
	public void testEqualsObject() {
		assertEquals(volo1, volo2);
	}

}
