package start;

import gui.*;
import java.awt.*;

public class Start {
	
		public static void main(String[] args) {

	        MainFrame frame = new MainFrame();
	        Prepare.PrepareGD();
	        GlobalData.setFrame(frame);
	        GlobalData.setAppPath();
	        GlobalData.setFrameDimension((int)(GlobalData.getMonitorWidth()/4)*3, 
	        		                     (int)(GlobalData.getMonitorHeight()/4)*3);
	        
	        try
	        {
	         	Prepare.PrepareDB();
	        }
	        catch (Exception E)
	        {
	        	MyTools.MessageBox(E.getMessage());
	        	E.printStackTrace();
	        }
	        Point p = MyTools.FramePosition(GlobalData.getFrameWidth(),GlobalData.getFrameHeight());
	        frame.setLocation(p.x,p.y);
	        frame.setSize(GlobalData.getFrameWidth(),GlobalData.getFrameHeight());
	        frame.setTitle("Oriflame Consultant");
	        frame.setVisible(true);
	    }
	
}
