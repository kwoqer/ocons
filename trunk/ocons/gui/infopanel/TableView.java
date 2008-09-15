package gui.infopanel;


import javax.swing.*;
import java.sql.*;
import start.*;

public class TableView extends JPanel {
	
	private CommonTableModel tableModel;

	public TableView(String sql) {
		try {
			Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

	

}
