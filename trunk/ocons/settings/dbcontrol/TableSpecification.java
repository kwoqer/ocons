package settings.dbcontrol;

import java.util.*;

public class TableSpecification {
	
	private String name;
	private ArrayList<FieldSpecification> fields;
 
	
	public TableSpecification(String name){
		this.name = name;
		fields = new ArrayList<FieldSpecification>();		
	}
	
	public void addField(FieldSpecification f){
		fields.add(f);
	}
	
	public String getName(){
		return name;
	}
	
	public int getFieldsQuantity(){
		return fields.size();
	}
	
	/**
	 * возвращает спецификацию по названию поля
	 */
	public FieldSpecification getFieldSpecification(String f){
		Iterator<FieldSpecification> iterator = fields.iterator();
		while (iterator.hasNext()) {
			FieldSpecification fs = iterator.next();
			if (fs.getName()==f){
				return fs;
			}
		}
		return null;
	}
	
	/**
	 * возвращает команду SQL, которая создает таблицу
	 */
	public String createSQLTable(){
		String sqlcommand = "CREATE TABLE "+name+" (";
		Iterator<FieldSpecification> iterator = fields.iterator();
		while (iterator.hasNext()) {
			FieldSpecification fs = iterator.next();
			sqlcommand = sqlcommand + fs.getFullString();
			if (iterator.hasNext()) {
				sqlcommand = sqlcommand + ",";
			};			
		}
		sqlcommand = sqlcommand + ");";
		return sqlcommand;
	}
}
