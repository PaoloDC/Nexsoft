package database.bean;

public class Ordine {

	// variabili di istanza
	private int id;
	private int idCliente;
	private String data;
	private double importo;

	public Ordine() {
		
	}
	
	public Ordine(int id, int idCliente, String data, double importo) {
		this.id = id;
		this.idCliente = idCliente;
		this.data = data;
		this.importo = importo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public double getImporto() {
		return importo;
	}

	public void setImporto(double importo) {
		this.importo = importo;
	}

}
