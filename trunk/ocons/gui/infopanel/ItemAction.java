package gui.infopanel;

import java.awt.event.ActionEvent;
import javax.swing.*;
import start.*;


public class ItemAction extends AbstractAction {
	
	private String name;
	private Icon icon;
	private String prompt;
	// объект, осуществляющий запуск функционала
	private RunnableForm executor;
	
	// Упрощенный конструктор - иконка и подсказка устанавливается исходя из имени
	public ItemAction(String name, RunnableForm executor){
		
		String icon = "";
		String prompt = "";
		// Подставляем иконку
		if (name=="Add"){
			icon = "pict/add32.png";
			prompt = Localizator.IP_AddAction;
		}
		if (name=="Delete"){
			icon = "pict/delete32.png";
			prompt = Localizator.IP_DeleteAction;
		}
		if (name=="Edit"){
			icon = "pict/edit32.png";
			prompt = Localizator.IP_EditAction;
		}
		if (name=="Find"){
			icon = "pict/find32.png";
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
	}
	
	// Полный конструктор
	public ItemAction(String name, String icon, String prompt,RunnableForm executor){
		this.name = name;
		this.prompt = prompt;
		this.icon = MyTools.getImageResource(icon);
		this.executor = executor;
		this.putValue(Action.NAME, this.name);
		this.putValue(Action.SMALL_ICON, this.icon);
		this.putValue(Action.SHORT_DESCRIPTION, this.prompt);		
	}
	
	public void actionPerformed(ActionEvent e) {

	}

}
