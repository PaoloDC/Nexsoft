package thread;

public class Tester {

	public static void main(String[] args) {
		ThreadExtend te = new ThreadExtend();
		ThreadExtend te1 = new ThreadExtend();
		ThreadExtend te2 = new ThreadExtend();
		ThreadExtend te3 = new ThreadExtend();
		
		te.start();
		te1.start();
		te2.start();
		te3.start();
		
		Thread ts2 = new Thread(new ThreadRunnable());
		ts2.start();
	}
	


}
