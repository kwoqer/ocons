package data;

import java.util.*;

import start.Localizator;

public class Client {
	
	private int id;
	private String name;
	private String phone;
	private String mobile;
	private String adress;
	private Calendar birthday;
	private String otherEvent;
	private Calendar otherEventDate;
	private double discount;
	
	// Параметры отображения таблицы клиентов
	private static String[] tableHeader = {Localizator.IP_ClientName, Localizator.IP_ClientAdress,
											Localizator.IP_ClientPhone,Localizator.IP_ClientPhoneMob};
	private static String sql = "SELECT Name, Adress, Phone, PhoneMob FROM Clients";
	
	public static String[] getTableHeader(){
		return tableHeader;
	}
	
	public static String getSql(){
		return sql;
	}
	
	public String getAdress() {
		return adress;
	}
	public Calendar getBirthday() {
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
	public Calendar getOtherEventDate() {
		return otherEventDate;
	}
	public String getPhone() {
		return phone;
	}

	public Client(int id, String name, String phone, String mobile, String adress, 
				  Calendar birthday, String other_event, Calendar other_event_date, String discount){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.adress = adress;
		this.birthday = birthday;
		this.otherEvent = other_event;
		this.otherEventDate = other_event_date;
		//discount.
	}	
}
