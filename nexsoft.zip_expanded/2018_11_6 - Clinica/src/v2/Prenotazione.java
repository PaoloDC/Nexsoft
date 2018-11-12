package v2;

import java.io.IOException;
import java.io.Serializable;
import java.util.Objects;

import v2.Clinica.Specialista;

public class Prenotazione implements Serializable {

	// variabili di istanza
	private String nomePaziente;
	private Specialista specialista;
	private static final long serialVersionUID = 1L;

	// costruttore
	public Prenotazione(String nomePaziente, Specialista specialista) {
		this.nomePaziente = nomePaziente;
		this.specialista = specialista;
	}

	// metodi

	public String getNomePaziente() {
		return nomePaziente;
	}

	public Specialista getSpecialista() {
		return specialista;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Prenotazione) {
			Prenotazione p = (Prenotazione) obj;
			return p.getNomePaziente().equals(this.getNomePaziente())
					&& p.getSpecialista().equals(this.getSpecialista());
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nomePaziente, this.specialista);
	}

	@Override
	public String toString() {
		return "Prenotazione [Nome Paziente: " + nomePaziente + ", Specialista: " + specialista + " ]";
	}

	@Override
	protected Prenotazione clone() {
		return new Prenotazione(nomePaziente, specialista);
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(nomePaziente);
		out.writeObject(specialista);
	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		nomePaziente = (String) in.readObject();
		specialista = (Specialista) in.readObject();
	}

}
