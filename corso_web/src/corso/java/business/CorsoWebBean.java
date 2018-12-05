package corso.java.business;

import java.util.ArrayList;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import corso.java.data.ContoCorrente;
import corso.java.data.Utente;

/**
 * Session Bean implementation class CorsoWeb
 */
@Stateless
@LocalBean
public class CorsoWebBean implements CorsoWebRemote, CorsoWebLocal {

	@PersistenceContext(unitName="corsoWebPersistence")
	EntityManager manager;
	
    /**
     * Default constructor. 
     */
    public CorsoWebBean() {
    }
    
    public void creaConto() {
    	
    	Utente u = new Utente();
    	u.setCognome("Rossi");
    	u.setNome("mario");
    	u.setId(1);
    	u.setListaConti(new ArrayList<>());
    	
    	ContoCorrente c1 = new ContoCorrente();
    	c1.setNumero("1234");
    	c1.setUtente(u);
    	u.getListaConti().add(c1);
    	
    	ContoCorrente c2 = new ContoCorrente();
    	c2.setNumero("5647");
    	c2.setUtente(u);
    	u.getListaConti().add(c2);
    	
    	manager.persist(u);
    }

}
