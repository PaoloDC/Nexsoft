package corso.java.business;

import javax.ejb.Local;

@Local
public interface PersonaServiceBeanLocal extends PersonaService {
public void saluta();
}
