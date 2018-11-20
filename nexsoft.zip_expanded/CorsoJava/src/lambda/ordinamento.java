package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ordinamento {

	public static void main(String[] args) {

		
		List<String> list = new ArrayList(Arrays.asList("alba rossa", "alba chiara", "mare nero", "luna rossa", "luna blu",
				"hanno ucciso l'uomo ragno"));
//		System.out.println(list);
////		list.sort((c1,c2)-> c1.compareTo(c2));
//		list.sort(Comparator.naturalOrder());
//		System.out.println(list);
		
		
		String[] canzoni = {"alba rossa", "alba chiara", "mare nero", "luna rossa", "luna blu",
		    				"hanno ucciso l'uomo ragno"};

		for(String s : canzoni) System.out.println(s);
		
		Arrays.asList(canzoni).sort(Comparator.naturalOrder());
		System.out.println("\nNUOVO");
		for(String s : canzoni) System.out.println(s);
		 
		
		
	}

}
