package gui.infopanel;

import gui.TreeItem;

import java.awt.BorderLayout;
import java.util.*;
import javax.swing.*;
import start.*;
import data.*;

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
		setLayout(new BorderLayout());
		viewPanels = new HashMap<String, JPanel>();
		currentPanel = null;
	}
	
	public void openPanel(String id){
		// Закрываем текущую панель
		closePanel();
		// Открываем новую
		if (isCreated(id)){
			currentPanel = viewPanels.get(id); 			
		}
		else {
			String sql="";
			String[] headers = {};	
			JPanel panel;
			if (id=="10") {
				sql = Client.getSql();				
				headers = Client.getTableHeader();
				InfoPanelDialog cf = new ClientForm("Clients","111");
				panel = new TableView(sql,headers,cf);
			}
			else if (id=="20"){
				panel = new JPanel();
			}
			else {
				panel = new JPanel();
			}
			viewPanels.put(id, panel);
			currentPanel = panel;			
		}
		//GlobalData.getFrame().getWorkPanel().setRightComponent(currentPanel);
		add(currentPanel);
		validate();
		GlobalData.getFrame().repaint();
	}
	
	
	public void closePanel(){
		if (currentPanel != null) {
			//currentPanel.setVisible(false);
			removeAll();
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
