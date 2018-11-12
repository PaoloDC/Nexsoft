package sync;

public class Cliente extends Thread {

	// variabili di istanza
	private double sommaDaPrelevare;

	// costruttore
	public Cliente(String nome, double sommaPrelievo) {
		this.setName(nome);
		this.sommaDaPrelevare = sommaPrelievo;
	}

	// metodi
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " è arrivato al bancomat, il saldo attuale è di "
				+ ContoCorrente.getIstance().getSaldo() + ", la somma che vuole prelevare è "
				+ this.getSommaDaPrelevare());

		ContoCorrente.getIstance().prelievo(sommaDaPrelevare);
	}

	public double getSommaDaPrelevare() {
		return sommaDaPrelevare;
	}
}
