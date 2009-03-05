package settings;

import java.util.ArrayList;

public class LogicalStructure {
	
	private ArrayList<StructuralElement> structure;
	
	public LogicalStructure(){
		structure = new ArrayList<StructuralElement>();
	}
	
	public void addElement(StructuralElement element){
		structure.add(element);
	}
}
