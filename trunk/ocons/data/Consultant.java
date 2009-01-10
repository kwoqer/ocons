package data;

import gui.*;
import gui.infopanel.*;
import java.sql.*;
import start.*;

public class Consultant {
	private String ID;
	private String Name;
	private String Phone;
	private String EMail;
	private boolean IsDefault;
	private int PasswordHash;
	private NavigationTree consultantTree = null;
	private InfoPanel consultantPanel = null;
	
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
	
	public InfoPanel getConsultantPanel() {
		return consultantPanel;
	}

	public void setConsultantPanel(InfoPanel consultantPanel) {
		this.consultantPanel = consultantPanel;
	}

	public NavigationTree getConsultantTree() {
		return consultantTree;
	}

	public void setConsultantTree(NavigationTree consultantTree) {
		this.consultantTree = consultantTree;
	}

	public boolean readFromDB(){
		//Consultant c = new Consultant(id);
		boolean find = false;
		Connection conn = DBTools.ConnectDB();
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
		Connection conn = DBTools.ConnectDB();
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
		Connection conn = DBTools.ConnectDB();
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
			MyTools.setStatusBarMessage("Консультант "+ID+" успешно добавлен!");
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
	
	public static int getOwnClientNumber(String s){
		Integer I = new Integer(s.substring(1));
		I = I*1000;
		return I.intValue();
	}
}
