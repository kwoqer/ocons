package gui.infopanel;


import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.text.*;
import start.*;
import gui.*;
import com.toedter.calendar.*;
import data.Client;

public class ClientForm extends InfoPanelDialog {

	private Client client ;
	
	
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
	private JComboBox comboboxStatus;
	private JLabel labelDiscount;
	private JFormattedTextField fieldDiscount;
	private JPanel buttonPanel;
	private JButton saveButton;
	private JButton cancelButton;
	
	
	public ClientForm(String name, String title) {		
		super(name, title);
		client = new Client();
		setLayout(new GridBagLayout());
		int width = 400;
		int height = 250;		
		this.setSize(width, height);
		setResizable(false);
		Point p = MyTools.FramePosition(width, height);
		this.setLocation(p.x,p.y);		
		Dimension nameDim = new Dimension(200,20);
		Dimension phoneDim = new Dimension(110,20);
		Dimension calDim = new Dimension(100,20);
		Dimension discDim = new Dimension(60,20);
		Icon ipict = MyTools.getImageResource("pict/userb.png");
		pict = new JLabel(ipict);
		labelName = new JLabel(Localizator.IP_ClientName);
		fieldName = new JTextField();
		fieldName.setMinimumSize(nameDim);
		labelAdress = new JLabel(Localizator.IP_ClientAdress);
		fieldAdress = new JTextField();
		labelPhone = new JLabel(Localizator.IP_ClientPhone);
		fieldPhone = new JTextField();
		fieldPhone.setMinimumSize(phoneDim);
		labelMobile = new JLabel(Localizator.IP_ClientPhoneMob);
		fieldMobile = new JTextField();
		fieldMobile.setMinimumSize(phoneDim);
		labelBirthday = new JLabel(Localizator.IP_ClientBirthday);
		calendarBirthday = new JDateChooser();		
		calendarBirthday.setMinimumSize(calDim);
		calendarBirthday.getJCalendar().setWeekOfYearVisible(false);
		labelOtherEvent = new JLabel(Localizator.IP_ClientOther);
		fieldOtherEvent = new JTextField();
		calendarOtherEvent = new JDateChooser();
		calendarOtherEvent.setMinimumSize(calDim);
		calendarOtherEvent.getJCalendar().setWeekOfYearVisible(false);
		labelStatus = new JLabel(Localizator.IP_ClientStatus);
		comboboxStatus = new JComboBox();
		labelDiscount = new JLabel(Localizator.IP_ClientDiscount+"(%)");
		fieldDiscount = new JFormattedTextField(new 
				DefaultFormatter(){							
					protected DocumentFilter getDocumentFilter(){
						return filter;
					}
					private DocumentFilter filter = new CurrencyFilter();
				});
		fieldDiscount.setMaximumSize(discDim);
		fieldDiscount.setMinimumSize(discDim);
		buttonPanel = new JPanel();
		saveButton = new JButton(Localizator.G_Save);
		saveButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				client = new Client(0,
									fieldName.getText(),
									fieldPhone.getText(),
									fieldMobile.getText(),
									fieldAdress.getText(),
									calendarBirthday.getDate(),
									fieldOtherEvent.getText(),
									calendarOtherEvent.getDate(),
									fieldDiscount.getText(),
									'S');
				client.addToDB();
				getTableView().getTableModel().addRow(client.generateRow());
				getTableView().refresh();
				setVisible(false);				
			}
		});
		cancelButton = new JButton(Localizator.G_Cancel);
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);				
			}
		});
		comboboxStatus.addItem(Localizator.IP_ClientStatus_1);
		comboboxStatus.addItem(Localizator.IP_ClientStatus_2);
		add(pict,new GBC(0,0,1,2).setAnchor(GBC.EAST));
		add(labelName,new GBC(1,0,3,1).setAnchor(GBC.CENTER));
		add(fieldName,new GBC(1,1,3,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelAdress, new GBC(0,2).setAnchor(GBC.EAST));
		add(fieldAdress, new GBC(1,2,3,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelPhone, new GBC(0,3).setAnchor(GBC.EAST));
		add(fieldPhone, new GBC(1,3).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelMobile, new GBC(2,3).setAnchor(GBC.EAST));
		add(fieldMobile, new GBC(3,3).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelBirthday, new GBC(0,4,2,2).setAnchor(GBC.SOUTH));
		add(labelOtherEvent, new GBC(2,4,2,1).setAnchor(GBC.CENTER));
		add(fieldOtherEvent, new GBC(2,5,2,1).setFill(GBC.HORIZONTAL).setInsets(1));
		add(calendarBirthday, new GBC(0,6,2,1).setAnchor(GBC.NORTH).setInsets(1));
		add(calendarOtherEvent, new GBC(2,6,2,1).setAnchor(GBC.CENTER));
		add(labelStatus, new GBC(0,7).setAnchor(GBC.EAST));
		add(comboboxStatus, new GBC(1,7).setFill(GBC.HORIZONTAL).setInsets(1));
		add(labelDiscount, new GBC(2,7).setAnchor(GBC.EAST));
		add(fieldDiscount,new GBC(3,7).setAnchor(GBC.WEST).setInsets(1));
		buttonPanel.add(saveButton);
		buttonPanel.add(cancelButton);
		add(buttonPanel,new GBC(0,8,4,1).setAnchor(GBC.CENTER));
		this.getRootPane().setDefaultButton(saveButton);
		setTitle(title);
	}

	public void run(boolean isEdit) {
		if (isEdit) {
			int row = getTableView().getTable().getSelectedRow();
			int id = getTableView().getTableModel().getID(row);			
			boolean find = client.readFromDB(id); 
			if (find){
				fieldName.setText(client.getName());
				fieldAdress.setText(client.getAdress());
				fieldPhone.setText(client.getPhone());
				fieldMobile.setText(client.getMobile());
				calendarBirthday.setDate(client.getBirthday());
				fieldOtherEvent.setText(client.getOtherEvent());
				calendarOtherEvent.setDate(client.getOtherEventDate());
				fieldDiscount.setText((new Double(client.getDiscount()).toString()));
			}			
		}
		setVisible(true);
		
	}
	
	
	

	
	

}
