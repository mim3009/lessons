package lab;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {

	public static Connection getConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/database","pg","roma251293");
		return conn;
	}
	
}
