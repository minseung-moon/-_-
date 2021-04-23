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
			System.out.println("DB연결중...");
			conn = DriverManager.getConnection(dbURL,id,password);
			System.out.println("데이터베이스 연결 성공");
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾을 수 없다");
		}catch (SQLException e) {
			System.out.println("데이터베이스 연결에 실패");
		}
	}
	
	public void close(ResultSet rs) {
		try{
			if(rs != null)
				rs.close();
		}catch(SQLException e){
			System.out.println("rs.close에 문제가 생겼습니다");
		}
	}
	public void close(PreparedStatement pstmt) {
		try{
			if(pstmt != null)
				pstmt.close();
		}catch(SQLException e){
			System.out.println("pstmt.close에 문제가 생겼습니다");
		}
	}
	public void close(Connection conn) {
		try{
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			System.out.println("connection.close에 문제가 생겼습니다");
		}
	}
	
//	public static void main(String[] args) {
//		new DBConn();
//	}
}
