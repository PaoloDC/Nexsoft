import eccezioni.OperaDarteException;
import operedarte.Collezione;
import operedarte.Quadro;
import operedarte.Scultura;

/**
 * Esercizio no.7 Realizza una opportuna gerarchia di classi per modellare una
 * collezione (C) identificata da un nome, da un luogo, da un insieme di opere
 * d'arte e dalle informazioni relative al loro ingombro. Radice della gerarchia
 * è la classe astratta operadarte (OD) contenente : — i campi protetti titolo
 * artista — il costruttore — il metodo public abstract double printingombro()
 * che restituisce l'ingombro dell'opera — il metodo public boolean
 * equals(Object o) che verifica se due opere d'arte sono uguali ed altri metodi
 * di interesse. La sottoclasse quadro (Q) ha due variabili aggiuntive:altezza e
 * larghezza che identificano la misura del quadro. La sottoclasse scultura (S)
 * ha 3 variabili aggiuntive altezza larghezza e profondità che identificano le
 * misure della scultura. Implementare le due classi concretizzando il metodo
 * ingombro(). Realizzare poi, una classe collezione identificata da un nome e
 * da un insieme di opere d'arte scrivere i seguenti metodi: inserire un opera
 * d'arte, stampare la collezione , stampare l'occupazione di una data opera .
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Tester {

	public static void main(String[] args) {
		Scultura s1 = new Scultura("Venere di Milo", "Michelangelo", 200, 50, 50);
		Scultura s11 = new Scultura("Venere di Milo", "Michelangelo", 200, 50, 50);

		System.out.println("true : " + s1.equals(s11));
		System.out.println("false : " + s1.equals(null));

		Scultura s2 = new Scultura("David", "Michelangelo", 517, 199, 80);
		Scultura s3 = new Scultura("Amore e Psiche", "Antonio Canova", 155, 168, 100);

		Quadro q1 = new Quadro("Gioconda", "Leonardo da Vinci", 77, 53);
		Quadro q2 = new Quadro("Dama con l'ermellino", "Leonardo da Vinci", 54, 39);
		Quadro q3 = new Quadro("La persistenza della memoria", "Salvador Dalí", 24, 33);

		final String NOME_COLLEZIONE = "MyCollection";

		Collezione c = new Collezione(NOME_COLLEZIONE);
		System.out.println("\nTENTATIVO 1: COLLEZIONE VUOTA\n" + c);
		System.out.println(c.getNome());
		System.out.println(c.getListaOpere());
		try {
			System.out.println("-1 : " + c.getIngombroCollezione());
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("-1 : " + c.getIngombroOpera(""));
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}

		c.inserisciOperaDarte(s1);
		c.inserisciOperaDarte(s2);
		c.inserisciOperaDarte(s3);
		c.inserisciOperaDarte(q1);
		c.inserisciOperaDarte(q2);
		c.inserisciOperaDarte(q3);

		System.out.println("\nTENTATIVO 2: COLLEZIONE CON 6 ELEMENTI\n" + c);
		System.out.println(c.getListaOpere());

		try {
			System.out.println(c.getIngombroCollezione());
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(200 * 50 * 50 + " : " + c.getIngombroOpera(s1));
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}

		c.inserisciOperaDarte("1", "1", 1, 1, 1);
		c.inserisciOperaDarte("2", "2", 2, 2);

		try {
			System.out.println(2 * 2 + " : " + c.getIngombroOpera(new Quadro("2", "2", 2, 2)));
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(2 * 2 + " : " + c.getIngombroOpera("2"));
		} catch (OperaDarteException e) {
			e.printStackTrace();
		}

		System.out.println("\n\n" + c.stampaCollezione());
		System.out.println(c);

		c.salvaCollezioneSuFile();

		Collezione c2 = new Collezione("");
		c2.caricaCollezioneDaFile();
		c2.setNome("C2");
		System.out.println("\n\n" + c2.stampaCollezione());
	}

}
