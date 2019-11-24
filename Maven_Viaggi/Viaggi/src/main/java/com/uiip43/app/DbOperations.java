/**
 * 
 */
package com.uiip43.app;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author pasop
 * Inerfaccia operazioni su database
 */
public interface DbOperations {
	
	/**
	 * Consente di inserire un elemento in un database
	 * @param db parametro da inserire
	 * @throws SQLException 
	 * @throws IllegalArgumentException 
	 */
	public int insert(DbOperations db, Connection conn) throws IllegalArgumentException, SQLException;
	
	/**
	 * 	 * Consente di prelevare informazioni dal database
	 * @param db
	 * @param conn
	 * @param selectQuery
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(DbOperations db, Connection conn) throws SQLException;
	
	/**
	 * Consente di modificare un campo nel database
	 * @param db campo da modificare
	 * @throws SQLException 
	 */
	public int update(DbOperations db, Connection conn) throws SQLException;
	
	
	
}
