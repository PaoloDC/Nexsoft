
public class FileCifratoNonTrovatoException extends java.io.FileNotFoundException {


	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "Cifrario di Cesare: File Cifrato Non Trovato!";
	}
}
