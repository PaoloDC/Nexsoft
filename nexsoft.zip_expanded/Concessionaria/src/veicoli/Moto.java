package veicoli;

public class Moto extends Veicolo{

	public Moto(String marca, String modello, int cilindrata, int cavalli, double prezzo) {
		super(marca, modello, cilindrata, cavalli, prezzo);
	}
	
	@Override
	protected Moto clone() throws CloneNotSupportedException {
		return new Moto(this.getMarca(), this.getModello(), this.getCilindrata(), this.getCavalli(), this.getPrezzo()) {
		};
	}
	
	@Override
	public String toString() {
		return "Moto [marca: " + this.getMarca() + ", Modello: " + this.getModello() + ", Cilindrata: "
				+ this.getCilindrata() + ", Cavalli: " + this.getCavalli() + ", Prezzo: " + this.getPrezzo();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Moto) {
			Moto m = (Moto) obj;
			return m.getMarca().equals(this.getMarca()) && m.getModello().equals(this.getModello())
					&& m.getCilindrata() == this.getCilindrata() && m.getCavalli() == this.getCavalli()
					&& m.getPrezzo() == this.getPrezzo();
		}
		return false;
	}

}
