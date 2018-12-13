package com.esempio.vaadin.ProvaVaadin;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

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
	private Grid<Customer> grid = new Grid<>(Customer.class);
	private TextField tf = new TextField();
	private CustomerForm form = new CustomerForm(this);

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout vl = new VerticalLayout();

		tf.setPlaceholder("filter by name..");
		tf.addValueChangeListener(e -> updateList());
		tf.setValueChangeMode(ValueChangeMode.LAZY);

		Button clearFilterTextBT = new Button(VaadinIcons.CLOSE);
		clearFilterTextBT.setDescription("clear the current filter");
		clearFilterTextBT.addClickListener(e -> tf.clear());

		CssLayout css = new CssLayout();
		css.addComponents(tf, clearFilterTextBT);
		css.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);

		Button btAdd = new Button("Add New Customer");
		btAdd.addClickListener(e -> {
			grid.asSingleSelect().clear();
			form.setCustomer(new Customer());
		});
		
		HorizontalLayout hlToolbar = new HorizontalLayout(css, btAdd);
		
		grid.setColumns("firstName", "lastName", "email");

		HorizontalLayout hl = new HorizontalLayout(grid, form);
		hl.setSizeFull();
		grid.setSizeFull();
		hl.setExpandRatio(grid, 1);

		updateList();

		vl.addComponents(hlToolbar, hl);

		setContent(vl);
		
		form.setVisible(false);
		grid.asSingleSelect().addValueChangeListener(event -> {
			if(event.getValue() == null)
				form.setVisible(false);
			else
				form.setCustomer(event.getValue());
		});
	}

	public void updateList() {
		List<Customer> customers = service.findAll(tf.getValue());
		grid.setItems(customers);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}
}
