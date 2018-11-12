package v2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import v2.Clinica.Specialista;

public class Main {

	public static final String PERCORSO = "D:\\mioFile.txt";

	public static void main(String[] args) {
		Clinica c = new Clinica();

		c.prenota("MARCO", Specialista.DENTISTA);
		c.prenota("MARIO", Specialista.OCULISTA);
		c.prenota("LUCA", Specialista.OTORINO);
		c.prenota("PAOLO", Specialista.PEDIATRA);
		
		 System.out.println(c.getNumeroPrenotazioni());
		 System.out.println(c.getListaPrenotazioni());
		 System.out.println(c.getStringaPrenotazioni());
		 
		 System.out.println("false : " + c.prenota("MARCO", Specialista.OCULISTA));
		 System.out.println("false : " + c.prenota("MARCO", Specialista.DENTISTA));
		 
		 System.out.println("false : " + c.cancellaPrenotazione("MARCO",
		 Specialista.OCULISTA)); System.out.println("true : " +
		 c.cancellaPrenotazione("MARCO", Specialista.DENTISTA));
		 System.out.println("false : " + c.cancellaPrenotazione("MARCO",
		 Specialista.DENTISTA));
		 
		 System.out.println(c.getNumeroPrenotazioni());
		 System.out.println(c.getListaPrenotazioni());
		 System.out.println(c.getStringaPrenotazioni());
		
		c.scriviPrenotazioniSuFile(PERCORSO);
		c.cancellaPrenotazioni();

		System.out.println(c.getNumeroPrenotazioni());
		System.out.println(c.getListaPrenotazioni());
		System.out.println(c.getStringaPrenotazioni());

		c.leggiPrenotazioniDaFile(PERCORSO);

		System.out.println(c.getNumeroPrenotazioni());
		System.out.println(c.getListaPrenotazioni());
		System.out.println(c.getStringaPrenotazioni());

		try {
			File f = new File(PERCORSO);
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(f));
			out.writeObject(c);
			out.close();
			
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
			Clinica c2 = (Clinica) in.readObject();
			in.close();
			
			System.out.println(c2.getListaPrenotazioni());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
