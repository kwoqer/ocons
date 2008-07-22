package gui;

import javax.swing.*;
import javax.swing.text.*;
import data.Consultant;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import start.*;


public class AddConsultantDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPaneACD = null;
	
	public AddConsultantDialog(Frame owner) {
		super(owner);
		initialize();
	}

	
	private void initialize() {
		int width = 280;
		int height = 250;
		this.setSize(width, height);
		Point p = MyTools.FramePosition(width, height);
		this.setLocation(p.x,p.y);
		this.setContentPane(getJContentPaneACD());
		this.setTitle("Новый консультант");
		
	}

	
	private JPanel getJContentPaneACD() {
		if (jContentPaneACD == null) {
			jContentPaneACD = new JPanel();
			jContentPaneACD.setLayout(new GridBagLayout());
			LabelID = new JLabel("Личный номер");
			LabelID.setForeground(Color.RED);
			FieldID = new JFormattedTextField(new 
						DefaultFormatter()
						{
							private static final long serialVersionUID = 1L;
							protected DocumentFilter getDocumentFilter(){
								return filter;
							}
							private DocumentFilter filter = new IntFilter();
						});
			
			LabelName = new JLabel("Фамилия И.О.");
			FieldName = new JTextField();
			LabelPhone = new JLabel("Телефон");
			FieldPhone = new JTextField();
			LabelEmail = new JLabel("E-Mail");
			FieldEmail = new JTextField();
			//DataPanel = new JPanel();
			First = new JCheckBox("Запомнить меня");
			LabelPass1 = new JLabel("Пароль");
			LabelPass1.setForeground(Color.RED);
			Pass1 = new JPasswordField();
			LabelPass2 = new JLabel("Еще раз");
			LabelPass2.setForeground(Color.RED);
			Pass2 = new JPasswordField();
			Warning = new JLabel("Красным выделены обязательные поля");
			ButtonPanel = new JPanel();
			Save = new JButton("Сохранить");
			Cancel = new JButton("Отмена");
			Cancel.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e){
							//setVisible(false);
							dispose();
						}
					});
			Save.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					int id = Integer.parseInt(FieldID.getText()); 
					Consultant c = new Consultant(id);
					c.setName(FieldName.getText());
					c.setPhone(FieldPhone.getText());
					c.setEMail(FieldEmail.getText());
					c.setDefault(First.isSelected());
					String p1 = new String(Pass1.getPassword());
					String p2 = new String(Pass2.getPassword());
					if (p1.equals(p2)){
						c.setPasswordHash(p1.hashCode());
						if (c.ConsultantPresent(id)) {
							MyTools.ErrorBox("Будьте внимательнее!","Консультант с таким номером уже есть!");
						}
						else {
							// В случае установки нового консультанта по умолчанию убираем предыдущего по умолчанию 
							if (c.isDefault()){
								int cn = MyTools.findDefaultConsultant();
								if (cn!=-1){
									Connection conn = MyTools.ConnectDB();
									try{
										Statement stat = conn.createStatement();
										String scn = new Integer(cn).toString();
										stat.executeUpdate("UPDATE Consultants SET First=0 WHERE Cons_ID="+scn+";");
									}
									catch (SQLException E){
										E.printStackTrace();
									}
								}
							}
							c.addToDB();
							dispose();
						}
						//setVisible(false);
						
					}
					else{
						MyTools.ErrorBox("Будьте внимательнее!", "Пароли не совпадают!");
					}
					
				}
			});
			ButtonPanel.add(Save);
			ButtonPanel.add(Cancel);
			
			jContentPaneACD.add(LabelID,new GBC(0,0).setAnchor(GBC.EAST));
			jContentPaneACD.add(FieldID,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100,0).setInsets(1));
			jContentPaneACD.add(LabelName,new GBC(0,1).setAnchor(GBC.EAST));
			jContentPaneACD.add(FieldName,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
			jContentPaneACD.add(LabelPhone,new GBC(0,2).setAnchor(GBC.EAST));
			jContentPaneACD.add(FieldPhone,new GBC(1,2).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
			jContentPaneACD.add(LabelEmail,new GBC(0,3).setAnchor(GBC.EAST));
			jContentPaneACD.add(FieldEmail,new GBC(1,3).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
			jContentPaneACD.add(First, new GBC(0,4,2,2).setAnchor(GBC.CENTER).setWeight(100, 100));
			jContentPaneACD.add(LabelPass1,new GBC(0,6).setAnchor(GBC.EAST));
			jContentPaneACD.add(Pass1,new GBC(1,6).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
			jContentPaneACD.add(LabelPass2,new GBC(0,7).setAnchor(GBC.EAST));
			jContentPaneACD.add(Pass2,new GBC(1,7).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
			jContentPaneACD.add(Warning,new GBC(0,8,2,1).setAnchor(GBC.CENTER));
			jContentPaneACD.add(ButtonPanel,new GBC(0,9,2,2).setAnchor(GBC.CENTER).setWeight(100, 100));
		}
		return jContentPaneACD;
	}
	//private JPanel DataPanel;
	private JLabel LabelID;
	private JFormattedTextField FieldID;
	private JLabel LabelName;
	private JTextField FieldName;
	private JLabel LabelPhone;
	private JTextField FieldPhone;
	private JLabel LabelEmail;
	private JTextField FieldEmail;
	private JCheckBox First;
	//private JPanel PassPanel;
	private JLabel LabelPass1;
	private JPasswordField Pass1;
	private JLabel LabelPass2;
	private JPasswordField Pass2;
	private JLabel Warning;
	private JPanel ButtonPanel;
	private JButton Save;
	private JButton Cancel;
	
	

} 



 