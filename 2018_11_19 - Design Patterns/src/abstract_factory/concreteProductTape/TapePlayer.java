package abstract_factory.concreteProductTape;

import abstract_factory.abstractProduct.Media;
import abstract_factory.abstractProduct.Player;

public class TapePlayer implements Player {
	private Tape cassettaInserita;

	@Override
	public void accept(Media media) {
		cassettaInserita = (Tape) media;
	}

	@Override
	public void play() {
		if(null == cassettaInserita)
			System.out.println("Inserisci una cassetta prima di registrare");
		System.out.println(cassettaInserita.leggiCassetta());
	}

}
