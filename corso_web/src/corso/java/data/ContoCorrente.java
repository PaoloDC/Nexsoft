package corso.java.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Table(name = "conto")
@javax.persistence.Entity
public class ContoCorrente {
	
	private Integer id;
	private String numero;
	private Utente utente;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_conto", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@ManyToOne
	@JoinColumn(name = "utente")
	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	
}
