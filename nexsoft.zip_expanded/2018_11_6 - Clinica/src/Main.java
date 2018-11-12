/**
 * Data la seguente enumerazione:
 * enum Specialista { OCULISTA, PEDIATRA; }
 * Realizzare la classe Clinica, che permette di prenotare e cancellare visite mediche. I metodi
 * prenota e cancellaPrenotazione accettano uno Specialista e il nome di un paziente, ed effettuano
 * o cancellano la prenotazione, rispettivamente. Il metodo getPrenotati restituisce l’elenco dei
 * prenotati.
 * La classe deve rispettare le seguenti proprietà:
 * a) Non ci si può prenotare con più di uno Specialista.
 * b) Si deve poter aggiungere uno Specialista all’enumerazione senza dover modificare la classe Clinica.
 * @author Paolo De Cristofaro
 *
 */
public class Main {
	public static void main (String[] args) {
		Clinica c = new Clinica();
		
		//inserimenti
		c.prenota("Marco", Clinica.Specialista.OCULISTA);
		c.prenota("Luca", Clinica.Specialista.OCULISTA);
		c.prenota("Paolo", Clinica.Specialista.PEDIATRA);
		c.prenota("Michele", Clinica.Specialista.PEDIATRA);
		
		System.out.println("\n" + c.getPrenotati());
		System.out.println(c.getPrenotatiStringa());
		
		System.out.println("false: " + c.prenota("Marco", Clinica.Specialista.DENTISTA)); //false
		System.out.println("false: " + c.prenota("Marco", Clinica.Specialista.OCULISTA)); //false
		
		System.out.println("false: " + c.cancellaPrenotazione("Marco", Clinica.Specialista.PEDIATRA)); //false
		System.out.println("true: " + c.cancellaPrenotazione("Marco", Clinica.Specialista.OCULISTA)); //true
		
		System.out.println(c.getPrenotatiStringa());
		
		System.out.println("true: " + c.prenota("Marco", Clinica.Specialista.PEDIATRA)); //true
		System.out.println("false: " + c.prenota("Marco", Clinica.Specialista.OCULISTA)); //false
		
		System.out.println("\n" + c.getPrenotati());
		System.out.println(c.getPrenotatiStringa());
		
		System.out.println(c.getPrenotatiLista());
		
	}
}
