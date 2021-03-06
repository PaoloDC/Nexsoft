package operedarte;

import java.io.IOException;
import java.io.Serializable;

public class Scultura extends OperaDarte implements Serializable {

	// variabili di istanza
	private double altezza;
	private double larghezza;
	private double profonditā;
	private static final long serialVersionUID = 3L;

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo Scultura
	 * 
	 * @param titolo
	 *            stringa che indica il titolo dato alla scultura
	 * @param artista
	 *            stringa che indica il nome dell'artista che ha creato la scultura
	 * @param altezza
	 *            double che indica l'altezza della scultura
	 * @param larghezza
	 *            double che indica la larghezza della scultura
	 * @param profonditā
	 *            double che indica la profonditā della scultura
	 */
	public Scultura(String titolo, String artista, double altezza, double larghezza, double profonditā) {
		super(titolo, artista);
		this.setLarghezza(larghezza);
		this.setAltezza(altezza);
		this.setProfonditā(profonditā);
	}

	// metodi
	public double getAltezza() {
		return altezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public double getProfonditā() {
		return profonditā;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	public void setProfonditā(double profonditā) {
		this.profonditā = profonditā;
	}

	@Override
	public double printingombro() {
		return altezza * larghezza * profonditā;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Scultura) {
			Scultura s = (Scultura) obj;
			return this.getAltezza() == s.getAltezza() && this.getLarghezza() == s.getLarghezza()
					&& this.getProfonditā() == s.getProfonditā() && super.equals(obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Scultura [Titolo: " + getTitolo() + ", Artista: " + getArtista() + ", Altezza: " + getAltezza()
				+ ", Larghezza: " + getLarghezza() + ", Profonditā: " + getProfonditā() + " ]";
	}

	@Override
	protected Scultura clone() throws CloneNotSupportedException {
		return new Scultura(getTitolo(), getArtista(), getAltezza(), getLarghezza(), getProfonditā());
	}

	private void writeObject(java.io.ObjectOutputStream out) {
		try {
			out.writeDouble(altezza);
			out.writeDouble(larghezza);
			out.writeDouble(profonditā);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			altezza = in.readDouble();
			larghezza = in.readDouble();
			profonditā = in.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
