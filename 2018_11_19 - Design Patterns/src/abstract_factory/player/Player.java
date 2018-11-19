package abstract_factory.player;

import abstract_factory.media.Media;

public interface Player {
	void accept(Media media);
	void play();
}
