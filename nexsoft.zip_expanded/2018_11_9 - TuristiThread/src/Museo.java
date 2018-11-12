import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Classe che simula un museo, che può ospitare un certo numero di turisti per
 * volta La gestione dei turisti (thread) è gestita tramite una coda
 * 
 * @author Paolo De Cristofaro
 *
 */
public class Museo {
	// variabili di istanza
	private int numeroTuristi;
	public static final int POSTI_PER_VISITA = 5;
	private BlockingQueue<Runnable> codaTuristi;
	private ExecutorService gestoreVisitatori;

	// costruttore
	/**
	 * Istanzia un nuovo oggetto di tipo Museo
	 * 
	 * @param numeroTotaleTuristi
	 *            indica il numero di turisti che sono giunti al museo
	 */
	public Museo(int numeroTotaleTuristi) {
		this.numeroTuristi = numeroTotaleTuristi;
		
		//Coda a capacità fissa, con stessa priorità, gestita come FIFO
		this.codaTuristi = new ArrayBlockingQueue<>(numeroTuristi,true);
		
		//istanzia un thread pool a capacità fissa
		this.gestoreVisitatori = Executors.newFixedThreadPool(POSTI_PER_VISITA);
	}

	/**
	 * Metodo che assegna un biglietto ad ogni turista e lo salva nella code
	 */
	public void arrivoTuristiAlMuseo() {
		for (int i = 1; i <= numeroTuristi; i++) {
			try {
				codaTuristi.put(new Turista(i,new Random().nextInt(5) * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metodo che permette ai turisti di visitare il museo, gestisce la coda dei
	 * posti disponibili per la visita
	 */
	public void visitaGioconda() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						gestoreVisitatori.execute(codaTuristi.take());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
