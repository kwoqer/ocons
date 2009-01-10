package gui.infopanel;


import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import start.*;

public class TableView extends JPanel {
	
	private CommonTableModel tableModel;
	//private Map<String, ToolBarAction> actionBar; 
	private JToolBar actionBar;
	private InfoPanelDialog dialogBox;
	private JTable table;
	private JScrollPane scrollPane;

	public InfoPanelDialog getExecutor(){
		return dialogBox;
	}
	
	public TableView(String sql,int fields, int[] columns, String[] headers, InfoPanelDialog executor) {
		try {
			dialogBox = executor;
			setLayout(new BorderLayout());
			Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			tableModel = new CommonTableModel(rs,fields,headers,columns);
			rs.close();
			table = new JTable(tableModel);
			JTableHeader tableHeader = table.getTableHeader();
			Color bg = new Color(179,216,0);
			tableHeader.setBackground(bg);
			/* Font f = tableHeader.getFont(); 
			f.deriveFont(Font.BOLD);
			f.deriveFont(Font.TRUETYPE_FONT);
			tableHeader.setFont(f);
			
			TableColumnModel tcm = table.getColumnModel();
			for (int i=1;i<=5;i++) {
				TableColumn tc = new TableColumn();
				tc.setHeaderValue(headers[columns[i-1]-1]);
				tcm.addColumn(tc);
			}			
			tableHeader.setColumnModel(tcm);*/
			table.setTableHeader(tableHeader);
			table.addFocusListener(new FocusListener(){

				public void focusGained(FocusEvent e) {					
					checkRowSelected();
				}

				public void focusLost(FocusEvent e) {
					//checkRowSelected();
				}
				
			});
			
			scrollPane = new JScrollPane(table);
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
	
	public void refresh(){
		tableModel.fireTableDataChanged();
		repaint();
	}
	
	public JTable getTable(){
		return table;
	}

	private void createActionBar(){
		actionBar = new JToolBar();
		actionBar.add(new ToolBarAction("Add",dialogBox,this));		
		actionBar.add(new ToolBarAction("Delete",dialogBox,this));
		actionBar.add(new ToolBarAction("Edit",dialogBox,this));
		actionBar.add(new ToolBarAction("Find",dialogBox,this));
		add(actionBar,BorderLayout.NORTH);
		checkRowSelected();
	}
	
	// Возможность добавления в тулбар кнопок, отличных от стандартных
	public void addAction(ToolBarAction a){
		actionBar.add(a);
	}
	
	private void setEditDeleteEnabled(){
		actionBar.getComponent(1).setEnabled(true);
		actionBar.getComponent(2).setEnabled(true);
		actionBar.repaint();
	}
	
	private void setEditDeleteDisabled(){
		actionBar.getComponent(1).setEnabled(false);
		actionBar.getComponent(2).setEnabled(false);
		actionBar.repaint();
	}
	
	private void checkRowSelected(){		
		if (table.getSelectedRow()==-1)
			setEditDeleteDisabled();
		else
			setEditDeleteEnabled();
	}

}
