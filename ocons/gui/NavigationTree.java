package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import settings.Localizator;
import start.*;

public class NavigationTree extends JPanel {
	
	private DefaultMutableTreeNode root;
	private TreeManager tm; 

	public TreeManager getTreeManager() {
		return tm;
	}

	public NavigationTree(String cn){
		
		// Tree		
		tm = new TreeManager();
		
		tm.addItem(new TreeItem(Localizator.NT_Clients,"10","pict/userb22.png"));
		tm.addItem(new TreeItem(Localizator.NT_Invoices,"20","pict/textfile22.png"));
		tm.addItem(new TreeItem(Localizator.NT_Catalogs,"30","pict/favb22.png"));
		tm.addItem(new TreeItem(Localizator.NT_Pricelist,"40","pict/money22.png"));
		tm.addItem(new TreeItem(Localizator.NT_Orders,"50","pict/file22.png"));
		tm.addItem(new TreeItem(Localizator.NT_Reports,"60","pict/documents22.png"));
		//tm.addItem(new TreeItem(Localizator.NT_Reports,"70","pict/struct.png"));
		tm.addItem(new TreeItem(Localizator.NT_Contacts,"80","pict/network22.png"));
		root = tm.BuildTree();
		
		setLayout(new BorderLayout());
		JTree navtree = new JTree(new DefaultTreeModel(root));
		navtree.setShowsRootHandles(true);
		navtree.putClientProperty("JTree.lineStyle", "None");
		navtree.setRowHeight(24);
		navtree.setCellRenderer(new CustomIconTreeCellRenderer());
		navtree.addTreeSelectionListener(new TreeListener());
		JScrollPane scrollPane = new JScrollPane(navtree);
		
		
		add(scrollPane, BorderLayout.CENTER);
		//setVisible(true);
	}
	
	public void setConsultantNumber(String cn){		
		TreeItem newroot = new TreeItem(cn,"0","pict/user22.png");
		root.setUserObject(newroot);
	}
	
	public Object getRootObject(){
		return root.getUserObject();
	}
	
	private static class CustomIconTreeCellRenderer extends DefaultTreeCellRenderer{
		
		private TreeItem item;
		
		public final Icon getClosedIcon(){
			if (item!=null && item.getIcon()!= null)
				return item.getIcon();
			else
				return super.getClosedIcon();
		}
		
		public final Icon getLeafIcon(){
			if (item!=null && item.getIcon()!= null)
				return item.getIcon();
			else
				return super.getLeafIcon();
		}
		
		public final Icon getOpenIcon(){
			if (item!=null && item.getIcon()!= null)
				return item.getIcon();
			else
				return super.getOpenIcon();
		}
		
		public final Component getTreeCellRendererComponent(JTree jtree, Object obj, boolean flag,
							boolean flag1, boolean flag2, int i, boolean flag3){
			DefaultMutableTreeNode dmtn = (DefaultMutableTreeNode)obj;
			item = (TreeItem)dmtn.getUserObject();
			Font bbFont = new Font(Font.DIALOG,Font.BOLD,12);
			Font nbFont = new Font(Font.DIALOG,Font.PLAIN,12);
			if (item.getId()=="0"){				
				setFont(bbFont);
			}
			else{
				setFont(nbFont);
			}
			Component c = super.getTreeCellRendererComponent(jtree, obj, flag, flag1, flag2, i, flag3);
			item = null;
			return c;
		}
		
		public CustomIconTreeCellRenderer(){
			
		}
	}
	
	private static class TreeListener implements TreeSelectionListener{
		
		public void valueChanged(TreeSelectionEvent e){
			TreePath path = e.getNewLeadSelectionPath();
			if (path == null) return;
			DefaultMutableTreeNode selectedNode = 
				(DefaultMutableTreeNode)path.getLastPathComponent();
			TreeItem item = (TreeItem)selectedNode.getUserObject();
			MyTools.setStatusBarMessage(item.getName());
			GlobalData.getFrame().getInfoPanel().openPanel(item.getId());
			GlobalData.getFrame().validate();
		}
	}
}


