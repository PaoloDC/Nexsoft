package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		// creo il thread pool
		ExecutorService pool = Executors.newCachedThreadPool();

		// massimo 10 thread, ne posso aggiungere altri ma andranno in coda
		ExecutorService pool2 = Executors.newFixedThreadPool(10);

		// aggiunge i thread alla pool
		pool.execute(new EsempioThread("1"));
		pool.execute(new EsempioThread("2"));
		pool.execute(new EsempioThread("3"));
		pool.execute(new EsempioThread("4"));

		// chiude l'esecuzione del pool
		pool.shutdown();
	}

}
