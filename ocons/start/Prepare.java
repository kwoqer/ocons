package start;

import java.sql.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;


public class Prepare {
			
	public static void PrepareDB() throws Exception {
		boolean fileexist=false;
		{
			File dbfile = new File("db/ocons.db");
			fileexist = dbfile.exists(); 
		}
		if (!fileexist){
			//MyTools.MessageBox("Create DB");
			// если файл системной БД не существует - создаем его и формируем структуру таблиц
			// из файла ocons.sql
			Connection conn = DBTools.ConnectDB();
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = DBTools.convSQL("db/ocons.sql");
			for (String s: SQLst){
				//MyTools.MessageBox(s);
				stat.execute(s);
			}
			// таблица локализации
			ArrayList<String> SQLst2 = DBTools.convSQL("db/local.sql");
			for (String s: SQLst2){				
				stat.execute(s);
			}
			conn.close();
		}
		    
	}
	
	public static void PrepareCDB(String c) throws Exception {
		boolean fileexist=false;		
		{			
			File dbfile = new File("db/"+c+".db");
			fileexist = dbfile.exists(); 
		}
		if (!fileexist){
			// если файл БД консультанта не существует - создаем его и формируем структуру таблиц
			// из файла consultant.sql
			
			Connection conn = DBTools.ConnectCDB(c);
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = DBTools.convSQL("db/consult.sql");
			for (String s: SQLst){
				stat.execute(s);
			}
			// добавим в список клиентов самого себя (покупка товаров для себя и 
			// установка автоинкремента в таблице клиентов)
			// первый знак в номере клиента отбрасываем
			Integer I = new Integer(c.substring(1));
			I = I*1000;
			stat.execute("INSERT INTO Clients VALUES(\""+I.toString()+
														  "\",\"0\","+
														  "\"\","+
														  "\"\","+
														  "\"\","+
														  "\"1900-01-01\","+
														  "\"\","+
														  "\"1900-01-01\","+
														  "\"0\","+
														  "30.0"+
														  ");");
			conn.close();
		}
		    
	}
	
	public static void PrepareGD(){
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screensize = kit.getScreenSize();
	    GlobalData.setMonitorDimension(screensize.width,screensize.height);
	    
	}
}
