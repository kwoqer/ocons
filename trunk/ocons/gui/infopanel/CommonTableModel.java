package gui.infopanel;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CommonTableModel extends AbstractTableModel {

	private int columns;	
	private String[] columnnames;	
	private ArrayList<Row> rows;
	
	
	public CommonTableModel(ResultSet rs, String[] names){
		columns = names.length;		
		columnnames = names;
		rows = new ArrayList<Row>();
		
		try{			
			while (rs.next()){
				Row currentrow = new Row();
				for (int i=1; i<=columns; i++){						
					currentrow.add(rs.getObject(i));
				}
				rows.add(currentrow);				
			}
		}
		catch(SQLException e){  
	         e.printStackTrace();	       
	    }
	}
	
	public int getColumnCount() {
		return columns;
	}

	public String getColumnName(int c){
		return columnnames[c];
	}
	
	public int getRowCount() {		
		return rows.size();
	}

	public Object getValueAt(int r, int c) {		
		Row currentrow = rows.get(r);
		return currentrow.get(c);
	}
	
	public void addRow(ArrayList<Object> r){
		Row row = new Row(r);
		rows.add(row);
	}
		
	
	private class Row {
		
		private ArrayList<Object> elements;
		
		public Row(){
			elements = new ArrayList<Object>();
		}
		
		public Row(ArrayList<Object> r){			
			elements = r;
		}
		
		public void add(Object e){
			elements.add(e);
		}
		
		public Object get(int i){
			return elements.get(i);
		}
	}
}
