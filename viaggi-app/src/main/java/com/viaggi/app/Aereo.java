package com.viaggi.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aereo {
	
	String tipoAereo;
	private int npass;
	private int quantitaMerci;
	
	


	public Aereo() {

	}

	public Aereo(String tipoAereo,  int npass,int quantitaMerci) {
	this.tipoAereo = tipoAereo;
	this.npass = npass;
	this.quantitaMerci = quantitaMerci;
	}

	public void insertAereo(Scanner inputKey) {
	String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	Connection connection = null;
	try {

	connection = DriverManager.getConnection(connectionString);
	PreparedStatement prepared = connection.prepareStatement(
	"insert into aereo ( tipoAereo,   npass, quantitaMerci) values (?,?,?)");
	System.out.println("inserisci tipo aereo dell'aereo: ");
	tipoAereo = inputKey.nextLine();
	prepared.setString(1, tipoAereo);
	System.out.println("inserisci numero passeggeri: ");
	npass = inputKey.nextInt();
	prepared.setInt(2, npass);
	System.out.println("inserisci la quantita' merci");
	quantitaMerci = inputKey.nextInt();
	prepared.setInt(3, quantitaMerci);
	
	prepared.executeUpdate();
	Statement stm = connection.createStatement();
	ResultSet rs = stm
	.executeQuery("select * from aereo; ");
	while (rs.next()) {
	System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3));
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
	
	
	
public void updateAereo(Scanner inputKey) {
	String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

	try {
	Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	Connection connection = null;
	try {
		
			connection = DriverManager.getConnection(connectionString);
			
			System.out.println("inserisci l'aereo da modificare: ");
			tipoAereo=inputKey.nextLine();
			
			System.out.println("inserisci la modifica numero passeggeri: ");
			npass = inputKey.nextInt();
				
			System.out.println();
			
			String query = "update aereo set npass=? where tipoAereo=?";
			PreparedStatement prepared = connection.prepareStatement(query);
			
			
			prepared.setInt(1, npass);
			prepared.setString(2, tipoAereo);
			
				
			prepared.executeUpdate();
			
			Statement stm = connection.createStatement();
			ResultSet rs = stm
			.executeQuery("select * from aereo; ");
			while (rs.next()) {
			System.out.println(rs.getString(1) + " " +rs.getString(2) + " " + rs.getString(3));
			System.out.println();
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


public void cercaAereo(Scanner inputK) {

String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;

try {

connection = DriverManager.getConnection(connectionString);

Statement stm = connection.createStatement();

System.out.println("Inserisci il modello dell'aereo del quale vuoi vedere i voli");
tipoAereo = inputK.nextLine();

ResultSet rs = stm.executeQuery("SELECT * FROM Aereo WHERE tipoAereo = '" + tipoAereo + "'");
while (rs.next()) {
System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
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

/*public void updatePassengers (Scanner inputK) {

String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;

try {

connection = DriverManager.getConnection(connectionString);

System.out.println("Di quale modello di aereo vuoi aggiornare il numero di passeggeri?");
tipoAereo = inputK.nextLine();

System.out.println("Quale numero di passeggeri devo settare?");
npass = inputK.nextInt();

String query = "UPDATE aereo SET nPass  " + npass + " WHERE tipoAereo = " + tipoAereo + " ";
PreparedStatement prepared = connection.prepareStatement(query);

prepared.setString(2, tipoAereo);
prepared.setLong(1, npass);

prepared.executeUpdate();

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
*/

}
