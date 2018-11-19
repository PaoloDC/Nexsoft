package bean;

/**
 * Classe che modella un oggetto di tipo Libro, presente in una biblioteca
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Libro {

	// variabili di istanza
	private String titolo;
	private String autore;
	private String isbn;

	// costruttore vuoto
	public Libro() {

	}

	/**
	 * Istanzia un nuovo oggetto di tipo Libro
	 * 
	 * @param titolo
	 *            stringa che contiene il titolo del libro
	 * @param autore
	 *            stringa che contiene l'autore del libro
	 * @param isbn
	 *            stringa che contiene il codice isbn del libro
	 */
	public Libro(String titolo, String autore, String isbn) {
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
	}

	// metodi getter e setter
	public String getAutore() {
		return autore;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * Restituisce una rappresentazione sotto forma di stringa dell'oggetto
	 */
	@Override
	public String toString() {
		return "Libro [Titolo: " + titolo + ", Autore: " + autore + ", ISBN: " + isbn + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autore == null) ? 0 : autore.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result + ((titolo == null) ? 0 : titolo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autore == null) {
			if (other.autore != null)
				return false;
		} else if (!autore.equals(other.autore))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (titolo == null) {
			if (other.titolo != null)
				return false;
		} else if (!titolo.equals(other.titolo))
			return false;
		return true;
	}

	@Override
	protected Libro clone() throws CloneNotSupportedException {
		return new Libro(titolo, autore, isbn);
	}
}
