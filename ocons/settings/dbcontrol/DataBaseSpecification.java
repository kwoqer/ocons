package settings.dbcontrol;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DataBaseSpecification {

	private String name;
	private String jdbctype;
	private String jdbc;
	private String path;
	private String ext;	
	private ArrayList<TableSpecification> tables;
	
	
	public DataBaseSpecification(String name,String jdbctype, String jdbc, String path, String ext) {		
		this.name = name;
		this.jdbctype = jdbctype;
		this.jdbc = jdbc;
		this.path = path;
		this.ext = ext;
		tables = new ArrayList<TableSpecification>();
	}
	
	public String getJDBCType(){
		return jdbctype;
	}
	
	public String getConnectString(){
		return jdbc+path+name+ext;
	}
	
	public void addTable(TableSpecification table){
		tables.add(table);
	}
	
	public boolean readFromXML(String xmlfile){
		Element table,tablename, fields, field;		
		try {
			File f = new File(xmlfile);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(f);
			Element root = document.getDocumentElement();
			name = root.getNodeValue();
			 // DBStructure			
			NodeList rootlist = root.getChildNodes();
			Element edatabase = (Element)rootlist.item(0); // database
			NodeList dblist = edatabase.getChildNodes();
			Element etables = (Element)dblist.item(1); // tables
			NodeList nodelist = etables.getChildNodes();
			// перебираем все элементы table
			NodeList nodelist2, nodelist3, nodelist4;		
			for (int i = 0; i < nodelist.getLength(); i++) {
				table = (Element)nodelist.item(i);
				nodelist2 = table.getChildNodes();
				tablename = (Element)nodelist2.item(0);
				String vtablename = tablename.getTextContent();				
				TableSpecification tablespec = new TableSpecification(vtablename);
				fields = (Element)nodelist2.item(1);
				nodelist3 = fields.getChildNodes();				
				for (int j = 0; j < nodelist3.getLength(); j++) {
					field = (Element)nodelist3.item(j);
					nodelist4 = field.getChildNodes();
					Element fieldelement;
					String fieldvalue, nodename;
					String fname = "";
					String ftype = "";
					String fsize = "";
					String fkeys = "";
					for (int k = 0; k < nodelist4.getLength(); k++) {
						fieldelement = (Element)nodelist4.item(k);
						nodename = fieldelement.getNodeName();
						fieldvalue = fieldelement.getTextContent();
						if (nodename=="fieldname") {
							fname = fieldvalue;
						} 						
						if (nodename=="fieldtype") {
							ftype = fieldvalue;
						} 
						if (nodename=="fieldsize") {
							fsize = fieldvalue;
						}									
						if (nodename=="fieldkey") {
							fkeys = fieldvalue;
						}
					}
					FieldSpecification fs = new FieldSpecification(fname,ftype,fsize,fkeys);
					tablespec.addField(fs);													
				}
				tables.add(tablespec);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
	}
	
	/**
	 * возвращает SQL команду, создающую базу данных 
	 */
	public String createSQLDatabase(){
		String sqlcommand = "";
		Iterator<TableSpecification> iterator = tables.iterator();
		while (iterator.hasNext()) {
			TableSpecification ts = iterator.next();
			sqlcommand = sqlcommand + ts.createSQLTable();
			if (iterator.hasNext()) {
				sqlcommand = sqlcommand + " ";
			}
		}
		return sqlcommand;
	}
		
}
