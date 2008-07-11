package start;

import java.sql.*;
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
			// ���� ���� ��������� �� �� ���������� - ������� ��� � ��������� ��������� ������
			// �� ����� ocons.sql
			MyTools.MessageBox("���� ���� �������");
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:db\\ocons.db");
			Statement stat = conn.createStatement();	
	    
			ArrayList<String> SQLst = MyTools.convSQL("db\\ocons.sql");
			for (String s: SQLst){
				stat.execute(s);
			}
			conn.close();
		}
	    
	}
}
