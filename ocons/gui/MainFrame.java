package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import start.*;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private StatusBar statusBar;
	//private JPanel workArea;
	
	public MainFrame(){
    
		 
	      MainMenu mainMenu = new MainMenu();
	      GlobalData.setMenu(mainMenu);
	      mainMenu.BeforeLoginConsultantSettings();
	      setJMenuBar(mainMenu);
	      //workArea = new JPanel();
	      setLayout(new BorderLayout()); 
	      statusBar = new StatusBar();
	      
	      //JPanel statusPanel = new JPanel();
	      //statusPanel.add(statusBar);
	      //add(workArea, new GBC(0,0).setFill(GBC.BOTH));	      
	      add(statusBar, BorderLayout.SOUTH);
	      
	      addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                dispose();
	                System.exit(0);
	            }
	      });    
	      	      

	   }

	public StatusBar getStatusBar() {
		return statusBar;
	}
}
