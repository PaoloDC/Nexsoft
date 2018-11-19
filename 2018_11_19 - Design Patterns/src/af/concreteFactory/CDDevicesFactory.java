package af.concreteFactory;

import af.abstractFactory.DevicesFactory;
import af.abstractProduct.Media;
import af.abstractProduct.Player;
import af.abstractProduct.Recorder;
import af.concreteProductCD.CD;
import af.concreteProductCD.CDPlayer;
import af.concreteProductCD.CDRecorder;

public class CDDevicesFactory implements DevicesFactory {

	@Override
	public Player createPlayer() {
		return new CDPlayer();
	}

	@Override
	public Recorder createRecorder() {
		return new CDRecorder();
	}

	@Override
	public Media createMedia() {
		return new CD();
	}

}
