package operedarte;

import java.io.IOException;
import java.io.Serializable;

public class Scultura extends OperaDarte implements Serializable {

	// variabili di istanza
	private double altezza;
	private double larghezza;
	private double profondit�;
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
	 * @param profondit�
	 *            double che indica la profondit� della scultura
	 */
	public Scultura(String titolo, String artista, double altezza, double larghezza, double profondit�) {
		super(titolo, artista);
		this.setLarghezza(larghezza);
		this.setAltezza(altezza);
		this.setProfondit�(profondit�);
	}

	// metodi
	public double getAltezza() {
		return altezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public double getProfondit�() {
		return profondit�;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	public void setProfondit�(double profondit�) {
		this.profondit� = profondit�;
	}

	@Override
	public double printingombro() {
		return altezza * larghezza * profondit�;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Scultura) {
			Scultura s = (Scultura) obj;
			return this.getAltezza() == s.getAltezza() && this.getLarghezza() == s.getLarghezza()
					&& this.getProfondit�() == s.getProfondit�() && super.equals(obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Scultura [Titolo: " + getTitolo() + ", Artista: " + getArtista() + ", Altezza: " + getAltezza()
				+ ", Larghezza: " + getLarghezza() + ", Profondit�: " + getProfondit�() + " ]";
	}

	@Override
	protected Scultura clone() throws CloneNotSupportedException {
		return new Scultura(getTitolo(), getArtista(), getAltezza(), getLarghezza(), getProfondit�());
	}

	private void writeObject(java.io.ObjectOutputStream out) {
		try {
			out.writeDouble(altezza);
			out.writeDouble(larghezza);
			out.writeDouble(profondit�);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			altezza = in.readDouble();
			larghezza = in.readDouble();
			profondit� = in.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
