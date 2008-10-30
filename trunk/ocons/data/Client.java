package data;

import java.sql.*;
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
											Localizator.IP_ClientPhone,Localizator.IP_ClientPhoneMob};
	// отсчет полей в БД начинается с 0
	private static int[] tableColumns = {1,4,2,3};
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
			PreparedStatement st = conn.prepareStatement("INSERT INTO Clients VALUES(?,?,?,?,?,?);");
		}
		catch (SQLException e){
			e.printStackTrace();
		}	
		
	}
	
	
	
}
