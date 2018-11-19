package af;

import af.client.Client;
import af.concreteFactory.CDDevicesFactory;
import af.concreteFactory.TapeDevicesFactory;

public class Tester {

	public static void main(String[] args) {
		Client c = new Client();
		
		System.out.println("**Test Cassetta**");
		c.selezionaTecnologia(new TapeDevicesFactory());
		c.test("O sole mio");
		
		System.out.println("**Test CD**");
		c.selezionaTecnologia(new CDDevicesFactory());
		c.test("Napulè");
	}

}
