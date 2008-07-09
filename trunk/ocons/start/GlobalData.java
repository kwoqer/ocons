package start;


import java.awt.*;
import javax.swing.*;

public class GlobalData{

  // версия
  private final String OCONS_VERSION = "0.01 alpha";
  private final String OCONS_APPNAME = "Oriflame Consultant";
  // путь приложения
  private String OCONS_APPPATH = "";
  private String OCONS_DBPATH = "";
  // разрешение монитора
  private int OCONS_MONITOR_WIDTH;
  private int OCONS_MONITOR_HEIGHT;
  // размеры главного окна
  private int OCONS_FRAME_WIDTH;
  private int OCONS_FRAME_HEIGHT;
  //координаты главного окна
  private int OCONS_FRAME_X;
  private int OCONS_FRAME_Y;
  //ссылка на главное окно
  private Frame OCONS_FRAME;

  private GlobalData() {
	  OCONS_MONITOR_WIDTH = 1024;
	  OCONS_MONITOR_HEIGHT = 768;
	  OCONS_FRAME_WIDTH = 0;
	  OCONS_FRAME_HEIGHT = 0;
	  OCONS_FRAME_X = 0;
	  OCONS_FRAME_Y = 0;
	  setAppPath();
  }
  private void setAppPath(){
	  OCONS_APPPATH = System.getProperty("user.dir");
	  OCONS_DBPATH = OCONS_APPPATH+"\\db";
  }
  
  public static String getVersion(){
      return GLOBSET.OCONS_VERSION;
  }
  
  public static String getAppName(){
	  return GLOBSET.OCONS_APPNAME;
  }
  
  public static String getAppPath(){
	  return GLOBSET.OCONS_APPPATH;
  } 

  public static String getDBPath(){
	  return GLOBSET.OCONS_DBPATH;
  }
  
  public static int getMonitorWidth(){
      return GLOBSET.OCONS_MONITOR_WIDTH;
  }

  public static int getMonitorHeight(){
      return GLOBSET.OCONS_MONITOR_HEIGHT;
  }

  public static void setMonitorDimension(int width, int height){
	  GLOBSET.OCONS_MONITOR_WIDTH = width;
	  GLOBSET.OCONS_MONITOR_HEIGHT = height;
  }

  public static void setFrameDimension(int width, int height){
	  GLOBSET.OCONS_FRAME_WIDTH = width;
	  GLOBSET.OCONS_FRAME_HEIGHT = height;
  }

  public static int getFrameWidth(){
      return GLOBSET.OCONS_FRAME_WIDTH;
  }

  public static int getFrameHeight(){
      return GLOBSET.OCONS_FRAME_HEIGHT;
  }

  public static int getFrameX(){
      return GLOBSET.OCONS_FRAME_X;
  }

  public static int getFrameY(){
      return GLOBSET.OCONS_FRAME_Y;
  }

  public static void setFrameLocation(int x, int y){
	  GLOBSET.OCONS_FRAME_X = x;
	  GLOBSET.OCONS_FRAME_Y = y;
  }

  public static void setFrame(Frame frame){
	  GLOBSET.OCONS_FRAME = frame;
  }

  public static Frame getFrame(){
      return GLOBSET.OCONS_FRAME;
  }
  
  public static GlobalData GLOBSET;
  static {
	  GLOBSET = new GlobalData();
  }

}