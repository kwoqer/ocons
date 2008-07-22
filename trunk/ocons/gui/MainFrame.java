package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import start.*;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private StatusBar statusBar;
	
	public MainFrame(){
    
		 
	      MainMenu mainMenu = new MainMenu();
	      GlobalData.setMenu(mainMenu);
	      mainMenu.BeforeLoginConsultantSettings();
	      setJMenuBar(mainMenu);
	      setLayout(new BorderLayout());      

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
