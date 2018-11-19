package abstract_factory.concreteFactory;

import abstract_factory.abstractFactory.DevicesFactory;
import abstract_factory.media.CD;
import abstract_factory.media.Media;
import abstract_factory.player.CDPlayer;
import abstract_factory.player.Player;
import abstract_factory.recorder.CDRecorder;
import abstract_factory.recorder.Recorder;

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
