package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.jdbc.MysqlDataSource;

import bean.Utente;

public class UtenteModel {
	// variabili di istanza
		private Connection con;

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
		}
		
		public Utente selectUtenteByCF(String cf) throws SQLException {
			String sql = "SELECT CF, nome, cognome FROM utenti WHERE CF = ?";

			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cf);
			ResultSet rs = ps.executeQuery();

			if(!rs.next())
				throw new SQLException();
			
			Utente u = new Utente();
			u.setCF(rs.getString(1));
			u.setNome(rs.getString(2));
			u.setCognome(rs.getString(3));
			return u;
		}
		
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
		}
		
		public void insertUtente(Utente u) throws SQLException {
			String sql = "INSERT INTO utenti(CF, nome, cognome) VALUES (?,?,?)";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, u.getCF());
			ps.setString(2, u.getNome());
			ps.setString(3, u.getCognome());
			
			ps.executeUpdate();
		}
		
		public void deleteUtente(Utente u) throws SQLException {
			String sql = "DELETE FROM utenti WHERE CF = ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, u.getCF());
			
			ps.executeUpdate();
		}
		
		public void deleteUtente(String cf) throws SQLException {
			String sql = "DELETE FROM utenti WHERE CF = ?";
			
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ps.setString(1, cf);
			
			ps.executeUpdate();
		}

		
}
