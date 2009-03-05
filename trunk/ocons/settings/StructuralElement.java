package settings;

public class StructuralElement {
	
	public String table;
	public String field;
	public String type;
	public String action;
	
	
	public StructuralElement(String table, String field, String type, String action) {	
		this.table = table;
		this.field = field;
		this.type = type;
		this.action = action;
	}


	public StructuralElement(String table, String field, String type) {		
		this.table = table;
		this.field = field;
		this.type = type;
		action = "";		
	}


	public StructuralElement(String table, String action) {		
		this.table = table;
		field = "";
		type = "";
		this.action = action;
	}
	
	
	
	
}
