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

	public TableView(String sql,int fields, int[] columns, String[] headers, InfoPanelDialog executor) {
		try {
			dialogBox = executor;
			setLayout(new BorderLayout());
			Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			tableModel = new CommonTableModel(rs,fields,headers,columns);
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
		actionBar.add(new ToolBarAction("Add",dialogBox));		
		actionBar.add(new ToolBarAction("Delete",dialogBox));
		actionBar.add(new ToolBarAction("Edit",dialogBox));
		actionBar.add(new ToolBarAction("Find",dialogBox));
		add(actionBar,BorderLayout.NORTH);
	}
	
	// Возможность добавления в тулбар кнопок, отличных от стандартных
	public void addAction(ToolBarAction a){
		actionBar.add(a);
	}
	

}
