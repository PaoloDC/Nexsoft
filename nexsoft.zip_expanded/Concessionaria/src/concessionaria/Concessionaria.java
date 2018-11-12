package concessionaria;

import java.util.ArrayList;

import veicoli.*;

public class Concessionaria {
	//variabili di istanza
	private ArrayList<Veicolo> listaVeicoli;
	
	//costruttore
	public Concessionaria() {
		listaVeicoli = new  ArrayList<>();
	}
	
	public Concessionaria(ArrayList<Veicolo> lista) {
		this.listaVeicoli = lista;
	}

	//metodi
	public void aggiungiVeicolo(Veicolo v) {
		listaVeicoli.add(v);
	}
	
	public void eliminaVeicolo(Veicolo v) {
		listaVeicoli.remove(v);
	}
	
	public void eliminaVeicolo(int indice) {
		listaVeicoli.remove(indice);
	}
	
	public ArrayList<Auto> getAllAuto(){
		ArrayList<Auto> daRestituire = new ArrayList<>();
		for(Veicolo v : listaVeicoli) {
			if (v instanceof Auto) {
				daRestituire.add((Auto) v);
			}
		}
		return daRestituire;
	}
	
	public ArrayList<Moto> getAllMoto(){
		ArrayList<Moto> daRestituire = new ArrayList<>();
		for(Veicolo v : listaVeicoli) {
			if (v instanceof Moto) {
				daRestituire.add((Moto) v);
			}
		}
		return daRestituire;
	}
	
	public ArrayList<Veicolo> getAllVeicolo(){
		return this.listaVeicoli;
	}
	
	@Override
	public String toString() {
		String daRestituire = "Concessionaria:\n";
		
		for(Veicolo v : listaVeicoli) {
			daRestituire += v.toString() + "\n";
		}
		
		return daRestituire;
	}

}
