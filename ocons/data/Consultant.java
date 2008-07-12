package data;

import java.sql.Connection;

public class Consultant {
	private int ID;
	private String Name;
	private String Phone;
	private String EMail;
	private boolean IsDefault;
	private char[] Password;
	
	public Consultant(int id){
		ID = id;
	}
	
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String mail) {
		EMail = mail;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		ID = id;
	}
	public boolean isDefault() {
		return IsDefault;
	}
	public void setDefault(boolean isDefault) {
		IsDefault = isDefault;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public void readfromDB(int id, Connection conn){
		
	}
	
	public void savetoDB(Connection conn){
		
	}

	public char[] getPassword() {
		return Password;
	}

	public void setPassword(char[] password) {
		Password = password;
	}
}
