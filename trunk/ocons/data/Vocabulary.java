package data;

/**
 *  —ловарь дл€ разного рода combobox-ов, listbox-ов и т.п.
 *  ≈сть массив строковых значений, индекс которых соответствует коду
 *  массив vitems содержит значени€ индексов отображаемых элементов
 *  ѕример: значени€ "синий", "красный", "зеленый", "желтый", "белый"
 *  		’отим реализовать светофор -
 *  		«адаем setVItems(new int[] {1,3,2}) 
 * */
public class Vocabulary {
	
	// фактический размер словар€
	private int capacity;
	private String[] items;
	
	// список тех значений, которые будут отображатьс€ в боксе
	private int[] vitems;
	// указатель на значение
	private int pointer;
	
	public Vocabulary(String[] words){
		items = words;
		capacity = items.length;
		// по умолчанию отображаем все элементы, которые есть
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
	
	/** ¬озвращает индекс элемента 
	 *  по значению индекса в боксе
	 * 	 
	 */
	public int getIndex(int i){				
		return vitems[i];
	}
	
	/** ¬озвращает индекс в боксе
	 *  по индексу элемента
	 * 	 
	 */
	public int getBoxIndex(int i){
		for (int j = 0; j < vitems.length; j++) {
			if (vitems[j]==i) 
				return j;
		}
		return -1;
	}
	
	/** ¬озвращает индекс элемента по значению
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
	
	/* first() & next() - набор методов дл€ заполнени€ бокса через addItem()
	 ѕример - 
	 	Client.getStatusVoc().first();
		String item = Client.getStatusVoc().next();
		while (item != null){
			comboboxStatus.addItem(item);
			item = Client.getStatusVoc().next();
		}
	*/
	
	/** установка указател€ на первый отображаемый элемент	  
	 */ 
	public void first(){
		pointer = 0;
	}
	
	/**
	* ≈сли следующий элемент существует - возвращаем его, если нет возвращаем null
	*/
	public String next(){
		if (pointer < vitems.length) {			
			return items[vitems[pointer++]];
		}
		else 
			return null;
	}
	
}
