package start;

import gui.MainFrame;

import java.sql.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;
import java.util.ArrayList;


public class Prepare {
			
	public static void PrepareDB() throws Exception {
		boolean fileexist=false;
		{
			File dbfile = new File("db\\ocons.db");
			fileexist = dbfile.exists(); 
		}
		if (!fileexist){
			// если файл системной БД не существует - создаем его и формируем структуру таблиц
			// из файла ocons.sql
			Connection conn = MyTools.ConnectDB();
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = MyTools.convSQL("db\\ocons.sql");
			for (String s: SQLst){
				stat.execute(s);
			}
			conn.close();
		}
		    
	}
	
	public static void PrepareGD(){
		Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screensize = kit.getScreenSize();
	    GlobalData.setMonitorDimension(screensize.width,screensize.height);
	    
	}
}
