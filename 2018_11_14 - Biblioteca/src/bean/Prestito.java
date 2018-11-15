package bean;

import java.time.LocalDate;

public class Prestito {
	private Libro libro;
	private Utente utente;
	private LocalDate dataInizio;
	private LocalDate dataFine;

	public Prestito() {
	}

	public Prestito(Libro libro, Utente utente, LocalDate dataInizio, LocalDate dataFine) {
		this.libro = libro;
		this.utente = utente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

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
		if(null != getDataFine()) {
			dataFine = getDataFine().toString(); 
		} 
			
		return "Prestito [Libro(isbn): " + getLibro().getIsbn() + ", Utente(CF): " + getUtente().getCF()
				+ ", Data Inizio: " + getDataInizio() + ", Data Fine: " + dataFine + " ]";
	}
}
