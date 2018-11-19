package abstract_factory.media;

public class Tape implements Media {
	private String cassetta;
	
	public void salvaSuCassetta(String suono) {
		cassetta = suono;
	}
	
	public String leggiCassetta() {
		return cassetta;
	}
}
