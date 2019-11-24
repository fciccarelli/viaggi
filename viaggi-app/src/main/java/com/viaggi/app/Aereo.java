package com.viaggi.app;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aereo {

private String tipoAereo;
private int nPass;
private int quantitaMerci;

public Aereo () {

}

public Aereo (String tipoAereo, int nPass, int quantitaMerci) {
this.tipoAereo = tipoAereo;
this.nPass = nPass;
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
"insert into Aereo (tipoAereo, nPass, quantitaMerci) values (?,?,?)");

System.out.println("inserisci il modello dell'aereo: ");
tipoAereo = inputKey.nextLine();
prepared.setString(1, tipoAereo);

System.out.println("inserisci il numero di passeggeri: ");
nPass = inputKey.nextInt();
prepared.setLong(2, nPass);

System.out.println("inserisci la quantità di merci");
quantitaMerci = inputKey.nextInt();
prepared.setLong(3, quantitaMerci);

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
//
}
}

}

public void cercaAereo(Scanner inputKey) {

String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;

try {

connection = DriverManager.getConnection(connectionString);

Statement stm = connection.createStatement();

System.out.println("Inserisci il modello dell'aereo del quale vuoi vedere i voli");
tipoAereo = inputKey.nextLine();

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

}
}

}
////

public void aggNpassAereo(Scanner inputKey) {
String connectionString = "jdbc:mysql://localhost:3306/viaggi?user=root&password=root&serverTimezone=Europe/Rome";

try {
Class.forName("com.mysql.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;

try {

connection = DriverManager.getConnection(connectionString);

System.out.println("Di quale modello di aereo vuoi aggiornare il numero di passeggeri?");
tipoAereo = inputKey.nextLine();

System.out.println("Quale numero di passeggeri devo settare?");
nPass = inputKey.nextInt();

String query = "UPDATE aereo SET nPass = ? WHERE tipoAereo = ?";
PreparedStatement prepared = connection.prepareStatement(query);

prepared.setLong(1, nPass);
prepared.setString(2, tipoAereo);

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
//
}
}
}









}