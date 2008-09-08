package gui;

import javax.swing.*;

import start.MyTools;

public class TreeItem {
	
	private Icon icon;
	private String name;
	private String id;	// root - "0", ����� 10, 20, 30..., ������ - 11, 12..
	
	public TreeItem(String name, String id, String ipath){
		this.name = name;
		this.id = id;
		icon = MyTools.getImageResource(ipath);
		
	}
	
	public Icon getIcon() {
		return icon;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString(){
		return name;
	}
	
	
	
}
