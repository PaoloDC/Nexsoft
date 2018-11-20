package model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.Libro;
import bean.Prestito;
import bean.Utente;

/**
 * Classe che gestisce la connessione al database per gli oggetti di tipo
 * Prestito
 * 
 * @author Paolo De Cristofaro
 *
 */
public class PrestitoModel extends JDBCconnection {

	// variabili di istanza
	private final Logger LOG = LoggerFactory.getLogger(PrestitoModel.class);

	/**
	 * Seleziona tutti i record prestiti presenti sul database
	 * 
	 * @return una lista che contiene tutti i prestiti
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public ArrayList<Prestito> selectPrestiti() throws SQLException {
		LOG.debug("entro nel metodo selectPrestiti");
		String sql = "SELECT ISBN,titolo,autore,dataInizio,dataFine,CF,nome,cognome "
				+ "FROM libri JOIN prestiti ON prestiti.libro = libri.ISBN JOIN utenti ON utenti.CF = prestiti.utente ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Prestito> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Prestito p = new Prestito();

			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));
			p.setLibro(l);

			Date dataInizio = rs.getDate(4);
			Date dataFine = rs.getDate(5);

			LocalDate inizio = dataInizio.toLocalDate();
			LocalDate fine = null;

			if (dataFine != null)
				fine = dataFine.toLocalDate();

			p.setDataInizio(inizio);
			p.setDataFine(fine);

			Utente u = new Utente();
			u.setCF(rs.getString(6));
			u.setNome(rs.getString(7));
			u.setCognome(rs.getString(8));
			p.setUtente(u);
			
			daRestituire.add(p);
		}
		LOG.debug("esco dal metodo selectPrestiti");
		return daRestituire;
	} // fine metodo selectPrestiti

	/**
	 * Seleziona i record prestiti di un certo utente
	 * 
	 * @param u
	 *            l'utente per cui ricercare i record prestiti
	 * 
	 * @return una lista che contiene tutti i prestiti dell'utente inserito
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public ArrayList<Prestito> selectPrestiti(Utente u) throws SQLException {
		String sql = "SELECT ISBN,titolo,autore,dataInizio,dataFine FROM libri "
				+ "JOIN prestiti ON prestiti.libro = libri.ISBN WHERE utente = ? ORDER BY dataInizio DESC";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, u.getCF());
		ResultSet rs = ps.executeQuery();

		ArrayList<Prestito> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));

			Prestito p = new Prestito();
			p.setLibro(l);
			p.setUtente(u);

			Date dataInizio = rs.getDate(4);
			Date dataFine = rs.getDate(5);

			LocalDate inizio = dataInizio.toLocalDate();
			LocalDate fine = null;

			if (dataFine != null)
				fine = dataFine.toLocalDate();

			p.setDataInizio(inizio);
			p.setDataFine(fine);

			daRestituire.add(p);
		}
		return daRestituire;
	} // fine metodo selectPrestiti

	/**
	 * Inserisce un nuovo record prestito sul database
	 * 
	 * @param p
	 *            il prestito da memorizzare
	 * @return il prestito appena inserito
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public boolean insertPrestito(Prestito p) throws SQLException {
		String sql = "INSERT INTO prestiti (utente, libro, dataInizio, dataFine) VALUES (?,?,?,?)";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, p.getUtente().getCF());
		ps.setString(2, p.getLibro().getIsbn());
		ps.setDate(3, Date.valueOf(p.getDataInizio()));

		if (null == p.getDataFine()) {
			ps.setNull(4, java.sql.Types.DATE);
		} else {
			ps.setDate(4, Date.valueOf(p.getDataFine()));
		}

		int id = ps.executeUpdate();
		if (1 == id)
			return true;
		return false;
	} // fine metodo insertPrestito

	/**
	 * Seleziona tutti i prestiti ancora in corso (quelli con dataFine pari a null)
	 * 
	 * @return una lista di prestiti
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public ArrayList<Prestito> selectPrestitiInCorso() throws SQLException {
		LOG.debug("entro nel metodo selectPrestiti");
		String sql = " SELECT ISBN,titolo,autore,dataInizio,CF,nome,cognome "
				+ "FROM libri JOIN prestiti ON prestiti.libro = libri.ISBN JOIN utenti ON utenti.CF = prestiti.utente "
				+ "WHERE dataFine is null; ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Prestito> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Date dataInizio = rs.getDate(4);

			LocalDate inizio = dataInizio.toLocalDate();

			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));

			Utente u = new Utente();
			u.setCF(rs.getString(5));
			u.setNome(rs.getString(6));
			u.setCognome(rs.getString(7));

			Prestito p = new Prestito();
			p.setLibro(l);
			p.setUtente(u);
			p.setDataInizio(inizio);
			p.setDataFine(null);

			daRestituire.add(p);
		}
		LOG.debug("esco dal metodo selectPrestiti");
		return daRestituire;
	} // fine metodo selectPrestitiInCorso

	/**
	 * Seleziona tutti gli utenti che hanno effettuato almeno un prestito indicando
	 * per ogni utente il numero di prestiti associato
	 * 
	 * @return una lista di oggetti classifica
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public ArrayList<Classifica> selectUtenteNumeroPrestiti() throws SQLException {
		String sql = " SELECT cf,nome,cognome,COUNT(utente) as num FROM prestiti "
				+ "JOIN utenti ON prestiti.utente = utenti.CF GROUP BY utente ORDER BY num DESC ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Classifica> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Utente u = new Utente();
			u.setCF(rs.getString(1));
			u.setNome(rs.getString(2));
			u.setCognome(rs.getString(3));
			int num = rs.getInt(4);
			daRestituire.add(new Classifica(u, num, null));
		}

		return daRestituire;
	} // fine metodo selectUtenteNumeroPrestiti

	/**
	 * classe interna per modellare una entry di una classifica
	 * 
	 * @author Paolo De Cristofaro
	 *
	 */
	public final class Classifica {

		// variabili di istanza
		private int numeroPrestiti;
		private Utente utente;
		private Libro libro;

		// costruttore
		public Classifica(Utente u, int num, Libro l) {
			this.utente = u;
			this.numeroPrestiti = num;
			this.libro = l;
		}

		// metodi getter
		public Utente getUtente() {
			return utente;
		}

		public int getNumeroPrestiti() {
			return numeroPrestiti;
		}

		public Libro getLibro() {
			return libro;
		}
	} // fine classe Classifica

	/**
	 * Seleziona tutti i libri che sono stati prestati almeno una volta, indicando
	 * per ogni libro il numero di volte che è stao prestato
	 * 
	 * @return una lista di oggetti classifica
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public ArrayList<Classifica> selectLibriNumeroPrestiti() throws SQLException {
		String sql = "SELECT DISTINCT isbn,titolo,autore,COUNT(utente) as num FROM prestiti "
				+ "JOIN libri ON prestiti.libro = libri.isbn GROUP BY libro ORDER BY num DESC ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Classifica> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));
			int num = rs.getInt(4);
			daRestituire.add(new Classifica(null, num, l));
		}

		return daRestituire;
	} // fine metodo selectLibriNumeroPrestiti

	/**
	 * Imposta la data di fine di un prestito, indicando l'utente, il libro e
	 * imposta come data quella attuale
	 * 
	 * @param u
	 *            l'utente che sta chiudendo il prestito
	 * @param l
	 *            il libro che è stato restituito
	 * @return true se la restituzione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */
	public boolean impostaDataFinePrestito(Utente u, Libro l) throws SQLException {
		String sql = "UPDATE prestiti SET dataFine = ? WHERE utente = ? AND libro = ? AND dataFine IS NULL ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setDate(1, new Date(System.currentTimeMillis()));
		ps.setString(2, u.getCF());
		ps.setString(3, l.getIsbn());
		LOG.debug("PreparedStatement selectPrestiti: " + ps);

		int i = ps.executeUpdate();
		if (1 == i)
			return true;
		return false;
	} // fine metodo impostaDataFinePrestito

	/**
	 * Imposta la data di fine di un prestito, indicando l'utente, il libro e
	 * imposta come data quella passata
	 * 
	 * @param u
	 *            utente che sta chiudendo il prestito
	 * @param l
	 *            il libro che è stato restituito
	 * @param dataFine
	 *            LocalDate che indica la data di restituzione
	 * @return true se la restituzione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errore di connessione al db
	 */

	public boolean impostaDataFinePrestito(Utente u, Libro l, LocalDate dataFine) throws SQLException {
		String sql = "UPDATE prestiti SET dataFine = ? WHERE utente = ? AND libro = ? AND dataFine IS NULL ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setDate(1, Date.valueOf(dataFine));
		ps.setString(2, u.getCF());
		ps.setString(3, l.getIsbn());
		LOG.debug("PreparedStatement selectPrestiti: " + ps);

		int i = ps.executeUpdate();
		if (1 == i)
			return true;
		return false;
	} // fine metodo impostaDataFinePrestito

	public boolean deletePrestito(Prestito p) throws SQLException {
		String sql = "DELETE FROM prestiti WHERE utente = ? AND libro = ? AND dataInizio = ? AND dataFine = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, p.getUtente().getCF());
		ps.setString(2, p.getLibro().getIsbn());
		ps.setDate(3, Date.valueOf(p.getDataInizio()));
		ps.setDate(4, Date.valueOf(p.getDataFine()));
		
		int i = ps.executeUpdate();

		if (1 == i)
			return true;
		return false;
	}
} // fine classe
