package abstract_factory.concreteFactory;

import abstract_factory.abstractFactory.DevicesFactory;
import abstract_factory.abstractProduct.Media;
import abstract_factory.abstractProduct.Player;
import abstract_factory.abstractProduct.Recorder;
import abstract_factory.concreteProductTape.Tape;
import abstract_factory.concreteProductTape.TapePlayer;
import abstract_factory.concreteProductTape.TapeRecorder;

public class TapeDevicesFactory implements DevicesFactory{

	@Override
	public Player createPlayer() {
return new TapePlayer();
	}

	@Override
	public Recorder createRecorder() {
		return new TapeRecorder();
	}

	@Override
	public Media createMedia() {
		return new Tape();
	}

}
