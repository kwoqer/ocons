package gui;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import data.Consultant;
import start.*;

public class NavigationTree extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private DefaultMutableTreeNode root; 

	public NavigationTree(String cn){
		
		// Tree		
		root = new DefaultMutableTreeNode(new TreeItem(cn,"0","pict/user22.png"));
		DefaultMutableTreeNode node10 = new DefaultMutableTreeNode(new TreeItem("Клиенты","10","pict/userb22.png"));
		DefaultMutableTreeNode node20 = new DefaultMutableTreeNode(new TreeItem("Накладные","20","pict/textfile22.png"));
		DefaultMutableTreeNode node30 = new DefaultMutableTreeNode(new TreeItem("Каталоги","30","pict/favb22.png"));
		DefaultMutableTreeNode node40 = new DefaultMutableTreeNode(new TreeItem("Прайслист","40","pict/money22.png"));
		DefaultMutableTreeNode node50 = new DefaultMutableTreeNode(new TreeItem("Отчеты","50","pict/documents22.png"));
		root.add(node10);
		root.add(node20);
		root.add(node30);
		root.add(node40);
		root.add(node50);
		setLayout(new BorderLayout());
		JTree navtree = new JTree(new DefaultTreeModel(root));
		navtree.setShowsRootHandles(true);
		navtree.putClientProperty("JTree.lineStyle", "None");
		navtree.setRowHeight(24);
		navtree.setCellRenderer(new CustomIconTreeCellRenderer());
		navtree.addTreeSelectionListener(new TreeListener());
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
		}
	}
}


