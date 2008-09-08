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
			// ���� ���� ��������� �� �� ���������� - ������� ��� � ��������� ��������� ������
			// �� ����� ocons.sql
			Connection conn = MyTools.ConnectDB();
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = MyTools.convSQL("db/ocons.sql");
			for (String s: SQLst){
				//MyTools.MessageBox(s);
				stat.execute(s);
			}
			// ������� �����������
			ArrayList<String> SQLst2 = MyTools.convSQL("db/local.sql");
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
			// ���� ���� �� ������������ �� ���������� - ������� ��� � ��������� ��������� ������
			// �� ����� consultant.sql
			
			Connection conn = MyTools.ConnectCDB(c);
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = MyTools.convSQL("db/consult.sql");
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