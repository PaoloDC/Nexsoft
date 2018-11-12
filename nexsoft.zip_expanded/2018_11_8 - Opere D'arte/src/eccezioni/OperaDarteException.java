package eccezioni;

public class OperaDarteException extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "Eccezione: L'opera d'arte non è stata trovata";
	}
	
	public String getMessage(String msg) {
		return "Eccezione: " + msg;
	}
}
