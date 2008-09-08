package gui;

import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import start.*;

/*	
 *  Класс-модель для дерева управления.
 */

public class TreeManager {
	
	/**
	 *  HashMap, состоящий из TreeItem. Из него строим дерево
	 */
	private Map<String, TreeItem> items;
	private TreeItem currentItem;
	
	
	public TreeManager(){
		 items = new LinkedHashMap<String, TreeItem>();
		 currentItem = null;
	}
	
	
	public TreeItem getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(TreeItem current_Item) {
		currentItem = current_Item;
	}

	public void addItem(TreeItem item) {
		items.put(item.getId(), item);
	}
	
	public DefaultMutableTreeNode BuildTree(){
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(
				new TreeItem(GlobalData.getConsultantNumber(),"0","pict/user22.png"));
		for (Map.Entry<String,TreeItem> entry : items.entrySet()){
			root.add(new DefaultMutableTreeNode(entry.getValue()));
		}
		return root;
	}
}
