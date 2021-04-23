package z_first.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import z_first.DBConn.DBConn;
import z_first.DTO.Lab_testDTO;

public class Lab_testDAO {
	private DBConn dbConn = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public Lab_testDAO() {
		dbConn = new DBConn();
		con = dbConn.conn;
	}
	
	public ArrayList<Lab_testDTO> selectLab(){
		ArrayList<Lab_testDTO> labList = new ArrayList<Lab_testDTO>();
		try{
			sql = "select * from lab_test";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Lab_testDTO dto = new Lab_testDTO(rs.getString(1), rs.getString(2));
				labList.add(dto);
			}
		}catch(SQLException e) {
			System.out.println("lab_test 결과를 못 갖고 왔습니다");
		}finally{
			dbConn.close(rs);
			dbConn.close(pstmt);
			dbConn.close(con);
		}
		return labList; 
	}
	
	public static void main(String[] args) {
		Lab_testDAO dao = new Lab_testDAO();
		ArrayList<Lab_testDTO> a = dao.selectLab();
		Lab_testDTO b = a.get(1);
		System.out.println(b.getCode());
	}
}
