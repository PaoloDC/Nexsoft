package abstract_factory.concreteProductCD;

import abstract_factory.abstractProduct.Media;
import abstract_factory.abstractProduct.Player;

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
