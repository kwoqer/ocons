package start;

import java.lang.reflect.*;
import java.sql.*;

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
	 
	
	public  Localizator(String lang) throws SQLException{
		Connection conn = MyTools.ConnectDB();
		Statement stat = conn.createStatement();
		ResultSet rs = stat.executeQuery("SELECT Name,"+lang+" FROM Localization");
		
		/*	Имена полей перечислены в БД
		 * 	Извлекаем имена и значения, соответствующие нужному языку
		 *  и присваиваем их
		 *  G - ключевое значение - название языка
		 */
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
		//MyTools.MessageBox(MM_1_Control);
	}
	
}
