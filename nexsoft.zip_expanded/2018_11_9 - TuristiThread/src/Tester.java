/**
 * Un gruppo di 50 turisti si recano a visitare il Louvre per vedere la
 * Gioconda. Per motivi di sicurezza possono entrare nel museo solo 5 persone
 * alla volta. Simulare la suddetta situazione in Java. Ogni turista sarà
 * rappresentato da un Thread; i turisti attenderanno un tempo casuale, quindi
 * cercheranno di entrare nel museo, di vedere il quadro e alla fine usciranno
 * dal museo.
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Tester {

	public static final int NUMERO_VISITATORI = 50;
	
	public static void main(String[] args) {
		System.out.println("Nel museo sono arrivati " + NUMERO_VISITATORI + " visitatori");
		
		Museo museo = new Museo(NUMERO_VISITATORI);
		museo.arrivoTuristiAlMuseo();
		museo.visitaGioconda();
	}

}
