package geometria;

public class Quadrato extends Figura_Piana implements Operazioni_Geometriche {

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo Quadrato
	 * 
	 * @param lato
	 *            intero che indica la lunghezza dei lati del quadrato
	 */
	public Quadrato(int lato) {
		super(4, new int[] { lato });
	}

	// metodi
	@Override
	public double calcolaArea() {
		int lato = this.getDimensioneLati()[0];
		return lato * lato;
	}

	@Override
	public int calcolaPerimetro() {
		int lato = this.getDimensioneLati()[0];
		return lato * 4;
	}
}
