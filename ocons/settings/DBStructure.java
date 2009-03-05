package settings;

import java.io.File;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DBStructure {
	
	// имя xml-файла с спецификацией БД
	private String xmlfile;
	// имя файла БД
	private String dbfile;
	
	private Document document;
	private String name;
	
	
	
	public DBStructure(String xmlname, String dbname){
		xmlfile = xmlname;
		dbfile = dbname;
		try {
			File f = new File(xmlfile);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();			
			factory.setValidating(true);
			factory.setIgnoringElementContentWhitespace(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			document = builder.parse(f);
			Element root = document.getDocumentElement();
			name = root.getNodeValue();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public String getName(){
		return name;
	}
	
	public String XMLToSQL(){
		String sqlcommand, result = "";
		Element table,tablename, fields, field, fieldname, fieldtype;
		String vtablename, vfieldname, vfieldtype;		
		try {						
			Element root = document.getDocumentElement(); // DBStructure			
			NodeList rootlist = root.getChildNodes();
			Element database = (Element)rootlist.item(0); // database
			NodeList dblist = database.getChildNodes();
			// databasename - пока не нужен
			Element tables = (Element)dblist.item(1); // tables
			NodeList nodelist = tables.getChildNodes();
			// перебираем все элементы table
			NodeList nodelist2, nodelist3, nodelist4;		
			for (int i = 0; i < nodelist.getLength(); i++) {
				table = (Element)nodelist.item(i);
				nodelist2 = table.getChildNodes();
				tablename = (Element)nodelist2.item(0);
				vtablename = tablename.getTextContent();
				sqlcommand = "CREATE TABLE "+vtablename+" (";
				fields = (Element)nodelist2.item(1);
				nodelist3 = fields.getChildNodes();				
				for (int j = 0; j < nodelist3.getLength(); j++) {
					field = (Element)nodelist3.item(j);
					nodelist4 = field.getChildNodes();
					fieldname = (Element)nodelist4.item(0);
					vfieldname = fieldname.getTextContent();
					fieldtype = (Element)nodelist4.item(1);
					vfieldtype = fieldtype.getTextContent();
					sqlcommand = sqlcommand + vfieldname+" "+vfieldtype;
					if (j != nodelist3.getLength()-1) {
						sqlcommand = sqlcommand+",";
					}
					else {
						sqlcommand = sqlcommand+");";
					}
				}
				result = result + sqlcommand;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void generateStructure(){
		DatabaseMetaData dmd = conn.getMetaData();
		ResultSet rs = dmd.getTables(conn.getCatalog(), "%", "%", new String[] {"TABLE"});
		String r; 
		while (rs.next()){
			r=rs.getString("TABLE_NAME");
			System.out.print(r+" - ");
			r=rs.getString("TABLE_TYPE");
			System.out.print(r+" - ");
			r=rs.getString("TABLE_SCHEM");
			System.out.print(r+'\n');
		}	
	}
		
}
