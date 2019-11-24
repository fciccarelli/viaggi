/**
 * 
 */
package com.uiip43.app;

import junit.framework.TestCase;

/**
 * @author pasop
 *
 */
public class AereoTest extends TestCase {
	
	Aereo aereo1 = new Aereo("jumbo 100", 100, 10);
	Aereo aereo2 = new Aereo("jumbo 100", 100, 10);
	Aereo aereo3 = new Aereo("jumbo 300", 300, 30);
	
	/**
	 * Test method for {@link com.uiip43.app.Aereo#hashCode()}.
	 */
	public void testHashCode() {
		assertEquals(aereo1.hashCode(), aereo2.hashCode());
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#getTipoAereo()}.
	 */
	public void testGetTipoAereo() {
		assertEquals("jumbo 100", aereo1.getTipoAereo());
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#setTipoAereo(java.lang.String)}.
	 */
	public void testSetTipoAereo() {
		aereo3.setTipoAereo("jumbo 3000");
		assertEquals("jumbo 3000", aereo3.getTipoAereo());
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#getnPass()}.
	 */
	public void testGetnPass() {
		assertEquals(100, aereo1.getnPass());
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#setnPass(int)}.
	 */
	public void testSetnPass() {
		aereo3.setnPass(500);
		assertEquals(aereo3.getnPass(), 500);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#getQuantitaMerci()}.
	 */
	public void testGetQuantitaMerci() {
		assertEquals(aereo1.getQuantitaMerci(), 10);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#setQuantitaMerci(int)}.
	 */
	public void testSetQuantitaMerci() {
		aereo3.setQuantitaMerci(50);
		assertEquals(aereo3.getQuantitaMerci(), 50);
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#toString()}.
	 */
	public void testToString() {
		assertEquals(aereo1.toString(), "Aereo [tipoAereo=" + aereo1.getTipoAereo() + ", nPass=" + aereo1.getnPass() + ", quantitaMerci=" + aereo1.getQuantitaMerci() + "]");
	}

	/**
	 * Test method for {@link com.uiip43.app.Aereo#equals(java.lang.Object)}.
	 */
	public void testEqualsObject() {
		assertEquals(aereo1, aereo2);
	}

}
