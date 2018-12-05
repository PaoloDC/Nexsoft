package corso.java.data;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "persona")
public class Persona {

	public void setId(Long id) {
		this.id = id;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private Long id;
	private String nome;
	private String cognome;
	private Calendar dataNascita;
	private Account account;

	public String getCognome() {
		return cognome;
	}

	@OneToOne
	@JoinColumn(name = "account_id")
	public Account getAccount() {
		return account;
	}

	@Id
	@Column(name = "id_persona")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Column(name = "nome_persona", nullable = false)
	public String getNome() {
		return nome;
	}

	@Temporal(TemporalType.DATE)
	public Calendar getDataNascita() {
		return dataNascita;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setDataNascita(Calendar dataNascita) {
		this.dataNascita = dataNascita;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
