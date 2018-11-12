package lambda;

public class Utente {
	private String nome;
	private String cognome;
	private int eta;

	public String getCognome() {
		return cognome;
	}

	public int getEta() {
		return eta;
	}

	public String getNome() {
		return nome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Utente(String nome, String cognome, int eta) {
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
	}

	@Override
	public String toString() {
		return "Utente [Nome: " + nome + ", Cognome: " + cognome + ", Età: " + eta + " ]";
	}
}
