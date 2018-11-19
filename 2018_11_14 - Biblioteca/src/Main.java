import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Consumer;

import bean.Libro;
import bean.Prestito;
import bean.Utente;
import model.LibroModel;
import model.PrestitoModel;

/**
 * Realizzare un db per la gestione di una biblioteca, considerando che gli
 * utenti possano prelevare dei libri, tenerli per un certo periodo di tempo e
 * poi riconsegnarli. Modellare il dominio tramite opportuni oggetti java e
 * realizzare classi di utility per l'accesso ai dati. Realizzare un servizio
 * nel quale devono essere implementate le seguenti interrogazioni: 1] Tutti i
 * libri prestati ad un utente specifico in ordine cronologico. 2] Individua i
 * primi tre lettori che hanno letto più libri. 3] Individua tutti i possessori
 * dei libri non ancora rientrati e il titolo degli stessi. 4] Dare lo storico
 * dei libri chiesti in prestito da un utente indicando il periodo. 5] Fai la
 * classifica dei libri maggiormente prestati. 6] Individua prestiti la cui
 * durata supera i 15gg.
 * 
 * NB: Cercare di mantenere separato il livello di modellazione dei dati dal
 * livello di logica di accesso. Utilizzare, se necessario e ove possibile, i
 * costrutti introdotti con la versione di Java 8.
 * 
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Main {

	

	public static void main(String[] args) {
		Biblioteca b = new Biblioteca();

		Utente u1, u2, u3;
		u1 = new Utente("Paolo", "De Cristofaro", "PDC");
		u2 = new Utente("Marco", "Polo", "MDD");
		u3 = new Utente("Carmine", "Palo", "CRD");

		Libro l1, l2, l3;
		l1 = new Libro("Codice Da Vinci", "Dan Brown", "1");
		l2 = new Libro("Silenzio degli innocenti", "Patterson", "2");
		l3 = new Libro("L'Estate di Montalbano", "Camilleri", "3");

		Prestito p1, p2, p3, p4, p5, p6;

		p1 = new Prestito(l1, u1, LocalDate.parse("2018-01-01", PrestitoModel.FORMATO_DATA),
				LocalDate.parse("2018-02-01", PrestitoModel.FORMATO_DATA));
		p2 = new Prestito(l2, u1, LocalDate.parse("2018-01-01", PrestitoModel.FORMATO_DATA),
				LocalDate.parse("2018-03-01", PrestitoModel.FORMATO_DATA));
		p3 = new Prestito(l3, u1, LocalDate.parse("2018-02-01", PrestitoModel.FORMATO_DATA), null);
		p4 = new Prestito(l1, u2, LocalDate.parse("2018-02-02", PrestitoModel.FORMATO_DATA),
				LocalDate.parse("2018-03-02", PrestitoModel.FORMATO_DATA));
		p5 = new Prestito(l2, u2, LocalDate.parse("2018-02-02", PrestitoModel.FORMATO_DATA),
				LocalDate.parse("2018-04-02", PrestitoModel.FORMATO_DATA));
		p6 = new Prestito(l2, u2, LocalDate.parse("2018-05-02", PrestitoModel.FORMATO_DATA),
				LocalDate.parse("2018-06-02", PrestitoModel.FORMATO_DATA));

//		 b.inserisciNuovoUtente(u1);
//		 b.inserisciNuovoUtente(u2);
//		 b.inserisciNuovoUtente(u3);
//		
//		 b.inserisciNuovoLibro(l1);
//		 b.inserisciNuovoLibro(l2);
//		 b.inserisciNuovoLibro(l3);
//		
//		 b.inserisciNuovoPrestito(p1);
//		 b.inserisciNuovoPrestito(p2);
//		 b.inserisciNuovoPrestito(p3);
//		 b.inserisciNuovoPrestito(p4);
//		 b.inserisciNuovoPrestito(p5);
//		 b.inserisciNuovoPrestito(p6);

		Libro l4 = new Libro("88", "88", "88");
		LibroModel lm = new LibroModel();
		try {
			System.out.println(lm.insertLibro(l4));
			System.out.println(lm.selectLibri());
			System.out.println(lm.deleteLibro(l4));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\nLISTA PRESTITI DI: " + u1);
		
		ArrayList<Prestito> listaPrestiti = b.getPrestitiUtente(u1);
		
		listaPrestiti.forEach( (Prestito p) -> System.out.println(p) );
		
//		for (Prestito p : b.getPrestitiUtente(u1))
//			System.out.println(p);
//
//		System.out.println("\nLibri ancora in prestito:");
//		for (Prestito p : b.getPrestitiInCorso())
//			System.out.println(p);
		
		listaPrestiti = b.getPrestitiInCorso();
		listaPrestiti.forEach( (Prestito p) -> System.out.println(p) );

		System.out.println("\n" + b.getBestTreLettori());
		System.out.println(b.getStoricoPrestitiUtente(u1));

		int giorniPrestito = 15;

		System.out.println(b.getClassificaLibri());
		System.out.println(b.getPrestitiLungaDurata(giorniPrestito));
	}

}
