package start;

import java.sql.*;

public class Prepare {
	public static void PrepareDB() throws Exception {
		Class.forName("org.sqlite.JDBC");
		String DB_fp = GlobalData.getDBPath()+"\test.db";
	    Connection conn = DriverManager.getConnection("jdbc:sqlite:"+DB_fp);
	    Statement stat = conn.createStatement();
	    stat.executeUpdate("drop table if exists people;");
	    stat.executeUpdate("create table people (name, occupation);");
	    PreparedStatement prep = conn.prepareStatement(
        "insert into people values (?, ?);");

	    prep.setString(1, "Gandhi");
	    prep.setString(2, "politics");
	    prep.addBatch();
	    prep.setString(1, "Turing");
	    prep.setString(2, "computers");
	    prep.addBatch();
	    prep.setString(1, "Wittgenstein");
	    prep.setString(2, "smartypants");
	    prep.addBatch();

	    conn.setAutoCommit(false);
	    prep.executeBatch();
	    conn.setAutoCommit(true);

	    ResultSet rs = stat.executeQuery("select * from people;");
	    while (rs.next()) {
	    	System.out.println("name = " + rs.getString("name"));
	    	System.out.println("job = " + rs.getString("occupation"));
    }
    rs.close();
    conn.close();
	}
}
