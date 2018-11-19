package af.concreteFactory;

import af.abstractFactory.DevicesFactory;
import af.abstractProduct.Media;
import af.abstractProduct.Player;
import af.abstractProduct.Recorder;
import af.concreteProductTape.Tape;
import af.concreteProductTape.TapePlayer;
import af.concreteProductTape.TapeRecorder;

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
