package gui.infopanel;

import gui.GBC;

import java.awt.GridBagLayout;
import java.awt.Point;
import java.util.Map;
import javax.swing.*;
import start.*;

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
	private JDateChooser calendarBirthday;
	private JLabel labelOtherEvent;
	private JTextField fieldOtherEvent;
	private JDateChooser calendarOtherEvent;
	private JLabel labelStatus;
	private JCheckBox checkboxStatus;
	private JLabel labelDiscount;
	private JFormattedTextField fieldDiscount;
	private JPanel buttonPanel;
	private JButton saveButton;
	private JButton cancelButton;
	
	
	public ClientForm(String name, String title) {
		super(name, title);
		setLayout(new GridBagLayout());
		int width = 350;
		int height = 250;
		this.setSize(width, height);
		Point p = MyTools.FramePosition(width, height);
		this.setLocation(p.x,p.y);
		Icon ipict = MyTools.getImageResource("pict/userb.png");
		pict = new JLabel(ipict);
		labelName = new JLabel(Localizator.IP_ClientName);
		fieldName = new JTextField();
		fieldName.setColumns(30);
		labelAdress = new JLabel(Localizator.IP_ClientAdress);
		fieldAdress = new JTextField();
		labelPhone = new JLabel(Localizator.IP_ClientPhone);
		fieldPhone = new JTextField();
		labelMobile = new JLabel(Localizator.IP_ClientPhoneMob);
		fieldMobile = new JTextField();
		labelBirthday = new JLabel(Localizator.IP_ClientBirthday);
		calendarBirthday = new JDateChooser();
		labelOtherEvent = new JLabel(Localizator.IP_ClientOtherDate);
		fieldOtherEvent = new JTextField();
		calendarOtherEvent = new JDateChooser();
		labelStatus = new JLabel(Localizator.IP_ClientStatus);
		checkboxStatus = new JCheckBox();
		labelDiscount = new JLabel(Localizator.IP_ClientDiscount);
		fieldDiscount = new JFormattedTextField();
		buttonPanel = new JPanel();
		saveButton = new JButton(Localizator.G_Save);
		cancelButton = new JButton(Localizator.G_Cancel);
		add(pict,new GBC(0,0,1,2).setAnchor(GBC.CENTER));
		add(labelName,new GBC(1,0,3,1).setAnchor(GBC.CENTER));
		add(fieldName,new GBC(1,1,3,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelAdress, new GBC(0,2).setAnchor(GBC.EAST));
		add(fieldAdress, new GBC(1,2,3,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelPhone, new GBC(0,3).setAnchor(GBC.EAST));
		add(fieldPhone, new GBC(1,3).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelMobile, new GBC(2,3).setAnchor(GBC.EAST));
		add(fieldMobile, new GBC(3,3).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelBirthday, new GBC(0,4,2,2).setAnchor(GBC.CENTER));
		add(labelOtherEvent, new GBC(2,4,2,1).setAnchor(GBC.CENTER));
		add(fieldOtherEvent, new GBC(2,5,2,1).setAnchor(GBC.CENTER));
		add(calendarBirthday, new GBC(0,6,2,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(calendarOtherEvent, new GBC(2,6,2,1).setAnchor(GBC.CENTER));
		add(labelStatus, new GBC(0,7).setAnchor(GBC.EAST));
		add(checkboxStatus, new GBC(1,7).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelDiscount, new GBC(2,7).setAnchor(GBC.EAST));
		add(fieldDiscount,new GBC(3,7).setFill(GBC.HORIZONTAL).setInsets(1));
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel,new GBC(0,8,4,1).setAnchor(GBC.CENTER));
		this.getRootPane().setDefaultButton(saveButton);
	}

	public void run(boolean isEdit) {
		setVisible(true);
		
	}

	
	

}
