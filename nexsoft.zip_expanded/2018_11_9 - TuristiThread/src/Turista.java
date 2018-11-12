import java.util.Random;

public class Turista extends Thread {
	//variabili di istanza
	private int numeroBiglietto;
	
	//costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo Turista
	 * @param num indica il numero del biglietto che identifica il turista
	 */
	public Turista(int num,int tempoDiAttesa) {
		this.numeroBiglietto = num;
	}

	//metodi
	public int getNumeroBiglietto() {
		return numeroBiglietto;
	}

	@Override
	public void run() {
		visitaMuseo();
	}
	
	/**
	 * Permette al turista di visitare il museo, per un numero casuale di secondi 
	 */
	public void visitaMuseo() {
		System.out.println("Il turista con biglietto " + this.getNumeroBiglietto() + " sta visitando la gioconda");
		
		int tempoPerLaVisita = (new Random().nextInt(5) + 5);
		try {
			Thread.sleep(tempoPerLaVisita * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Il turista con numero " + this.getNumeroBiglietto() + " ha completato la visita in "
				+ tempoPerLaVisita + " secondi");
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Turista) {
			Turista t = (Turista) obj;
			return this.getNumeroBiglietto() == t.getNumeroBiglietto(); 
		}
		return false;
	}
}
