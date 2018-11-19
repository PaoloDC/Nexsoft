import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.stream.Collectors;

import bean.Libro;
import bean.Prestito;
import bean.Utente;
import model.LibroModel;
import model.PrestitoModel;
import model.PrestitoModel.Classifica;
import model.UtenteModel;

/**
 * Classe che modella una biblioteca
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Biblioteca {

	// variabili di istanza
	private final UtenteModel UM;
	private final LibroModel LM;
	private final PrestitoModel PM;

	// costruttore vuoto
	public Biblioteca() {
		UM = new UtenteModel();
		LM = new LibroModel();
		PM = new PrestitoModel();
	}

	/**
	 * Inserisce un nuovo utente nell'archivio della biblioteca
	 * 
	 * @param u
	 *            nuovo oggetto di tipo utente da registrare
	 */
	public void inserisciNuovoUtente(Utente u) {
		try {
			UM.insertUtente(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserisce un nuovo libro nell'archivio della biblioteca
	 * 
	 * @param l
	 *            nuovo oggetto di tipo libro da registrare
	 */
	public void inserisciNuovoLibro(Libro l) {
		try {
			LM.insertLibro(l);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserisce un nuovo prestito nell'archivio della biblioteca
	 * 
	 * @param p
	 *            nuovo oggetto di tipo prestito da registrare
	 */
	public void inserisciNuovoPrestito(Prestito p) {
		try {
			PM.insertPrestito(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Inserisce un nuovo prestito nell'archivio della biblioteca
	 * 
	 * @param u
	 *            l'utente che sta effettuando il prestito
	 * @param l
	 *            il libro per cui si sta effettuando il prestito
	 */
	public void inserisciNuovoPrestito(Utente u, Libro l) {
		Prestito p = new Prestito();
		p.setUtente(u);
		p.setLibro(l);
		p.setDataInizio(LocalDate.now());
		p.setDataFine(null);
		try {
			PM.insertPrestito(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Permette di riconsegnare un libro preso in prestito dall'utente
	 * 
	 * @param u
	 *            l'utente che ha preso il libro in prestito
	 * @param l
	 *            libro che era in prestito all'utente
	 */
	public void riconsegnaLibro(Utente u, Libro l) {
		try {
			PM.impostaDataFinePrestito(u, l);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Restituisce la lista dei prestiti di un certo utente
	 * 
	 * @param u
	 *            utente per cui eseguire la ricerca
	 * @return lista dei libri ricercati
	 */
	public ArrayList<Prestito> getPrestitiUtente(Utente u) {
		try {
			return PM.selectPrestiti(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Restituisce la lista dei prestiti in corso
	 * 
	 * @return lista dei prestiti ancora in corso
	 */
	public ArrayList<Prestito> getPrestitiInCorso() {
		try {
			return PM.selectPrestitiInCorso();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Ritorna un messaggio che indica chi sono i 3 migliori lettori, in base al
	 * numero di prestiti effettuati
	 * 
	 * @return una stringa che contiene il messaggio
	 */
	public String getBestTreLettori() {
		ArrayList<Classifica> lettori = null;
		try {
			lettori = PM.selectUtenteNumeroPrestiti();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg = "TOP TRE LETTORI\n";

		msg += lettori.stream().limit(3).map(p -> p.getUtente() + " : " + p.getNumeroPrestiti()).collect(Collectors.joining("\n"));
		
		
//		for (int i = 0; i < lettori.size() && i < 3; i++) {
//			msg += lettori.get(i).getUtente() + " : " + lettori.get(i).getNumeroPrestiti() + "\n";
//		}

		return msg;
	}

	/**
	 * Indica la durata dei prestiti per un certo utente
	 * 
	 * @param u
	 *            l'utente per cui ricercare i prestiti
	 * @return una stringa che contiene il messaggio
	 */
	public String getStoricoPrestitiUtente(Utente u) {
		ArrayList<Prestito> listaPrestiti = null;
		try {
			listaPrestiti = PM.selectPrestiti(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String msg = "Storico Prestiti dell'utente: '" + u.getNome() + " " + u.getCognome() + "'\n";
		for (Prestito pr : listaPrestiti) {

			LocalDate dataInizio = pr.getDataInizio();
			LocalDate dataFine = pr.getDataFine();

			if (null == dataFine) {
				dataFine = LocalDate.now();
			}

			Period p = Period.between(dataInizio, dataFine);
			msg += "Il Prestito del libro '" + pr.getLibro().getTitolo() + "' è durato: " + p.getDays() + " giorni, "
					+ p.getMonths() + " mesi, " + p.getYears() + " anni.\n";
		}

		return msg;
	}

	/**
	 * Restituisce un messaggio che indica quali sono i libri richiesti maggiormente
	 * in prestito
	 * 
	 * @return una stringa che contiene il messaggio
	 */
	public String getClassificaLibri() {
		String msg = "CLASSIFICA LIBRI IN PRESTITO\n";

		ArrayList<Classifica> listaLibri = null;

		try {
			listaLibri = PM.selectLibriNumeroPrestiti();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Classifica c : listaLibri) {
			msg += "Il libro '" + c.getLibro().getTitolo() + "', '" + c.getLibro().getAutore()
					+ "' è stato preso in prestito " + c.getNumeroPrestiti() + " volte.\n";
		}

		return msg;
	}

	/**
	 * Cerca tutti quei prestiti che hanno una durata in giorni maggiore di un certo
	 * valore
	 * 
	 * @param giorniPrestito
	 *            intero che indica il numero di giorni per ricercare i prestiti
	 * @return una stringa che contiene il messaggio
	 */
	public String getPrestitiLungaDurata(int giorniPrestito) {
		String msg = "Lista Prestiti con Durata Superiore a " + giorniPrestito + " giorni\n";

		ArrayList<Prestito> listaPrestiti = null;
		try {
			listaPrestiti = PM.selectPrestiti();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Prestito pr : listaPrestiti) {
			LocalDate dataInizio = pr.getDataInizio();
			LocalDate dataFine = pr.getDataFine();

			if (null == dataFine) {
				dataFine = LocalDate.now();
			}

			Period p = Period.between(dataInizio, dataFine);
			if (p.getYears() > 0 || p.getMonths() > 0 || p.getDays() >= giorniPrestito)
				msg += "Il Prestito del libro '" + pr.getLibro().getTitolo() + "' è durato: " + p.getDays()
						+ " giorni, " + p.getMonths() + " mesi, " + p.getYears() + " anni.\n";
		}
		return msg;
	}
}
