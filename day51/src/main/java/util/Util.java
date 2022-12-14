package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Util {

	static final String DriverName="oracle.jdbc.driver.OracleDriver";
	static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	static final String user="lim";
	static final String password="1234";
	
	public static Connection connect() {
		Connection conn = null;
		try {
			Class.forName(DriverName);
			
			conn =DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void disconnect(PreparedStatement pstmt, Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}