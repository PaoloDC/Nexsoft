package model.paser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileGenerator {

	public enum percorsi {
		E_CAYENNE("D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\equipaggiamenti\\cayenne"), 
		E_CUSTOM("D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\equipaggiamenti\\custom");

		private String path;

		public String getPath() {
			return path;
		}

		private percorsi(String s) {
			this.path = s;
		}
	}

	public static void main(String[] args) {
//		creaFileCustom(
//				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\anagrafiche\\cayenne", 
//				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\anagrafiche\\custom", 
//				"anagrafiche");
		
		creaFileCustom(
				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\usato\\cayenne",
				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\usato\\custom",
				"usato"
				);
		
		creaFileCustom(
				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\identificazione\\cayenne",
				"D:\\Documenti\\GitHub\\Nexsoft\\TutorialCayenne\\src\\main\\java\\model\\paser\\identificazione\\custom",
				"identificazione"
				);
	}

	private static ArrayList<String> listaNomiFileInFolder(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		ArrayList<String> nomiFile = new ArrayList<>();

		for (File f : listOfFiles) {
			String nome = f.getName();
			nome = nome.substring(0, nome.indexOf("."));
			nome = nome.concat(".class,");
			nomiFile.add(nome);
		}

		return nomiFile;
	}

	private static void creaFileCustom(String pathCayenne, String pathCustom, String packageName) {

		File folder = new File(pathCayenne);

		for (File file : folder.listFiles()) {

			String nomeFile = file.getName().substring(1);
			String nomeClasse = nomeFile.substring(0, nomeFile.indexOf("."));
			File f = new File(pathCustom + "/" + nomeFile);

			try {
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);

				String scrivi = "package model.paser."+packageName+".custom;\r\n" + 
						"\r\n" + 
						"import model.paser."+packageName+".cayenne._"+nomeClasse+";\r\n" + 
						"\r\n" + 
						"public class "+nomeClasse+" extends _"+nomeClasse+" {\r\n" + 
						"\r\n" + 
						"	//variabili di istanza\r\n" + 
						"	\r\n" + 
						"	//costruttore\r\n" + 
						"	public "+nomeClasse+"() {\r\n" + 
						"\r\n" + 
						"	}\r\n" + 
						"\r\n" + 
						"	//metodi\r\n" + 
						"	\r\n" + 
						"}";
				pw.println(scrivi);

				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void creaFileCustomEquipaggiamenti() {

		File folder = new File(percorsi.E_CAYENNE.getPath());

		for (File file : folder.listFiles()) {

			String nomeFile = file.getName().substring(1);
			String nomeClasse = nomeFile.substring(0, nomeFile.indexOf("."));
			File f = new File(percorsi.E_CUSTOM.getPath() + "/" + nomeFile);

			try {
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);

				String scrivi = "package model.paser.equipaggiamenti.custom;\r\n" + "\r\n"
						+ "import model.paser.equipaggiamenti.cayenne._" + nomeClasse + ";\r\n" + "\r\n"
						+ "public class " + nomeClasse + " extends _" + nomeClasse + " {\r\n" + "\r\n"
						+ "	//variabili di istanza\r\n" + "	\r\n" + "	//costruttore\r\n" + "	public " + nomeClasse
						+ "() {\r\n" + "\r\n" + "	}\r\n" + "\r\n" + "	//metodi\r\n" + "	\r\n" + "}";
				pw.println(scrivi);

				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
