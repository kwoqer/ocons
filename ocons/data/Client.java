package data;

import java.sql.*;
import java.util.*;

import settings.Localizator;
import start.*;

public class Client {
	
	private int id;
	private String name = null;
	private String phone = null;
	private String mobile = null;
	private String adress = null;
	private java.util.Date birthday = null;
	private String otherEvent = null;
	private java.util.Date otherEventDate = null;
	private int status;
	private double discount = 0;
	
	private static Vocabulary statusVoc = new Vocabulary(new String[] {"myself", Localizator.IP_ClientStatus_1, Localizator.IP_ClientStatus_2});
	
	// Параметры отображения таблицы клиентов
	private static String[] tableHeader = {Localizator.IP_ClientName, Localizator.IP_ClientAdress,
											Localizator.IP_ClientPhone,Localizator.IP_ClientPhoneMob,Localizator.IP_ClientBirthday};
	// отсчет полей в БД начинается с 0
	private static int[] tableColumns = {1,4,2,3,5};
	private static int tableFields = 10;
	private static String sql = "SELECT * FROM Clients WHERE Status!=0";
	
	
	public static String[] getTableHeader(){
		return tableHeader;
	}
	
	public static int[] getTableColumns(){
		return tableColumns;
	}
	
	public static String getSql(){
		return sql;
	}
	
	public static int getTableFields(){
		return tableFields;
	}
	
	public String getAdress() {
		return adress;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public double getDiscount() {
		return discount;
	}
	public int getId() {
		return id;
	}
	public String getMobile() {
		return mobile;
	}
	public String getName() {
		return name;
	}
	public String getOtherEvent() {
		return otherEvent;
	}
	public java.util.Date getOtherEventDate() {
		return otherEventDate;
	}
	public String getPhone() {
		return phone;		
	}
	
	public int getStatus(){
		return status;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOtherEvent(String otherEvent) {
		this.otherEvent = otherEvent;
	}

	public void setOtherEventDate(java.util.Date otherEventDate) {
		this.otherEventDate = otherEventDate;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public static Vocabulary getStatusVoc(){
		return statusVoc;
	}

	public Client(int id, String name, String phone, String mobile, String adress, 
			java.util.Date birthday, String other_event, java.util.Date other_event_date, String discount, int status){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.adress = adress;
		this.birthday = birthday;
		this.otherEvent = other_event;
		this.otherEventDate = other_event_date;
		this.status = status;
	}	
	
	public Client(){
		this.id = 0;
	}
	
	public boolean readFromDB(int clientID){		
		boolean finded = false;
		Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Clients WHERE Client_ID="+Integer.toString(clientID)+";");
			if (rs.next()){
				id = rs.getInt("Client_ID");
				name = rs.getString("Name");
				phone = rs.getString("Phone");
				mobile = rs.getString("PhoneMob");
				adress = rs.getString("Adress");
				String Sb = rs.getString("Birthday");
				//MyTools.MessageBox(Sb);
				birthday = DBTools.YMDToDate(Sb);
				otherEvent = rs.getString("Other");
				otherEventDate = DBTools.YMDToDate(rs.getString("Otherdate"));
				discount = (new Double(rs.getString("Discount"))).doubleValue();
				status = rs.getInt("Status");
				finded = true;
				//MyTools.MessageBox(birthday.toString());
			}
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}
	
	public void deleteFromDB(int clientID){		
		try {
			Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
			Statement st = conn.createStatement();
			st.execute("DELETE FROM Clients WHERE Client_ID="+Integer.toString(clientID)+";");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addToDB(){		
		try{
			Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());
			PreparedStatement st = conn.prepareStatement("INSERT INTO Clients VALUES(?,?,?,?,?,?,?,?,?,?);");
			//st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, phone);
			st.setString(4, mobile);
			st.setString(5, adress);
			if (birthday!=null) {						
				st.setString(6, DBTools.DateToYMD(birthday));
			}			
			st.setString(7, otherEvent);
			if (otherEventDate!=null){				
				st.setString(8, DBTools.DateToYMD(otherEventDate));
			}	
			st.setInt(9, status);
			st.setDouble(10, discount);
			st.execute();
			conn.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	public void updateRecord(){
		if (id!=0){				
			String Sid = (new Integer(id)).toString();
			try {
				Connection conn = DBTools.ConnectCDB(GlobalData.getConsultantNumber());		
				String prs =  "UPDATE Clients SET Name=?," +
												 "Phone=?," +
												 "PhoneMob=?," +
												 "Adress=?," +
												 "Birthday=?," +
												 "Other=?," +
												 "Otherdate=?," +
												 "Status=?," +
												 "Discount=? WHERE Client_ID="+Sid+";";
				PreparedStatement st = conn.prepareStatement(prs);
				st.setString(1, name);
				st.setString(2, phone);
				st.setString(3, mobile);
				st.setString(4, adress);
				if (birthday!=null) {						
					st.setString(5, DBTools.DateToYMD(birthday));
				}			
				st.setString(6, otherEvent);
				if (otherEventDate!=null){				
					st.setString(7, DBTools.DateToYMD(otherEventDate));
				}	
				st.setInt(8, status);
				st.setDouble(9, discount);
				st.execute();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public ArrayList<Object> generateRow(){
		ArrayList<Object> row = new ArrayList<Object>();
		row.add(new Integer(id));
		row.add(name);
		row.add(phone);
		row.add(mobile);
		row.add(adress);
		row.add(DBTools.DateToYMD(birthday));
		row.add(otherEvent);
		row.add(otherEventDate);
		row.add(String.valueOf(status));
		row.add(new Double(discount));
		return row;
	}
	
	
	
	
}
