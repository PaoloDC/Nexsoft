package abstract_factory.abstractFactory;

import abstract_factory.abstractProduct.Media;
import abstract_factory.abstractProduct.Player;
import abstract_factory.abstractProduct.Recorder;

public interface DevicesFactory {
	Player createPlayer();
	Recorder createRecorder();
	Media createMedia();
}
