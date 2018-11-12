package v2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Museo {

	// variabili di istanza
	public static final int NUM_MAX_VISITATORI = 5;
	private BlockingQueue<Runnable> codaTuristi;

	// costruttore
	public Museo() {
		codaTuristi = new ArrayBlockingQueue<>(NUM_MAX_VISITATORI);
	}

	public void arrivaTuristaAlMuseo(Turista t) {
		if (t.isAlive()) {
			try {
				codaTuristi.put(t);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
