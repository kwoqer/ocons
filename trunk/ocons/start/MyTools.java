package start;

import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import start.*;

import javax.swing.JOptionPane;

public class MyTools {
	
	public static ArrayList<String> convSQL(String SQLfile){
		StringBuffer buf = new StringBuffer();
		ArrayList<String> reslist = new ArrayList<String>();
		try 
		{
			FileReader sqlf = new FileReader(SQLfile);
			int i=0;
			while (i!=-1) {
				i = sqlf.read();
				buf.append((char)i);
				if ((char)i==';') {
					reslist.add(buf.toString());
					buf.delete(0, buf.length());
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return reslist;
	}
	
	public static void  MessageBox(String s){
		JOptionPane.showMessageDialog(null,s,"MessageBox",
	    		 JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void  MessageBox(String h, String s){
		JOptionPane.showMessageDialog(null,s,h,
	    		 JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static Point FramePosition(int width, int height){
		int x = GlobalData.getMonitorWidth()/2-width/2;
		int y = GlobalData.getMonitorHeight()/2-height/2;
		return new Point(x,y);
	}
	
	public static Connection ConnectDB(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:db\\ocons.db");
			return conn;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
