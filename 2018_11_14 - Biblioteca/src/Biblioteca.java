import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import bean.Libro;
import bean.Prestito;
import bean.Utente;
import model.LibroModel;
import model.PrestitoModel;
import model.PrestitoModel.Classifica;
import model.UtenteModel;

public class Biblioteca {

	// variabili di istanza
	private final UtenteModel UM = new UtenteModel();
	private final LibroModel LM = new LibroModel();
	private final PrestitoModel PM = new PrestitoModel();

	public Biblioteca() {
	}

	public void inserisciNuovoUtente(Utente u) {
		try {
			UM.insertUtente(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserisciNuovoLibro(Libro l) {
		try {
			LM.insertLibro(l);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserisciNuovoPrestito(Prestito p) {
		try {
			PM.insertPrestito(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Prestito> getPrestitiUtente(Utente u) {
		try {
			return PM.selectPrestiti(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Prestito> getPrestitiInCorso() {
		try {
			return PM.selectPrestitiInCorso();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getBestTreLettori() {
		ArrayList<Classifica> lettori = null;
		try {
			lettori = PM.selectUtenteNumeroPrestiti();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String msg = "Top Tre Migliori Lettori\n";

		for (int i = 0; i < lettori.size() && i < 3; i++) {
			msg += lettori.get(i).getUtente() + " : " + lettori.get(i).getNumeroPrestiti() + "\n";
		}

		return msg;
	}

	public String getStoricoPrestitiUtente(Utente u) {
		ArrayList<Prestito> listaPrestiti = null;
		try {
			listaPrestiti = PM.selectPrestiti(u);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String msg = "Storico Prestiti dell'utente: '" + u.getNome() + " " + u.getCognome() + "'";
		for (Prestito pr : listaPrestiti) {

			LocalDate dataInizio = pr.getDataInizio();
			LocalDate dataFine = pr.getDataFine();

			if (null == dataFine) {
				dataFine = LocalDate.now();
			}

			Period p = Period.between(dataInizio, dataFine);
			msg += "\nIl Prestito del libro '" + pr.getLibro().getTitolo() + "' è durato: " + p.getDays() + " giorni, "
					+ p.getMonths() + " mesi, " + p.getYears() + " anni.";
		}

		return msg;
	}

	public String getClassificaLibri() {
		String msg = "Classifica Libri";

		ArrayList<Classifica> listaLibri = null;

		try {
			listaLibri = PM.selectLibriNumeroPrestiti();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for (Classifica c : listaLibri) {
			msg += "\nIl libro '" + c.getLibro().getTitolo() + "', '" + c.getLibro().getAutore()
					+ "' è stato preso in prestito " + c.getNumeroPrestiti() + " volte";
		}

		return msg;
	}

	public String getPrestitiLungaDurata(int giorniPrestito) {
		String msg = "\nLista Prestiti con Durata Superiore a " + giorniPrestito + " giorni\n";

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
