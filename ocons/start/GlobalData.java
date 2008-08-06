package start;


import java.awt.*;
import javax.swing.*;
import gui.*;

public class GlobalData{

  // версия
  private static final String OCONS_VERSION = "0.05 alpha";
  private static final String OCONS_APPNAME = "Oriflame Consultant";
  // путь приложения
  private static String OCONS_APPPATH = "";
  private static String OCONS_DBPATH = "";
  // разрешение монитора
  private static int OCONS_MONITOR_WIDTH = 1024;
  private static int OCONS_MONITOR_HEIGHT = 768;
  // размеры главного окна
  private static int OCONS_FRAME_WIDTH = 0;
  private static int OCONS_FRAME_HEIGHT = 0;
  //координаты главного окна
  private static int OCONS_FRAME_X = 0;
  private static int OCONS_FRAME_Y = 0;
  //ссылка на главное окно
  private static MainFrame OCONS_FRAME = null;
  private static MainMenu OCONS_MENU = null;
  
  private static int OCONS_LOGGED_CONSULTANT = -1;


  /*
 * Номер залогинившегося консультатнта. Если никто не залогинился возвращает -1 
 */
  public static int getConsultantNumber() {
	return OCONS_LOGGED_CONSULTANT;
  }

  public static void setConsultantNumber(int ocons_logged_consultant) {
	OCONS_LOGGED_CONSULTANT = ocons_logged_consultant;
  }

  public static void setAppPath(){
	  OCONS_APPPATH = System.getProperty("user.dir");
	  OCONS_DBPATH = OCONS_APPPATH+"\\db";
  }
  
  public static String getVersion(){
      return OCONS_VERSION;
  }
  
  public static String getAppName(){
	  return OCONS_APPNAME;
  }
  
  public static String getAppPath(){
	  return OCONS_APPPATH;
  } 

  public static String getDBPath(){
	  return OCONS_DBPATH;
  }
  
  public static int getMonitorWidth(){
      return OCONS_MONITOR_WIDTH;
  }

  public static int getMonitorHeight(){
      return OCONS_MONITOR_HEIGHT;
  }

  public static void setMonitorDimension(int width, int height){
	  OCONS_MONITOR_WIDTH = width;
	  OCONS_MONITOR_HEIGHT = height;
  }

  public static void setFrameDimension(int width, int height){
	  OCONS_FRAME_WIDTH = width;
	  OCONS_FRAME_HEIGHT = height;
  }

  public static int getFrameWidth(){
      return OCONS_FRAME_WIDTH;
  }

  public static int getFrameHeight(){
      return OCONS_FRAME_HEIGHT;
  }

  public static int getFrameX(){
      return OCONS_FRAME_X;
  }

  public static int getFrameY(){
      return OCONS_FRAME_Y;
  }

  public static void setFrameLocation(int x, int y){
	  OCONS_FRAME_X = x;
	  OCONS_FRAME_Y = y;
  }

  public static void setFrame(MainFrame frame){
	  OCONS_FRAME = frame;
  }

  public static MainFrame getFrame(){
      return OCONS_FRAME;
  }

  public static MainMenu getMenu() {
	return OCONS_MENU;
  }

  public static void setMenu(MainMenu ocons_menu) {
	OCONS_MENU = ocons_menu;
  }
  
  
}