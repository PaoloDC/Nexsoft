package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mysql.cj.jdbc.MysqlDataSource;

import bean.Libro;

public class LibroModel {
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
	}

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
	}
			
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
			daRestituire.put(l.getIsbn(),l);
		}
		return daRestituire;
	}
	
	public void insertLibro(Libro l) throws SQLException {
		String sql = "INSERT INTO libri (ISBN, titolo, autore) VALUES (?,?,?)";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, l.getIsbn());
		ps.setString(2, l.getTitolo());
		ps.setString(3, l.getAutore());
		
		ps.executeUpdate();
	}
	
	public void deleteLibro(Libro l) throws SQLException {
		String sql = "DELETE FROM libri WHERE isbn = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, l.getIsbn());
		
		ps.executeUpdate();
	}
	
	public void deleteLibro(String isbn) throws SQLException {
		String sql = "DELETE FROM libri WHERE isbn = ?";
		
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setString(1, isbn);
		
		ps.executeUpdate();
	}

			
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}
