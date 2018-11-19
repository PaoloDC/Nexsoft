package bean;

import java.time.LocalDate;

public class Prestito {

	// variabili di istanza
	private Libro libro;
	private Utente utente;
	private LocalDate dataInizio;
	private LocalDate dataFine;

	// costruttore vuoto
	public Prestito() {
	}

	/**
	 * Istanzia un nuovo oggetto di tipo prestito
	 * 
	 * @param libro
	 *            oggetto di tipo libro
	 * @param utente
	 *            oggetto di tipo utente
	 * @param dataInizio
	 *            oggetto LocalDate che modella la data di inizio del prestito
	 * @param dataFine
	 *            oggetto LocalDate che modella la data di fine del prestito (vale
	 *            null se il prestito è in corso)
	 */
	public Prestito(Libro libro, Utente utente, LocalDate dataInizio, LocalDate dataFine) {
		this.libro = libro;
		this.utente = utente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	//metodi getter e setter
	public LocalDate getDataFine() {
		return dataFine;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public Libro getLibro() {
		return libro;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	@Override
	public String toString() {
		String dataFine = "Ancora in Prestito";
		if (null != getDataFine()) {
			dataFine = getDataFine().toString();
		}

		return "Prestito [Libro(isbn): " + getLibro().getIsbn() + ", Utente(CF): " + getUtente().getCF()
				+ ", Data Inizio: " + getDataInizio() + ", Data Fine: " + dataFine + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + ((utente == null) ? 0 : utente.hashCode());
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
		Prestito other = (Prestito) obj;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (utente == null) {
			if (other.utente != null)
				return false;
		} else if (!utente.equals(other.utente))
			return false;
		return true;
	}

}
