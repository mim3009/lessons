package lab2jdbc;

import java.sql.*;

public class Main {

	public static void main(String[] args) {
		Connection connection = null;
		String url = "jdbc:postgresql://localhost:5432/parichm";
		String user = "postgres", password = "roma251293";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("не найден драйвер");
			return;
		}
		try {
			connection = DriverManager.getConnection(url,user,password);
			System.out.println("conectionsucs");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection != null){
				try {
					connection.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

}
