package af.concreteProductTape;

import af.abstractProduct.Media;

public class Tape implements Media {
	private String cassetta;
	
	public void salvaSuCassetta(String suono) {
		cassetta = suono;
	}
	
	public String leggiCassetta() {
		return cassetta;
	}
}
