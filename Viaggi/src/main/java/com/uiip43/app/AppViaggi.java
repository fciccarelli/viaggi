package com.uiip43.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.uiip43.app.db.dao.AereoDAO;
import com.uiip43.app.db.dao.AeroportoDAO;
import com.uiip43.app.db.dao.VoloDAO;
import com.uiip43.app.entities.Aereo;
import com.uiip43.app.entities.Aeroporto;
import com.uiip43.app.entities.Volo;

public class AppViaggi {
	private String s = new String();

	public static void main(String[] args) {
		AppViaggi a = new AppViaggi();
		a.MostraConsole(a);
	}

	private void MostraConsole(AppViaggi a) {
		// TODO implement here
		System.out.println("SONO LA CONSOLE \n" + "INSERISCI IL NUMERO CORRISPONDENTE ALLA FUNZIONALITA RICHIESTA \n"
				+ "1:INSERISCI AEREO \n" + "2:SELEZIONA AEREO \n" + "3:AGGIORNA PASSEGGERI AEREO \n"
				+ "4:INSERISCI AEROPORTO \n" + "5:SELEZIONA AEROPORTO \n" + "6:AGGIORNA PISTE AEROPORTO \n"
				+ "7:INSERISCI VOLO \n" + "8:SELEZIONA VOLO \n");
		while (s.compareTo("0") != 0) {
			System.out.println("");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			try {
				s = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Inserimento errato\n");
				break;
			}
			switch (s) {
			case "1":
				a.creaAereo();
				break;
			case "2":
				a.selezionaAereo();
				break;
			case "3":
				a.aggiornaAereo();
				break;
			case "4":
				a.creaAeroporto();
				break;
			case "5":
				a.selezionaAeroporto();
				break;
			case "6":
				a.aggiornaAeroporto();
				break;
			case "7":
				a.creaVolo();
				break;
			case "8":
				a.selezionaVolo();
				break;
			case "0":
				System.out.println("Arrivederci\n");
				System.exit(0);
				break;
			default:
				System.out.println("NUMERO ERRATO\n");
			}
			System.out.println("SE DESIDERI AVVIARE UNA FUNZIONALITA INSERISCI IL NUMERO CORRISPONDENTE\n"
					+ "ALTRIMENTI INSERISCI 0 PER USCIRE\n");
		}

	}

	private void creaAereo() {
		// TODO implement here
		String tipoAereo = null;
		String nPass = null;
		String quantitaMerci = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci il tipo di aereo\n");
			tipoAereo = in.readLine();
			System.out.println("Inserisci il numero di passeggeri dell'aereo\n");
			nPass = in.readLine();
			System.out.println("Inserisci la quantita di merci dell'aereo\n");
			quantitaMerci = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato\n");
		}
		Aereo a = new Aereo();
		a.setTipoAereo(tipoAereo);
		if (isInteger(nPass) == true) {
			a.setNpass(Integer.parseInt(nPass));
		} else {
			System.out.println("Inserimento errato, prova ad inserire un numero per i passeggeri");
		}
		if (isInteger(quantitaMerci) == true) {
			a.setQuantitaMerci(Integer.parseInt(quantitaMerci));
		} else {
			System.out.println("Inserimento errato, prova ad inserire un numero per la quantita merci");
		}

		AereoDAO.inserimento(a);
	}

	private void selezionaAereo() {
		String tipoAereo = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci il tipo di aereo\n");
			tipoAereo = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato \n");
		}

		Aereo a = new Aereo();
		a = AereoDAO.selezione(tipoAereo);
		System.out.println("tipoAereo: " + a.getTipoAereo() + " Npass: " + a.getNpass() + " quantitaMerci: "
				+ a.getQuantitaMerci());

	}

	private void aggiornaAereo() {
		// TODO implement here
		String tipoAereo = null;
		String nPass = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci il tipo di aereo a cui aggiornare il numero di passeggeri\n");
			tipoAereo = in.readLine();
			System.out.println("Inserisci il nuovo numero  di passeggeri dell'aereo\n");
			nPass = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato\n");
		}
		if (isInteger(nPass) == true) {
			AereoDAO.aggiornamento(tipoAereo, Integer.parseInt(nPass));
		} else {
			System.out.println("Inserimento errato prova ad inserire un numero  per i passeggeri");
		}

	}

	private void creaAeroporto() {
		// TODO implement here
		String id = null;
		String citta = null;
		String nazione = null;
		String nPiste = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci l id dell'aeroporto (es.per Napoli inserire NAP)\n");
			id = in.readLine();
			System.out.println("Inserisci la citta  dell'aeroporto\n");
			citta = in.readLine();
			System.out.println("Inserisci la nazione dell'aeroporto\n");
			nazione = in.readLine();
			System.out.println("Inserisci il numero di piste dell'aeroporto\n");
			nPiste = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato\n");
		}
		Aeroporto a = new Aeroporto();
		a.setId(id);
		a.setCitta(citta);
		a.setNazione(nazione);
		if (isInteger(nPiste) == true) {
			a.setnPiste(Integer.parseInt(nPiste));
		} else {
			System.out.println("Inserimento errato prova ad inserire un numero  per le piste");
		}
		AeroportoDAO.inserimento(a);
	}

	private void selezionaAeroporto() {
		String id = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci il codice di aeroporto(es.per napoli inserire NAP)\n");
			id = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato \n");
		}

		Aeroporto a = new Aeroporto();
		a = AeroportoDAO.selezione(id);
		System.out.println("id: " + a.getId() + " citta: " + a.getCitta() + " nazione: " + a.getNazione()
				+ " numero piste: " + a.getnPiste());

	}

	private void aggiornaAeroporto() {
		// TODO implement here
		String id = null;
		String nPiste = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println(
					"Inserisci l id dell aereoporto(es. per Napoli inserire NAP) a cui aggiornare il numero di piste\n");
			id = in.readLine();
			System.out.println("Inserisci il nuovo numero  di piste dell'aeroporto\n");
			nPiste = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato\n");
		}
		if (isInteger(nPiste) == true) {
			AeroportoDAO.aggiornamento(id, Integer.parseInt(nPiste));
		} else {
			System.out.println("Inserimento errato prova ad inserire un numero  per le piste");
		}

	}

	private void creaVolo() {
		// TODO implement here
		String giorniSett = null;
		String aeroportoPart = null;
		String aeroportoArr = null;
		String tipoAereo = null;
		String oraPartenza = null;
		String oraArrivo = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci il giorno del volo \n");
			giorniSett = in.readLine();
			System.out.println("Inserisci l aeroporto di partenza come codice(es.per Napoli inserire NAP) \n");
			aeroportoPart = in.readLine();
			System.out.println("Inserisci l aeroporto di arrivo come codice(es.per Napoli inserire NAP) \n");
			aeroportoArr = in.readLine();
			System.out.println("Inserisci il tipo di aereo \n");
			tipoAereo = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato\n");
		}
		try {
			System.out.println("Inserisci ora della partenza nel formato HH:mm:ss \n");
			oraPartenza = in.readLine();
			System.out.println("Inserisci ora dell'arrivo nel formato HH:mm:ss \n");
			oraArrivo = in.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato \n");
		}
		// TODO Auto-generated catch block
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = null;
		Date date2 = null;
		try {
			date1 = format.parse(oraPartenza);
			date2 = format.parse(oraArrivo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("formato ora errato,un esempio potrebbe essere(12:00:00)");
		}
		Time oraP = new Time(date1.getTime());
		Time oraA = new Time(date2.getTime());
		Volo v = new Volo();
		v.setGiorniSett(giorniSett);
		v.setAeroportoPart(aeroportoPart);
		v.setAeroportoArr(aeroportoArr);
		v.setTipoAereo(tipoAereo);
		v.setOraPartenza(oraP);
		v.setOraArrivo(oraA);
		VoloDAO.inserimento(v);
	}

	private void selezionaVolo() {
		String idVolo = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Inserisci id del volo\n");
			idVolo = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserimento errato \n");
		}

		Volo v = new Volo();
		v = VoloDAO.selezione(Integer.parseInt(idVolo));
		System.out.println("id: " + v.getIdVolo() + " giorno: " + v.getGiorniSett() + " aeroporto di partenza: "
				+ v.getAeroportoPart() + " aeroporto di arrivo: " + v.getAeroportoArr() + " tipo di aereo: "
				+ v.getTipoAereo() + " ora partenza: " + v.getOraPartenza() + " ora arrivo: " + v.getOraArrivo());

	}

	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		return true;
	}
}
