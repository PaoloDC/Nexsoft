package v2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Scanner;

public class Clinica implements Serializable {

	// variabili di istanza
	public enum Specialista {
		OCULISTA, PEDIATRA, DENTISTA, OTORINO
	};

	private static final long serialVersionUID = 1L;
	//private ArrayList<Prenotazione> listaPrenotazioni;
	private HashSet<Prenotazione> setPrenotazioni;
	// costruttore
	public Clinica() {
		//listaPrenotazioni = new ArrayList<>();
		setPrenotazioni = new HashSet<>();
	}

	// metodi
	/**
	 * Esegue una prenotazione fornendo il nome di un paziente e il tipo di
	 * Specialista
	 * 
	 * @param paziente
	 *            stringa che indica il nome del paziente
	 * @param Specialista
	 *            enum che indica il tipo di Specialista
	 * @return true se la prenotazione va a buon fine, false altrimenti
	 */
	public boolean prenota(String paziente, Specialista specialista) {
		for(Prenotazione p : setPrenotazioni) {
			if(p.getNomePaziente().equals(paziente))
				return false;
		}
		//listaPrenotazioni.add(new Prenotazione(paziente, specialista));
		setPrenotazioni.add(new Prenotazione(paziente, specialista));
		return true;
	}

	/**
	 * Cancella una prenotazione fornendo il nome di un paziente e il tipo di
	 * Specialista
	 * 
	 * @param paziente
	 *            stringa che indica il nome del paziente
	 * @param Specialista
	 *            enum che indica il tipo di Specialista
	 * @return true se la prenotazione viene cancellata con successo, false
	 *         altrimenti
	 */
	public boolean cancellaPrenotazione(String paziente, Specialista specialista) {
		Prenotazione p = new Prenotazione(paziente, specialista);
		if (setPrenotazioni.contains(p)) {
			setPrenotazioni.remove(p);
			return true;
		}
		return false;
	}

	/**
	 * Restituisce una stringa con tutti i pazienti che hanno prenotato una visita
	 * 
	 * @return una stringa con indicato tutti i pazienti che hanno prenotato una
	 *         visita
	 */
	public HashSet<Prenotazione> getListaPrenotazioni() {
		return setPrenotazioni;
	}

	/**
	 * Restituisce un array list di stringhe che contiene le prenotazioni
	 * 
	 * @return un array che per ogni elemento contiene il nome del paziente con
	 *         associata visita prenotata
	 */
	public String getStringaPrenotazioni() {
		if (setPrenotazioni.size() == 0)
			return "Non ci sono prenotazioni";

		String s = "Elenco Prenotazioni: \r\n";
		for (Prenotazione p : setPrenotazioni) {
			s += "Il paziente '" + p.getNomePaziente() + "' ha prenotato una visita con '" + p.getSpecialista() + "'\n";
		}
		return s;
	}

	public int getNumeroPrenotazioni() {
		return setPrenotazioni.size();
	}

	public void scriviPrenotazioniSuFile(String percorso) {
		File f = new File(percorso);
		try {
			if (!f.exists())
				f.createNewFile();
			PrintWriter pw = new PrintWriter(f);
			for (Prenotazione p : setPrenotazioni) {
				pw.println(p.getNomePaziente());
				pw.println(p.getSpecialista());
			}

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void leggiPrenotazioniDaFile(String percorso) {
		File f = new File(percorso);
		try {
			if (!f.exists())
				return;

			setPrenotazioni.clear();
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				String p = in.nextLine();
				Specialista sp = Specialista.valueOf(in.nextLine());
				setPrenotazioni.add(new Prenotazione(p, sp));
			}
			in.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void cancellaPrenotazioni() {
		setPrenotazioni.clear();
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(setPrenotazioni);
	}

	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		setPrenotazioni = (HashSet<Prenotazione>) in.readObject();
	}
	
}
