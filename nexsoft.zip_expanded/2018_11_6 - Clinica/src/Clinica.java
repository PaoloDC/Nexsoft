import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Clinica {
	
	//variabili di istanza
	public enum Specialista { OCULISTA, PEDIATRA, DENTISTA, OTORINO };
	private HashMap<String, Specialista> mappa;
	
	//costruttore
	public Clinica(){
		mappa = new HashMap<>();
	}
	
	//metodi
	/**
	 * Esegue una prenotazione fornendo il nome di un paziente e il tipo di Specialista
	 * @param paziente stringa che indica il nome del paziente
	 * @param Specialista enum che indica il tipo di Specialista
	 * @return true se la prenotazione va a buon fine, false altrimenti
	 */
	public boolean prenota(String paziente, Specialista Specialista) {
		if(mappa.containsKey(paziente))
			return false;
		mappa.put(paziente, Specialista);
		return true;
	}
	
	/**
	 * Cancella una prenotazione fornendo il nome di un paziente e il tipo di Specialista
	 * @param paziente stringa che indica il nome del paziente
	 * @param Specialista enum che indica il tipo di Specialista
	 * @return true se la prenotazione viene cancellata con successo, false altrimenti
	 */
	public boolean cancellaPrenotazione(String paziente, Specialista Specialista) {
		
		if(mappa.containsKey(paziente) && Specialista.equals(mappa.get(paziente))) {
			mappa.remove(paziente);
			return true;
		}
		return false;
		
		/*
		if(!mappa.containsKey(paziente)) {
			return false;
		}
		else {
			Specialista s = mappa.get(paziente);
			if(!s.equals(Specialista))
				return false;
		}
		mappa.remove(paziente);
		return true;
		*/
	}
	
	/**
	 * Restituisce una stringa con tutti i pazienti che hanno prenotato una visita	
	 * @return una stringa con indicato tutti i pazienti che hanno prenotato una visita
	 */
	public String getPrenotati() {
		return mappa.keySet().toString();
	}
	
	/**
	 * Restituisce un array list di stringhe che contiene le prenotazioni
	 * @return un array che per ogni elemento contiene il nome del paziente con associata visita prenotata
	 */
	public ArrayList<String> getPrenotatiLista() {
		ArrayList<String> listaPazienti = new ArrayList<>();
		
		Set<String> pazienti = mappa.keySet();
		for(String s : pazienti) 
			listaPazienti.add(s);
		
		return listaPazienti;
	}
	
	/**
	 * Restituisce una stringa con tutte le prenotazioni
	 * @return una stringa che contiene il nome del paziente con associata visita prenotata
	 */
	public String getPrenotatiStringa() {
		
		Set<String> pazienti = mappa.keySet();
		if(mappa.isEmpty())
			return "Non ci sono prenotazioni";
		
		String daRestituire = "";
		for(String s : pazienti) {
			daRestituire += s + " ha prenotato una visita con " + mappa.get(s) + "\n";
		}
		return daRestituire;
	}
}
