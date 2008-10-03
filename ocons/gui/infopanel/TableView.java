package gui.infopanel;


import javax.swing.*;
import java.awt.BorderLayout;
import java.sql.*;
import java.util.*;

import start.*;

public class TableView extends JPanel {
	
	private CommonTableModel tableModel;
	//private Map<String, ToolBarAction> actionBar; 
	private JToolBar actionBar;
	private InfoPanelDialog dialogBox;

	public TableView(String sql, String[] headers) {
		try {
			setLayout(new BorderLayout());
			Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			tableModel = new CommonTableModel(rs, headers);
			rs.close();
			JTable table = new JTable(tableModel);
			JScrollPane scrollPane = new JScrollPane(table);
			createActionBar();
            add(scrollPane, BorderLayout.CENTER);
            validate();            			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
	public CommonTableModel getTableModel(){
		return tableModel;
	}

	private void createActionBar(){
		actionBar = new JToolBar();
		ClientForm cf = new ClientForm("Clients","111");
		actionBar.add(new ToolBarAction("Add",cf));		
		actionBar.add(new ToolBarAction("Delete",cf));
		actionBar.add(new ToolBarAction("Edit",cf));
		actionBar.add(new ToolBarAction("Find",cf));
		add(actionBar,BorderLayout.NORTH);
		
	}
	

}
