package gui.infopanel;

import gui.TreeItem;
import java.util.*;

import javax.swing.JPanel;

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
	}
	
	public void openPanel(String id){
		// Закрываем текущую панель
		closePanel();
		// Открываем новую
		if (isCreated(id)){
			currentPanel = viewPanels.get(id); 
			currentPanel.setVisible(true);
		}
		else {
			String sql="";
			if (id=="10") {
				sql = "SELECT Name, Adress, Phone, PhoneMob FROM Clients";
			}
			else if (id=="20"){
				
			}
			else {
				
			}
			JPanel panel = new TableView(sql);
			viewPanels.put(id, panel);
		}
	}
	
	public void closePanel(){
		currentPanel.setVisible(false);
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
