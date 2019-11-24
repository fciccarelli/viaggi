package com.viaggi.app;


import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) 
    {
    	Scanner inputk = new Scanner(System.in);
    	Volo volo = new Volo();
    	Aeroporto aeroporto = new Aeroporto();
    	Aereo aereo = new Aereo();
    	
    	int scelta = -1;

    	do {

    	scelta = mostraOpzioni(inputk);

    	switch (scelta) {

    	case 0:
    	System.out.println("Grazie ed Arrivederci.");
    	break;

    	case 1:
    	aereo.insertAereo(inputk);
    	break;

    	case 2:
    	aereo.cercaAereo(inputk);
    	break;

    	case 3:
    	aereo.updateAereo(inputk);
    	break;

    	case 4:
    	aeroporto.insertAeroporto(inputk);
    	break;

    	case 5:
    	aeroporto.cercaAeroporto(inputk);
    	break;
    	
    	case 6:
    	aeroporto.updatePiste(inputk);
    	break;
    	
    	case 7:
    	volo.insertVolo(inputk);
    	break;
    	
    	case 8:
    	volo.cercaVolo(inputk);
    	break;
    	
    	default:
    	System.out.println("scelta non consentita,per favore riprova");
    	scelta = 987;
    	break;

    	}

    	} while (scelta > 0);

    	inputk.close();
    	}

    	//volo.insertVolo(inputk);
    	//aeroporto.insertAeroporto(inputk);
    	//aereo.insertAereo(inputk);
    	//aereo.UpdateAereo(inputk);
    	//volo.cercaVolo(inputk);
    	//aereo.cercaAereo(inputk);
    	//aeroporto.cercaAeroporto(inputk);



public static int mostraOpzioni(Scanner inputKeyb) {

//  scelta ha scope interno a questo metodo
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
