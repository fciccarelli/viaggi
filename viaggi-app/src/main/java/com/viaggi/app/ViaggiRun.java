package com.viaggi.app;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 */
public class ViaggiRun {

	public static void main(String[] args) {

		Scanner inputK = new Scanner(System.in);

		Volo volo = new Volo();
		Aereo aereo = new Aereo();
		Aeroporto aeroporto = new Aeroporto();

		int scelta = -1;
			
		do {
			
			try {
				scelta = mostraOpzioni(inputK);
			} catch (InputMismatchException e){
				System.out.print("Puoi inserire solo dei numeri. ");
			}
	
			switch (scelta) {
	
			case 0:
				System.out.println("Grazie ed Arrivederci.");
				break;
				
			case 1:
				try {
					aereo.insertAereo(inputK);
				} catch (SQLException e2) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e2.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito una stringa, non accettato.");
					System.out.println("");
				}
				break;
				
			case 2:
				try {
					aereo.cercaAereo(inputK);
				} catch (SQLException e2) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e2.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito una stringa, non accettato.");
					System.out.println("");
				}
				break;
	
			case 3:
				try {
					aereo.updatePassengers(inputK);
				} catch (SQLException e2) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e2.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito una stringa, non accettato.");
					System.out.println("");
				}
				break;
	
			case 4:
				try {
					aeroporto.insertAeroporto(inputK);
				} catch (SQLException e1) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e1.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito una stringa, non accettato.");
					System.out.println("");
				}
				break;
	
			case 5:
				try {
					aeroporto.cercaAeroporto(inputK);
				} catch (SQLException e) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito una stringa, non accettato.");
					System.out.println("");
				}
				break;
					
			case 6:
				try {
					aeroporto.updatePiste(inputK);
				} catch (SQLException e1) {
					System.err.println("Hai inserito un valore non accettato nel database");
//					e1.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
					System.out.println("");
				}
				break;
					
			case 7:
				try {
					volo.insertVolo(inputK);
				} catch (SQLException e1) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
//					e1.printStackTrace();
				}
				break;
					
			case 8:
				try {
					volo.cercaVolo(inputK);
				} catch (SQLException e) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
					e.printStackTrace();
				} catch (InputMismatchException e2) {
					System.err.println("Hai inserito un valore non accettato nel database. Operazione non effettuata.");
					System.out.println("");
				}
				break;
					
			default:
				System.out.println("Scelta non consentita, per favore riprova.");
				scelta = 999;
				break;
			}

		} while (scelta > 0);
		
		inputK.close();
		
	}

	public static int mostraOpzioni(Scanner inputK) {

		int scelta = -1;

		System.out.println("Si prega di inserire un'opzione: ");
		System.out.println("0 - Per terminare.");
		System.out.println("1 - Inserire un nuovo aereo.");
		System.out.println("2 - Selezionare un aereo dato il tipo.");
		System.out.println("3 - Aggiornare il numero di passeggeri dato l’aereo.");
		System.out.println("4 - Inserire un nuovo aeroporto.");
		System.out.println("5 - Selezionare un aeroporto dato l’id.");
		System.out.println("6 - Aggiornare il numero di piste di un aeroporto.");
		System.out.println("7 - Inserire un nuovo volo.");
		System.out.println("8 - Selezionare un volo dato l’id.");

		try {
			scelta = inputK.nextInt();
		} catch (InputMismatchException e){
			System.out.print("Puoi inserire solo dei numeri. ");
			inputK.next();
		}
		inputK.nextLine();

		return scelta;
	}

}
