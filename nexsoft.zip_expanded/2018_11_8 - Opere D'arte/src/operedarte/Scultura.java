package operedarte;

import java.io.IOException;
import java.io.Serializable;

public class Scultura extends OperaDarte implements Serializable {

	// variabili di istanza
	private double altezza;
	private double larghezza;
	private double profondità;
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
	 * @param profondità
	 *            double che indica la profondità della scultura
	 */
	public Scultura(String titolo, String artista, double altezza, double larghezza, double profondità) {
		super(titolo, artista);
		this.setLarghezza(larghezza);
		this.setAltezza(altezza);
		this.setProfondità(profondità);
	}

	// metodi
	public double getAltezza() {
		return altezza;
	}

	public double getLarghezza() {
		return larghezza;
	}

	public double getProfondità() {
		return profondità;
	}

	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}

	public void setLarghezza(double larghezza) {
		this.larghezza = larghezza;
	}

	public void setProfondità(double profondità) {
		this.profondità = profondità;
	}

	@Override
	public double printingombro() {
		return altezza * larghezza * profondità;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Scultura) {
			Scultura s = (Scultura) obj;
			return this.getAltezza() == s.getAltezza() && this.getLarghezza() == s.getLarghezza()
					&& this.getProfondità() == s.getProfondità() && super.equals(obj);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Scultura [Titolo: " + getTitolo() + ", Artista: " + getArtista() + ", Altezza: " + getAltezza()
				+ ", Larghezza: " + getLarghezza() + ", Profondità: " + getProfondità() + " ]";
	}

	@Override
	protected Scultura clone() throws CloneNotSupportedException {
		return new Scultura(getTitolo(), getArtista(), getAltezza(), getLarghezza(), getProfondità());
	}

	private void writeObject(java.io.ObjectOutputStream out) {
		try {
			out.writeDouble(altezza);
			out.writeDouble(larghezza);
			out.writeDouble(profondità);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			altezza = in.readDouble();
			larghezza = in.readDouble();
			profondità = in.readDouble();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
