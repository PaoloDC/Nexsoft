package proxy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class ProxyExample {
	public static void main(String[] args) {
		File f = new File("segreti.txt");
		PrintWriter pw = null;
		if (!f.exists()) {
			try {
				f.createNewFile();
				String[] frase = {"ciao","sono","io","quello","che","scrive","il","file"};
				pw = new PrintWriter(new FileOutputStream(f));
				
//				for(String s : frase) 
//					pw.println(s);
				
				Arrays.asList(frase).stream().forEach(pw::println);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				pw.close();
			}
		}
		FileHandler fh = new ProxyFileHandler(f.getAbsolutePath());
		System.out.println("** The name of the file is: ");
		System.out.println(fh.getFileName());
		System.out.println("** The content of the file is: ");
		System.out.println(fh.getContent());
		System.out.println("** The content of the file is (again):");
		System.out.println(fh.getContent());
		System.out.println("** The content of line 2 is: ");
		System.out.println(fh.getLine(2));
		System.out.println("** The content of line 2 is (again): ");
		System.out.println(fh.getLine(2));
		System.out.println("** The content of line 4 is: ");
		System.out.println(fh.getLine(4));
	}
}
