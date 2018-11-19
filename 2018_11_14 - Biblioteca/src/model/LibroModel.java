package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.jdbc.MysqlDataSource;

import bean.Libro;

/**
 * Classe che gestisce la connessione al database per gli oggetti di tipo Libro
 * 
 * @author Paolo De Cristofaro
 *
 */
public class LibroModel {
	
	// variabili di istanza
	private Connection con;

	/**
	 * Permette di ottenere la connessione al database
	 * 
	 * @return un oggetto di tipo connection
	 * @throws SQLException
	 *             in caso di errori di connessione
	 */
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
	} //fine metodo getConnection

	/**
	 * Seleziona tutti i libri presenti nella tabella 'libri' del db
	 * 
	 * @return un arraylist che contiene tutti i libri
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public ArrayList<Libro> selectLibri() throws SQLException {
		String sql = "SELECT ISBN, titolo, autore FROM libri";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Libro> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));
			daRestituire.add(l);
		}
		return daRestituire;
	} //fine metodo selectLibri

	/**
	 * Seleziona un singolo libro, ricercato in base alla chiave primaria
	 * 
	 * @param isbn
	 *            stringa che contiene il codice univoco del libro
	 * @return un oggetto di tipo libro, null se il libro con quel codice isbn non è
	 *         presente
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public Libro selectLibroByIsbn(String isbn) throws SQLException {
		String sql = "SELECT ISBN, titolo, autore FROM libri WHERE ISBN = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();

		if (!rs.next())
			throw new SQLException();

		Libro l = new Libro();
		l.setIsbn(rs.getString(1));
		l.setTitolo(rs.getString(2));
		l.setAutore(rs.getString(3));

		return l;
	} //fine metodo selectLibroByIsbn

	/**
	 * Crea una mappa con tutti i libri presenti sul db, dove il codice univoco del
	 * libro fa da chiave
	 * 
	 * @return una hashmap di libri
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public HashMap<String, Libro> selectMappaLibri() throws SQLException {
		String sql = "SELECT ISBN, titolo, autore FROM libri";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		HashMap<String, Libro> daRestituire = new HashMap<>();

		while (rs.next()) {
			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));
			daRestituire.put(l.getIsbn(), l);
		}
		return daRestituire;
	} //fine metodo selectMappaLibri

	/**
	 * Inserisce un nuovo libro sul db
	 * 
	 * @param l
	 *            oggetto Libro da inserire
	 * @return true se l'inserimento va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean insertLibro(Libro l) throws SQLException {
		String sql = "INSERT INTO libri (ISBN, titolo, autore) VALUES (?,?,?)";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, l.getIsbn());
		ps.setString(2, l.getTitolo());
		ps.setString(3, l.getAutore());

		int i = ps.executeUpdate();
		if (1 == i)
			return true;
		return false;
	} //fine metodo insertLibro

	/**
	 * Elimina il libro dal database (se presente)
	 * 
	 * @param l
	 *            oggetto Libro da eliminare dal db
	 * @return true se l'eliminazione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean deleteLibro(Libro l) throws SQLException {
		String sql = "DELETE FROM libri WHERE isbn = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, l.getIsbn());

		int i = ps.executeUpdate();
		if (1 == i)
			return true;
		return false;
	} //fine metodo deleteLibro

	/**
	 * Elimina il libro dal database (se presente)
	 * 
	 * @param isbn
	 *            stringa che identifica l'oggetto libro
	 * @return true se l'eliminazione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean deleteLibro(String isbn) throws SQLException {
		String sql = "DELETE FROM libri WHERE isbn = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, isbn);

		int i = ps.executeUpdate();
		if (1 == i)
			return true;
		return false;
	} //fine metodo deleteLibro

	
	/**
	 * Restituisce una lista di libri disponibili, cioè che non sono attualmente in prestito
	 * @return ArrayList di libri
	 * @throws SQLException in caso di errore di connessione al db
	 */
	public ArrayList<Libro> selectLibriDisponibiliPerRitiro() throws SQLException {
		String sql = "SELECT ISBN,titolo,autore FROM libri JOIN prestiti ON libri.ISBN = prestiti.libro WHERE dataFine IS NOT NULL";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Libro> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Libro l = new Libro();
			l.setIsbn(rs.getString(1));
			l.setTitolo(rs.getString(2));
			l.setAutore(rs.getString(3));
			daRestituire.add(l);
		}
		return daRestituire;
	}
	
}
