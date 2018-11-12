package sync;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class ContoCorrente {
	private static ContoCorrente cc;
	public static final String PERCORSO = "D:\\saldo.txt";
	public static ContoCorrente getIstance() {
		if(cc == null)
			cc = new ContoCorrente();
		return cc;
	}
	
	public double getSaldo() {
		double saldo = 0;
		
		Scanner in = null;
		try {
			in = new Scanner(new File(PERCORSO));
			saldo = in.nextDouble();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}
		return saldo;
	}
	
	public synchronized void prelievo(double somma) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			Thread.sleep(3000);
			
			double nuovoSaldo = this.getSaldo() - somma;
			if(nuovoSaldo > 0) {
				fw = new FileWriter(new File(PERCORSO));
				bw = new BufferedWriter(fw);
				bw.write(nuovoSaldo+"");
				fw.close();
				bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void prelievoNonSync(double somma) {
		BufferedWriter bw = null;
		FileWriter fw = null;
		
		try {
			Thread.sleep(3000);
			
			double nuovoSaldo = this.getSaldo() - somma;
			if(nuovoSaldo > 0) {
				fw = new FileWriter(new File(PERCORSO));
				bw = new BufferedWriter(fw);
				bw.write(nuovoSaldo+"");
				fw.close();
				bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
