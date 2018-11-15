package bean;
public class Libro {

	private String titolo;
	private String autore;
	private String isbn;

	public Libro() {

	}

	public Libro(String titolo, String autore, String isbn) {
		this.titolo = titolo;
		this.autore = autore;
		this.isbn = isbn;
	}

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

	public String toString() {
		return "Libro [Titolo: " + titolo + ", Autore: " + autore +", ISBN: " + isbn + " ]";
	}
}
