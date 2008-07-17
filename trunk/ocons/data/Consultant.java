package data;

import java.sql.*;
import start.MyTools;

public class Consultant {
	private int ID;
	private String Name;
	private String Phone;
	private String EMail;
	private boolean IsDefault;
	private int PasswordHash;
	
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
	
	public Consultant readFromDB(int id){
		Consultant c = new Consultant(id);
		Connection conn = MyTools.ConnectDB();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Consultants WHERE Cons_ID="+Integer.toString(id)+";");
			if (rs.next()){
				c.Name = rs.getString("Name");
				c.Phone = rs.getString("Phone");
				c.EMail = rs.getString("EMail");
				c.IsDefault = rs.getBoolean("First");
				c.PasswordHash = rs.getInt("PasswordHash");
			}
			else{
				c = null;
			}
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return c;
		
	}
	
	public boolean ConsultantPresent(int id){
		Boolean cp = false;
		Connection conn = MyTools.ConnectDB();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Consultants WHERE Cons_ID="+Integer.toString(id)+";");
			if (rs.next()){
				cp = true;
			}
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return cp;
	}
	
	public void addToDB(){
		Connection conn = MyTools.ConnectDB();
		try{
			//TODO Проверка - если установлен isDefault - сбросить у предыдущего
			PreparedStatement st = conn.prepareStatement("INSERT INTO Consultants VALUES(?,?,?,?,?,?);");
			st.setInt(1, ID);
			st.setString(2, Name);
			st.setString(3, Phone);
			st.setString(4, EMail);
			st.setBoolean(5, IsDefault);
			st.setInt(6, PasswordHash);
			st.execute();
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}

	public int getPasswordHash() {
		return PasswordHash;
	}

	public void setPasswordHash(int passwordhash) {
		PasswordHash = passwordhash;
	}
}
