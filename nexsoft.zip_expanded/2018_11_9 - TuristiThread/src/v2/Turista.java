package v2;

public class Turista extends Thread {
	
	// variabili di istanza
	private int numeroBiglietto;
	private long tempoDiAttesa;

	// costruttore
	public Turista(int num, int tempoDiAttesa) {
		this.numeroBiglietto = num;
		this.tempoDiAttesa = tempoDiAttesa;
	}

	// metodi getter
	public int getNumeroBiglietto() {
		return numeroBiglietto;
	}

	public long getTempoDiAttesa() {
		return tempoDiAttesa;
	}

	@Override
	public void run() {
		System.out.println("Il turista con biglietto " + this.getNumeroBiglietto() + " è arrivato al museo");
		
		try {
			this.sleep(tempoDiAttesa);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Il turista con biglietto " + numeroBiglietto + " non vuole più aspettare");
		}		
	}
}
