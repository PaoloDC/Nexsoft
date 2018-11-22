package proxy;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		
		HashMap<Integer, String> mappa = new HashMap<>();
		
		mappa.put(1, "1");
		mappa.put(1, "2");
		mappa.put(1, "3");
		mappa.put(1, "4");
		
		String val = mappa.get(1);
		System.out.println(val);
		
		System.out.println(mappa.containsKey(1));
	}

}
