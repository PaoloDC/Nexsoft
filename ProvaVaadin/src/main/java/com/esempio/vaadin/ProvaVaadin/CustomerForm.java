package com.esempio.vaadin.ProvaVaadin;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerForm extends FormLayout{
	//variabili di istanza
	private TextField tfFirstName = new TextField("First Name: ");
	private TextField tfLastName = new TextField("Last Name: ");
	private TextField tfEmail = new TextField("Email: ");
	private NativeSelect<CustomerStatus> status = new NativeSelect<>("Status");
	private DateField dfBirthDate = new DateField("Birth Date: ");
	
	private Button btSave = new Button("Save");
	private Button btDelete = new Button("Delete");
	
	private CustomerService service = CustomerService.getInstance();
	private Customer customer;
	private MyUI myUI;
	private Binder<Customer> binder = new Binder<>(Customer.class);
	
	
	//costruttore
	public CustomerForm(MyUI myUI) {
		this.myUI = myUI;
		
		setSizeUndefined();
		HorizontalLayout hlButtons = new HorizontalLayout(btSave,btDelete);
		addComponents(tfFirstName,tfLastName,tfEmail,status,dfBirthDate,hlButtons);

		status.setItems(CustomerStatus.values());
		btSave.setStyleName(ValoTheme.BUTTON_PRIMARY);
		btSave.setClickShortcut(KeyCode.ENTER);
		
		binder.bindInstanceFields(this);
		
		btSave.addClickListener(e -> save());
		btDelete.addClickListener(e -> delete());
	}
	
	public void setCustomer(Customer c) {
		this.customer = c;
		binder.setBean(c);
		btDelete.setVisible(c.isPersisted());
		setVisible(true);
		tfFirstName.selectAll();
	}
	
	private void delete() {
		service.delete(customer);
		setVisible(false);
	}
	
	private void save() {
		service.save(customer);
		myUI.updateList();
		setVisible(false);
	}
}
