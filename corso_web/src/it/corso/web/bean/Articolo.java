package it.corso.web.bean;

import java.io.Serializable;

public class Articolo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nome;
	private String codice;
	private String prezzo;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Articolo [Nome: " + nome + ", Prezzo: " + prezzo + ", Codice: " + codice + "]";
	}
}
