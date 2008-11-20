package gui.infopanel;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

	/**
	 * ������������� ������ ��� ������.
	 * ��������� SQLite �� �������� � ��������������� ���������,
	 * ���������� ������ ������ ������� ������ ������� �����������
	 * ������� ��. � ������ ���������� ����� ��� ��������� �����������,
	 * ������ � SQL-��������, ����������� ��, ���������� ��������� ��� 
	 * �������� ���������� ������� rows �� ��������������� ������
	 * 
	 */

public class CommonTableModel extends AbstractTableModel {

	// ���������� ������� � �������
	private int columns;
	// ���������� ����� �� ��
	private int fields;
	// ������ ���������� ��������
	private String[] columnnames;	
	// ������ � �������� �����, ������������ � �������
	private int[] colnumbers;
	private ArrayList<Row> rows;
	
	
	public CommonTableModel(ResultSet rs, int flds, String[] names, int[] clmnbrs){
		columns = names.length;		
		columnnames = names;
		fields = flds;
		rows = new ArrayList<Row>();
		colnumbers = clmnbrs;
		
		try{			
			while (rs.next()){
				Row currentrow = new Row();
				for (int i=1; i<=fields; i++){						
					currentrow.add(rs.getObject(i));
				}
				rows.add(currentrow);				
			}
		}
		catch(SQLException e){  
	         e.printStackTrace();	       
	    }
	}
	
	/*
	private boolean isVisible(int c){
		boolean visible = false;
		for (int i = 0; i <= colnumbers.length; i++) {
			if (c==colnumbers[i]){
				visible = true;
				break;
			}
			
		}
		return visible;
	}
	*/
	
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
		return currentrow.get(colnumbers[c]);
	}
	
	public void addRow(ArrayList<Object> r){
		Row row = new Row(r);
		rows.add(row);
	}
	
	// ���������� �������� �������� �������� �� ������ ������� 
	// �������� �������� ������ � 1-� �������
	public int getID(int row){
		Row r = rows.get(row);
		Integer key = (Integer)r.get(0);
		//Integer i = new Integer(key.toString());
		return key.intValue();
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
