package af.abstractFactory;

import af.abstractProduct.Media;
import af.abstractProduct.Player;
import af.abstractProduct.Recorder;

public interface DevicesFactory {
	Player createPlayer();
	Recorder createRecorder();
	Media createMedia();
}
