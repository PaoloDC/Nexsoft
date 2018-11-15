package database.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.MysqlDataSource;

import database.bean.Cliente;
import database.eccezioni.ClienteNonTrovatoException;

public class ClienteModel {
	// variabili di istanza
	private Connection con;
	private final Logger LOG = LoggerFactory.getLogger(ClienteModel.class);
	
	private Connection getConnection() throws SQLException {
		if (con == null) {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setServerName("127.0.0.1");
			ds.setPortNumber(3306);
			ds.setUser("root");
			ds.setPassword("root");
			ds.setDatabaseName("corso_java");
			ds.setServerTimezone("Europe/Amsterdam");

			con = ds.getConnection();
		}
		return con;
	}

	public ArrayList<Cliente> selectClienti() throws SQLException {
		LOG.debug("entro nel metodo selectClienti");
		String sql = "SELECT id, nome, cognome, email, telefono FROM clienti";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectClienti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Cliente> allClienti = new ArrayList<>();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setCognome(rs.getString(3));
			c.setEmail(rs.getString(4));
			c.setTelefono(rs.getString(5));
			allClienti.add(c);
		}
		LOG.debug("esco dal metodo selectClienti");
		return allClienti;
	}

	public Cliente selectClienteByID(int id) throws SQLException {
		LOG.debug("entro nel metodo selectClienteByID");
		String sql = "SELECT id, nome, cognome, email, telefono FROM clienti where id = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		LOG.debug("PreparedStatement selectClienteByID: " + ps);

		ResultSet rs = ps.executeQuery();

		if (!rs.next())
			throw new ClienteNonTrovatoException();

		Cliente c = new Cliente();
		c.setId(rs.getInt(1));
		c.setNome(rs.getString(2));
		c.setCognome(rs.getString(3));
		c.setEmail(rs.getString(4));
		c.setTelefono(rs.getString(5));
		LOG.debug("esco dal metodo selectClienteByID");
		return c;
	}

	public ArrayList<Cliente> selectClienti(String campo, String chiave) throws SQLException {
		LOG.debug("entro nel metodo selectClienti");
		String sql = "SELECT id, nome, cognome, email, telefono FROM clienti WHERE " + campo + " LIKE ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		chiave = "%" + chiave + "%";
		ps.setString(1, chiave);

		LOG.debug("PreparedStatement selectClienti<C,C>: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Cliente> allClienti = new ArrayList<>();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setCognome(rs.getString(3));
			c.setEmail(rs.getString(4));
			c.setTelefono(rs.getString(5));
			allClienti.add(c);
		}
		LOG.debug("esco dal metodo selectClienti");
		return allClienti;
	}

	public void insertCliente(Cliente c) throws SQLException {
		LOG.debug("entro nel metodo insertCliente");
		String sql = "INSERT INTO clienti(nome, cognome, email, telefono) VALUES  (?,?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, c.getNome());
		ps.setString(2, c.getCognome());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getTelefono());

		LOG.debug("PreparedStatement insertCliente: " + ps);
		int i = ps.executeUpdate();
		System.out.println("NUOVO ID: " + i);

		LOG.debug("esco dal metodo insertCliente");
	}
	
	public int insertCliente(String nome,String cognome,String email,String telefono) throws SQLException {
		LOG.debug("entro nel metodo insertCliente");
		String sql = "INSERT INTO clienti(nome, cognome, email, telefono) VALUES  (?,?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, nome);
		ps.setString(2, cognome);
		ps.setString(3, email);
		ps.setString(4, telefono);

		LOG.debug("PreparedStatement insertCliente: " + ps);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		LOG.debug("esco dal metodo insertCliente");
		return rs.getInt(1);
	}
	
	public void deleteCliente(int id) throws SQLException {
		LOG.debug("entro nel metodo deleteCliente");
		String sql = "DELETE FROM clienti WHERE id = ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id);

		LOG.debug("PreparedStatement deleteCliente: " + ps);
		ps.executeUpdate();
		LOG.debug("esco dal metodo deleteCliente");
	}
	
	public ArrayList<Integer> selectIDsClienti() throws SQLException {
		LOG.debug("entro nel metodo selectIDsClienti");
		String sql = "SELECT id FROM clienti";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		LOG.debug("PreparedStatement selectIDsClienti: " + ps);
		ResultSet rs = ps.executeQuery();

		ArrayList<Integer> listaID = new ArrayList<>();
		
		while (rs.next()) {
			listaID.add(rs.getInt(1));
		}
		LOG.debug("esco dal metodo selectIDsClienti");
		return listaID;
	}
}
