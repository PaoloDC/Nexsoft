package lambda;

public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				System.out.println("CIAO");
			}
		};

		Thread t2 = new Thread(() -> System.out.println("CIAO 2"));

		t1.start();
		t2.start();

		t1.interrupt();
		t2.interrupt();

		CalcolaAreaFunctionalInterface rettangolo = (a, b) -> a * b;
		System.out.println(rettangolo.calcolaArea(10, 2));

		Thread t4 = new Thread(() -> {
			System.out.println("Sono nel thread 4");
		});
		
		t4.start();
		t4.interrupt();

		Maiuscola var = (a) -> a.toUpperCase();
		System.out.println(var.maiuscolo("m"));

	}

	
}
