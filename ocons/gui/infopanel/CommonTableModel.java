package gui.infopanel;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

	/**
	 * Универсальная модель для таблиц.
	 * Поскольку SQLite не работает с прокручиваемыми курсорами,
	 * необходимо внутри модели хранить полную картину содержимого
	 * таблицы БД. В случае добавления строк или изменения содержимого,
	 * наряду с SQL-командой, обновляющей БД, необходимо добавлять или 
	 * изменять содержимое массива rows из соответствующей модели
	 * 
	 */

public class CommonTableModel extends AbstractTableModel {

	// количество колонок в таблице
	private int columns;
	// количество полей из БД
	private int fields;
	// массив заголовков столбцов
	private String[] columnnames;	
	// массив с номерами полей, отображаемых в таблице
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
	
	// Возвращает ключевое значение элемента из строки таблицы 
	// Ключевое значение всегда в 1-й позиции
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
