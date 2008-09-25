package data;

import java.sql.*;
import start.MyTools;

public class Consultant {
	private String ID;
	private String Name;
	private String Phone;
	private String EMail;
	private boolean IsDefault;
	private int PasswordHash;
	
	public Consultant(String id){
		ID = id;
	}
	
	public String getEMail() {
		return EMail;
	}
	public void setEMail(String mail) {
		EMail = mail;
	}
	public String getID() {
		return ID;
	}
	public void setID(String id) {
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
	
	public boolean readFromDB(){
		//Consultant c = new Consultant(id);
		boolean find = false;
		Connection conn = MyTools.ConnectDB();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Consultants WHERE Cons_ID="+ID+";");
			if (rs.next()){
				Name = rs.getString("Name");
				Phone = rs.getString("Phone");
				EMail = rs.getString("EMail");
				IsDefault = rs.getBoolean("First");
				PasswordHash = rs.getInt("PasswordHash");
				find = true;
			}
			conn.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return find;
	}
	
	public boolean ConsultantPresent(String id){
		boolean cp = false;
		Connection conn = MyTools.ConnectDB();
		try{
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Consultants WHERE Cons_ID="+id+";");
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
			PreparedStatement st = conn.prepareStatement("INSERT INTO Consultants VALUES(?,?,?,?,?,?);");
			st.setString(1, ID);
			st.setString(2, Name);
			st.setString(3, Phone);
			st.setString(4, EMail);
			st.setBoolean(5, IsDefault);
			st.setInt(6, PasswordHash);
			st.execute();
			conn.close();
			String cs = new Integer(ID).toString();
			MyTools.setStatusBarMessage("����������� "+cs+" ������� ��������!");
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