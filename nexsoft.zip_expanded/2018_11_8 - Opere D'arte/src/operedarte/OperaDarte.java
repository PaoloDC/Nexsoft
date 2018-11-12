package operedarte;

import java.io.IOException;
import java.io.Serializable;

import eccezioni.OperaDarteException;

public abstract class OperaDarte implements Serializable {

	// variabili di istanza
	private String titolo;
	private String artista;
	private static final long serialVersionUID = 1L;

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo opera d'arte
	 * 
	 * @param titolo
	 *            stringa che indica il titolo dato all'opera d'arte
	 * @param artista
	 *            stringa che indica il nome dell'artista che ha creato l'opera
	 *            d'arte
	 */
	public OperaDarte(String titolo, String artista) {
		this.setArtista(artista);
		this.setTitolo(titolo);
	}

	// metodi
	public String getArtista() {
		return artista;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Restituisce l'ingombro dell'opera d'arte
	 * 
	 * @return double che corrisponde all'ingombro
	 */
	public abstract double printingombro();

	@Override
	public boolean equals(Object obj) {
		if (obj == null || this == null)
			try {
				throw new OperaDarteException();
			} catch (OperaDarteException e) {
				e.printStackTrace();
			}
		if (obj instanceof OperaDarte) {
			OperaDarte o = (OperaDarte) obj;
			return this.getTitolo().equals(o.getTitolo()) && this.getArtista().equals(o.getArtista());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Opera d'Arte [Titolo: " + getTitolo() + ", Artista: " + getArtista() + "]";
	}

	private void writeObject(java.io.ObjectOutputStream out) {
		try {
			out.writeObject(titolo);
			out.writeObject(artista);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void readObject(java.io.ObjectInputStream in) {
		try {
			titolo = (String) in.readObject();
			artista = (String) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}