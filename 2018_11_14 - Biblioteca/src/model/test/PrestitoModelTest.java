package model.test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

import bean.Libro;
import bean.Prestito;
import bean.Utente;
import junit.framework.TestCase;
import model.LibroModel;
import model.PrestitoModel;
import model.UtenteModel;

public class PrestitoModelTest extends TestCase {

	// variabili di istanza
	private static PrestitoModel model = new PrestitoModel();

	@Test
	public void testSelectPrestiti() throws SQLException {

		Utente u = new Utente("prova_utente", "prova_utente", "prova_utente");
		Libro l = new Libro("prova_libro", "prova_libro", "prova_libro");
		Prestito p = new Prestito(l, u, LocalDate.now(), LocalDate.now());

		UtenteModel um = new UtenteModel();
		LibroModel lm = new LibroModel();

		try {
			ArrayList<Prestito> listaIniziale = model.selectPrestiti();
			assertNotNull(listaIniziale);

			um.insertUtente(u);

			lm.insertLibro(l);

			assertTrue(model.insertPrestito(p));
			
			ArrayList<Prestito> listaAggiornata = model.selectPrestiti();
			assertNotNull(listaAggiornata);
			assertTrue(listaAggiornata.contains(p));
			assertEquals(listaIniziale.size() + 1, listaAggiornata.size());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			model.deletePrestito(p);
			lm.deleteLibro(l);
			um.deleteUtente(u);
		}
	}

	public void testSelectPrestitiPerUtente() throws SQLException {
		Utente u = new Utente("prova_utente", "prova_utente", "prova_utente");
		Libro l = new Libro("prova_libro", "prova_libro", "prova_libro");
		Prestito p = new Prestito(l, u, LocalDate.now(), LocalDate.now());

		UtenteModel um = new UtenteModel();
		LibroModel lm = new LibroModel();

		try {
			ArrayList<Prestito> listaPrestitiUtente = model.selectPrestiti(u);
			assertNotNull(listaPrestitiUtente);
			assertEquals(listaPrestitiUtente.size(), 0);
			
			um.insertUtente(u);
			lm.insertLibro(l);

			assertTrue(model.insertPrestito(p));
			assertTrue(model.insertPrestito(p));
			assertTrue(model.insertPrestito(p));
						
			listaPrestitiUtente = model.selectPrestiti(u);
			assertEquals(listaPrestitiUtente.size(), 3);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			model.deletePrestito(p);
			lm.deleteLibro(l);
			um.deleteUtente(u);
		}
	}
}
