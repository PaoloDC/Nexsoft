import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TestPersonal {
	//variabili di istanza
	public static final String KEY_USERNAME = "username";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_DRIVER = "driver";
	public static final String KEY_URL = "url";
	public static final String KEY_DB_NAME = "database";
	
	public static final String FILENAME = "/cayenne-personal.xml";
	//main
	public static void main(String[] args){
		String username = System.getProperty(KEY_USERNAME, "root");
		String password = System.getProperty(KEY_PASSWORD, "root");
		String driver = System.getProperty(KEY_DRIVER, "com.mysql.jdbc.Driver");
		String url = System.getProperty(KEY_URL, "jdbc:mysql://localhost/infocardb40?serverTimezone=Europe/Amsterdam");
		String dbName = System.getProperty(KEY_DB_NAME, "infocardb40");
		
		System.out.println(username);
		System.out.println(password);
		System.out.println(driver);
		System.out.println(url);
		System.out.println(dbName);
		
		String pathAssoluto = "";
		String xmlFileContent = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n" + 
				"<domain project-version=\"9\">\r\n" + 
				"	<map name=\"datamap\"/>\r\n" + 
				"\r\n" + 
				"	<node name=\"infocar_datanode\"\r\n" + 
				"		 factory=\"org.apache.cayenne.configuration.server.XMLPoolingDataSourceFactory\"\r\n" + 
				"		 schema-update-strategy=\"org.apache.cayenne.access.dbsync.SkipSchemaUpdateStrategy\"\r\n" + 
				"		>\r\n" + 
				"		<map-ref name=\"datamap\"/>\r\n" + 
				"		<data-source>\r\n" + 
				"			<driver value=\""+driver+"\"/>\r\n" + 
				"			<url value=\""+url+"\"/>\r\n" + 
				"			<connectionPool min=\"1\" max=\"1\"/>\r\n" + 
				"			<login userName=\""+username+"\" password=\""+password+"\"/>\r\n" + 
				"		</data-source>\r\n" + 
				"	</node>\r\n" + 
				"</domain>";
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(pathAssoluto + FILENAME));
			out.print(xmlFileContent);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
		
		
//		String path = "D:\\test.txt";
//		Scanner in = new Scanner(new File(path));
//		
//		int contaFirma = 0, contaCommento = 0;
//		while(in.hasNextLine()) {
//			String riga = in.nextLine();
//			if(riga.contains("public void salva"))
//				contaFirma++;
//			else if(riga.contains("fine metodo"))
//				contaCommento++;
//		}
//		
//		System.out.println("firme: " + contaFirma);
//		System.out.println("commenti: " + contaCommento);
//		
//		in.close();
		
		
	}

}
