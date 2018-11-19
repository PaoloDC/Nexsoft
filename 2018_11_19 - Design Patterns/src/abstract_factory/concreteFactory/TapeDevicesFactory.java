package abstract_factory.concreteFactory;

import abstract_factory.abstractFactory.DevicesFactory;
import abstract_factory.media.Media;
import abstract_factory.media.Tape;
import abstract_factory.player.Player;
import abstract_factory.player.TapePlayer;
import abstract_factory.recorder.Recorder;
import abstract_factory.recorder.TapeRecorder;

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
