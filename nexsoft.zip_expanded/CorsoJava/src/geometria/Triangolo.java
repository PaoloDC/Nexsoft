package geometria;

public class Triangolo extends Figura_Piana implements Operazioni_Geometriche {

	private boolean isoscele = false;
	private boolean equilatero = false;

	/**
	 * Istanzia un nuovo triangolo generico, con 3 lati
	 * 
	 * @param lato1
	 *            intero che indica la lunghezza di uno dei tre lati
	 * @param lato2
	 *            intero che indica la lunghezza di uno dei tre lati
	 * @param lato3
	 *            intero che indica la lunghezza di uno dei tre lati
	 */
	public Triangolo(int lato1, int lato2, int lato3) {
		super(3, new int[] { lato1, lato2, lato3 });
	}

	/**
	 * Istanzia un nuovo triangolo isoscele
	 * 
	 * @param base
	 *            intero che indica la lunghezza della base del triangolo
	 * @param lato
	 *            intero che indica la lunghezza dei lati uguali del triangolo
	 */
	public Triangolo(int base, int lato) {
		super(3, new int[] { base, lato, lato });
		isoscele = true;
	}

	/**
	 * Istanzia un nuovo triangolo equilatero
	 * 
	 * @param lato
	 *            intero che indica la lunghezza dei lati del triangolo
	 */
	public Triangolo(int lato) {
		super(3, new int[] { lato, lato, lato });
		equilatero = true;
	}

	@Override
	public double calcolaArea() {
		if (isoscele) {
			return this.getDimensioneLati()[0] * this.getDimensioneLati()[1] / 2;
		} else if (equilatero) {
			return this.getDimensioneLati()[0] * this.getDimensioneLati()[0] / 4 * Math.sqrt(3);
		}
		return 0;
	}

	@Override
	public int calcolaPerimetro() {
		return this.getDimensioneLati()[0] + this.getDimensioneLati()[1] + this.getDimensioneLati()[2];
	}

}
