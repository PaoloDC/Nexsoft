import java.util.HashMap;

import concessionaria.Concessionaria;
import veicoli.*;

public class Main {
	public static void main(String[] args) {
		Auto a1 = new Auto("Fiat", "Panda", 900, 90, 5000, 5, false);
		Auto a2 = new Auto("Fiat", "Uno", 1300, 70, 2400, 3, true);
		Auto a3 = a2.clone();
		
		Moto m1 = new Moto("Kawasaki", "Z1000", 1000, 110, 4000);
		Moto m2 = new Moto("Ducati", "Scrambler", 800, 68, 8000);
		
		System.out.println(a1.getId());
		System.out.println(a2.getId());
		System.out.println(a3.getId());
		System.out.println(m1.getId());
		System.out.println(m2.getId());
		
		
		Concessionaria c = new Concessionaria();
		c.aggiungiVeicolo(a1);
		c.aggiungiVeicolo(a2);
		c.aggiungiVeicolo(a3);
		c.aggiungiVeicolo(m1);
		c.aggiungiVeicolo(m2);
		
		System.out.println(c);
		System.out.println(c.getAllAuto());
		System.out.println(c.getAllMoto());
		
		c.eliminaVeicolo(a2);
		
		System.out.println("\n\n" + c);
		
		
		HashMap<Integer, Veicolo> mappa = new HashMap<>();
		
		for(Veicolo v: c.getAllVeicolo()) {
			mappa.put(v.getId(), v);
		}
	
		Moto m3 = new Moto("Moto Guzzi", "California", 1200, 80, 4800);
		
		System.out.println(mappa.containsKey(m3.getId()));
		
		mappa.put(m3.getId(), m3);
		
		System.out.println(mappa.containsKey(m3.getId()));
		
		mappa.remove(m3.getId());
		
		System.out.println(mappa.containsKey(m3.getId()));
	
	}
}
