package thread;

public class ThreadExtend extends Thread {
	
	@Override
	public void run() {		
		for(int i=10 ; i < 20; i++)
			System.out.println(i + " sono un thread " + getName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
