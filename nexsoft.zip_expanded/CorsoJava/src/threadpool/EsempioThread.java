package threadpool;

public class EsempioThread extends Thread {
	
	public EsempioThread(String nome) {
		super();
		this.setName(nome);
	}
	
	@Override
	public void run() {
		for(int i=0 ; i < 100 ; i++) {
			System.out.println(Thread.currentThread().getName() +" : " + i);
		}
	}
}
