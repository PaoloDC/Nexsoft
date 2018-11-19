package model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import bean.Utente;
import junit.framework.TestCase;

public class UtenteModelTest extends TestCase {

	// variabili di istanza
	private static UtenteModel model = new UtenteModel();

	/**
	 * Testa il metodo selectUtenti che prende tutti i record della tabella utenti,
	 * inserisce un nuovo utente e verifica che la lista lo contenga
	 * 
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	@Test
	public void testSelectUtenti() throws SQLException {
		ArrayList<Utente> listaUtentiIniziale = model.selectUtenti();
		assertNotNull(listaUtentiIniziale);

		Utente u = new Utente("", "", "");

		assertTrue(model.insertUtente(u));

		ArrayList<Utente> listaUtenti = model.selectUtenti();

		assertEquals(listaUtentiIniziale.size(), listaUtenti.size() - 1);

		assertTrue(model.deleteUtente(u));
	}

	/**
	 * Testa il metodo selectUtenteByCF, inserisce un nuovo record nella tabella
	 * utenti, e lo riprende con l'apposito metodo
	 * 
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	@Test
	public void testSelectUtenteByCF() throws SQLException {
		Utente u = new Utente("", "", "");

		assertTrue(model.insertUtente(u));

		Utente temp = model.selectUtenteByCF(u.getCF());
		assertEquals(u, temp);

		assertTrue(model.deleteUtente(u));
	}

	/**
	 * Testa il metodo selectMappaUtenti, inserisce un nuovo record nella tabella
	 * utenti, controlla che sia stato inserito nella mappa e verifica che l'oggetto
	 * nella mappa sia lo stesso
	 * 
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	@Test
	public void testSelectMappaUtenti() throws SQLException {
		HashMap<String, Utente> mappaIniziale = model.selectMappaUtenti();
		assertNotNull(mappaIniziale);

		Utente u = new Utente("", "", "");
		assertTrue(model.insertUtente(u));
		assertFalse(mappaIniziale.containsKey(u.getCF()));

		HashMap<String, Utente> mappa = model.selectMappaUtenti();
		assertNotNull(mappa);

		assertTrue(mappa.containsKey(u.getCF()));

		assertEquals(mappaIniziale.size(), mappa.size() - 1);

		Utente get = mappa.get(u.getCF());
		assertEquals(get, u);

		assertTrue(model.deleteUtente(u.getCF()));
	}

	/**
	 * Testa il metodo insert utente
	 * 
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	@Test
	public void testInsertUtente() throws SQLException {
		Utente u = new Utente("", "", "");
		assertTrue(model.insertUtente(u));

		assertThrows(SQLIntegrityConstraintViolationException.class, () -> model.insertUtente(u));

		assertTrue(model.deleteUtente(u.getCF()));
	}
}
