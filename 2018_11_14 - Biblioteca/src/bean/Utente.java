package bean;

/**
 * Classe che modella un utente di una biblioteca
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Utente {
	
	// variabili di istanza
	private String nome;
	private String cognome;
	private String CF;

	//costruttore vuoto
	public Utente() {
	}

	/**
	 * Istanzia un nuovo oggetto di tipo Utente
	 * @param nome stringa che contiene il nome dell'utente
	 * @param cognome stringa che contiene il cognome dell'utente 
	 * @param CF stringa che contiene il codice fiscale dell'utente
	 */
	public Utente(String nome, String cognome, String CF) {
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
	}

	//metodi getter e setter
	public String getCF() {
		return CF;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Restituisce una rappresentazione sotto forma di stringa dell'oggetto
	 */
	@Override
	public String toString() {
		return "Utente [Nome: " + nome + ", Cognome: " + cognome + ", CF: " + CF + " ]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CF == null) ? 0 : CF.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Utente other = (Utente) obj;
		if (CF == null) {
			if (other.CF != null)
				return false;
		} else if (!CF.equals(other.CF))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
