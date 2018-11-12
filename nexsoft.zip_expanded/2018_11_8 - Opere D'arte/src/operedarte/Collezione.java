package operedarte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import eccezioni.OperaDarteException;

public class Collezione implements Serializable {
	// variabili di istanza
	private String nome;
	private ArrayList<OperaDarte> listaOpere;
	private static final long serialVersionUID = 4L;
	public static final String PERCORSO_FILE = "opere.dat";

	// costruttore
	/**
	 * Istanzia una nuova collezione, indicandone il nome, che non contiene opere
	 * d'arte
	 * 
	 * @param nome
	 *            stringa che indica il nome della collezione
	 */
	public Collezione(String nome) {
		this.nome = nome;
		listaOpere = new ArrayList<>();
	}

	/**
	 * Istanzia una nuova collezione, indicando il nome e una lista di opere d'arte
	 * 
	 * @param nome
	 *            stringa che indica il nome della collezione
	 * @param listaOpere
	 *            array list di opere d'arte contenute nella collezione
	 */
	public Collezione(String nome, ArrayList<OperaDarte> listaOpere) {
		this.nome = nome;
		this.listaOpere = listaOpere;
	}

	// metodi
	public ArrayList<OperaDarte> getListaOpere() {
		return listaOpere;
	}

	public void setListaOpere(ArrayList<OperaDarte> listaOpere) {
		this.listaOpere = listaOpere;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Permette di inserire un'opera d'arte all'interno della collezione
	 * 
	 * @param o
	 *            l'opera d'arte da inserire
	 */
	public void inserisciOperaDarte(OperaDarte o) {
		if(null == o)
			return;
		listaOpere.add(o);
	}

	/**
	 * Permette di inserire un'opera d'arte all'interno della collezione Nello
	 * specifico permette di inserire un QUADRO, indicandone i parametri
	 * 
	 * @param titolo
	 *            stringa che indica il titolo dato al quadro
	 * @param artista
	 *            stringa che indica il nome dell'artista che ha dipinto il quadro
	 * @param altezza
	 *            double che indica l'altezza del quadro
	 * @param larghezza
	 *            double che indica la larghezza del quadro
	 */
	public void inserisciOperaDarte(String titolo, String artista, double altezza, double larghezza) {
		listaOpere.add(new Quadro(titolo, artista, altezza, larghezza));
	}

	/**
	 * Permette di inserire un'opera d'arte all'interno della collezione Nello
	 * specifico permette di inserire una SCULTURA, indicandone i parametri
	 * 
	 * @param titolo
	 *            stringa che indica il titolo dato alla scultura
	 * @param artista
	 *            stringa che indica il nome dell'artista che ha creato la scultura
	 * @param altezza
	 *            double che indica l'altezza della scultura
	 * @param larghezza
	 *            double che indica la larghezza della scultura
	 * @param profondità
	 *            double che indica la profondità della scultura
	 */
	public void inserisciOperaDarte(String titolo, String artista, double altezza, double larghezza,
			double profondita) {
		listaOpere.add(new Scultura(titolo, artista, altezza, larghezza, profondita));
	}

	/**
	 * Restituisce una descrizione di tutte le opere d'arte contenute nella
	 * collezione
	 * 
	 * @return una stringa formattata che indica tutte le opere d'arte
	 * 
	 */
	public String stampaCollezione() {
		if (listaOpere.size() == 0)
			return "La collezione '" + this.getNome() + "' è vuota";
		String s = "La collezione '" + this.getNome() + "' contiene:\n";
		for (OperaDarte od : listaOpere) {
			s += od.toString() + "\n";
		}
		return s;
	}

	/**
	 * Restituisce l'inbombro di una certa opera, ricercata in base al titolo
	 * 
	 * @param titoloOpera
	 *            stringa che indica il titolo dell'opera da cercare
	 * @return un double che corrisponde all'ingombro dell'opera
	 * @throws OperaDarteException se non trova l'opera d'arte
	 */
	public double getIngombroOpera(String titoloOpera) throws OperaDarteException {
		for (OperaDarte o : listaOpere) {
			if (o.getTitolo().equals(titoloOpera))
				return o.printingombro();
		}
		throw new OperaDarteException();
	}

	/**
	 * Restituisce l'inbombro di una certa opera
	 * 
	 * @param op
	 *            opera d'arte da cercare nella collezione
	 * @return un double che corrisponde all'ingombro dell'opera, -1 se l'opera non
	 *         è presente
	 * @throws OperaDarteException se non trova l'opera d'arte
	 */
	public double getIngombroOpera(OperaDarte op) throws OperaDarteException {
		if (listaOpere.contains(op))
			return op.printingombro();
		throw new OperaDarteException();
	}

	/**
	 * Restituisce l'ingombro di tutta la collezione
	 * 
	 * @return un double che corrisponde all'ingombro di tutta la collezione, -1 se
	 *         la collezione è vuota
	 * @throws OperaDarteException se la collezione è vuota
	 */
	public double getIngombroCollezione() throws OperaDarteException {
		if (listaOpere.size() == 0)
			throw new OperaDarteException();

		double in = 0;
		for (OperaDarte o : listaOpere)
			in += o.printingombro();

		return in;
	}

	@Override
	public String toString() {
		return "Collezione [ " + this.getNome() + " " + this.getListaOpere() + " ]";
	}

	public void salvaCollezioneSuFile() {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(PERCORSO_FILE)));
			oos.writeObject(nome);
			oos.writeObject(listaOpere);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void caricaCollezioneDaFile() {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(new File(PERCORSO_FILE)));
			nome = (String) in.readObject();
			listaOpere = (ArrayList<OperaDarte>) in.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
