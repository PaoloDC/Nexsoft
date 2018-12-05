
public class ContoCorrente {
	private static int CONTA = 1;
	private int id;
	private String numero;

	public ContoCorrente(){
		id = CONTA;
		CONTA++;
		numero = "";
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "ContoCorrente [id=" + id + ", numero=" + numero + "]";
	}

	
}
