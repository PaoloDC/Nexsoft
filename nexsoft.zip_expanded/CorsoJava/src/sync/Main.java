package sync;

public class Main {

	public static void main(String[] args) {
		Cliente c1 = new Cliente("Paolo", 50);
		Cliente c2 = new Cliente("Alda", 200);

		
		c1.start();
		c2.start();
		
		try {
			c1.join();
			c2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
