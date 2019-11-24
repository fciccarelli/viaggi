package com.mycompany.app;

import java.sql.*;

public class Aeroporto {
	static {
		try {
			// caricamento e registrazione driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString);
			PreparedStatement prepared = connection.prepareStatement("insert into aeroporto (id, citta, nazione, npiste) values (?,?,?,?)");
			prepared.setString(1, "OTP");
			prepared.setString(2, "Bucarest");
			prepared.setString(3, "Romania");
			prepared.setInt(4, 5);
			prepared.executeUpdate();
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery("SELECT*FROM aeroporto WHERE ID = 'AMS'");
			// aggiorna il database viaggi 
			System.out.println("\n\nUpdate the database viaggi ");
			stm = connection.createStatement();
			int rowsUpdated = stm.executeUpdate("UPDATE aeroporto SET npiste = 21 WHERE ID = 'JFK'");
			System.out.print("Changed "+rowsUpdated);
			if (1 == rowsUpdated)
			System.out.println(" row.");
			else
			System.out.println(" rows.");
			ResultSet rs_all = stm.executeQuery("Select*from aeroporto");
			
			System.out.println("Visualizza tutti gli aeroporti, controlla il volo aggiunto ed il set npiste da 20 a 21");
			while (rs_all.next()) {
				System.out.println(rs_all.getString("id") + " " + rs_all.getString("citta") + " " + rs_all.getString("nazione")+ " "+rs_all.getInt("npiste"));
			}
			System.out.println("La query:");
			while (rs.next()) {
				System.out.println(rs.getString("id") + " " + rs.getString("citta") + " " + rs.getString("nazione")+ " "+rs.getInt("npiste"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// gestione errore in chiusura
			}
		}
	}
	
}
//('AMS', 'Amsterdam', 'Olanda', 12),
//('NAP', 'Napoli', 'Italia', 22),
//('FCO', 'Roma', 'Italia', 10),
//('JFK', 'New York', 'Stati Uniti', 20),
//('CDG', 'Parigi', 'Francia', 15),
//('BCN', 'Barcellona', 'Spagna', 11),
//('SXF', 'Berlino', 'Germania', 13),
//('CPH', 'Copenaghen', 'Danimarca', 15),
//('IST', 'Instanbul', 'Turchia', 8),
//('MOW', 'Mosca', 'Russia', 10),
//('HND', 'Tokyo', 'Giappone', 14),
//('AHO', 'Alghero', 'Italia',12),
//('AOI', 'Ancona', 'Italia',5),
//('BRI', 'Bari','Italia',6),
//('BGY', 'Bergamo', 'Italia',7),
//('BLQ', 'Bologna', 'Italia',6),
//('BZO', 'Bolzano', 'Italia',8),
//('VBS', 'Brescia', 'Italia',4),
//('BDS', 'Brindisi', 'Italia',6),
//('CTA', 'Catania', 'Italia',7),
//('CAG', 'Cagliari' , 'Italia',5),
//('CRV', 'Crotone', 'Italia',6),
//('CUF', 'Cuneo', 'Italia',4),
//('FLR', 'Firenze', 'Italia',5),
//('FOG', 'Foggia', 'Italia',7),
//('FRL', 'Forlì', 'Italia',2),
//('GOA', 'Genova', 'Italia',9),
//('GRS', 'Grosseto', 'Italia',2),
//('SUF', 'Lamezia', 'Italia',5),
//('MXP', 'Milano', 'Italia',7),
//('LIN', 'Milano', 'Italia',4),
//('OLB', 'Olbia', 'Italia',8),
//('QPA', 'Padova', 'Italia',4),
//('PMO', 'Palermo', 'Italia',4),
//('PMF', 'Parma', 'Italia',6),
//('PEG', 'Perugia', 'Italia',4),
//('PSR', 'Pescara', 'Italia',5),
//('PSA', 'Pisa', 'Italia',6),
//('REG', 'Reggio Calabria', 'Italia',8),
//('RMI', 'Rimini', 'Italia',3),
//('CIA', 'Roma', 'Italia',2),
//('TAR', 'Taranto', 'Italia',8),
//('TRN', 'Torino', 'Italia',9),
//('TPS', 'Trapani', 'Italia',3),
//('ZIA', 'Trento', 'Italia',4),
//('TSF', 'Treviso', 'Italia',5),
//('TRS', 'Trieste', 'Italia',6),
//('VCE', 'Venezia', 'Italia',7),
//('VRN', 'Verona', 'Italia',4),
//('VIC', 'Vicenza', 'Italia',3)