package settings.dbcontrol;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	private DataBaseSpecification DBspec;
	private Connection connection;
	
	
	public DataBase(DataBaseSpecification db) {		
		DBspec = db;
	}
	
	public Connection connect(){
		try {
			Class.forName(DBspec.getJDBCType());
			connection = DriverManager.getConnection(DBspec.getConnectString());			
			return connection;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void disconnect(){
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
