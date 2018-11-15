import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe per testare i metodi della classe CifrarioCesare, con un opportuno
 * menù
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Tester {

	public static void main(String[] args) {

		//per testare l'eccezione
		File f = new File(CifrarioCesare.PERCORSO_FILE);
		f.delete();
		
		int lunghezzaChiave = 1;
		CifrarioCesare cc = new CifrarioCesare(lunghezzaChiave);

		Scanner in = new Scanner(System.in);
		boolean esci = false;
		do {
			System.out.println("\nOperazioni:\n1) Leggi e Decifra\n2) Inserisci, Cifra e Scrivi\n3) Esci\n");
			String valore = in.nextLine();
			switch (valore) {
			case "1":
				System.out.println("Leggo il contenuto del file cifrato");
				String s1 = "";
				boolean errore = false;
				try {
					s1 = cc.leggiDecifra();
				} catch (FileNotFoundException e) {
					System.err.println(e.getMessage());
					errore = true;
				}
				if (!errore)
					System.out.println("La stringa in chiaro è: '" + s1 + "'\n");
				break;
			case "2":
				System.out.println("Digita stringa da cifrare: ");
				String s2 = in.nextLine();
				cc.InserisciCifraScrivi(s2);
				System.out.println("Stringa cifrata salvata correttamente.\n");
				break;
			case "3":
				esci = true;
				break;
			default:
				System.out.println("Comando non disponibile!!! Riprova...\n");
			}
		} while (!esci);
		System.out.println("Programma Terminato");
		in.close();
	}

}
