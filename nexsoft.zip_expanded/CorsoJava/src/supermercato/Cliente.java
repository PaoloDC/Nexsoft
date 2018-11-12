package supermercato;

import java.util.Random;

public class Cliente implements Runnable {

	// variabili di istanza
	private int numeroTicket;

	// costruttore
	public Cliente(int numTicket) {
		this.numeroTicket = numTicket;
		System.out.println("È arrivato un nuovo cliente con numero " + numeroTicket);
	}

	// metodi
	@Override
	public void run() {
		richiediProdotti();
	}

	private void richiediProdotti() {
		System.out.println("Viene servito il cliente numero: " + this.numeroTicket);

		int tempoImpiegatoPerAcquisto = (new Random().nextInt(15) + 5);
		try {
			Thread.sleep(tempoImpiegatoPerAcquisto);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Il cliente con numero " + this.numeroTicket + " ha completato l'acquisto in "
				+ tempoImpiegatoPerAcquisto + " secondi");
	}

}
