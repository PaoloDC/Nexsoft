package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.jdbc.MysqlDataSource;

import bean.Libro;
import bean.Prestito;
import bean.Utente;

public class PrestitoModel {
	// variabili di istanza
	private Connection con;
	private final Logger LOG = LoggerFactory.getLogger(PrestitoModel.class);
	public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	private Connection getConnection() throws SQLException {
		if (con == null) {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setServerName("127.0.0.1");
			ds.setPortNumber(3306);
			ds.setUser("root");
			ds.setPassword("root");
			ds.setDatabaseName("biblioteca");
			ds.setServerTimezone("Europe/Amsterdam");

			con = ds.getConnection();
		}
		return con;
	}

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
			
			String dataInizio = rs.getString(4);
			String dataFine = rs.getString(5);

			LocalDate inizio = LocalDate.parse(dataInizio, FORMATO_DATA);
			LocalDate fine = null;

			if (dataFine != null)
				fine = LocalDate.parse(dataFine, FORMATO_DATA);

			p.setDataInizio(inizio);
			p.setDataFine(fine);

			Utente u = new Utente();
			u.setCF(rs.getString(6));
			u.setNome(rs.getString(7));
			u.setCognome(rs.getString(8));
			
			daRestituire.add(p);
		}
		LOG.debug("esco dal metodo selectPrestiti");
		return daRestituire;
	}

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

			String dataInizio = rs.getString(4);
			String dataFine = rs.getString(5);

			LocalDate inizio = LocalDate.parse(dataInizio, FORMATO_DATA);
			LocalDate fine = null;

			if (dataFine != null)
				fine = LocalDate.parse(dataFine, FORMATO_DATA);

			p.setDataInizio(inizio);
			p.setDataFine(fine);

			daRestituire.add(p);
		}
		return daRestituire;
	}

	/*
	 * public ArrayList<Prestito> selectPrestiti(Utente u) throws SQLException {
	 * LOG.debug("entro nel metodo selectPrestiti"); String sql =
	 * "SELECT utente, libro, dataInizio, dataFine FROM prestiti WHERE utente = ? ORDER BY dataInizio DESC"
	 * ;
	 * 
	 * PreparedStatement ps = getConnection().prepareStatement(sql); ps.setString(1,
	 * u.getCF()); LOG.debug("PreparedStatement selectPrestiti: " + ps); ResultSet
	 * rs = ps.executeQuery();
	 * 
	 * ArrayList<Prestito> daRestituire = new ArrayList<>();
	 * 
	 * while (rs.next()) { Prestito p = new Prestito(); UtenteModel um = new
	 * UtenteModel(); p.setUtente(um.selectUtenteByCF(rs.getString(1)));
	 * 
	 * LibroModel lm = new LibroModel();
	 * p.setLibro(lm.selectLibroByIsbn(rs.getString(2)));
	 * 
	 * String dataInizio = rs.getString(3); String dataFine = rs.getString(4);
	 * 
	 * LocalDate inizio = LocalDate.parse(dataInizio, FORMATO_DATA); LocalDate
	 * fine=null;
	 * 
	 * if(dataFine != null) fine = LocalDate.parse(dataFine, FORMATO_DATA);
	 * 
	 * p.setDataInizio(inizio); p.setDataFine(fine);
	 * 
	 * daRestituire.add(p); } LOG.debug("esco dal metodo selectPrestiti"); return
	 * daRestituire; }
	 */
	public void insertPrestito(Prestito p) throws SQLException {
		String sql = "INSERT INTO prestiti (utente, libro, dataInizio, dataFine) VALUES (?,?,?,?)";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, p.getUtente().getCF());
		ps.setString(2, p.getLibro().getIsbn());

		String dataInizio = p.getDataInizio().format(FORMATO_DATA);
		String dataFine = p.getDataFine().format(FORMATO_DATA);

		ps.setString(3, dataInizio);
		ps.setString(4, dataFine);

		ps.executeUpdate();
	}

	public ArrayList<Prestito> selectPrestitiInCorso() throws SQLException {
		LOG.debug("entro nel metodo selectPrestiti");
		String sql = " SELECT utente, libro, dataInizio, dataFine FROM prestiti WHERE dataFine is null ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Prestito> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Prestito p = new Prestito();
			UtenteModel um = new UtenteModel();
			p.setUtente(um.selectUtenteByCF(rs.getString(1)));

			LibroModel lm = new LibroModel();
			p.setLibro(lm.selectLibroByIsbn(rs.getString(2)));

			String dataInizio = rs.getString(3);
			String dataFine = rs.getString(4);

			LocalDate inizio = LocalDate.parse(dataInizio, FORMATO_DATA);
			LocalDate fine = null;

			if (dataFine != null)
				fine = LocalDate.parse(dataFine, FORMATO_DATA);

			p.setDataInizio(inizio);
			p.setDataFine(fine);

			daRestituire.add(p);
		}
		LOG.debug("esco dal metodo selectPrestiti");
		return daRestituire;
	}

	public HashMap<String, Integer> selectMappaUtenteNumeroPrestiti() throws SQLException {
		HashMap<String, Integer> daRestituire = new HashMap<>();

		String sql = " SELECT utente, COUNT(utente) as num FROM prestiti GROUP BY utente ORDER BY num DESC ";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectPrestiti: " + ps);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			String utente = rs.getString(1);
			int num = rs.getInt(2);
			daRestituire.put(utente, num);
		}

		return daRestituire;
	} // fine metodo selectMappaUtenteNumeroPrestiti()

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
	}

	public final class Classifica {
		private int numeroPrestiti;
		private Utente utente;
		private Libro libro;

		public Classifica(Utente u, int num, Libro l) {
			this.utente = u;
			this.numeroPrestiti = num;
			this.libro = l;
		}

		public Utente getUtente() {
			return utente;
		}

		public int getNumeroPrestiti() {
			return numeroPrestiti;
		}

		public Libro getLibro() {
			return libro;
		}
	}

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
	}

} // fine classe
