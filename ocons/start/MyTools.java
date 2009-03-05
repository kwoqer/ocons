package start;

import java.awt.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

import settings.Localizator;

public class MyTools {
	
	public static void  MessageBox(String s){
		Object[] ops = {Localizator.G_Ok};
		JOptionPane.showOptionDialog(null,s,"MessageBox",
				JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ops,Localizator.G_Ok);
		
	}
	
	public static void  MessageBox(String h, String s){
		Object[] ops = {Localizator.G_Ok};
		JOptionPane.showOptionDialog(null,s,h,
				JOptionPane.OK_OPTION,JOptionPane.INFORMATION_MESSAGE,null,ops,Localizator.G_Ok);		
	}
	
	public static void  ErrorBox(String h, String s){
		Object[] ops = {Localizator.G_Ok};
		JOptionPane.showOptionDialog(null,s,h,
				JOptionPane.OK_OPTION,JOptionPane.ERROR_MESSAGE,null,ops,Localizator.G_Ok);		
	}
		
	
	public static int ConfirmBox(String h, String s){
		Object[] ops = {Localizator.G_Yes,Localizator.G_No};
		return JOptionPane.showOptionDialog(null,s,h,
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,ops,Localizator.G_Yes);
		
	}
	
	public static int AlertBox(String h, String s){
		Object[] ops = {Localizator.G_Yes,Localizator.G_No};
		return JOptionPane.showOptionDialog(null,s,h,
				JOptionPane.YES_NO_OPTION,JOptionPane.ERROR_MESSAGE,null,ops,Localizator.G_Yes);
		
	}
	
	
	
	public static Point FramePosition(int width, int height){
		int x = GlobalData.getMonitorWidth()/2-width/2;
		int y = GlobalData.getMonitorHeight()/2-height/2;
		return new Point(x,y);
	}
	
	
	public static void setStatusBarConsultant(String cn){
		GlobalData.getFrame().getStatusBar().setConsultantName(cn);
	}
	
	public static void setStatusBarMessage(String m){
		GlobalData.getFrame().getStatusBar().setMessageField(m);
	}
	
	public static ImageIcon getImageResource(String s){
		URL u = MyTools.class.getResource(s);
		return new ImageIcon(u);
	}
	
	
}
