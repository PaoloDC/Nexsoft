package corso.java;

import java.util.Calendar;

import corso.java.business.PersonaServiceBean;
import corso.java.business.PersonaServiceBeanLocal;
import corso.java.data.Persona;

public class Tester {
	public static void main(String[] args) {
		PersonaServiceBeanLocal local = new PersonaServiceBean();
		Persona p = new Persona();
		p.setCognome("DC");
		p.setNome("PaolO");
		p.setDataNascita(Calendar.getInstance());
		
		local.inserisci(p);
	}
}
