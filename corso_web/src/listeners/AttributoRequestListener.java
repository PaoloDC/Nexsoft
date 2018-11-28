package listeners;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class AttributoRequestListener
 *
 */
@WebListener
public class AttributoRequestListener implements ServletRequestAttributeListener {

	/**
	 * Default constructor.
	 */
	public AttributoRequestListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("Oggetto rimosso dalla request");
	}

	/**
	 * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println("Oggetto aggiunto dalla request");
	}

	/**
	 * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("Oggetto modificato dalla request");
	}

}
