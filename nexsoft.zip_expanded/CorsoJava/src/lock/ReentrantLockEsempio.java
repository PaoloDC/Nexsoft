package lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockEsempio {
	private ReentrantLock istanzaLock = new ReentrantLock();
	private int contatore = 0;
	private int somma = 0;

	public int conta() {
		System.out
				.println("il Thread " + Thread.currentThread().getName() + "ha richiesto di incrementare il contatore");

		istanzaLock.lock();

		try {
			System.out.println(Thread.currentThread().getName() + " contatore: " + contatore);
			return contatore;
		} finally {
			istanzaLock.unlock();
		}

	}

	public void somma() {
		System.out.println("il Thread " + Thread.currentThread().getName() + "ha richiesto di visualizzare la somma");

		if (istanzaLock.tryLock()) {
			try {
				somma += contatore;
				System.out.println(Thread.currentThread().getName() + " la somma vale " + somma);
			} finally {
				istanzaLock.unlock();
			}
		} else
			System.out.println(
					"********** Il Thread '" + Thread.currentThread().getName() + "' ha il lock sulla variabile");

	}
}
