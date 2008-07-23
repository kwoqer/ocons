package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

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
		//Border border = new SoftBevelBorder(BevelBorder.LOWERED);
		//setBorder(border);
		Font sbFont = new Font(Font.DIALOG,Font.PLAIN,11);
		Font bbFont = new Font(Font.DIALOG,Font.BOLD,11);
		
		JLabel cLabel = new JLabel("Консультант");
		cLabel.setForeground(Color.BLUE);
		Box b = Box.createHorizontalBox();
		cLabel.setFont(sbFont);
		consultantName = new JTextField();
		consultantName.setFont(bbFont);
		consultantName.setEditable(false);
		consultantName.setColumns(10);
		consultantName.setMaximumSize(consultantName.getPreferredSize());
		consultantName.setMinimumSize(consultantName.getPreferredSize());
		messageField = new JTextField();
		messageField.setColumns(50);
		messageField.setEditable(false);
		messageField.setFont(bbFont);
		messageField.setMinimumSize(messageField.getPreferredSize());
		setLayout(new FlowLayout());
		b.add(Box.createVerticalStrut(20));
		b.add(Box.createRigidArea(new Dimension(5,20)));
		b.add(cLabel);
		b.add(Box.createRigidArea(new Dimension(5,20)));
		//b.add(Box.createHorizontalStrut(5));
		b.add(consultantName);
		b.add(Box.createRigidArea(new Dimension(5,20)));
		//b.add(Box.createHorizontalStrut(5));
		b.add(messageField);
		add(b);
		
	}
	

}
