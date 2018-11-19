package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.jdbc.MysqlDataSource;

import bean.Utente;

/**
 * Classe che gestisce la connessione al database per gli oggetti di tipo Utente
 * 
 * @author Paolo De Cristofaro
 *
 */
public class UtenteModel {

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
	} // fine metodo getConnection

	/**
	 * Seleziona tutti gli utenti presenti nella tabella utenti del db
	 * 
	 * @return un ArrayList che contiene tutti gli utenti
	 * @throws SQLException
	 *             in caso di errori di connessione
	 */
	public ArrayList<Utente> selectUtenti() throws SQLException {
		String sql = "SELECT CF, nome, cognome FROM utenti";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Utente> daRestituire = new ArrayList<>();

		while (rs.next()) {
			Utente u = new Utente();
			u.setCF(rs.getString(1));
			u.setNome(rs.getString(2));
			u.setCognome(rs.getString(3));
			daRestituire.add(u);
		}
		return daRestituire;
	} // fine metodo selectUtenti

	/**
	 * Seleziona l'utente che corrisponde al codice fiscale inserito
	 * 
	 * @param cf
	 *            stringa che identifica l'utente
	 * @return l'utente corrispondente
	 * @throws SQLException
	 *             in caso di errori di connessione o se non trova nessun utente
	 */
	public Utente selectUtenteByCF(String cf) throws SQLException {
		String sql = "SELECT CF, nome, cognome FROM utenti WHERE CF = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, cf);
		ResultSet rs = ps.executeQuery();

		if (!rs.next())
			throw new SQLException();

		Utente u = new Utente();
		u.setCF(rs.getString(1));
		u.setNome(rs.getString(2));
		u.setCognome(rs.getString(3));
		return u;
	} // fine metodo selectUtenteByCF

	/**
	 * Crea una mappa con tutti gli utenti presenti sul db, dove il codice univoco
	 * dell'utente (il codice fiscale) fa da chiave
	 * 
	 * @return una hashmap di utenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public HashMap<String, Utente> selectMappaUtenti() throws SQLException {
		String sql = "SELECT CF, nome, cognome FROM utenti";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		HashMap<String, Utente> daRestituire = new HashMap<>();

		while (rs.next()) {
			Utente u = new Utente();
			u.setCF(rs.getString(1));
			u.setNome(rs.getString(2));
			u.setCognome(rs.getString(3));
			daRestituire.put(u.getCF(), u);
		}
		return daRestituire;
	} // fine metodo selectMappaUtenti

	/**
	 * Inserisce un nuovo record utente sul db
	 * 
	 * @param u
	 *            l'utente da memorizzare sul db
	 * @return true se l'inserimento va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean insertUtente(Utente u) throws SQLException {
		String sql = "INSERT INTO utenti(CF, nome, cognome) VALUES (?,?,?)";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, u.getCF());
		ps.setString(2, u.getNome());
		ps.setString(3, u.getCognome());

		ps.executeUpdate();
				
		return true;
	}// fine metodo insertUtente

	/**
	 * Elimina un record utente sul db
	 * 
	 * @param u
	 *            l'utente da eliminare sul db
	 * @return true se l'eliminazione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean deleteUtente(Utente u) throws SQLException {
		String sql = "DELETE FROM utenti WHERE CF = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, u.getCF());

		int i = ps.executeUpdate();
		if (i == 1)
			return true;
		return false;
	}// fine metodo deleteUtente

	/**
	 * Elimina un record utente sul db
	 * 
	 * @param cf
	 *            stringa che identifica l'utente da eliminare
	 * @return true se l'eliminazione va a buon fine, false altrimenti
	 * @throws SQLException
	 *             in caso di errori di connessione al db
	 */
	public boolean deleteUtente(String cf) throws SQLException {
		String sql = "DELETE FROM utenti WHERE CF = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, cf);

		int i = ps.executeUpdate();
		if (i == 1)
			return true;
		return false;
	}// fine metodo deleteUtente

}
