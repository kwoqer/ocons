package data;

/**
 *  ������� ��� ������� ���� combobox-��, listbox-�� � �.�.
 *  ���� ������ ��������� ��������, ������ ������� ������������� ����
 *  ������ vitems �������� �������� �������� ������������ ���������
 *  ������: �������� "�����", "�������", "�������", "������", "�����"
 *  		����� ����������� �������� -
 *  		������ setVItems(new int[] {1,3,2}) 
 * */
public class Vocabulary {
	
	// ����������� ������ �������
	private int capacity;
	private String[] items;
	
	// ������ ��� ��������, ������� ����� ������������ � �����
	private int[] vitems;
	// ��������� �� ��������
	private int pointer;
	
	public Vocabulary(String[] words){
		items = words;
		capacity = items.length;
		// �� ��������� ���������� ��� ��������, ������� ����
		int[] tmp = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			tmp[i]=i;
		}
		vitems = tmp;
	}
	
	public void setVItems(int[] vi){
		vitems = vi;
	}
	
	public String getValue(int i){
		return items[vitems[i]];
	}
	
	/** ���������� ������ �������� 
	 *  �� �������� ������� � �����
	 * 	 
	 */
	public int getIndex(int i){				
		return vitems[i];
	}
	
	/** ���������� ������ � �����
	 *  �� ������� ��������
	 * 	 
	 */
	public int getBoxIndex(int i){
		for (int j = 0; j < vitems.length; j++) {
			if (vitems[j]==i) 
				return j;
		}
		return -1;
	}
	
	/** ���������� ������ �������� �� ��������
	 * 
	 */  
	public int getIndexByString(String word){		
		for (int i = 0; i < items.length; i++) {
			if (items[i]==word) {
				return i;							
			}
		}
		return -1;
	}
	
	public String[] getItems(){
		return items;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	/* first() & next() - ����� ������� ��� ���������� ����� ����� addItem()
	 ������ - 
	 	Client.getStatusVoc().first();
		String item = Client.getStatusVoc().next();
		while (item != null){
			comboboxStatus.addItem(item);
			item = Client.getStatusVoc().next();
		}
	*/
	
	/** ��������� ��������� �� ������ ������������ �������	  
	 */ 
	public void first(){
		pointer = 0;
	}
	
	/**
	* ���� ��������� ������� ���������� - ���������� ���, ���� ��� ���������� null
	*/
	public String next(){
		if (pointer < vitems.length) {			
			return items[vitems[pointer++]];
		}
		else 
			return null;
	}
	
}
