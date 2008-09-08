package start;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

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
	
	public static void  ErrorBox(String h, String s){
		JOptionPane.showMessageDialog(null,s,h,
	    		 JOptionPane.ERROR_MESSAGE);
	}
	
	public static int ConfirmBox(String h, String s){
		return  JOptionPane.showConfirmDialog(null, s, h, JOptionPane.YES_NO_OPTION);
	}
	
	public static Point FramePosition(int width, int height){
		int x = GlobalData.getMonitorWidth()/2-width/2;
		int y = GlobalData.getMonitorHeight()/2-height/2;
		return new Point(x,y);
	}
	
	public static Connection ConnectDB(){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:db/ocons.db");
			return conn;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static Connection ConnectCDB(String c){		
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:db/"+c+".db");
			return conn;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public static String findDefaultConsultant(){
		String cn = null;
		Connection conn = ConnectDB();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Consultants WHERE First=1;");
			if (rs.next()){
				cn = rs.getString("Cons_ID");
			}
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return cn;
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