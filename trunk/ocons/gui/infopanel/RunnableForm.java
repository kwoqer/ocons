package gui.infopanel;

import java.util.Map;

public interface RunnableForm {
	
	// Возвращает имя запускаемой формы
	public String getName();
	
	// Запуск формы с пустыми полями
	public void run();
	
	// Запуск с заполненными полями  
	public void run(Object obj, Map<String,String> values);

}
