package settings;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import start.DBTools;

public class Localizator {
	// Общие
	public static String G_Language;
	public static String G_Attention;
	public static String G_Error;
	public static String G_Open;
	public static String G_Save;
	public static String G_Cancel;
	public static String G_Yes;
	public static String G_No;
	public static String G_Ok;
	public static String G_AYouSure;
	// AddConsultantDialog
	public static String ACD_Title;
	public static String ACD_PersonalNumber;
	public static String ACD_Name;
	public static String ACD_Phone;
	public static String ACD_EMail;
	public static String ACD_Remember;
	public static String ACD_Password;
	public static String ACD_RepeatPassword;
	public static String ACD_RedLighting;
	public static String ACD_ConsultantPresent;
	public static String ACD_PasswordsNotCoincide;
	// LoginDialog
	public static String LD_Title;
	public static String LD_Number;
	public static String LD_Password;
	public static String LD_Enter;
	public static String LD_ConsultantNumberNotPoint;
	public static String LD_IncorrectPassword;
	public static String LD_ConsultantNumberNotFound;
	// MainMenu
	public static String MM_1_Control;
	public static String MM_Config;
	public static String MM_AboutProgram;
	public static String MM_Exit;
	public static String MM_2_Consultant;
	public static String MM_NewConsultant;
	public static String MM_Enter;
	public static String MM_OtherConsultant;
	public static String MM_ConfirmOtherConsultant;
	// NavigationTree
	public static String NT_Clients;
	public static String NT_Invoices;
	public static String NT_Catalogs;
	public static String NT_Pricelist;
	public static String NT_Reports;
	public static String NT_Orders;
	public static String NT_Contacts;
	// InfoPanel
	//  ---- GLOBAL
	public static String IP_Clients;
	public static String IP_Catalogs;
	public static String IP_Orders;
	public static String IP_Invoices;
	public static String IP_Prices;
	// ---- Actions
	public static String IP_AddAction;
	public static String IP_DeleteAction;
	public static String IP_EditAction;
	public static String IP_FindAction;
	public static String IP_PreviewAction;
	public static String IP_PrintAction;
	// ---- Fields 
	public static String IP_CatalogNumber;
	public static String IP_CatalogGiveDate;
	public static String IP_CatalogReturnDate;
	public static String IP_CatalogReturned;
	public static String IP_CatalogInfo;
	
	public static String IP_ClientName;
	public static String IP_ClientPhone;
	public static String IP_ClientPhoneMob;
	public static String IP_ClientAdress;
	public static String IP_ClientBirthday;
	public static String IP_ClientOther;
	public static String IP_ClientOtherDate;
	public static String IP_ClientStatus;
	public static String IP_ClientStatus_1;
	public static String IP_ClientStatus_2;
	public static String IP_ClientDiscount;
	public static String IP_ClientIncorrectDiscountFormat;
	public static String IP_ClientAdd;
	public static String IP_ClientEdit;	
	
	public static String IP_OrderDate;
	public static String IP_OrderQuantity;
	public static String IP_InvoicesID;
	public static String IP_InvoicesOrdered;
	public static String IP_InvoicesReceived;
	public static String IP_InvoicesPrice;
	public static String IP_InvoicesPoints;
	public static String IP_ProductID;
	public static String IP_ProductGetDate;
	public static String IP_ProductGetPrice;
	public static String IP_ProductRealDate;
	public static String IP_ProductRealPrice;
	public static String IP_EventsComing;
	public static String IP_EventsCompletion;
	public static String IP_EventsFixed;
	public static String IP_EventInfo;
	
	public static String IP_Contact;
	public static String IP_ContactPhone;
	public static String IP_ContactWhereFind;
	public static String IP_ContactWhereFind_1;
	public static String IP_ContactWhereFind_2;
	public static String IP_ContactWhereFind_3;
	public static String IP_ContactWhereFind_4;
	public static String IP_ContactName;
	public static String IP_ContactDate;
	public static String IP_ContactStatus;
	
	
	private String lang;
	
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
		readXML(lang);
	}

	public  Localizator(String lang) {
		this.lang = lang;
		/*
		Connection conn = DBTools.ConnectDB();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT Name,"+lang+" FROM Localization");
		
		 *	Имена полей перечислены в БД
		 * 	Извлекаем имена и значения, соответствующие нужному языку
		 *  и присваиваем их
		 *  G - ключевое значение - название языка
		 *
		while (rs.next()) {
			String fieldname = rs.getString("Name");
			String value = rs.getString(lang);
			try {
				if (!fieldname.equals("G")) {
					Field f = this.getClass().getField(fieldname);
					f.set(null, value);
				}	
			}
			catch (Exception e){
				e.printStackTrace();
			} 
		}
		rs.close();
		*/
	}
	
	/*
	 * Формирование dtd-файла с перичислением всех public static полей
	 * Служебная функция, используется для формирования dtd при обновлениях.
	 * На его основе формируется xml с локализацией.
	 * Плюс - всегда формируется список из всех полей Localizator-а, если 
	 * 		  чего-то не будет хватать, xml будет невалидным
	 * Минус - порядок полей в xml должен соответствовать dtd, т.е порядку
	 * 		   объявления полей в Localizator
	 */
	public void createDTD(){
		ArrayList<String> locs = new ArrayList<String>();		
		Class lc = this.getClass();
		Field[] fields = lc.getDeclaredFields();
		for (Field field : fields) {
			int m = field.getModifiers();
			boolean isLoc = Modifier.isPublic(m) && Modifier.isStatic(m);
			if (isLoc) {
				locs.add(field.getName());
			}			
		}					
		try {			
			FileWriter dtd_file = new FileWriter("db/local.dtd");
			dtd_file.write("<!ELEMENT Localization (locallist)>\n");
			dtd_file.write("<!ATTLIST Localization lang CDATA #REQUIRED>\n");
			String llist = "<!ELEMENT locallist (";
			for (String  s : locs) {
				llist += s+",";
			}
			// убираем последнюю запятую
			llist = llist.substring(0, llist.length()-1);		
			llist += ")>\n"; 
			dtd_file.write(llist);
			for (String s : locs) {
				dtd_file.write("<!ELEMENT "+s+" (#PCDATA)>\n");
			}
			dtd_file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void readXML(String lang){
		DocumentBuilder builder;
		try {
			File f = new File("db/lang_"+lang+".xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);			
			Element root = doc.getDocumentElement(); // Localization
			NodeList rootlist = root.getChildNodes();
			Element locallist = (Element)rootlist.item(0); // locallist
			NodeList nodelist = locallist.getChildNodes();
			for (int i = 0; i < nodelist.getLength(); i++) {
				Element element = (Element)nodelist.item(i);
				String name = element.getNodeName();
				String value = element.getTextContent();
				Field field = this.getClass().getDeclaredField(name);
				field.set(null,value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
