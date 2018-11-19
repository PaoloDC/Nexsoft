package af.client;

import af.abstractFactory.DevicesFactory;
import af.abstractProduct.Media;
import af.abstractProduct.Player;
import af.abstractProduct.Recorder;

public class Client {
	DevicesFactory tecnologia;
	
	public void selezionaTecnologia(DevicesFactory df) {
		this.tecnologia = df;
	}
	
	public void test(String canzone) {
		Media m = tecnologia.createMedia();
		Recorder r = tecnologia.createRecorder();
		Player p = tecnologia.createPlayer();
		
		r.accept(m);
		System.out.println("Registro la canzone: " + canzone);
		r.record(canzone);
		System.out.println("Ascolto la registrazione");
		p.accept(m);
		p.play();
	}
}
