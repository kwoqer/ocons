package gui.infopanel;

import java.util.Map;

public interface RunnableForm {
	
	// ���������� ��� ����������� �����
	public String getName();
	
	// ������ ����� � ������� ������
	public void run();
	
	// ������ � ������������ ������  
	public void run(Object obj, Map<String,String> values);

}
