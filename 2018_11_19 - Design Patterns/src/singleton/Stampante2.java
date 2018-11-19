package singleton;

public class Stampante2 {
	// variabile statica per l'istanza
	private static Stampante2 istance;

	/**
	 * Costruttore privato per evitare di istanziare altri oggetti
	 */
	private Stampante2() {
	}

	public static Stampante2 getIstance() {
		if(istance == null) {
			synchronized (Stampante2.class) {
				if(istance == null) {
					istance = new Stampante2();
				}
			}
		}
			
		return istance;
	}
	
	public void stampa(String msg) {
		System.out.println(msg);
	}
	
}
