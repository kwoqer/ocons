package gui.infopanel;

import gui.TreeItem;
import java.util.*;

import javax.swing.JPanel;

/**
 * 
 * 
 *	����� ���������-��������, ����������� ��������� � ������ �������������� ������� 
 */
public class InfoPanel extends JPanel {

	// ������� ������ ��� ������ ������� ������
	private Map<String, JPanel> viewPanels; 
	private JPanel currentPanel;
	
	public InfoPanel(){
		viewPanels = new HashMap<String, JPanel>();
	}
	
	public void openPanel(String id){
		// ��������� ������� ������
		closePanel();
		// ��������� �����
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
	
	// ���������, ������� �� ������ ��� ������� ������ ������
	private boolean isCreated(String id){		
		for (Map.Entry<String,JPanel> entry : viewPanels.entrySet()){
			if (entry.getKey()==id) {
				return true;
			}
		}
		return false;
	}
}
