package abstract_factory.recorder;

import abstract_factory.media.Media;
import abstract_factory.media.Tape;

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
