package abstract_factory.media;

public class CD implements Media{
	
	private String traccia;
	
	public void scriviSuDisco(String suono) {
		traccia = suono;
	}

	public String leggiDisco() {
		return traccia;
	}
}
