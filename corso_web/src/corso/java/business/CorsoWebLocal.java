package corso.java.business;

import javax.ejb.Local;

@Local
public interface CorsoWebLocal extends CorsoWeb{
	void creaConto();
}
