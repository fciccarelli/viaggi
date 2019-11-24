package com.viaggi.app;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Volo volo = new Volo();
		Aeroporto aerop = new Aeroporto();
		Aereo aer = new Aereo();
		

		Scanner inputKey = new Scanner(System.in);
		
		int scelta = -1;

		do {

			scelta = mostraOpzioni(inputKey);

			switch (scelta) {

			case 0:
				System.out.println("Grazie ed Arrivederci.");
				break;

			case 1:
				aer.insertAereo(inputKey);
				break;

			case 2:
				aer.cercaAereo(inputKey);
				break;

			case 3:
				aer.updatePassengers(inputKey);
				break;

			case 4:
				aerop.insertAeroporto(inputKey);
				break;

			case 5:
				aerop.cercaAeroporto(inputKey);
				break;

			case 6:
				aerop.updatePiste(inputKey);
				break;

			case 7:
				volo.insertVolo(inputKey);
				break;

			case 8:
				volo.cercaVolo(inputKey);
				break;

			default:
				System.out.println("scelta non consentita, per favore riprova.");
				scelta = 999;
				break;

			}

		} while (scelta > 0);

		inputKey.close();
	}

	public static int mostraOpzioni(Scanner inputKeyb) {

		// scelta ha scope interno a questo metodo
		int scelta = -1;

		System.out.println("Si prega di inserire un'opzione: ");
		System.out.println("0 - per uscire");
		System.out.println("1 - Inserimento di un aereo");
		System.out.println("2 - Selezionare un aereo dato il tipo");
		System.out.println("3 - Aggiornare il numero di passeggeri dato l’aereo");
		System.out.println("4 - Inserimento di un aeroporto");
		System.out.println("5 - Selezionare un aeroporto dato l’id");
		System.out.println("6 - Aggiornare il numero di piste di un aeroporto");
		System.out.println("7 - Inserimento di un volo");
		System.out.println("8 - Selezionare un volo dato l’id");
		scelta = inputKeyb.nextInt();
		inputKeyb.nextLine();

		return scelta;
	}
}
