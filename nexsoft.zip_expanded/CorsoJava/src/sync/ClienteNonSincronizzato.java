package sync;

public class ClienteNonSincronizzato extends Thread {

	// variabili di istanza
	private double sommaDaPrelevare;

	// costruttore
	public ClienteNonSincronizzato(String nome, double sommaPrelievo) {
		this.setName(nome);
		this.sommaDaPrelevare = sommaPrelievo;
	}

	// metodi
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " � arrivato al bancomat, il saldo attuale � di "
				+ ContoCorrente.getIstance().getSaldo() + ", la somma che vuole prelevare � "
				+ this.getSommaDaPrelevare());

		ContoCorrente.getIstance().prelievoNonSync(sommaDaPrelevare);
	}

	public double getSommaDaPrelevare() {
		return sommaDaPrelevare;
	}
}
