package v2;

import java.util.ArrayList;
import java.util.Random;

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

	public static void main(String[] args) {
		Museo museo = new Museo();
		
		ArrayList<Turista> listaTuristi = new ArrayList<>();
		for(int i=0 ; i < 50; i++) {
			listaTuristi.add(new Turista(i,(new Random().nextInt(5) + 5) * 1000));
			listaTuristi.get(i).start();
		}
		
		int i=0 ; 
		while(listaTuristi.size() > 0) {
			museo.arrivaTuristaAlMuseo(listaTuristi.get(i));
			i++;
		}
		
	}
}
