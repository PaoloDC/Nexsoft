

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileGenerator {

	public static final String PATH_BEAN_A = "D:\\Documenti\\infocar\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\anagrafiche";
	public static final String PATH_BEAN_E = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\equipaggiamenti";
	public static final String PATH_BEAN_U = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\usato";
	public static final String PATH_BEAN_I = "D:\\Documenti\\infocar\\infocarparser\\src\\main\\java\\com\\nexsoft\\infocar\\bean\\identificazione";
	
	public static final String PATH_TEST_A = "D:\\Documenti\\infocar\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\filler\\test\\anagrafiche";
	public static final String PATH_TEST_E = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\equipaggiamenti";
	public static final String PATH_TEST_U = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\usato";
	public static final String PATH_TEST_I = "D:\\Documenti\\infocar\\infocarparser\\src\\test\\java\\com\\nexsoft\\infocar\\parser\\test\\identificazione";
	
	public static void main(String[] args) {
		ArrayList<String> nomiClassi = listaNomiFileInFolder(PATH_BEAN_A);
		System.out.println(nomiClassi);
		ArrayList<String> nomiTabelle = getNomiTabelleDB();
		System.out.println(nomiTabelle);
		
		for(int i=0 ; i < nomiClassi.size() ; i++) {
			scriviMetodo(nomiClassi.get(i), nomiTabelle.get(i));
		}
	}
	
	private static ArrayList<String> getNomiTabelleDB(){
		String tables = "anagrafica_allestimenti\r\n" + 
				"anagrafica_motivazioni_periodi_quotazioni_usato\r\n" + 
				"anagrafica_raggruppamento_modelli\r\n" + 
				"anagrafica_segmenti\r\n" + 
				"categoria_veicolo\r\n" + 
				"codici_casa_anagrafica\r\n" + 
				"cross_raggruppamento_modelli\r\n" + 
				"dispositivi_antiinquinamento\r\n" + 
				"disposizione_cilindri\r\n" + 
				"anagrafica_marche\r\n" + 
				"anagrafica_modelli\r\n" + 
				"norme_antiinquinamento\r\n" + 
				"raggruppamento_tipo_carrozzeria\r\n" + 
				"sovralimentazione\r\n" + 
				"tipo_cambio\r\n" + 
				"tipo_carrozzeria\r\n" + 
				"tipo_combustibile\r\n" + 
				"consumo\r\n" + 
				"tipo_ibridizzazione\r\n" + 
				"tipo_impianto\r\n" + 
				"tipo_pneumatici\r\n" + 
				"tipo_struttura_pneumatici\r\n" + 
				"tipo_tetto\r\n" + 
				"tipo_trazione\r\n" + 
				"tipo_variazione\r\n" + 
				"vista_foto";
		String[] tabelle = tables.split("\r\n");
		ArrayList<String> list = new ArrayList<>();
		for(String s : tabelle) {
			list.add(s);	
		}
		return list;
	}
	
	private static void scriviMetodo(String nomeClasse,String nomeTabella) {
		
		String templateMethod = "	@Test\r\n" + 
				"	public void test"+nomeClasse+"() {\r\n" + 
				"		int numeroRigheFile = DEFAULT_VALUE_INT;\r\n" + 
				"		numeroRigheFile = FileHandler.getNumeroRigheNelFile("+nomeClasse+".NOME_FILE);\r\n" + 
				"		Assert.assertNotEquals(numeroRigheFile,DEFAULT_VALUE_INT);\r\n" + 
				"		String sql = \"SELECT COUNT(*) FROM INFOCARDB40."+nomeTabella+"\";\r\n" + 
				"\r\n" + 
				"		int numeroRigheTabellaDB = DEFAULT_VALUE_INT;\r\n" + 
				"		try {\r\n" + 
				"			PreparedStatement ps = DBHandler.getConnection().prepareStatement(sql);\r\n" + 
				"			ResultSet rs = ps.executeQuery();\r\n" + 
				"			assertTrue(rs.next());\r\n" + 
				"			numeroRigheTabellaDB = rs.getInt(1);\r\n" + 
				"		} catch (SQLException e) {\r\n" + 
				"			e.printStackTrace();\r\n" + 
				"		}\r\n" + 
				"		\r\n" + 
				"		Assert.assertNotEquals(numeroRigheTabellaDB, DEFAULT_VALUE_INT);\r\n" + 
				"		Assert.assertEquals(numeroRigheFile,numeroRigheTabellaDB);\r\n" + 
				"	} // fine metodo test"+nomeClasse;
		System.out.println(templateMethod);
	}
	
	private static ArrayList<String> listaNomiFileInFolder(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

//		String tabelle = "TRUNCATE TABLE anagrafica_allestimenti;\r\n" + 
//				"TRUNCATE TABLE anagrafica_marche;\r\n" + 
//				"TRUNCATE TABLE anagrafica_modelli;\r\n" + 
//				"TRUNCATE TABLE anagrafica_motivazioni_periodi_quotazioni_usato;\r\n" + 
//				"TRUNCATE TABLE anagrafica_normalizzati;\r\n" + 
//				"TRUNCATE TABLE anagrafica_raggruppamento_modelli;\r\n" + 
//				"TRUNCATE TABLE anagrafica_segmenti;\r\n" + 
//				"TRUNCATE TABLE anagrafica_status;\r\n" + 
//				"TRUNCATE TABLE anagrafica_ufficiali;\r\n" + 
//				"TRUNCATE TABLE base;\r\n" + 
//				"TRUNCATE TABLE cambi_e_prestazioni;\r\n" + 
//				"TRUNCATE TABLE categoria_veicolo;\r\n" + 
//				"TRUNCATE TABLE cause_anno_mese;\r\n" + 
//				"TRUNCATE TABLE chilometraggio_standard_complessivo;\r\n" + 
//				"TRUNCATE TABLE codici_casa_anagrafica;\r\n" + 
//				"TRUNCATE TABLE codici_casa_identificazione;\r\n" + 
//				"TRUNCATE TABLE composizione_pacchetti;\r\n" + 
//				"TRUNCATE TABLE consumo;\r\n" + 
//				"TRUNCATE TABLE cross_raggruppamento_modelli;\r\n" + 
//				"TRUNCATE TABLE cross_rcl;\r\n" + 
//				"TRUNCATE TABLE dati_tecnici_base;\r\n" + 
//				"TRUNCATE TABLE dati_tecnici_specifici_per_ibridi;\r\n" + 
//				"TRUNCATE TABLE dettagli_nucleo_motore;\r\n" + 
//				"TRUNCATE TABLE dettagli_nucleo_trasmissione;\r\n" + 
//				"TRUNCATE TABLE dettaglio_segmenti;\r\n" + 
//				"TRUNCATE TABLE dispositivi_antiinquinamento;\r\n" + 
//				"TRUNCATE TABLE disposizione_cilindri;\r\n" + 
//				"TRUNCATE TABLE edizione;\r\n" + 
//				"TRUNCATE TABLE edizione_quotazioni;\r\n" + 
//				"TRUNCATE TABLE esclusioni;\r\n" + 
//				"TRUNCATE TABLE foto;\r\n" + 
//				"TRUNCATE TABLE inclusioni;\r\n" + 
//				"TRUNCATE TABLE informazioni_aggiuntive;\r\n" + 
//				"TRUNCATE TABLE informazioni_aggiuntive_usato;\r\n" + 
//				"TRUNCATE TABLE intestazione;\r\n" + 
//				"TRUNCATE TABLE listini_nuovo;\r\n" + 
//				"TRUNCATE TABLE listini_ufficiali;\r\n" + 
//				"TRUNCATE TABLE norme_antiinquinamento;\r\n" + 
//				"TRUNCATE TABLE pneumatici;\r\n" + 
//				"TRUNCATE TABLE quotazioni;\r\n" + 
//				"TRUNCATE TABLE raggruppamento_tipo_carrozzeria;\r\n" + 
//				"TRUNCATE TABLE riferimenti_infocar_eliminati;\r\n" + 
//				"TRUNCATE TABLE sovralimentazione;\r\n" + 
//				"TRUNCATE TABLE tipo_cambio;\r\n" + 
//				"TRUNCATE TABLE tipo_carrozzeria;\r\n" + 
//				"TRUNCATE TABLE tipo_combustibile;\r\n" + 
//				"TRUNCATE TABLE tipo_ibridizzazione;\r\n" + 
//				"TRUNCATE TABLE tipo_impianto;\r\n" + 
//				"TRUNCATE TABLE tipo_pneumatici;\r\n" + 
//				"TRUNCATE TABLE tipo_struttura_pneumatici;\r\n" + 
//				"TRUNCATE TABLE tipo_tetto;\r\n" + 
//				"TRUNCATE TABLE tipo_trazione;\r\n" + 
//				"TRUNCATE TABLE tipo_variazione;\r\n" + 
//				"TRUNCATE TABLE vincoli;\r\n" + 
//				"TRUNCATE TABLE vista_foto;";
//		
//		String[] tab = tabelle.replace("TRUNCATE TABLE ", "").replaceAll("\r\n", "").split(";");
//		for(String s : tab) {
//		//	System.out.println(s);
//		}
//		
//		String tempo = "db.checkSize(Allestimenti.NOME_FILE,\"anagrafica_allestimenti\");\r\n" + 
//				"		db.checkSize(AnagraficaMotivazioniPeriodiQuotazioniUsato.NOME_FILE,\"anagrafica_motivazioni_periodi_quotazioni_usato\");\r\n" + 
//				"		db.checkSize(AnagraficaRaggruppamentoModelli.NOME_FILE,\"anagrafica_raggruppamento_modelli\");\r\n" + 
//				"		db.checkSize(AnagraficaSegmenti.NOME_FILE,\"anagrafica_segmenti\");\r\n" + 
//				"		db.checkSize(CategoriaVeicolo.NOME_FILE,\"categoria_veicolo\");\r\n" + 
//				"		db.checkSize(CodiciCasa.NOME_FILE,\"codici_casa_anagrafica\");\r\n" + 
//				"		db.checkSize(CrossRaggruppamentoModelli.NOME_FILE,\"cross_raggruppamento_modelli\");\r\n" + 
//				"		db.checkSize(DispositiviAntiInquinamento.NOME_FILE,\"dispositivi_antiinquinamento\");\r\n" + 
//				"		db.checkSize(DisposizioneCilindri.NOME_FILE,\"disposizione_cilindri\");\r\n" + 
//				"		db.checkSize(Marche.NOME_FILE,\"anagrafica_marche\");\r\n" + 
//				"		db.checkSize(Modelli.NOME_FILE,\"anagrafica_modelli\");\r\n" + 
//				"		db.checkSize(NormeAntiInquinamento.NOME_FILE,\"norme_antiinquinamento\");\r\n" + 
//				"		db.checkSize(RaggruppamentoTipoCarrozzeria.NOME_FILE,\"raggruppamento_tipo_carrozzeria\");\r\n" + 
//				"		db.checkSize(Sovralimentazione.NOME_FILE,\"sovralimentazione\");\r\n" + 
//				"		db.checkSize(TipoCambio.NOME_FILE,\"tipo_cambio\");\r\n" + 
//				"		db.checkSize(TipoCarrozzeria.NOME_FILE,\"tipo_carrozzeria\");\r\n" + 
//				"		db.checkSize(TipoCombustibile.NOME_FILE,\"tipo_combustibile\");\r\n" + 
//				"		db.checkSize(TipoConsumo.NOME_FILE,\"consumo\");\r\n" + 
//				"		db.checkSize(TipoIbridizzazione.NOME_FILE,\"tipo_ibridizzazione\");\r\n" + 
//				"		db.checkSize(TipoImpianto.NOME_FILE,\"tipo_impianto\");\r\n" + 
//				"		db.checkSize(TipoPneumatici.NOME_FILE,\"tipo_pneumatici\");\r\n" + 
//				"		db.checkSize(TipoStrutturaPneumatici.NOME_FILE,\"tipo_struttura_pneumatici\");\r\n" + 
//				"		db.checkSize(TipoTetto.NOME_FILE,\"tipo_tetto\");\r\n" + 
//				"		db.checkSize(TipoTrazione.NOME_FILE,\"tipo_trazione\");\r\n" + 
//				"		db.checkSize(TipoVariazione.NOME_FILE,\"tipo_variazione\");";
//		
//		System.out.println();
//		tempo = tempo.replace("db.checkSize", "System.out.println(db.checkSize");
//		System.out.println(tempo);
		
		ArrayList<String> nomiFile = new ArrayList<>();
		for (File f : listOfFiles) {
			String nome = f.getName();
			nome = nome.substring(0, nome.indexOf("."));
			nomiFile.add(nome);
			//nomiFile.add(nome);
			//String text = "\"IDAT1600F_folder/"+f.getName()+"\",";
			//nomiFile.add("\""+f.getName()+"\",");
			
			//System.out.println("db.checkSize("+nome+",\"aaaaaaaaaaa\");");
		}
		
		return nomiFile;
	}
	
	private static ArrayList<String> rimuoviPuntoJava(String path){
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		
		ArrayList<String> nomiFile = new ArrayList<>();
		for (File f : listOfFiles) {
			String nome = f.getName();
			nome = nome.substring(0, nome.indexOf("."));
			nomiFile.add(nome);
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
