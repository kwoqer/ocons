package gui.infopanel;

public interface RunnableForm {
	
	// Возвращает имя запускаемой формы
	public String getName();
	
	// Запуск   
	public void run(boolean isEdit);

}
