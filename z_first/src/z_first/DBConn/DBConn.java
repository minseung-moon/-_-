package z_first.DBConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {
	private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String password = "1234";
	public Connection conn = null;
	
	public DBConn() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("DB������...");
			conn = DriverManager.getConnection(dbURL,id,password);
			System.out.println("�����ͺ��̽� ���� ����");
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC ����̹��� ã�� �� ����");
		}catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���ῡ ����");
		}
	}
	
	public void close(ResultSet rs) {
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){
			System.out.println("rs.close�� ������ ������ϴ�");
		}
	}
	public void close(PreparedStatement pstmt) {
		try{
			if(pstmt != null)
				pstmt.close();
		}catch(SQLException e){
			System.out.println("pstmt.close�� ������ ������ϴ�");
		}
	}
	public void close(Connection conn) {
		try{
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			System.out.println("connection.close�� ������ ������ϴ�");
		}
	}
	
//	public static void main(String[] args) {
//		new DBConn();
//	}
}
