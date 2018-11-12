package it.corsoJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Classe_FILE {

	public static final String PERCORSO = "D:\\mioFile.txt";

	public static void main(String[] args) {

		try {
			File f = new File(PERCORSO);
			if (!f.exists())
				f.createNewFile();

			FileWriter fw = new FileWriter(f);
			fw.write("CIAO CIAO");
			fw.close();

			Scanner in = new Scanner(new FileInputStream(f));
			while (in.hasNext()) {
				System.out.println(in.nextLine());
			}
			in.close();
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public int hashCode() {
		return Objects.hashCode(1+2+3);
	}
}
