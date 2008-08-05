package gui;

import javax.swing.*;

public class TreeItem {
	
	private Icon icon;
	private String name;
	private String id;
	
	
	public Icon getIcon() {
		return icon;
	}
	
	public void setIcon(String path) {
		Icon i = new ImageIcon(path);		
		this.icon = i;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return name;
	}
	
	
}
