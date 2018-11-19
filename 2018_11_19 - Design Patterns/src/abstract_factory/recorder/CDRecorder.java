package abstract_factory.recorder;

import abstract_factory.media.CD;
import abstract_factory.media.Media;

public class CDRecorder implements Recorder{
	
	private CD cdInserito;
	
	@Override
	public void accept(Media media) {
		cdInserito = (CD) media;
	}
	
	@Override
	public void record(String suono) {
		if(null == cdInserito)
			System.out.println("Inserisci un cd prima di registrare");
		cdInserito.scriviSuDisco(suono);		
	}
}
