package singleton;

public class Stampante {
	
	private Stampante() {
	}
	
	public static void print(String msg) {
		System.out.println(msg);
	}
}
