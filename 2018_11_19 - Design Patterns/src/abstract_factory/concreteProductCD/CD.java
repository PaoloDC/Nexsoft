package abstract_factory.concreteProductCD;

import abstract_factory.abstractProduct.Media;

public class CD implements Media{
	
	private String traccia;
	
	public void scriviSuDisco(String suono) {
		traccia = suono;
	}

	public String leggiDisco() {
		return traccia;
	}
}
