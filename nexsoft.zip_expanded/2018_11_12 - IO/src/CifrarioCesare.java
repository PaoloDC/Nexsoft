import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Classe che modella un cifrario di cesare, con cui è possibile cifrare delle
 * frasi in base ad una certa chiave, il valore della chiave indica lo shift a
 * destra da eseguire per ogni singola lettera
 * 
 * @author Paolo De Cristofaro
 *
 */
public class CifrarioCesare {

	// variabili di istanza
	public static final String PERCORSO_FILE = "cifrato.txt";
	private final String MINUSCOLE = "abcdefghijklmnopqrstuvwxyz";
	private int chiave;

	// costruttore
	/**
	 * Istanzia un nuovo cifrario di Cesare
	 * 
	 * @param chiave
	 *            intero che indica lo shift a destra da eseguire per ogni carattere
	 */
	public CifrarioCesare(int chiave) {
		if (chiave < 0 || chiave > 25) {
			chiave = 0;
		}
		this.chiave = chiave;
	}

	// metodi
	public int getChiave() {
		return chiave;
	}

	/**
	 * Cifra la stringa secondo in cifrario di Cesare
	 * 
	 * @param input
	 *            una stringa in chiaro da cifrato
	 * @return una stringa cifrata
	 */
	private String cifra(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (MINUSCOLE.contains("" + c)) {
				int pos = c + chiave;
				if (pos > 122) {
					// pos = pos % 123 + 97;
					pos = pos - 26;
				}
				c = (char) pos;
			}
			output += c;
		}
		return output;
	}

	/**
	 * Decifra la stringa in input e la restituisce
	 * 
	 * @param input
	 *            una stringa cifrata
	 * @return una stringa in chiaro
	 */
	private String decifra(String input) {
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if (MINUSCOLE.contains("" + c)) {
				int pos = c - chiave;
				if (pos < 97) {
					pos = pos + 26;
				}
				c = (char) pos;
			}

			output += c;
		}
		return output;
	}

	/**
	 * Legge il file su cui è stata memorizzata una frase cifrata e la decifra
	 * 
	 * @return una stringa che contiene la frase in chiaro
	 * @throws FileNotFoundException
	 *             nel caso in cui il file non esiste
	 */
	public String leggiDecifra() throws FileNotFoundException {
		File f = new File(PERCORSO_FILE);
		if (!f.exists())
			throw new FileCifratoNonTrovatoException();

		Scanner in = null;
		String cifrata = "";

		try {
			in = new Scanner(f);
			cifrata = in.nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return this.decifra(cifrata);
	}

	/**
	 * Prende una stringa in chiaro, la decifra e la salva su un file, se il file
	 * non esiste viene creato
	 * 
	 * @param chiaro
	 *            la stringa in chiaro da cifrare
	 */
	public void InserisciCifraScrivi(String chiaro) {
		chiaro = chiaro.toLowerCase();
		File f = new File(PERCORSO_FILE);
		if (!f.exists())
			try {
				f.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		PrintWriter pw = null;
		try {
			pw = new PrintWriter(f);
			pw.println(this.cifra(chiaro));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

}
