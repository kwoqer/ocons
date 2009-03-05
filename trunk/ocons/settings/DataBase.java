package settings;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	private String name;
	private String jdbcname;
	private String jdbc;
	private String path;
	private String ext;
	private Connection connection;
	
	
	public DataBase(String name,String jdbcname, String jdbc, String path, String ext) {		
		this.name = name;
		this.jdbcname = jdbcname;
		this.jdbc = jdbc;
		this.path = path;
		this.ext = ext;
	}
	
	public Connection connect(){
		try {
			Class.forName(jdbcname);
			connection = DriverManager.getConnection(jdbc+path+name+ext);			
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
