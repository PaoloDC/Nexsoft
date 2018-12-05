import java.util.ArrayList;
import java.util.List;

public class Utente {
	private int id;
	private String nome;
	private String cognome;
	private List<ContoCorrente> listaConti;

	public Utente() {
		listaConti = new ArrayList<>();
	}
	
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

	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}

	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", listaConti=" + listaConti + "]";
	}

	
	
}
