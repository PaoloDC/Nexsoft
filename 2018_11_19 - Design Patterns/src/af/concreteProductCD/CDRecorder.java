package af.concreteProductCD;

import af.abstractProduct.Media;
import af.abstractProduct.Recorder;

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
