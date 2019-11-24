/**
 * 
 */
package com.uiip43.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * @author pasop
 *
 */
public class ViaggiDatabaseRunner {

	public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/Viaggi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DbOperations dbAereo = new Aereo();
		DbOperations dbAeroporto = new Aeroporto();
		DbOperations dbVolo =  new Volo();
		
		Connection connection = null;
		int scelta = -1;
		
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		    
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();  
			
			connection = DriverManager.getConnection(CONNECTION_STRING, "root", "root");
			
			do {
				
				scelta = mostraMenu(bufferedReader);
				
				switch (scelta) {
					case 0 : 
						System.out.println("Arrivederci.");
						break;
					case 1: mostraMenuAereo(bufferedReader, dbAereo, connection);
						break;
					case 2: mostraMenuAeroporto(bufferedReader, dbAeroporto, connection);
						break;
					case 3: mostraMenuVolo(bufferedReader, dbVolo, connection);
					
					default:
						System.out.println("Scelta non valida, riprovare.");
						scelta = 199999;
						break;
				}
			}while(scelta != 0);
			
			
			bufferedReader.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	private static int mostraMenu(BufferedReader reader){
		String lettura = "";
		int scelta = -1;
		
		System.out.println("Benvenuto nel database viaggi.");
		System.out.println("Selezionare 1 - per accedere alla tabella aereo.");
		System.out.println("Selezionare 2 - per accedere alla tabella aeroporto.");
		System.out.println("Selezionare 3 - per accedere alla tabella volo.");
		System.out.println("Selezionare 0 - per terminare il programma.");
		
		
		try {
			lettura = reader.readLine();
			scelta = Integer.parseInt(lettura);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException n){
			System.err.println("Non è stato inserito un numero.");
		}
		
		return scelta;
	}
	
	private static void mostraMenuAereo(BufferedReader reader, DbOperations dbAereo, Connection connection) {
		String lettura = "";
		int scelta = -1;
		int insertResult = -1;
		
		try {
			
			do {
				System.out.println("Benvenuto nell'area aereo.");
				System.out.println("Selezionare 1 - per inserire un nuovo aereo.");
				System.out.println("Selezionare 2 - per selezionare un aereo dato il tipo.");
				System.out.println("Selezionare 3 - per modificare il numero di posti di un aereo dato il tipo.");
				System.out.println("Selezionare 0 - per tornare al menu precedente.");
				
				lettura = reader.readLine();
				scelta = Integer.parseInt(lettura);
				switch(scelta) {
					case 0 :
						break;
					case 1: 
						
						System.out.println("Inserire il tipo di aereo: ");
						
						String tipoAereo = reader.readLine();
						
						if(tipoAereo.length()>Aereo.LENGTH_TIPO_AEREO) {
							throw new IllegalArgumentException("Tipo di aereo inserito non valido.");
						}
						
						System.out.println("Inserire il numero di passeggeri: ");
						
						lettura = reader.readLine();
						int nPass = Integer.parseInt(lettura);
						
						System.out.println("Inserire la quantita merci: ");
						
						lettura = reader.readLine();
						int quantitaMerci = Integer.parseInt(lettura);
						
						Aereo aereo1 = new Aereo(tipoAereo, nPass, quantitaMerci);
						
						insertResult = dbAereo.insert(aereo1, connection);
						
						if(insertResult == 1) {
							System.out.println("Inserimento avvenuto con successo.");
						} else {
							System.out.println("Inserito non avvenuto!");
						}
						
						break;
					case 2:
						ResultSet result = null;
	
						ResultSetMetaData meta = null;
						
						Aereo aereo2 = new Aereo();
	
						System.out.println("Inserire il tipo di aereo da cercare");
						
						String tipoAereoRicerca = reader.readLine();
						
						if(tipoAereoRicerca.length()>Aereo.LENGTH_TIPO_AEREO) {
							throw new IllegalArgumentException("Tipo di aereo inserito non valido.");
						}
						
						aereo2.setTipoAereo(tipoAereoRicerca);
						result = dbAereo.select(aereo2, connection);
						
						meta = result.getMetaData();
			
			            String colname1 = meta.getColumnName(1);
			            String colname2 = meta.getColumnName(2);
			            String colname3 = meta.getColumnName(3);
			
			            String header = String.format("%-21s%-21s%s", colname1, colname2, colname3);
			            System.out.println(header);
			
			            while (result.next()) {
			
			                String row = String.format("%-21s%-21s%s", result.getString(1), result.getString(2), result.getString(3));
			                System.out.println(row);
			            }
						
						break;
					case 3:
						
						Aereo aereoUpdate = new Aereo();
						
						System.out.println("Inserire il tipo di aereo di cui si vuole modificare il numero passeggeri");
						
						String tipoAereoUpdate = reader.readLine();
						
						if(tipoAereoUpdate.length()>Aereo.LENGTH_TIPO_AEREO) {
							throw new IllegalArgumentException("Tipo di aereo inserito non valido.");
						}
						
						aereoUpdate.setTipoAereo(tipoAereoUpdate);
						
						System.out.println("Inserire il numero di passeggeri: ");
						
						lettura = reader.readLine();
						int numeroPasseggeri = Integer.parseInt(lettura);
						
						aereoUpdate.setnPass(numeroPasseggeri);
						insertResult = dbAereo.update(aereoUpdate, connection);
						
						if(insertResult == 1) {
							System.out.println("Update avvenuto con successo.");
						} else {
							System.out.println("Update non avvenuto!");
						}
						
						break;
					
					default:
						System.out.println("Scelta non valida, riprovare.");
						scelta = 199999;
						break;
				} 
			}while(scelta != 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException n){
			System.err.println("Non è stato inserito un numero.");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void mostraMenuAeroporto(BufferedReader reader, DbOperations dbAeroporto, Connection connection) {
		String lettura = "";
		int scelta = -1;
		int insertResult = -1;
		
		try {
			
			do {
				System.out.println("Benvenuto nell'area aeroporto.");
				System.out.println("Selezionare 1 - per inserire un nuovo aeroporto.");
				System.out.println("Selezionare 2 - per selezionare un aeroporto dato l'Id.");
				System.out.println("Selezionare 3 - per modificare il numero di piste di un aeroporto dato l'Id.");
				System.out.println("Selezionare 0 - per tornare al menu precedente.");
				
				lettura = reader.readLine();
				scelta = Integer.parseInt(lettura);
				switch(scelta) {
					case 0 :
						break;
					case 1: 
						Aeroporto aeroporto1 = new Aeroporto();
						
						System.out.println("Inserire l'Id dell'aeroporto: ");
						String idAeroporto = reader.readLine();
						
						if(idAeroporto.length()>Aeroporto.LENGTH_ID_AEROPORTO) {
							throw new IllegalArgumentException("Id aeroporto inserito non valido.");
						}
						aeroporto1.setId(idAeroporto);
						
						System.out.println("Inserire la citta in cui è presente l'aeroporto: ");
						lettura = reader.readLine();
						aeroporto1.setCitta(lettura);
						
						System.out.println("Inserire la nazione: ");
						lettura = reader.readLine();
						aeroporto1.setNazione(lettura);
						
						System.out.println("Inserire il numero di piste dell'aeroporto: ");
						lettura = reader.readLine();
						int numeroPiste = Integer.parseInt(lettura);
						
						aeroporto1.setnPiste(numeroPiste);
						
						insertResult = dbAeroporto.insert(aeroporto1, connection);
						
						if(insertResult == 1) {
							System.out.println("Inserimento avvenuto con successo.");
						} else {
							System.out.println("Inserito non avvenuto!");
						}
						
						break;
					case 2:
						ResultSet result = null;
						ResultSetMetaData meta = null;
						Aeroporto aeroportoRicerca = new Aeroporto();
	
						System.out.println("Inserire il tipo di aeroporto da cercare");
						
						String idAeroportoRicerca = reader.readLine();
						
						if(idAeroportoRicerca.length()>Aeroporto.LENGTH_ID_AEROPORTO) {
							throw new IllegalArgumentException("Tipo di aeroporto inserito non valido.");
						}
						
						aeroportoRicerca.setId(idAeroportoRicerca);
						result = dbAeroporto.select(aeroportoRicerca, connection);
						
						meta = result.getMetaData();
			
			            String colname1 = meta.getColumnName(1);
			            String colname2 = meta.getColumnName(2);
			            String colname3 = meta.getColumnName(3);
			            String colname4 = meta.getColumnName(4);
			
			            String header = String.format("%-21s%-21s%-21s%s", colname1, colname2, colname3, colname4);
			            System.out.println(header);
			
			            while (result.next()) {
			
			                String row = String.format("%-21s%-21s%-21s%s", result.getString(1), result.getString(2), result.getString(3), result.getString(4));
			                System.out.println(row);
			            }
						
			            
						break;
					case 3:
						
						Aeroporto aeroportoUpdate = new Aeroporto();
						
						System.out.println("Inserire l'id dell'aeroporto di cui si vuole modificare il numero di piste");
						
						String idAeroportoUpdate = reader.readLine();
						
						if(idAeroportoUpdate.length()>Aeroporto.LENGTH_ID_AEROPORTO) {
							throw new IllegalArgumentException("L'Id dell'aeroporto inserito non valido.");
						}
						
						aeroportoUpdate.setId(idAeroportoUpdate);
						
						System.out.println("Inserire il numero di piste: ");
						
						lettura = reader.readLine();
						int numeroPisteUpdate = Integer.parseInt(lettura);
						
						aeroportoUpdate.setnPiste(numeroPisteUpdate);
						insertResult = dbAeroporto.update(aeroportoUpdate, connection);
						
						if(insertResult == 1) {
							System.out.println("Update avvenuto con successo.");
						} else {
							System.out.println("Update non avvenuto!");
						}
						
						break;
					
					default:
						System.out.println("Scelta non valida, riprovare.");
						scelta = 199999;
						break;
				} 
			}while(scelta != 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException n){
			System.err.println("Non è stato inserito un numero.");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void mostraMenuVolo(BufferedReader reader, DbOperations dbVolo, Connection connection) {
		String lettura = "";
		int scelta = -1;
		int insertResult = -1;
		
		try {
			
			do {
				System.out.println("Benvenuto nell'area volo.");
				System.out.println("Selezionare 1 - per inserire un nuovo volo.");
				System.out.println("Selezionare 2 - per selezionare un volo dato l'Id.");
				System.out.println("Selezionare 0 - per tornare al menu precedente.");
				
				lettura = reader.readLine();
				scelta = Integer.parseInt(lettura);
				switch(scelta) {
					case 0 :
						break;
					case 1: 
						Volo voloInsert = new Volo();
						System.out.println("Inserire il giorno della settimana del volo: ");
						
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_GIORNO_SETT) {
							throw new IllegalArgumentException("Tipo di aereo inserito non valido.");
						}
						voloInsert.setGiornoSett(lettura);
						
						System.out.println("Inserire l'id dell'aeroporto di partenza ");
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_AEROPORTO_PART) {
							throw new IllegalArgumentException("L'aeroporto di partenza inserito non è valido.");
						}
						voloInsert.setAeroportoPart(lettura);
						
						System.out.println("Inserire l'id dell'aeroporto di arrivo ");
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_AEROPORTO_ARR) {
							throw new IllegalArgumentException("L'aeroporto di arrivo inserito non è valido.");
						}
						voloInsert.setAeroportoArr(lettura);
						
						System.out.println("Inserire il tipo di aereo: ");
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_TIPO_AEREO) {
							throw new IllegalArgumentException("Il tipo di aereo inserito non è valido.");
						}
						voloInsert.setTipoAereo(lettura);
						
						System.out.println("Inserire l'ora di partenza: ");
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_ORARIO) {
							throw new IllegalArgumentException("L'ora di partenza inserita non è valido.");
						}
						voloInsert.setOraPartenza(lettura);
						
						System.out.println("Inserire l'ora di arrivo: ");
						lettura = reader.readLine();
						if(lettura.length() > Volo.LENGTH_ORARIO) {
							throw new IllegalArgumentException("L'ora di arrivo inserita non è valido.");
						}
						voloInsert.setOraArrivo(lettura);
						
						insertResult = dbVolo.insert(voloInsert, connection);
						
						if(insertResult == 1) {
							System.out.println("Inserimento avvenuto con successo.");
						} else {
							System.out.println("Inserito non avvenuto!");
						}
						
						break;
					case 2:
						ResultSet result = null;
						ResultSetMetaData meta = null;
						Volo voloSelect = new Volo();
	
						System.out.println("Inserire l'id del volo da cercare");
						
						lettura = reader.readLine();
						int idVolo = Integer.parseInt(lettura);
						
						voloSelect.setIdVolo(idVolo);
						
						result = dbVolo.select(voloSelect, connection);
						
						meta = result.getMetaData();
			
			            String colname1 = meta.getColumnName(1);
			            String colname2 = meta.getColumnName(2);
			            String colname3 = meta.getColumnName(3);
			            String colname4 = meta.getColumnName(4);
			            String colname5 = meta.getColumnName(5);
			            String colname6 = meta.getColumnName(6);
			            String colname7 = meta.getColumnName(7);
						
			            String header = String.format("%-21s%-21s%-21s%-21s%-21s%-21s%s", colname1, colname2, colname3, colname4, colname5, colname6, colname7);
			            System.out.println(header);
			
			            while (result.next()) {
			
			                String row = String.format("%-21s%-21s%-21s%-21s%-21s%-21s%s", result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6), result.getString(7));
			                System.out.println(row);
			            }
						
						break;
					default:
						System.out.println("Scelta non valida, riprovare.");
						scelta = 199999;
						break;
				} 
			}while(scelta != 0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException n){
			System.err.println("Non è stato inserito un numero.");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
