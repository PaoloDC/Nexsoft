package database.eccezioni;

import java.sql.SQLException;

public class ClienteNonTrovatoException extends SQLException {
	private static final long serialVersionUID = -6563846874235071139L;


	@Override
	public String getMessage() {
		return "Cliente Non Trovato!";
	}
}
