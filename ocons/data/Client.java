package data;

import java.sql.*;
import java.sql.Date;
import java.util.*;
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
	private char status;
	private double discount = 0;
	
	// Параметры отображения таблицы клиентов
	private static String[] tableHeader = {Localizator.IP_ClientName, Localizator.IP_ClientAdress,
											Localizator.IP_ClientPhone,Localizator.IP_ClientPhoneMob,Localizator.IP_ClientBirthday};
	// отсчет полей в БД начинается с 0
	private static int[] tableColumns = {1,4,2,3,5};
	private static int tableFields = 10;
	private static String sql = "SELECT * FROM Clients";
	
	
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
	
	public char getStatus(){
		return status;
	}

	public Client(int id, String name, String phone, String mobile, String adress, 
			java.util.Date birthday, String other_event, java.util.Date other_event_date, String discount, char status){
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
		Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Clients WHERE Client_ID="+Integer.toString(clientID)+";");
			if (rs.next()){				
				name = rs.getString("Name");
				phone = rs.getString("Phone");
				mobile = rs.getString("PhoneMob");
				adress = rs.getString("Adress");
				birthday = rs.getDate("Birthday");
				otherEvent = rs.getString("Other");
				otherEventDate = rs.getDate("Otherdate");
				status = rs.getString("Status").charAt(0);
				finded = true;
			}
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return finded;
	}
	
	public void addToDB(){
		Connection conn = MyTools.ConnectCDB(GlobalData.getConsultantNumber());
		try{
			PreparedStatement st = conn.prepareStatement("INSERT INTO Clients VALUES(?,?,?,?,?,?,?,?,?,?);");
			//st.setInt(1, id);
			st.setString(2, name);
			st.setString(3, phone);
			st.setString(4, mobile);
			st.setString(5, adress);
			if (birthday!=null) {
				java.sql.Date d = new java.sql.Date(birthday.getTime());			
				st.setDate(6, d);
			}			
			st.setString(7, otherEvent);
			if (otherEventDate!=null){
				java.sql.Date d1 = new java.sql.Date(otherEventDate.getTime());
				st.setDate(8, d1);
			}	
			st.setString(9, String.valueOf(status));
			st.setDouble(10, discount);
			st.execute();
			conn.close();
			
		}
		catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	public ArrayList<Object> generateRow(){
		ArrayList<Object> row = new ArrayList<Object>();
		row.add(new Integer(id));
		row.add(name);
		row.add(phone);
		row.add(mobile);
		row.add(adress);
		row.add(birthday);
		row.add(otherEvent);
		row.add(otherEventDate);
		row.add(String.valueOf(status));
		row.add(new Double(discount));
		return row;
	}
	
	
	
}
