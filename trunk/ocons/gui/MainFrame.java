package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import data.Consultant;
import gui.infopanel.*;
import start.*;

public class MainFrame extends JFrame {
	
	private StatusBar statusBar;
	private NavigationTree navigationTree;
	private InfoPanel infoPanel;
	private JPanel workArea;
	private JSplitPane workPanel;
	private Map<String, Consultant> consultantList;
	private Consultant consultant;
	
		

	public MainFrame(){
    		 
	      MainMenu mainMenu = new MainMenu();
	      GlobalData.setMenu(mainMenu);
	      mainMenu.BeforeLoginConsultantSettings();
	      setLayout(new BorderLayout());
	      setJMenuBar(mainMenu);
	      	      
	      statusBar = new StatusBar();
	      workArea = new JPanel();
		  workArea.setLayout(new BorderLayout());		  
		  navigationTree = null;
		  workPanel = new JSplitPane();
		  //infoPanel = new InfoPanel();
		  //workPanel.setLeftComponent(navigationTree);
		  //workPanel.setRightComponent(infoPanel);
		  workPanel.setBorder(BorderFactory.createEmptyBorder());
		  workPanel.setDividerSize(3);
		  workPanel.setDividerLocation(170);
		  workPanel.setVisible(true);
		  workArea.add(workPanel,BorderLayout.CENTER);
	      workArea.setVisible(false);
		  add(workArea, BorderLayout.CENTER);
	      add(statusBar, BorderLayout.SOUTH);
	      consultantList = new HashMap<String, Consultant>();
	
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
	
	public void setWorkArea(JPanel workArea) {
		this.workArea = workArea;
	}
	
	public JSplitPane getWorkPanel(){
		return workPanel;
	}
	
	public InfoPanel getInfoPanel(){
		return infoPanel;
	}
	
	public void setInfoPanel(InfoPanel ip){
		infoPanel = ip;
		validate();
	}
	
	public Map<String, Consultant> getConsultantList() {
		return consultantList;
	}
	
	public void addConsultant(Consultant c){
		consultantList.put(c.getID(), c);
	}
	
	public void openWorkArea(String cn){
		Consultant c = consultantList.get(cn);
		if (c.getConsultantPanel()==null) {
			navigationTree = new NavigationTree(cn);
			c.setConsultantTree(navigationTree);
			infoPanel = new InfoPanel();
			c.setConsultantPanel(infoPanel);
		}
		else {
			infoPanel = c.getConsultantPanel();
			navigationTree = c.getConsultantTree();
		}
		workPanel.setLeftComponent(navigationTree);
		workPanel.setRightComponent(infoPanel);   	
		workArea.setVisible(true);	    
	}
	
	public void closeWorkArea(){		
		workArea.setVisible(false);
	}
	 
	
	 
	
}
