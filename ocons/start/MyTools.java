package start;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.*;
import javax.swing.*;

public class MyTools {
	
	// Стили представления дат
	public final static int YYYYMMDD = 1;
	public final static int DDMMYYYY = 2;
	
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
	
	public static String DateToYMD(java.util.Date d){
		return DateToString('-',YYYYMMDD,d);
	}
	
	public static String DateToDMY(java.util.Date d){
		return DateToString('.',DDMMYYYY,d);
	}
	
	public static java.util.Date YMDToDate(String ymd){
	java.util.Date d = new Date(); 	
	try {		
		String Sy = ymd.substring(0,4);
		String Sm = ymd.substring(5,7);
		String Sd = ymd.substring(8);		
		Integer Iy = new Integer(Sy);
		Integer Im = new Integer(Sm);
		Integer Id = new Integer(Sd);
		GregorianCalendar gc = new GregorianCalendar(Iy.intValue(),Im.intValue()-1,Id.intValue());
		d = gc.getTime();
		} 
	catch (Exception e){
		d = null;
	}
		
	return d;
		
	}
	
	private static String DateToString(char separator, int style, java.util.Date d){
	String s = "";	
	if  (d!=null){	
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(d);				
		Integer Iy = new Integer(c.get(Calendar.YEAR));
		Integer Im = new Integer(c.get(Calendar.MONTH)+1);		
		String Sm = "0";
		if (Im.intValue()<10)
			Sm = Sm + Im.toString();
		else
			Sm = Im.toString();
		Integer Id = new Integer(c.get(Calendar.DATE));
		String Sd = "0";
		if (Id.intValue()<10)
			Sd = Sd + Id.toString();
		else
			Sd = Id.toString();
		
		switch (style) {
		case DDMMYYYY:
			s = Sd + separator + Sm + separator + Iy.toString();
			break;
		case YYYYMMDD:
			s = Iy.toString()+separator+Sm+separator+Sd;
			break;
		}
	}
	
	return s;
	}
}
