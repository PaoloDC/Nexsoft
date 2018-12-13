
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileGenerator {

	public static final String PATH_BEAN_A = "./src";
	public static final String PATH_BEAN_E = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\equipaggiamenti";
	public static final String PATH_BEAN_U = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\usato";
	public static final String PATH_BEAN_I = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\identificazione";
	
	public static final String PATH_TEST_A = "D:\\Documenti\\infocar\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\filler\\test\\anagrafiche";
	public static final String PATH_TEST_E = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\equipaggiamenti";
	public static final String PATH_TEST_U = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\usato";
	public static final String PATH_TEST_I = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\identificazione";
	
	public static void main(String[] args) {
		listaNomiFileInFolder("D:\\Documenti\\infocar\\infocar\\infocarparser\\src\\main\\resources\\Infocar_On_Line_AC\\IDAT1600F_folder");
	}
	
	private static ArrayList<String> listaNomiFileInFolder(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		ArrayList<String> nomiFile = new ArrayList<>();
		
		for (File f : listOfFiles) {
//			String nome = f.getName();
//			nome = nome.substring(0, nome.indexOf("."));
//			nome = nome.concat(".class,");
//			nomiFile.add(nome);
			String text = "\"IDAT1600F_folder/"+f.getName()+"\",";
			System.out.println(text);
			nomiFile.add("\""+f.getName()+"\",");
		}
		
		return nomiFile;
	}
	
	private static void creaFileTestAnagrafica() {
		File folder = new File(PATH_BEAN_A);
		File[] listOfFiles = folder.listFiles();

		ArrayList<String> nomiFile = new ArrayList<>();
		ArrayList<String> nomiClassi = new ArrayList<>();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			String nome = listOfFiles[i].getName();
			nome = nome.substring(0, nome.indexOf("."));
			nomiClassi.add(nome);
			nome = nome.concat("Test");
			nomiFile.add(nome);
		}

		nomiFile.forEach(System.out::println);

		for (int i=0 ; i < nomiFile.size() ; i++) {
			
			String nomeFileTest = nomiFile.get(i);
			String nomeClasse = nomiClassi.get(i);
			
			File f = new File(PATH_TEST_A + "/" + nomeFileTest + ".java");

			//vale per package equipaggiamenti
			//String nomeParser = nomeClasse 
			
			String nomeParser = nomeClasse.substring(0, 1);
			nomeParser = nomeParser.toLowerCase();

			nomeParser = nomeParser.concat(nomeClasse.substring(1));
			System.out.println(nomeParser);
			
			try {
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);
				
				String scrivi = ""
						+ "package com.nexsoft.infocar.parser.test.anagrafiche;\r\n" + 
						"\r\n" + 
						"import java.io.IOException;\r\n" + 
						"import java.util.List;\r\n" + 
						"import java.io.LineNumberReader;\r\n" + 
						"\r\n" + 
						"import org.beanio.BeanIOConfigurationException;\r\n" + 
						"import org.junit.Assert;\r\n" + 
						"import org.junit.Test;\r\n" + 
						"\r\n" + 
						"import com.nexsoft.infocar.bean.anagrafiche."+ nomeClasse +";\r\n" + 
						"import com.nexsoft.infocar.parser.Parser;\r\n" + 
						"import com.nexsoft.infocar.parser.test.FileHandler;"
						+ ""
						+ "/**\r\n" + 
						" * \r\n" + 
						" * Classe che testa la lettura del file contenente i dati e memorizza i valori\r\n" + 
						" * nei file bean "+ nomeClasse + " \r\n" + 
						" * \r\n" + 
						" * @author Paolo De Cristofaro\r\n" + 
						" *\r\n" + 
						" */"
						+ "\r\n\r\n public class " +nomeFileTest+ " {\r\n" + 
						"	@Test\r\n" + 
						"	public void testLettura() {\r\n" + 
						"		Parser<" + nomeClasse + "> p = new Parser<>(\""+ nomeParser +"\", Parser.MAPPING_FILE.ANAGRAFICHE,\r\n" + 
						"				FileHandler.PATH + "+nomeClasse+".NOME_FILE, "+nomeClasse+".class);\r\n" + 
						"\r\n" + 
						"		Assert.assertNotNull(p);\r\n" + 
						"\r\n" + 
						"		List<"+ nomeClasse +"> parse = null;\r\n" + 
						"		try {\r\n" + 
						"			parse = p.parse();\r\n" + 
						"		} catch (BeanIOConfigurationException e) {\r\n" + 
						"			e.printStackTrace();\r\n" + 
						"		} catch (IOException e) {\r\n" + 
						"			e.printStackTrace();\r\n" + 
						"		}\r\n" + 
						"		Assert.assertNotNull(parse);\r\n" + 
						"		\r\n" + 
						"\r\n" + 
						"int numeroRighe = FileHandler.getNumeroRigheNelFile(FileHandler.PATH + "+ nomeClasse +".NOME_FILE);\r\n" + 
						"		Assert.assertEquals(numeroRighe, parse.size());" +		
						"	}}\r\n";
						
				pw.println(scrivi);
				
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	
	private static void creaFileTestEquipaggiamenti() {

		File folder = new File(PATH_BEAN_E);
		File[] listOfFiles = folder.listFiles();

		ArrayList<String> nomiFile = new ArrayList<>();
		ArrayList<String> nomiClassi = new ArrayList<>();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			String nome = listOfFiles[i].getName();
			nome = nome.substring(0, nome.indexOf("."));
			nomiClassi.add(nome);
			nome = nome.concat("Test");
			nomiFile.add(nome);
		}

		nomiFile.forEach(System.out::println);

		for (int i=0 ; i < nomiFile.size() ; i++) {
			
			String nomeFileTest = nomiFile.get(i);
			String nomeClasse = nomiClassi.get(i);
			
			File f = new File(PATH_TEST_E + "/" + nomeFileTest + ".java");

			//vale per package equipaggiamenti
			String nomeParser = nomeClasse;
			
//			String nomeParser = nomeClasse.substring(0, 1);
//			nomeParser = nomeParser.toLowerCase();
//
//			nomeParser = nomeParser.concat(nomeClasse.substring(1));
//			System.out.println(nomeParser);
			
			try {
				f.createNewFile();
				PrintWriter pw = new PrintWriter(f);
				
				String scrivi = ""
						+ "package com.nexsoft.infocar.parser.test.equipaggiamenti;\r\n" + 
						"\r\n" + 
						"import java.io.IOException;\r\n" + 
						"import java.util.List;\r\n" + 
						"\r\n" + 
						"import org.beanio.BeanIOConfigurationException;\r\n" + 
						"import org.junit.Assert;\r\n" + 
						"import org.junit.Test;\r\n" + 
						"\r\n" + 
						"import com.nexsoft.infocar.bean.equipaggiamenti."+ nomeClasse +";\r\n" + 
						"import com.nexsoft.infocar.parser.Parser;\r\n" + 
						"import com.nexsoft.infocar.parser.test.FileHandler;"
						+ ""
						+ "/**\r\n" + 
						" * \r\n" + 
						" * Classe che testa la lettura del file contenente i dati e memorizza i valori\r\n" + 
						" * nei file bean "+ nomeClasse + " \r\n" + 
						" * \r\n" + 
						" * @author Paolo De Cristofaro\r\n" + 
						" *\r\n" + 
						" */"
						+ "\r\n\r\n public class " +nomeFileTest+ " {\r\n" + 
						"	@Test\r\n" + 
						"	public void testLettura() {\r\n" + 
						"		Parser<" + nomeClasse + "> p = new Parser<>(\""+ nomeParser +"\", Parser.MAPPING_FILE.EQUIPAGGIAMENTI,\r\n" + 
						"				FileHandler.PATH + "+nomeClasse+".NOME_FILE, "+nomeClasse+".class);\r\n" + 
						"\r\n" + 
						"		Assert.assertNotNull(p);\r\n" + 
						"\r\n" + 
						"		List<"+ nomeClasse +"> parse = null;\r\n" + 
						"		try {\r\n" + 
						"			parse = p.parse();\r\n" + 
						"		} catch (BeanIOConfigurationException e) {\r\n" + 
						"			e.printStackTrace();\r\n" + 
						"		} catch (IOException e) {\r\n" + 
						"			e.printStackTrace();\r\n" + 
						"		}\r\n" + 
						"		Assert.assertNotNull(parse);\r\n" + 
						"		\r\n" + 
						"\r\n" + 
						"int numeroRighe = FileHandler.getNumeroRigheNelFile(FileHandler.PATH + "+ nomeClasse +".NOME_FILE);\r\n" + 
						"		Assert.assertEquals(numeroRighe, parse.size());" +		
						"	}}\r\n";
						
				pw.println(scrivi);
				
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}


}
