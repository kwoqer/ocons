package settings.dbcontrol;

import java.sql.Connection;
import java.util.ArrayList;

public class DataBaseSpecification {

	private String name;
	private String jdbctype;
	private String jdbc;
	private String path;
	private String ext;	
	private ArrayList<TableSpecification> tables;
	
	
	public DataBaseSpecification(String name,String jdbctype, String jdbc, String path, String ext) {		
		this.name = name;
		this.jdbctype = jdbctype;
		this.jdbc = jdbc;
		this.path = path;
		this.ext = ext;
		tables = new ArrayList<TableSpecification>();
	}
	
	public String getJDBCType(){
		return jdbctype;
	}
	
	public String getConnectString(){
		return jdbc+path+name+ext;
	}
	
	public void addTable(TableSpecification table){
		tables.add(table);
	}
		
}
