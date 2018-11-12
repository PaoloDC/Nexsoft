package supermercato;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BancoSalumiFormaggi {
	//variabili di istanza
	private static final int CLIENTI_DA_SERVIRE = 30;
	private final int DIPENDENTI = 3;	
	private BlockingQueue<Runnable> codaBancone = new ArrayBlockingQueue<>(CLIENTI_DA_SERVIRE,true);
	private ExecutorService dipendentiDisponibili = Executors.newFixedThreadPool(DIPENDENTI);
	
	//main
	public static void main(String[] args) {
		System.out.println("Nel supermercato ci sono " + CLIENTI_DA_SERVIRE + " clienti da servire");
	
		BancoSalumiFormaggi banco = new BancoSalumiFormaggi();
		banco.arrivoClientiAlBancone();
		banco.servizioClienti();
	
	
	}
	
	public void arrivoClientiAlBancone() {
		for(int i=1 ; i <= CLIENTI_DA_SERVIRE ; i++) {
			try {
				codaBancone.put(new Cliente(i));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void servizioClienti() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						dipendentiDisponibili.execute(codaBancone.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}
	
}
