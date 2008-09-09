package gui.infopanel;

import gui.TreeItem;
import java.util.*;

import javax.swing.JPanel;

public class InfoPanel extends JPanel {

	// —менные панели дл€ разных режимов работы
	private Map<String, JPanel> viewPanels; 
	private JPanel currentPanel;
	
	private static final long serialVersionUID = 1L;	
	
	public InfoPanel(){
		viewPanels = new HashMap<String, JPanel>();
	}
	public void openPanel(String id){
		
	}
	
	public void closePanel(){
		currentPanel.setVisible(false);
	}
	
	// ѕровер€ет, создана ли панель дл€ данного пункта дерева
	private boolean isCreated(String id){		
		for (Map.Entry<String,JPanel> entry : viewPanels.entrySet()){
			if (entry.getKey()==id) {
				return true;
			}
		}
		return false;
	}
}
