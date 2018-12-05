package corso.java.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import corso.java.data.Persona;

/**
 * Session Bean implementation class PersonaServiceBean
 */
@Stateless
@LocalBean
public class PersonaServiceBean implements PersonaServiceBeanRemote, PersonaServiceBeanLocal {

	@PersistenceContext(unitName="corsoWebPersistence")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public PersonaServiceBean() {
    }

	public void inserisci(Persona p) {
		manager.persist(p);
	}
	
	public Persona getPersonaByID(long id) {
		return null;
	}
	
	@Override
	public void saluta() {
		System.out.println("CIAOOOOO");
	}
}
