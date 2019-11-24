/**
 * 
 */
package com.uiip43.app;

import junit.framework.TestCase;

/**
 * @author pasop
 *
 */
public class AeroportoTest extends TestCase {
	
	Aeroporto aeroporto1 = new Aeroporto("NAP", "Napoli", "Italia", 15);
	Aeroporto aeroporto2 = new Aeroporto("NAP", "Napoli", "Italia", 15);
	Aeroporto aeroporto3 = new Aeroporto("FCO", "Roma", "Italia", 25);
	
	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#hashCode()}.
	 */
	public void testHashCode() {
		assertEquals(aeroporto1, aeroporto2);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#getId()}.
	 */
	public void testGetId() {
		assertEquals(aeroporto1.getId(), "NAP");;
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#setId(java.lang.String)}.
	 */
	public void testSetId() {
		aeroporto3.setId("MIL");
		assertEquals(aeroporto3.getId(), "MIL");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#getCitta()}.
	 */
	public void testGetCitta() {
		assertEquals(aeroporto1.getCitta(), "Napoli");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#setCitta(java.lang.String)}.
	 */
	public void testSetCitta() {
		aeroporto3.setCitta("Milano");
		assertEquals(aeroporto3.getCitta(), "Milano");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#getNazione()}.
	 */
	public void testGetNazione() {
		assertEquals(aeroporto1.getNazione(), "Italia");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#setNazione(java.lang.String)}.
	 */
	public void testSetNazione() {
		aeroporto3.setNazione("Olanda");
		assertEquals(aeroporto3.getNazione(), "Olanda");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#getnPiste()}.
	 */
	public void testGetnPiste() {
		assertEquals(aeroporto1.getnPiste(), 15);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#setnPiste(int)}.
	 */
	public void testSetnPiste() {
		aeroporto3.setnPiste(100);
		assertEquals(aeroporto3.getnPiste(), 100);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#toString()}.
	 */
	public void testToString() {
		assertEquals(aeroporto1.toString(), "Aeroporto [id=" + aeroporto1.getId() + ", citta=" + aeroporto1.getCitta() + ", nazione=" + aeroporto1.getNazione() + ", nPiste=" + aeroporto1.getnPiste() + "]");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aeroporto#equals(java.lang.Object)}.
	 */
	public void testEqualsObject() {
		assertEquals(aeroporto1, aeroporto2);
	}

}
