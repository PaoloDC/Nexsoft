package abstract_factory.recorder;

import abstract_factory.media.Media;

public interface Recorder {
	void accept(Media media);
	void record(String sound);
}
