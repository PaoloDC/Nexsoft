package geometria;

public class Rettangolo extends Figura_Piana implements Operazioni_Geometriche {

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo rettangolo
	 * 
	 * @param base
	 *            intero che indica il valore della base del rettangolo
	 * @param altezza
	 *            intero che indica il valore dell'altezza del rettangolo
	 */
	public Rettangolo(int base, int altezza) {
		super(4, new int[] { base, altezza });
	}

	//metodi
	@Override
	public double calcolaArea() {
		int base = this.getDimensioneLati()[0];
		int altezza = this.getDimensioneLati()[1];
		return base * altezza;
	}

	@Override
	public int calcolaPerimetro() {
		int base = this.getDimensioneLati()[0];
		int altezza = this.getDimensioneLati()[1];
		return base * 2 + altezza * 2;
	}

}
