package code;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
	private BlockingQueue<String> coda;

	public Producer(BlockingQueue<String> coda) {
		this.coda = coda;
	}

	@Override
	public void run() {
		int i=0;
		
		while (true) {
			String elem = "Elemento numero: " + i;
			boolean add = coda.offer(elem);
			
			System.out.println("L'elemento " + i + " è stato aggiunto? " + add);
			i++;
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
