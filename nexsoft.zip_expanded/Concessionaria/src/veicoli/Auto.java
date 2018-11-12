package veicoli;

public class Auto extends Veicolo {

	// variabili di istanza
	private int numPortiere;
	private boolean ruotaDiScorta;

	// costruttore
	/**
	 * Inizializza un nuovo oggetto di tipo Auto
	 * 
	 * @param marca
	 *            stringa che indica la marca dell'auto
	 * @param modello
	 *            stringa che indica il modello dell'auto
	 * @param cilindrata
	 *            intero che indica la cilindrata dell'auto, espressa in cm3
	 * @param cavalli
	 *            intero che indica il numero di cavalli dell'auto
	 * @param prezzo
	 *            double che indica il prezzo dell'auto
	 * @param numPortiere
	 *            il numero di portiere dell'auto
	 * @param ruotaDiScorta
	 *            vale true se presente la ruota di scorta, false altrimenti
	 */
	public Auto(String marca, String modello, int cilindrata, int cavalli, double prezzo, int numPortiere,
			boolean ruotaDiScorta) {
		super(marca, modello, cilindrata, cavalli, prezzo);
		this.numPortiere = numPortiere;
		this.ruotaDiScorta = ruotaDiScorta;
	}

	// metodi getter e setter
	public int getNumPortiere() {
		return numPortiere;
	}

	public void setNumPortiere(int numPortiere) {
		this.numPortiere = numPortiere;
	}

	public boolean isRuotaDiScorta() {
		return ruotaDiScorta;
	}

	public void setRuotaDiScorta(boolean ruotaDiScorta) {
		this.ruotaDiScorta = ruotaDiScorta;
	}

	/**
	 * Restituisce una rappresentazione sottoforma di stringa dell'oggetto attuale
	 */
	@Override
	public String toString() {
		return "Auto [marca: " + this.getMarca() + ", Modello: " + this.getModello() + ", Cilindrata: "
				+ this.getCilindrata() + ", Cavalli: " + this.getCavalli() + ", Prezzo: " + this.getPrezzo()
				+ ", Numero Portiere: " + this.numPortiere + ", Ruota di scorta: " + this.ruotaDiScorta;
	}

	/**
	 * Confronta l'oggetto attuale con quello passato restituisce true se i due
	 * oggetti hanno lo stesso valori per tutte le variabili di istanza restituisce
	 * false altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Auto) {
			Auto a = (Auto) obj;
			return a.getMarca().equals(this.getMarca()) && a.getModello().equals(this.getModello())
					&& a.getCilindrata() == this.getCilindrata() && a.getCavalli() == this.getCavalli()
					&& a.getPrezzo() == this.getPrezzo() && a.getNumPortiere() == this.numPortiere
					&& a.isRuotaDiScorta() == this.ruotaDiScorta;
		}
		return false;
	}

	/**
	 * Restituisce un oggetto di tipo Auto che avrà gli stessi valori, per le
	 * variabili di istanza, dell'oggetto attuale
	 */
	@Override
	public Auto clone() {
		try {
			return new Auto(this.getMarca(), this.getModello(), this.getCilindrata(), this.getCavalli(),
					this.getPrezzo(), this.getNumPortiere(), this.isRuotaDiScorta());
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally");
		}
		return null;
	}

}
