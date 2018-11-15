package database.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cliente {

	// variabili di istanza
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	private final Logger LOG = LoggerFactory.getLogger(Cliente.class);

	// costruttore vuoto
	public Cliente() {
	}

	public Cliente(int id, String nome, String cognome, String telefono) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		LOG.debug("Oggetto Creato");
		LOG.error("AZZ");
		LOG.info("INFO");
	}

	// metodi
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String toString() {
		return "Cliente [ID: " + id + ", Nome: " + nome + ", Cognome: " + cognome + ", Email: " + email + ", Telefono: " + telefono + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		LOG.debug("Entra nel metodo 'equals'");
		if (this == obj)
			return true;
		if (obj != null && obj instanceof Cliente) {
			Cliente c = (Cliente) obj;
			return getNome().equals(c.getNome()) && getCognome().equals(c.getCognome()) && getId() == c.getId()
					&& getTelefono().equals(c.getTelefono()) && getEmail().equals(c.getEmail());
		}
		return false;
	}

}
