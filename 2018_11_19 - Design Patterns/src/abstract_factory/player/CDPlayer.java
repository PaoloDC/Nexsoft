package abstract_factory.player;

import abstract_factory.media.CD;
import abstract_factory.media.Media;

public class CDPlayer implements Player{
	
	private CD cdInserito;
	
	@Override
	public void accept(Media media) {
		cdInserito = (CD) media;
		
	}
	@Override
	public void play() {
		if(null == cdInserito)
			System.out.println("Inserisci un cd prima di registrare");
		System.out.println(cdInserito.leggiDisco());
		
	}
}
