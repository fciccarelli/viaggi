package com.mycompany.app;

import java.sql.*;

public class Volo {
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
			//insert
			PreparedStatement prepared = connection.prepareStatement("insert into volo (giornoSett, aeroportoPart, aeroportoArr, tipoAereo, oraPartenza, oraArrivo) values (?,?,?,?,?,?)");
			prepared.setString(1, "martedi");
			prepared.setString(2, "BRU");
			prepared.setString(3, "AMS");
			prepared.setString(4, "Boeing 747-400");
			prepared.setString(5, "01:00:00");
			prepared.setString(6,"04:08:00");
			prepared.executeUpdate();
			Statement stm = connection.createStatement();
			ResultSet rs_insert = stm.executeQuery("select *from volo");
			System.out.println("Controlla: è stato aggiunto l'ultimo volo!");
			while (rs_insert.next()) {	
				System.out.println(rs_insert.getString("giornoSett") + " " + rs_insert.getString("aeroportoPart") + " " + rs_insert.getString("aeroportoArr")+" "+rs_insert.getString("tipoAereo")+ " " + rs_insert.getString("oraPartenza")+ " " +rs_insert.getString("oraArrivo"));
			}
			
			// query richiesta
			ResultSet rs = stm.executeQuery("select *from volo where idVolo = 1");
			
			while (rs.next()) {
				System.out.println("La query: "+rs.getString("giornoSett") + " " + rs.getString("aeroportoPart") + " " + rs.getString("aeroportoArr")+" "+rs.getString("tipoAereo")+ " " + rs.getString("oraPartenza")+ " " +rs.getString("oraArrivo"));
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
//Voli di partenza:
//('Lunedì', 'MOW', 'HND', 'Boeing 747-400', '18:25:00', '04:00:00'),
//('Martedì', 'MOW', 'HND', 'Boeing 747-400', '18:25:00', '04:00:00'),
//('Mercoledì', 'MOW', 'HND', 'Boeing 747-400', '08:25:00', '18:00:00'),
//('Giovedì', 'MOW', 'HND', 'Boeing 747-8', '06:35:00', '16:10:00'),
//('Venerdì', 'MOW', 'HND', 'Boeing 747-8', '06:35:00', '16:10:00'),
//('Sabato', 'MOW', 'HND', 'Boeing 777-300', '12:25:00', '22:00:00'),
//('Domenica', 'MOW', 'HND', 'Boeing 777-300', '12:25:00', '22:00:00'),
//('Lunedì', 'HND', 'MOW', 'Boeing 747-400', '18:25:00', '04:00:00'),
//('Martedì', 'HND', 'MOW', 'Boeing 747-400', '18:25:00', '04:00:00'),
//('Mercoledì', 'HND', 'MOW', 'Boeing 747-400', '08:25:00', '18:00:00'),
//('Giovedì', 'HND', 'MOW', 'Boeing 747-8', '06:35:00', '16:10:00'),
//('Venerdì', 'HND', 'MOW', 'Boeing 747-8', '06:35:00', '16:10:00'),
//('Sabato', 'HND', 'MOW', 'Boeing 777-300', '12:25:00', '22:00:00'),
//('Domenica', 'HND', 'MOW', 'Boeing 777-300', '12:25:00', '22:00:00'),
//('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '10:30:00', '13:05:00'),
//('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '07:20:00', '09:45:00'),
//('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '16:30:00', '18:50:00'),
//('lunedì', 'FCO', 'AMS', 'Airbus A340-300', '14:35:00', '19:45:00'),
//('martedì', 'FCO', 'AMS', 'Airbus A340-500', '07:20:00', '09:45:00'),
//('martedì', 'FCO', 'AMS', 'Airbus A340-500', '16:30:00', '18:50:00'),
//('martedì', 'FCO', 'AMS', 'Airbus A340-500', '14:35:00', '19:45:00'),
//('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '10:30:00', '13:05:00'),
//('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '16:30:00', '18:50:00'),
//('mercoledì', 'FCO', 'AMS', 'Airbus A340-600', '14:35:00', '19:45:00'),
//('giovedì', 'FCO', 'AMS', 'Airbus A340-300', '16:30:00', '18:50:00'),
//('giovedì', 'FCO', 'AMS', 'Airbus A340-300', '14:35:00', '19:45:00'),
//('venerdì', 'FCO', 'AMS', 'Airbus A340-500', '10:30:00', '13:05:00'),
//('venerdì', 'FCO', 'AMS', 'Airbus A340-500', '07:20:00', '09:45:00'),
//('sabato', 'FCO', 'AMS', 'Airbus A340-300', '10:30:00', '13:05:00'),
//('domenica', 'FCO', 'AMS', 'Airbus A340-600', '14:35:00', '19:45:00'),
//('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '10:30:00', '13:05:00'),
//('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '07:20:00', '09:45:00'),
//('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '16:30:00', '18:50:00'),
//('lunedì', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
//('martedì', 'AMS', 'FCO', 'Airbus A340-500', '10:30:00', '13:05:00'),
//('martedì', 'AMS', 'FCO', 'Airbus A340-500', '07:20:00', '09:45:00'),
//('martedì', 'AMS', 'FCO', 'Airbus A340-500', '16:30:00', '18:50:00'),
//('martedì', 'AMS', 'FCO', 'Airbus A340-500', '14:35:00', '19:45:00'),
//('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '10:30:00', '13:05:00'),
//('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '07:20:00', '09:45:00'),
//('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '16:30:00', '18:50:00'),
//('mercoledì', 'AMS', 'FCO', 'Airbus A340-600', '14:35:00', '19:45:00'),
//('giovedì', 'AMS', 'FCO', 'Airbus A340-300', '16:30:00', '18:50:00'),
//('giovedì', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
//('venerdì', 'AMS', 'FCO', 'Airbus A340-500', '10:30:00', '13:05:00'),
//('venerdì', 'AMS', 'FCO', 'Airbus A340-500', '14:35:00', '19:45:00'),
//('sabato', 'AMS', 'FCO', 'Airbus A340-300', '10:30:00', '13:05:00'),
//('sabato', 'AMS', 'FCO', 'Airbus A340-300', '14:35:00', '19:45:00'),
//('domenica', 'AMS', 'FCO', 'Airbus A340-600', '10:30:00', '13:05:00'),
//('Domenica','FCO','JFK','Boeing 777-200','08:00:00','22:00:00'),
//('Domenica','NAP','AMS','Airbus A380-700','08:00:00','12:00:00'),
//('Domenica','AMS','NAP','Airbus A380-700','15:00:00','19:00:00'),
//('Lunedi','JFK','FCO','Boeing 747-400','08:00:00','22:00:00'),
//('Lunedi','CPH','IST','Airbus A340-300','10:00:00','16:00:00'),
//('Lunedi','IST','CPH','Airbus A340-300','18:00:00','24:00:00'),  ho eliminato questo volo, 24:00:00 non è supportato
//('Martedi','SXF','BCN','Airbus A380-700','08:00:00','11:00:00'),
//('Martedi','BCN','SXF','Airbus A380-700','13:00:00','14:00:00'),
//('Mercoledi','CDG','NAP','Airbus A340-500','08:00:00','10:00:00'),
//('Mercoledi','NAP','CDG','Airbus A340-500','12:00:00','14:00:00'),
//('Giovedi','IST','AMS','Airbus A340-300','08:00:00','12:00:00'),
//('Giovedi','AMS','IST','Airbus A340-300','14:00:00','16:00:00');
