package model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import org.junit.Test;

import bean.Libro;
import junit.framework.TestCase;
import model.LibroModel;

public class LibroModelTest extends TestCase {

	// variabili di istanza
	private static LibroModel model = new LibroModel();

	@Test
	public void testSelectLibri() throws SQLException {
		ArrayList<Libro> listaIniziale = model.selectLibri();
		assertNotNull(listaIniziale);

		Libro l = new Libro("prova", "prova", "prova");
		assertTrue(model.insertLibro(l));

		ArrayList<Libro> listaAggioranta = model.selectLibri();
		assertEquals(listaIniziale.size() + 1, listaAggioranta.size());

		assertTrue(listaAggioranta.contains(l));

		assertTrue(model.deleteLibro(l));
	}

	public void testSelectLibroByIsbn() throws SQLException {
		Libro l = new Libro("prova", "prova", "prova");
		assertTrue(model.insertLibro(l));

		Libro recuperato = model.selectLibroByIsbn(l.getIsbn());
		assertEquals(l, recuperato);

		assertTrue(model.deleteLibro(l));
	}

	public void testInsertLibro() throws SQLException
	{
		Libro l = new Libro("prova", "prova", "prova");
		assertTrue(model.insertLibro(l));

		assertThrows(SQLIntegrityConstraintViolationException.class, ()-> model.insertLibro(l));

		assertTrue(model.deleteLibro(l));
	}
}
