package data;

import java.util.*;

public class Client {
	
	private int id;
	private String name;
	private String phone;
	private String mobile;
	private String adress;
	private GregorianCalendar birthday;
	private String other_event;
	private GregorianCalendar other_event_date;
	private float discount;
	
	public String getAdress() {
		return adress;
	}
	public GregorianCalendar getBirthday() {
		return birthday;
	}
	public float getDiscount() {
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
	public String getOther_event() {
		return other_event;
	}
	public GregorianCalendar getOther_event_date() {
		return other_event_date;
	}
	public String getPhone() {
		return phone;
	}

	public Client(int id, String name, String phone, String mobile, String adress, 
				  String birthday, String other_event, String other_event_date, String discount){
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.adress = adress;
		GregorianCalendar bday = new GregorianCalendar();
		//bday.
	}
}
