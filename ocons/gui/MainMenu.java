package gui;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import start.*;

public class MainMenu extends JMenuBar{

   public MainMenu(){
	   // Управление
      JMenu beginMenu = new JMenu("Управление");
      Action DBConfigAction = new DBConfigAction("Настройки");
      DBConfigAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\configure22.png"));
      Action dbAction = new ConfigAction("Действующий прайс");
      dbAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\textfile22.png"));
      Action loginAction = new ConfigAction("Прайс текущего каталога");
      loginAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\documents22.png"));
      //Action logoutAction = new ConfigAction("Другой пользователь");
      //logoutAction.putValue(Action.SMALL_ICON,
      //   new ImageIcon("z:\\usr\\jk\\src\\jk\\gui\\logout.gif"));
      beginMenu.add(DBConfigAction);
      beginMenu.add(dbAction);
      beginMenu.add(loginAction);
      //beginMenu.add(logoutAction);
      Action aboutAction = new AboutAction("О программе");
      beginMenu.addSeparator();
      beginMenu.add(aboutAction);
      beginMenu.add(new ExitAction("Выход"));
      add(beginMenu);
      
      //Консультант
      JMenu workMenu = new JMenu("Консультант");
      Action AddConsAction = new AddConsultantAction("Новый консультант");
      AddConsAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\adduser22.png"));
      Action ConsAction = new ConfigAction("Вход");
      ConsAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\user22.png"));
      Action OtherAction = new ConfigAction("Другой консультант");
      OtherAction.putValue(Action.SMALL_ICON,
         new ImageIcon("pict\\users22.png"));
      OtherAction.setEnabled(false);
      workMenu.add(ConsAction);
      workMenu.add(AddConsAction);
      workMenu.add(OtherAction);
      add(workMenu);
      
      //Клиенты
      JMenu clientMenu = new JMenu("Клиенты");
      		clientMenu.setEnabled(false);
      add(clientMenu);
      
      //Заказы
      JMenu orderMenu = new JMenu("Заказы");
      		orderMenu.setEnabled(false);
      add(orderMenu);
      
      //Результаты
      JMenu resultMenu = new JMenu("Результаты");
      		resultMenu.setEnabled(false);
      add(resultMenu);
      
   }
}

class ConfigAction extends AbstractAction
{
   public ConfigAction(String name) { super(name); }

   public void actionPerformed(ActionEvent event)
   {
      System.out.println(getValue(Action.NAME)
         + " selected.");
   }
}

class AddConsultantAction extends AbstractAction{
	public AddConsultantAction(String name) {
		super(name);
	}
	public void actionPerformed(ActionEvent e) {
		AddConsultantDialog ACDialog = new AddConsultantDialog(GlobalData.getFrame());
		ACDialog.setVisible(true);
	}
}

class ExitAction extends AbstractAction{

   public ExitAction(String name) { super(name); }

   public void actionPerformed(ActionEvent event)
   {
      System.exit(0);
   }

}

class AboutAction extends AbstractAction{

   public AboutAction(String name) { super(name); }

   public void actionPerformed(ActionEvent event)
   {
     String mess = GlobalData.getAppName()+ " v."+GlobalData.getVersion();
     JOptionPane.showMessageDialog(null,mess,"О программе",
    		 JOptionPane.INFORMATION_MESSAGE);
   }
}

class DBConfigAction extends AbstractAction
{
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