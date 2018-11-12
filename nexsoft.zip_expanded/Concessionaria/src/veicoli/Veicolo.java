package veicoli;

public abstract class Veicolo {

	// variabili di istanza
	private String marca;
	private String modello;
	private int cilindrata;
	private int cavalli;
	private double prezzo;
	private int id;
	private static int IDcounter;

	// costruttore
	public Veicolo(String marca, String modello, int cilindrata, int cavalli, double prezzo) {
		id = IDcounter;
		IDcounter++;
		this.marca = marca;
		this.modello = modello;
		this.cilindrata = cilindrata;
		this.cavalli = cavalli;
		this.prezzo = prezzo;
	}

	// metodi
	public int getCilindrata() {
		return cilindrata;
	}

	public String getMarca() {
		return marca;
	}

	public String getModello() {
		return modello;
	}

	public int getCavalli() {
		return cavalli;
	}

	public double getPrezzo() {
		return prezzo;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Veicolo [marca: " + marca + ", modello: " + modello + ", cilindrata: " + cilindrata + ", cavalli: "
				+ cavalli + ", prezzo: " + prezzo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Veicolo) {
			Veicolo v = (Veicolo) obj; // cast
			return v.marca.equals(this.marca) && v.modello.equals(this.modello) && v.cilindrata == this.cilindrata
					&& v.cavalli == this.cavalli && v.prezzo == this.prezzo;
		}
		return false;
	}

	@Override
	protected Veicolo clone() throws CloneNotSupportedException {
		return new Veicolo(this.marca, this.modello, this.cilindrata, this.cavalli, this.prezzo) {
		};
	}
}
