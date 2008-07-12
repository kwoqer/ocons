package gui;

import java.awt.Point;
import java.awt.event.*;
import javax.swing.*;
import start.*;

public class MainFrame extends JFrame {

	public MainFrame(){
    
		 
	      JMenuBar mainmenu = new MainMenu();
	      setJMenuBar(mainmenu);
	      	      

	      addWindowListener(new WindowAdapter() {
	            public void windowClosing(WindowEvent e) {
	                dispose();
	                System.exit(0);
	            }
	      });    
	      
	      //addPropertyChangeListener(new WindowAdapter()  {      
	      //      public void PropertyChange(WindowEvent e){
	      //          Point p = getLocationOnScreen();
	      //          System.out.println("Window Moved!");
	      //          GlobalData.setFrameLocation(p.x,p.y);
	      //      }

	      //});


	   }
}
