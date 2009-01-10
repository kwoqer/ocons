package start;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DBTools {

	//	 ����� ������������� ���
	public final static int YYYYMMDD = 1;
	public final static int DDMMYYYY = 2;
	
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
	
	public static ArrayList<String> convSQLfromString(String s){
		StringBuffer buf = new StringBuffer();
		ArrayList<String> reslist = new ArrayList<String>();
		int i=0;
		char c;
		while (i!=s.length()-1) {
			c = s.charAt(i++);
			buf.append(c);
			if (c==';') {
				reslist.add(buf.toString());
				buf.delete(0, buf.length());
			}			
		}				
		return reslist;
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
