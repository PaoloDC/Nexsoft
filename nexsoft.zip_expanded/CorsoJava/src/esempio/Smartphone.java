package esempio;

public class Smartphone {
	//variabili di istanza
	private String numeroDiSerie;
	private String imei;
	private String marca;
	private String modello;
	private Display display;
	
	//metodi getter
	public String getImei() {
		return imei;
	}
	public String getMarca() {
		return marca;
	}
	public String getModello() {
		return modello;
	}
	public String getNumeroDiSerie() {
		return numeroDiSerie;
	}
	
	//metodi setter
	public void setImei(String imei) {
		this.imei = imei;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModello(String modello) {
		this.modello = modello;
	}
	public void setNumeroDiSerie(String numeroDiSerie) {
		this.numeroDiSerie = numeroDiSerie;
	}
	
}
