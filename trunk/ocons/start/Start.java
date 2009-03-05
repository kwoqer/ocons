package start;

import gui.*;
import java.awt.*;

import settings.Localizator;

public class Start {
	
		public static void main(String[] args) {
			// Подготовка системной БД 
			try
	        {
	         	Prepare.PrepareDB();
	        }
	        catch (Exception E)
	        {
	        	MyTools.MessageBox(E.getMessage());
	        	E.printStackTrace();
	        }
	        // Создание экземпляра GlobalData
	        Prepare.PrepareGD();
	        
	        // Запуск Localizator-а
	        try {
	        	new Localizator(GlobalData.getLanguage());
	        	
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
	        // Создание основного окна
	        MainFrame frame = new MainFrame();
	        
	        // TODO Читаем настройки	           
	        
	        GlobalData.setFrame(frame);
	        GlobalData.setAppPath();
	        GlobalData.setFrameDimension((int)(GlobalData.getMonitorWidth()/4)*3, 
	        		                     (int)(GlobalData.getMonitorHeight()/4)*3);	              	        
	        
	        Point p = MyTools.FramePosition(GlobalData.getFrameWidth(),GlobalData.getFrameHeight());
	        frame.setLocation(p.x,p.y);
	        frame.setSize(GlobalData.getFrameWidth(),GlobalData.getFrameHeight());
	        frame.setTitle("Oriflame Consultant");
	        frame.setVisible(true);
	    }
	
}
