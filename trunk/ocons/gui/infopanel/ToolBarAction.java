package gui.infopanel;

import java.awt.event.ActionEvent;
import javax.swing.*;
import start.*;


public class ToolBarAction extends AbstractAction {
	
	private String name;
	private Icon icon;
	private String prompt;
	// объект, осуществляющий запуск функционала
	private RunnableForm executor;
	private TableView parent;
	
	// Упрощенный конструктор - иконка и подсказка устанавливается исходя из имени
	public ToolBarAction(String name, RunnableForm executor, TableView parent){
		
		String icon = "";
		String prompt = "";
		// Подставляем иконку
		if (name=="Add"){
			icon = "pict/add22.png";
			prompt = Localizator.IP_AddAction;
		}
		if (name=="Delete"){
			icon = "pict/delete22.png";
			prompt = Localizator.IP_DeleteAction;
		}
		if (name=="Edit"){
			icon = "pict/edit22.png";
			prompt = Localizator.IP_EditAction;
		}
		if (name=="Find"){
			icon = "pict/find22.png";
			prompt = Localizator.IP_FindAction;
		}
		if (name=="Print"){
			icon = "pict/printer32.png";
			prompt = Localizator.IP_PrintAction;
		}
		if (name=="Preview"){
			icon = "pict/printerpreview32.png";
			prompt = Localizator.IP_PreviewAction;
		}
		// Подставляем подсказку
		if (executor.getName()=="Clients"){
			prompt = prompt+" "+Localizator.IP_Clients;
		}
		if (executor.getName()=="Catalogs"){
			prompt = prompt+" "+Localizator.IP_Catalogs;
		}
		if (executor.getName()=="Orders"){
			prompt = prompt+" "+Localizator.IP_Orders;
		}
		if (executor.getName()=="Invoices"){
			prompt = prompt+" "+Localizator.IP_Invoices;
		}
		if (executor.getName()=="Prices"){
			prompt = prompt+" "+Localizator.IP_Prices;
		}
		//this(name, icon, prompt, executor);
		this.name = name;
		this.prompt = prompt;
		this.icon = MyTools.getImageResource(icon);
		this.executor = executor;
		this.putValue(Action.NAME, this.name);
		this.putValue(Action.SMALL_ICON, this.icon);
		this.putValue(Action.SHORT_DESCRIPTION, this.prompt);
		this.parent = parent;
	}
	
	// Полный конструктор
	public ToolBarAction(String name, String icon, String prompt,RunnableForm executor, TableView parent){
		this.name = name;
		this.prompt = prompt;
		this.icon = MyTools.getImageResource(icon);
		this.executor = executor;
		this.putValue(Action.NAME, this.name);
		this.putValue(Action.SMALL_ICON, this.icon);
		this.putValue(Action.SHORT_DESCRIPTION, this.prompt);
		this.parent = parent;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (name=="Add")
				executor.run(false);
		else if	(name=="Edit")
				executor.run(true);
		else if (name=="Delete"){
				int answer = MyTools.AlertBox(Localizator.IP_DeleteAction+"?",Localizator.G_AYouSure+" "+prompt.toLowerCase()+"?");
				if (answer==JOptionPane.YES_OPTION){
					//  номер строки в таблице
					int row = parent.getTable().getSelectedRow();
					//  ID клиента
					int id = parent.getTableModel().getID(row);
					// удаляем из БД 
					((ClientForm)parent.getExecutor()).getClient().deleteFromDB(id);
					// и из таблицы
					parent.getTableModel().deleteRow(row);
					parent.refresh();
				} 					
		}
	}

	public String getName(){
		return name;
	}
}
