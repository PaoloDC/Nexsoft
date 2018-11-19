package abstract_factory.concreteProductTape;

import abstract_factory.abstractProduct.Media;

public class Tape implements Media {
	private String cassetta;
	
	public void salvaSuCassetta(String suono) {
		cassetta = suono;
	}
	
	public String leggiCassetta() {
		return cassetta;
	}
}
