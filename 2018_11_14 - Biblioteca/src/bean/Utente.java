package bean;

public class Utente {
	private String nome;
	private String cognome;
	private String CF;
	
	public Utente() {
	}
	
	public Utente(String nome,String cognome,String CF) {
		this.nome = nome;
		this.cognome = cognome;
		this.CF = CF;
	}
	
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
	
	@Override
	public String toString() {
		return "Utente [Nome: " + nome + ", Cognome: " + cognome + ", CF: " + CF + " ]";
	}
}
