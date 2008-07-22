package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import data.Consultant;
import start.*;

public class LoginDialog extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private int emptyNumber;
	private JPanel jContentPaneLD = null;
	private JLabel Pict;
	private JLabel LabelID;
	private JFormattedTextField FieldID;
	private JLabel LabelPassword;
	private JPasswordField FieldPassword;
	private JPanel ButtonPanel;
	private JButton LoginButton;
	private JButton CancelButton;
	
	
	public LoginDialog(Frame owner) {		
		super(owner);
		setEmptyNumber(0);
		initialize();
		
	}
	
	public LoginDialog(Frame owner, int en) {		
		super(owner);
		setEmptyNumber(en);
		initialize();
		
	}

	private void initialize() {
		int width = 180;
		int height = 120;
		this.setSize(width, height);
		Point p = MyTools.FramePosition(width, height);
		this.setLocation(p.x,p.y);
		this.setContentPane(getJContentPaneLD());
		this.setTitle("Вход");
		
	}

	private JPanel getJContentPaneLD(){
		if (jContentPaneLD == null){
			jContentPaneLD = new JPanel();
			jContentPaneLD.setLayout(new GridBagLayout());
			Icon pict = new ImageIcon("pict\\user.png");
			Pict = new JLabel(pict);
			LabelID = new JLabel("Номер");
			FieldID = new JFormattedTextField(new 
					DefaultFormatter()
					{
						private static final long serialVersionUID = 1L;
						protected DocumentFilter getDocumentFilter(){
							return filter;
						}
						private DocumentFilter filter = new IntFilter();
					});
			// Подставляем консультанта по умолчанию, если он есть
			if (getEmptyNumber()==0){				
				int n = MyTools.findDefaultConsultant();
				if (n != -1){
					Integer ni = new Integer(n);
					FieldID.setValue(ni.toString());
				}
				
			}
			LabelPassword = new JLabel("Пароль");
			FieldPassword = new JPasswordField();
			LoginButton = new JButton("Вход");
			LoginButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if (FieldID.getText().equals("")){
						MyTools.ErrorBox("Будьте внимательнее!", "Номер консультанта не задан!");						
					}
					else{
						Consultant c = new Consultant(Integer.parseInt(FieldID.getText()));
						if (c.readFromDB()){
							String psw = new String(FieldPassword.getPassword());
							if (psw.hashCode()==c.getPasswordHash()){
								// Вход в режим работы консультанта
								GlobalData.setConsultantNumber(c.getID());
								GlobalData.getMenu().AfterLoginConsultantSettings();
								dispose();
							}
							else{
								MyTools.ErrorBox("Будьте внимательнее!", "Неправильный пароль!");
							}
						}
						else{
							MyTools.ErrorBox("Будьте внимательнее!", "Консультант с таким номером отсутствует!");
						}
					}							
				}
			});
			CancelButton = new JButton("Отмена");
			CancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					//setVisible(false);
					dispose();
				}
			});
			ButtonPanel = new JPanel();
			ButtonPanel.add(LoginButton);
			ButtonPanel.add(CancelButton);
			
			jContentPaneLD.add(Pict, new GBC(0,0,1,2).setAnchor(GBC.CENTER));
			jContentPaneLD.add(LabelID, new GBC(1,0).setAnchor(GBC.EAST));
			jContentPaneLD.add(FieldID, new GBC(2,0).setFill(GBC.HORIZONTAL).setInsets(1));
			jContentPaneLD.add(LabelPassword, new GBC(1,1).setAnchor(GBC.EAST));
			jContentPaneLD.add(FieldPassword, new GBC(2,1).setFill(GBC.HORIZONTAL).setInsets(1));
			
			jContentPaneLD.add(ButtonPanel,new GBC(0,2,3,1).setAnchor(GBC.CENTER));
		}
		return jContentPaneLD;
	}

	private int getEmptyNumber() {
		return emptyNumber;
	}

	private void setEmptyNumber(int emptyNumber) {
		this.emptyNumber = emptyNumber;
	}
}
