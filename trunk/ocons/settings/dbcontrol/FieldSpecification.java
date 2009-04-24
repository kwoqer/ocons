package settings.dbcontrol;

public class FieldSpecification {
	private String name;
	private String type;
	private String size;
	private String keys;
	static final String space = " ";
	
	public FieldSpecification(String name, String type, String size, String keys){
		this.name = name;		
		this.type = type;
		this.size = size;
		this.keys = keys;
	}
	
	public FieldSpecification(String name, String type, String size){
		this.name = name;		
		this.type = type;
		this.size = size;
		this.keys = "";
	}
	
	public FieldSpecification(String name, String type){
		this.name = name;		
		this.type = type;
		this.size = "";
		this.keys = "";
	}
	
	public String getFullString(){
		return name+space+type+size+space+keys;
	}
	
	public String getName(){
		return name;
	}
	
	public String getSpecification(){
		return space+type+size+space+keys;
	}
}
