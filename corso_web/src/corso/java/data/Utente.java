package corso.java.data;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente{
	
	private Integer id;
	private String nome;
	private String cognome;
	private List<ContoCorrente> listaConti;

	@Id
	@Column(name = "id_utente", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
	public List<ContoCorrente> getListaConti() {
		return listaConti;
	}

	public void setListaConti(List<ContoCorrente> listaConti) {
		this.listaConti = listaConti;
	}

	

}
