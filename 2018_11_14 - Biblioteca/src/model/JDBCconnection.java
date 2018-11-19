package model;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public abstract class JDBCconnection {
	// variabili di istanza
	private Connection con;

	/**
	 * Permette di ottenere la connessione al database
	 * 
	 * @return un oggetto di tipo connection
	 * @throws SQLException
	 *             in caso di errori di connessione
	 */
	public Connection getConnection() throws SQLException {
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
}
