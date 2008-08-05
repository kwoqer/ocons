package gui;

import java.awt.BorderLayout;


import javax.swing.*;
import javax.swing.tree.*;
import data.Consultant;

public class NavigationTree extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private DefaultMutableTreeNode root; 

	public NavigationTree(int cn){
		
		// Tree
		Integer ci = new Integer(cn);
		root = new DefaultMutableTreeNode(ci.toString());
		DefaultMutableTreeNode clients = new DefaultMutableTreeNode("Клиенты");
		DefaultMutableTreeNode invoices = new DefaultMutableTreeNode("Накладные");
		DefaultMutableTreeNode catalogs = new DefaultMutableTreeNode("Каталоги");
		DefaultMutableTreeNode pricelist = new DefaultMutableTreeNode("Прайслист");
		DefaultMutableTreeNode reports = new DefaultMutableTreeNode("Отчеты");
		root.add(clients);
		root.add(invoices);
		root.add(catalogs);
		root.add(pricelist);
		root.add(reports);
		setLayout(new BorderLayout());
		JTree navtree = new JTree(new DefaultTreeModel(root));
		JScrollPane scrollPane = new JScrollPane(navtree);
		
		//Dimension d = new Dimension(200,10000);
		//Dimension dmax = new Dimension();
		//d = scrollPane.getSize();
		//dmax = scrollPane.getMaximumSize();
		//d.height = dmax.height;
		//scrollPane.setMinimumSize(d);
		//scrollPane.setPreferredSize(d);
		add(scrollPane, BorderLayout.CENTER);
		//setVisible(true);
	}
	
	public void setConsultantNumber(int cn){
		String ci = new Integer(cn).toString();
		root.setUserObject(ci);
	}
	
	public Object getRootObject(){
		return root.getUserObject();
	}
}
