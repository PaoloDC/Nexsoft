package abstract_factory.abstractProduct;

public interface Recorder {
	void accept(Media media);
	void record(String sound);
}
