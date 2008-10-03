package gui.infopanel;

import java.util.Map;
import javax.swing.*;
import com.toedter.calendar.*;

import data.Client;

public class ClientForm extends InfoPanelDialog {

	private Client client;
	
	private JLabel pict;
	private JLabel labelName;
	private JTextField fieldName;
	private JLabel labelAdress;
	private JTextField fieldAdress;
	private JLabel labelPhone;
	private JTextField fieldPhone;
	private JLabel labelMobile;
	private JTextField fieldMobile;
	private JLabel labelBirthday;
	private JCalendar calendarBirthday;
	private JLabel labelOtherEvent;
	private JTextField fieldOtherEvent;
	private JDateChooser calendarOtherEvent;
	private JLabel labelStatus;
	private JCheckBox checkboxStatus;
	private JLabel labelDiscount;
	private JFormattedTextField fieldDiscount;
	
	
	public ClientForm(String name, String title) {
		super(name, title);
		
	}

	public void run() {
		
		
	}

	public void run(Object obj, Map<String, String> values) {
		
		
	}

	
	

}
