package af.concreteProductTape;

import af.abstractProduct.Media;
import af.abstractProduct.Recorder;

public class TapeRecorder implements Recorder {
	private Tape cassettaInserita;
	
	@Override
	public void accept(Media media) {
		cassettaInserita = (Tape) media;
	}
	
	@Override
	public void record(String suono) {
		if(null == cassettaInserita)
			System.out.println("Inserisci una cassetta prima di registrare");
		cassettaInserita.salvaSuCassetta(suono);
	}
}
