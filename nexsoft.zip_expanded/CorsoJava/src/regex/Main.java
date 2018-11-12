package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String stringa = "Ciao ciao, sono quello che";
	
		System.out.println(stringa.replaceAll("[a-h]", "h"));
		
		String regex = "a-c";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(stringa);
		
		while(matcher.find()) {
			
		}
	}
	
	
}
