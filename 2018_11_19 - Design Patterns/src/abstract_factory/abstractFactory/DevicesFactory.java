package abstract_factory.abstractFactory;

import abstract_factory.media.Media;
import abstract_factory.player.Player;
import abstract_factory.recorder.Recorder;

public interface DevicesFactory {
	Player createPlayer();
	Recorder createRecorder();
	Media createMedia();
}
