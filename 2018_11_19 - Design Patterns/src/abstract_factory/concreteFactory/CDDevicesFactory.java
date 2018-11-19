package abstract_factory.concreteFactory;

import abstract_factory.abstractFactory.DevicesFactory;
import abstract_factory.abstractProduct.Media;
import abstract_factory.abstractProduct.Player;
import abstract_factory.abstractProduct.Recorder;
import abstract_factory.concreteProductCD.CD;
import abstract_factory.concreteProductCD.CDPlayer;
import abstract_factory.concreteProductCD.CDRecorder;

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
