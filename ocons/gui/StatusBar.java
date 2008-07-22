package gui;

import javax.swing.*;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField consultantName;
	private JTextField messageField;
	
	public void setConsultantName(String consultantName) {
		this.consultantName.setText(consultantName);
	}
	
	public void setMessageField(String messageField) {
		this.messageField.setText(messageField);
	}
	
	public StatusBar(){
		
	}
	

}
