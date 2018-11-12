package code;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EsempioArrayBlockingQueue {
	public static void main(String[] args) {
		//BlockingQueue<String> coda = new ArrayBlockingQueue<>(10);
		BlockingQueue<String> coda = new LinkedBlockingQueue<>();
		Thread producer = new Thread(new Producer(coda));
		Thread consumer = new Thread(new Consumer(coda));
		
		producer.start();
		consumer.start();
	}
}
