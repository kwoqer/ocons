package gui.infopanel;


import javax.swing.*;

import java.awt.BorderLayout;
import java.sql.*;
import start.*;

public class TableView extends JPanel {
	
	private CommonTableModel tableModel;

	public TableView(String sql, String[] headers) {
		try {
			Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			tableModel = new CommonTableModel(rs, headers);
			JTable table = new JTable(tableModel);
			JScrollPane scrollPane = new JScrollPane(table);
            add(scrollPane, BorderLayout.WEST);
            validate();            
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

	

}
