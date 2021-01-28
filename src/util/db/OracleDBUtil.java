package util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class OracleDBUtil {

	public static Connection conn = null;
	
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "travle_product";
	public static final String PW = "1234";
	
	public static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
	
	// ����� null�� �ƴ� conn�� ������ ������ �ٷ� ����ϰ� �ƴϸ� �ű� conn�� �����Ͽ� �����ϴ� �Լ�
	public static Connection getConn() {
		if( conn != null ) return conn;
		else {
			boolean c = connectDB();
			return c ? conn : null;
		}
	}
	
	public static boolean connectDB() {
		try {
			Class.forName(DB_DRIVER);
			
			conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println("DB ���� ����! - " + new Date());
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("DB ����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ��� Ȥ�� ���� �� SQL ����");
			e.printStackTrace();
		}
		return false;
	}
	
	public static void closeDB() {
		if(conn != null) {
			try {
				conn.close();
				System.out.println("DB ���� ����.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("��� ����!");
		}
	}
	
	public static void main(String[] args) {
		connectDB();
		closeDB();
	}

}
