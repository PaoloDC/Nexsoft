package code;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<String> coda;

	public Consumer(BlockingQueue<String> coda) {
		this.coda = coda;
	}

	@Override
	public void run() {
		while (true) {
			if (coda.remainingCapacity() > 0) {
				System.out.println("Si possono aggiungere altri " + coda.remainingCapacity() + " / " + coda.size());
			} else if (coda.remainingCapacity() == 0) {
				String elementoRimosso = coda.remove();
				System.out.println("è stato rimosso l'elemento: " + elementoRimosso);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
