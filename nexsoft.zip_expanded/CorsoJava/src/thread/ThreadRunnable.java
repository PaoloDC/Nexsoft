package thread;

public class ThreadRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("Sono un thread 2");
		for(int i=0 ; i < 10; i++)
			System.out.println(i);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
