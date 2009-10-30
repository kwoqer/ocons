package start;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.parsers.*;

import org.w3c.dom.*;

public class DBTools {

	//	 Стили представления дат
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
	/*
	 * Разбивает файл с набором sql-команд на команды и помещает их в массив
	 */
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
	/*
	 * То же самое, только в sql-программа не в файле, а в String-e
	 */
	public static ArrayList<String> convSQLfromString(String s){
		StringBuffer buf = new StringBuffer();
		ArrayList<String> reslist = new ArrayList<String>();
		int i=0;
		char c;
		do  {
			c = s.charAt(i++);
			buf.append(c);
			if (c==';') {
				reslist.add(buf.toString());
				buf.delete(0, buf.length());
			} 			
		} while (i<=s.length()-1);				
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
	/*
	 * Разбор xml-файла со структурой БД и формирование из него sql-запроса в String
	 */
	public static String XMLToSQL(String xmlfile){
		String sqlcommand, result = "";
		Element table,tablename, fields, field, fieldname, fieldtype;
		String vtablename, vfieldname, vfieldtype;
		DocumentBuilder builder;
		try {
			File f = new File(xmlfile);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);			
			Element root = doc.getDocumentElement(); // DBStructure			
			NodeList rootlist = root.getChildNodes();
			Element database = (Element)rootlist.item(0); // database
			NodeList dblist = database.getChildNodes();
			// databasename - пока не нужен
			Element tables = (Element)dblist.item(1); // tables
			NodeList nodelist = tables.getChildNodes();
			// перебираем все элементы table
			NodeList nodelist2, nodelist3, nodelist4;		
			for (int i = 0; i < nodelist.getLength(); i++) {
				table = (Element)nodelist.item(i);
				nodelist2 = table.getChildNodes();
				tablename = (Element)nodelist2.item(0);
				vtablename = tablename.getTextContent();
				sqlcommand = "CREATE TABLE "+vtablename+" (";
				fields = (Element)nodelist2.item(1);
				nodelist3 = fields.getChildNodes();				
				for (int j = 0; j < nodelist3.getLength(); j++) {
					field = (Element)nodelist3.item(j);
					nodelist4 = field.getChildNodes();
					fieldname = (Element)nodelist4.item(0);
					vfieldname = fieldname.getTextContent();
					fieldtype = (Element)nodelist4.item(1);
					vfieldtype = fieldtype.getTextContent();
					sqlcommand = sqlcommand + vfieldname+" "+vfieldtype;
					if (j != nodelist3.getLength()-1) {
						sqlcommand = sqlcommand+",";
					}
					else {
						sqlcommand = sqlcommand+");";
					}
				}
				result = result + sqlcommand;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
