package gui.infopanel;

import java.sql.*;
import javax.swing.table.AbstractTableModel;

public class CommonTableModel extends AbstractTableModel {

	private int columns;
	private ResultSet results;
	private String[] columnnames;
	
	public CommonTableModel(ResultSet rs, String[] names){
		columns = columnnames.length;
		results = rs;
		columnnames = names; 
	}
	
	public int getColumnCount() {
		return columns;
	}

	public String getColumnName(int c){
		return columnnames[c+1];
	}
	
	public int getRowCount() {
		try
	      {  
	         results.last();
	         return results.getRow();
	      }
	      catch(SQLException e)
	      {  
	         e.printStackTrace();
	         return 0;
	      }
	}

	public Object getValueAt(int r, int c) {
		try
	      {  
	         results.absolute(r + 1);
	         return results.getObject(c + 1);
	      }
	      catch(SQLException e)
	      {  
	         e.printStackTrace();
	         return null;
	      }
	}

}
