package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import start.*;

public class MainFrame extends JFrame {

	public MainFrame(){

	      //GlobalData GLOBAL_DATA = new GlobalData();
	      Toolkit kit = Toolkit.getDefaultToolkit();
	      Dimension screensize = kit.getScreenSize();
	      GlobalData.setMonitorDimension(screensize.width,screensize.height);
	      GlobalData.setFrame(MainFrame.this);
	      JMenuBar mainmenu = new MainMenu();
	      setJMenuBar(mainmenu);
	      int x = GlobalData.getMonitorWidth()/4;
	      int y = GlobalData.getMonitorHeight()/4;
	      GlobalData.setFrameLocation(x,y);
	      setSize(GlobalData.getMonitorWidth()/2,GlobalData.getMonitorHeight()/2);
	      setLocation(x,y);

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
