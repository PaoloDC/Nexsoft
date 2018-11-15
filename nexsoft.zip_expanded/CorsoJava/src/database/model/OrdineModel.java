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

import database.Main;
import database.bean.Ordine;

public class OrdineModel {
	// variabili di istanza
	private Connection con;
	private static final Logger LOG = LoggerFactory.getLogger(OrdineModel.class);

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

	public ArrayList<Ordine> selectOrdini() throws SQLException {
		String sql = "SELECT id, id_cliente, data_consegna, importo FROM ordini";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		ArrayList<Ordine> allOrdini = new ArrayList<>();

		while (rs.next()) {
			Ordine o = new Ordine();
			o.setId(rs.getInt(1));
			o.setIdCliente(rs.getInt(2));
			o.setData(rs.getString(3));
			o.setImporto(rs.getDouble(4));
			allOrdini.add(o);
		}
		return allOrdini;
	}

	public Ordine selectOrdineById(int id) throws SQLException {
		String sql = "SELECT id, id_cliente, data_consegna, importo FROM ordini WHERE id = ?";

		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();

		if (!rs.next())
			return null;
		
		Ordine o = new Ordine();
		o.setId(rs.getInt(1));
		o.setIdCliente(rs.getInt(2));
		o.setData(rs.getString(3));
		o.setImporto(rs.getDouble(4));
		
		return o;
	}
	
	public int insertOrdine(int idCliente,String data,double importo) throws SQLException {
		Main.LOG.debug("entro nel metodo insertOrdine");
		String sql = "INSERT INTO ordini(id_cliente, data_consegna, importo) VALUES  (?,?,?)";
		PreparedStatement ps = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1, idCliente);
		ps.setString(2, data);
		ps.setDouble(3, importo);

		Main.LOG.debug("PreparedStatement insertOrdine: " + ps);
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		
		Main.LOG.debug("esco dal metodo insertOrdine");
		return rs.getInt(1);
	}
	
	public void deleteOrdine(int id) throws SQLException {
		Main.LOG.debug("entro nel metodo deleteOrdine");
		String sql = "DELETE FROM ordini WHERE id = ?";
		PreparedStatement ps = getConnection().prepareStatement(sql);
		ps.setInt(1, id);

		Main.LOG.debug("PreparedStatement deleteOrdine: " + ps);
		ps.executeUpdate();
		Main.LOG.debug("esco dal metodo deleteOrdine");
	}
}
