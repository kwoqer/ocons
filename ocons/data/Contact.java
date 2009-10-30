package data;

import java.sql.*;
import java.util.Date;

import start.*;


public class Contact {

	private int id;
	private String name = null;
	private String phone = null;
	private java.util.Date date = null;
	private java.util.Date last = null;
	private int wherefind;
	private int status;
	private String info;
	private int client_id;
	private int consultant_id;
	
	public int getClient_id() {
		return client_id;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public int getConsultant_id() {
		return consultant_id;
	}
	public void setConsultant_id(int consultant_id) {
		this.consultant_id = consultant_id;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public java.util.Date getLast() {
		return last;
	}
	public void setLast(java.util.Date last) {
		this.last = last;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getWherefind() {
		return wherefind;
	}
	public void setWherefind(int wherefind) {
		this.wherefind = wherefind;
	}
	
	public Contact(){
		this.id = 0;
	}	
	
	public Contact(int id, String name, String phone, Date date, Date last, int wherefind, int status, String info, int client_id, int consultant_id) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.date = date;
		this.last = last;
		this.wherefind = wherefind;
		this.status = status;
		this.info = info;
		this.client_id = client_id;
		this.consultant_id = consultant_id;
	}
	public boolean readFromDB(int id){
		boolean finded = false;
		Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Contacts WHERE Contact_ID="+Integer.toString(id)+";");
			if (rs.next()){
				this.id = rs.getInt("Contact_ID");
				this.name = rs.getString("Name");
				this.phone = rs.getString("Phone");
				this.date = DBTools.YMDToDate(rs.getString("Date"));
				this.last = DBTools.YMDToDate(rs.getString("Last"));
				this.wherefind = rs.getInt("WhereFind");
				this.status = rs.getInt("Status");
				this.info = rs.getString("Info");
				this.client_id = rs.getInt("Client_ID");
				this.consultant_id = rs.getInt("Consultant_ID");
				finded = true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finded;
	}
	
	public void addToDB(){
		try{
			Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
			PreparedStatement st = conn.prepareStatement("INSERT INTO Contacts VALUES(?,?,?,?,?,?,?,?,?,?);");
			//st.setInt(1, id);
			st.setString(2, phone);
			st.setInt(3, wherefind);
			st.setString(4, name);			
			if (this.date!=null) {						
				st.setString(5, DBTools.DateToYMD(date));
			}
			if (this.last!=null) {						
				st.setString(6, DBTools.DateToYMD(last));
			}
			st.setInt(7, status);
			st.setString(8, info);
			
			st.setInt(9, client_id);
			st.setInt(10, consultant_id);
			st.execute();
			conn.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public void deleteFromDB(int id){		
		try {
			Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement st = conn.createStatement();
			st.execute("DELETE FROM Contacts WHERE Contacts_ID="+Integer.toString(id)+";");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateInDB(){
		if (id!=0){				
			String Sid = (new Integer(id)).toString();
			try {
				Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());		
				String prs =  "UPDATE Contacts SET Phone=?," +
												  "WhereFind=," +
												  "Name=?," +
												  "Date=?," +
												  "Last=?," +
												  "Status=?," +
												  "Info=?," +
												  "Client_ID=?," +
												  "Consultant_ID=? WHERE Contact_ID="+Sid+";";
				PreparedStatement st = conn.prepareStatement(prs);
				st.setString(1, phone);
				st.setInt(2, wherefind);
				st.setString(3, name);				
				if (date!=null) {						
					st.setString(4, DBTools.DateToYMD(date));
				}
				if (last!=null) {						
					st.setString(5, DBTools.DateToYMD(last));
				}
				st.setInt(6, status);								
				st.setString(7, info);					
				st.setInt(8, client_id);
				st.setInt(9, consultant_id);
				st.execute();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
}
