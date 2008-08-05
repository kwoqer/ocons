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
		cLabel.setFont(sbFont);
		Box b = Box.createHorizontalBox();
		//JPanel panel = new JPanel(); 
		
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
		messageField.setPreferredSize(null);
		/* 
		SpringLayout layout = new SpringLayout();
		Spring strut = Spring.constant(10);
		Spring vstrut = Spring.height(consultantName);
		Spring torsion = Spring.constant(0, 10000, 10000);
		layout.putConstraint(SpringLayout.WEST, cLabel, strut, SpringLayout.WEST,this);
		layout.putConstraint(SpringLayout.EAST, cLabel, strut, SpringLayout.WEST,consultantName);
		layout.putConstraint(SpringLayout.EAST, consultantName, strut, SpringLayout.WEST,messageField);
		layout.putConstraint(SpringLayout.WEST, messageField, torsion, SpringLayout.EAST, messageField);
		layout.putConstraint(SpringLayout.EAST, messageField, strut, SpringLayout.EAST,this);
		layout.putConstraint(SpringLayout.NORTH, this, vstrut, SpringLayout.SOUTH, this);
		setLayout(layout); 
		
		add(cLabel);
		add(consultantName);
		add(messageField);
		*/
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
