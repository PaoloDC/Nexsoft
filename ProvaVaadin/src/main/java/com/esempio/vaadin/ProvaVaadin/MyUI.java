package com.esempio.vaadin.ProvaVaadin;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private CustomerService service = CustomerService.getInstance();
	private Grid<Customer> grid = new Grid<Customer>();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		// Label label = new Label("Hello World");
		// setContent(label);

		// Button b = new Button("OK!");
		// TextField tf = new TextField("Name");
		// b.addClickListener(e -> Notification.show("Hello " + tf.getValue()));

		// VerticalLayout vl = new VerticalLayout();
		// vl.setMargin(true);
		// vl.setSpacing(true);
		// vl.addComponent(grid);
		//
		// List<Customer> findAll = service.findAll();
		//
		// setContent(vl);
		
		final VerticalLayout vl = new VerticalLayout();
		vl.addComponents(grid);
		vl.setMargin(true);
		
		
		updateList();
		
		setContent(grid);
	}

	private void updateList() {
		List<Customer> customers = service.findAll();
		grid.setItems(customers);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
