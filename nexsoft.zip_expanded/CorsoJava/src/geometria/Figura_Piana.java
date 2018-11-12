package geometria;

/**
 * Classe creata per fattorizzazione con elementi comuni alle figure piane
 * 
 * @author decri
 *
 */
public abstract class Figura_Piana {

	// variabili di istanza
	private int numeroDiLati;
	private int[] dimensioneLati;

	// costruttore
	/**
	 * Istanzia una nuova figura piana, indicando il numero di lati e la dimensione
	 * di ogni lato
	 * 
	 * @param numeroLati
	 *            intero che indica il numero di lati
	 * @param dimensioniLati
	 *            array di interi in cui sono memorizzate le dimensioni di tutti i
	 *            lati della figura
	 */
	public Figura_Piana(int numeroLati, int[] dimensioniLati) {
		this.numeroDiLati = numeroLati;
		this.dimensioneLati = dimensioniLati;
	}

	// metodi
	/**
	 * Restituisce un array di interi in cui sono memorizzati i valori dei lati di
	 * una figura
	 * 
	 * @return un array di interi
	 */
	public int[] getDimensioneLati() {
		return dimensioneLati;
	}

	/**
	 * Restituisce un intero che indica il numero di lati di una figura piana
	 * 
	 * @return un intero che indica il numero di lati
	 */
	public int getNumeroDiLati() {
		return numeroDiLati;
	}
}
