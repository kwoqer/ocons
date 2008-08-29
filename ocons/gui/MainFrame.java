package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import data.Consultant;
import start.*;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private StatusBar statusBar;
	private NavigationTree navigationTree;
	private JPanel workArea;
	
	public MainFrame(){
    
		 
	      MainMenu mainMenu = new MainMenu();
	      GlobalData.setMenu(mainMenu);
	      mainMenu.BeforeLoginConsultantSettings();
	      setLayout(new BorderLayout());
	      setJMenuBar(mainMenu);
	      	      
	      statusBar = new StatusBar();
	      workArea = new JPanel();
		  workArea.setLayout(new BorderLayout());
		  //String cn = MyTools.findDefaultConsultant();
		  navigationTree = new NavigationTree(null);
		  JSplitPane workPanel = new JSplitPane();
		  JPanel infoPanel = new JPanel();
		  workPanel.setLeftComponent(navigationTree);
		  workPanel.setRightComponent(infoPanel);
		  workPanel.setBorder(BorderFactory.createEmptyBorder());
		  workPanel.setDividerSize(3);
		  workPanel.setDividerLocation(170);
		  workPanel.setVisible(true);
		  workArea.add(workPanel,BorderLayout.CENTER);
	      workArea.setVisible(false);
		  add(workArea, BorderLayout.CENTER);
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

	public NavigationTree getNavigationTree() {
		return navigationTree;
	}

	public void setNavigationTree(NavigationTree navigationTree) {
		this.navigationTree = navigationTree;
	}

	public JPanel getWorkArea() {
		return workArea;
	}
	
	public void openWorkArea(String cn){
		String so = ((TreeItem)navigationTree.getRootObject()).getName();		 
	    if (so!=cn){
	    	navigationTree.setConsultantNumber(cn);
	    	navigationTree.repaint();
	    }	    	
		workArea.setVisible(true);	    
	}
	
	public void closeWorkArea(){		
		workArea.setVisible(false);
	}
	 
	 
	
}
