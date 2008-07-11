package start;

import gui.*;

public class Start {
	
		public static void main(String[] args) {

	        MainFrame frame = new MainFrame();
	        try
	        {
	         	Prepare.PrepareDB();
	        }
	        catch (Exception E)
	        {
	        	MyTools.MessageBox(E.getMessage());
	        	E.printStackTrace();
	        }
	        //frame.setSize(600, 500);
	        frame.setTitle("Oriflame Consultant");
	        frame.setVisible(true);
	    }
	
}
