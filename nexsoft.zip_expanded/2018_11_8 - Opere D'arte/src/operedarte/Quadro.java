package operedarte;

import java.io.IOException;
import java.io.Serializable;

public class Quadro extends OperaDarte implements Serializable {

	// variabili di istanza
	private double altezza;
	private double larghezza;
	private static final long serialVersionUID = 2L;

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo Quadro
	 * 
	 * @param titolo
	 *            stringa che indica il titolo dato al quadro
	 * @param artista
	 *            stringa che indica il nome dell'artista che ha dipinto il quadro
	 * @param altezza
	 *            double che indica l'altezza del quadro
	 * @param larghezza
	 *            double che indica la larghezza del quadro
	 */
	public Quadro(String titolo, String artista, double altezza, double larghezza) {
		super(titolo, artista);
		this.setLarghezza(larghezza);
		this.setAltezza(altezza);
	}

	// metodi
	public double getAltezza() {
		return altezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	@Override
	public double printingombro() {
		return altezza * larghezza;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quadro) {
			Quadro s = (Quadro) obj;
			return this.getAltezza() == s.getAltezza() && this.getLarghezza() == s.getLarghezza() && super.equals(obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Quadro [Titolo: " + getTitolo() + ", Artista: " + getArtista() + ", Altezza: " + getAltezza()
				+ ", Larghezza: " + getLarghezza() + " ]";
	}

	@Override
	protected Quadro clone() throws CloneNotSupportedException {
		return new Quadro(getTitolo(), getArtista(), getAltezza(), getLarghezza());
	}

	private void writeObject(java.io.ObjectOutputStream out) {
		try {
			out.writeDouble(altezza);
			out.writeDouble(larghezza);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			altezza = in.readDouble();
			larghezza = in.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
