package it.corsoJava;

import java.util.ArrayList;
import java.util.Iterator;

public class CorsoJava implements Interfaccia_Base{
	//variabili di istanza
	public int a;
	public static int b;
	static CorsoJava c;

	@Override
	public void saluta(String nome) {
		System.out.println("Ciao " + nome);
	}
	
	
	//MAIN
	public static void main(String[] args) {
		/*
		 * for (int i = 0; i < 1000; i++) { if (i % 2 == 1) continue; if (i == 954)
		 * break; System.out.println(i); }
		 */
		ArrayList<Boolean> listaNomi = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0)
				listaNomi.add(true);
			else
				listaNomi.add(false);
		}

		System.out.println("SIZE: 100: " + listaNomi.size());

		int conta = 0;
		int contaTrue = 0;
		int contaFalse = 0;

		Iterator<Boolean> s = listaNomi.iterator();
		
		while (s.hasNext()) {
			if (s.next())
				contaTrue++;
			else
				contaFalse++;	
			conta++;
			break;
		}
		System.out.println("Conta: " + conta + " ct: " + contaTrue + " cf: " + contaFalse);
		
		
		//boxing
		
		double d1 = 125.6;
		Double d2 = new Double(125.6);
		
		System.out.println(d1 == d2);
		
		//autoboxing
		Double d3 = 125.6;
				
		//unboxing
		double d4 = d2;
				
	} 

	// costruttore
	public CorsoJava() {

	}

	// metodi
	public static void metodo1() {
		c.metodo2();
	}

	public void metodo2() {
		metodo1();
	}

}
