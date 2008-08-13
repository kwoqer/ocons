package gui;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import start.*;

public class MainMenu extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	private JMenu beginMenu;
	private JMenu consultantMenu;
	private Action addConsultantAction;
	private Action loginAction;
	private Action otherConsultantAction;
	
	public MainMenu(){
	   // ����������
      beginMenu = new JMenu("����������");
      Action DBConfigAction = new DBConfigAction("���������");
      DBConfigAction.putValue(Action.SMALL_ICON,
         MyTools.getImageResource("pict/configure22.png"));
      Action dbAction = new ConfigAction("����������� �����");
      dbAction.putValue(Action.SMALL_ICON,
    	 MyTools.getImageResource("pict/money22.png"));
      Action ginAction = new ConfigAction("����� �������� ��������");
      ginAction.putValue(Action.SMALL_ICON,
    	 MyTools.getImageResource("pict/favbadd22.png"));
      //Action logoutAction = new ConfigAction("������ ������������");
      //logoutAction.putValue(Action.SMALL_ICON,
      //   new ImageIcon("z:\\usr\\jk\\src\\jk\\gui\\logout.gif"));
      beginMenu.add(DBConfigAction);
      beginMenu.add(dbAction);
      beginMenu.add(ginAction);
      //beginMenu.add(logoutAction);
      Action aboutAction = new AboutAction("� ���������");
      beginMenu.addSeparator();
      beginMenu.add(aboutAction);
      beginMenu.add(new ExitAction("�����"));
      add(beginMenu);
      
      //�����������
      consultantMenu = new JMenu("�����������");
      addConsultantAction = new AddConsultantAction("����� �����������");
      addConsultantAction.putValue(Action.SMALL_ICON,
    		  MyTools.getImageResource("pict/adduser22.png"));
      loginAction = new LoginAction("����");
      loginAction.putValue(Action.SMALL_ICON,
    		  MyTools.getImageResource("pict/user22.png"));
      otherConsultantAction = new OtherAction("������ �����������");
      otherConsultantAction.putValue(Action.SMALL_ICON,
    		  MyTools.getImageResource("pict/users22.png"));
      consultantMenu.add(loginAction);
      consultantMenu.add(addConsultantAction);
      consultantMenu.add(otherConsultantAction);
      add(consultantMenu);
      
      //�������
      JMenu clientMenu = new JMenu("�������");
      		clientMenu.setEnabled(false);
      add(clientMenu);
      
      //������
      JMenu orderMenu = new JMenu("������");
      		orderMenu.setEnabled(false);
      add(orderMenu);
      
      //����������
      JMenu resultMenu = new JMenu("����������");
      		resultMenu.setEnabled(false);
      add(resultMenu);
      
   }
   
   public void BeforeLoginConsultantSettings(){
	   loginAction.setEnabled(true);
	   addConsultantAction.setEnabled(true);
	   otherConsultantAction.setEnabled(false);
   }
   
   public void AfterLoginConsultantSettings(){
	   loginAction.setEnabled(false);
	   addConsultantAction.setEnabled(false);
	   otherConsultantAction.setEnabled(true);
   }
}

class ConfigAction extends AbstractAction
{
   
	private static final long serialVersionUID = 1L;

	public ConfigAction(String name) { super(name); }

	public void actionPerformed(ActionEvent event)
	{
      System.out.println(getValue(Action.NAME)
         + " selected.");
	}
}

class AddConsultantAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	public AddConsultantAction(String name) {
		super(name);
	}
	public void actionPerformed(ActionEvent e) {
		AddConsultantDialog ACDialog = new AddConsultantDialog(GlobalData.getFrame());
		ACDialog.setVisible(true);
	}
}

class LoginAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	public LoginAction(String name) {
		super(name);
	}
	public void actionPerformed(ActionEvent e) {
		LoginDialog LDialog = new LoginDialog(GlobalData.getFrame());
		LDialog.setVisible(true);
	}
}

class OtherAction extends AbstractAction{
	private static final long serialVersionUID = 1L;
	public OtherAction(String name) {
		super(name);
	}
	
	public void actionPerformed(ActionEvent e) {
		int a = MyTools.ConfirmBox("��������!", "�� ������������� ������ ����� ������ �������������?"); 
		if (a==0){
			GlobalData.setConsultantNumber(-1);
			GlobalData.getMenu().BeforeLoginConsultantSettings();
			MyTools.setStatusBarConsultant("");
			GlobalData.setConsultantNumber(-1);			
			GlobalData.getFrame().closeWorkArea();
			LoginDialog LDialog = new LoginDialog(GlobalData.getFrame(),1);
			LDialog.setVisible(true);
		}
	}
}

class ExitAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

	public ExitAction(String name) { super(name); }

	public void actionPerformed(ActionEvent event)
	{
      System.exit(0);
	}

}

class AboutAction extends AbstractAction{

	private static final long serialVersionUID = 1L;

public AboutAction(String name) { super(name); }

   public void actionPerformed(ActionEvent event)
   {
     String mess = GlobalData.getAppName()+ " v."+GlobalData.getVersion();
     JOptionPane.showMessageDialog(null,mess,"� ���������",
    		 JOptionPane.INFORMATION_MESSAGE);
   }
}

class DBConfigAction extends AbstractAction
{
	private static final long serialVersionUID = 1L;

public DBConfigAction(String name) { super(name); }

   public void actionPerformed(ActionEvent event)
   {
      //DBConfigDialog DBConfig = new DBConfigDialog(GlobalData.getFrame(),true);
	   String mess = "App Path = "+GlobalData.getAppPath()+'\n'+
	   				 "DB Path = "+GlobalData.getDBPath();
	   JOptionPane.showMessageDialog(null,mess,"App Paths",
	   JOptionPane.INFORMATION_MESSAGE);
   }
}