package gui.infopanel;

import gui.TreeItem;
import java.util.*;
import javax.swing.*;
import start.*;

/**
 * 
 * 
 *	Класс контейнер-менеджер, управляющий созданием и сменой информационных панелей 
 */
public class InfoPanel extends JPanel {

	// Сменные панели для разных режимов работы
	private Map<String, JPanel> viewPanels; 
	private JPanel currentPanel;
	
	public InfoPanel(){
		viewPanels = new HashMap<String, JPanel>();
		currentPanel = null;
	}
	
	public void openPanel(String id){
		// Закрываем текущую панель
		closePanel();
		// Открываем новую
		if (isCreated(id)){
			currentPanel = viewPanels.get(id); 
			//currentPanel.setVisible(true);
		}
		else {
			String sql="";
			String[] headers = {};			
			if (id=="10") {
				sql = "SELECT Name, Adress, Phone, PhoneMob FROM Clients";
				String[] head = new String[4];
				head[0] = Localizator.IP_ClientName;
				head[1] = Localizator.IP_ClientAdress;
				head[2] = Localizator.IP_ClientPhone;
				head[3] = Localizator.IP_ClientPhoneMob;
				headers = head;
			}
			else if (id=="20"){
				
			}
			else {
				
			}
			JPanel panel = new TableView(sql,headers);
			viewPanels.put(id, panel);
			currentPanel = panel;
		}
		GlobalData.getFrame().getWorkPanel().setRightComponent(currentPanel);
		GlobalData.getFrame().validate();
	}
	
	
	public void closePanel(){
		if (currentPanel != null) {
			currentPanel.setVisible(false);
		}
	}
	
	// Проверяет, создана ли панель для данного пункта дерева
	private boolean isCreated(String id){		
		for (Map.Entry<String,JPanel> entry : viewPanels.entrySet()){
			if (entry.getKey()==id) {
				return true;
			}
		}
		return false;
	}
}
