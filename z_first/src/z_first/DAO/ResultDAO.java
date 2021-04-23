package z_first.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import z_first.DBConn.DBConn;
import z_first.DTO.ResultDTO;
import z_first.DTO.ResultShowDTO;

public class ResultDAO {
	private DBConn dbConn = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public ResultDAO() {
		dbConn = new DBConn();
		con = dbConn.conn;
	}
	
	public boolean insertResult(ResultDTO dto) {
		boolean check = false;
		
		try {
			sql = "insert into result values(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getNo());
			pstmt.setString(2, dto.getCode());
			pstmt.setString(3, dto.getSdate());
			pstmt.setString(4, dto.getStatus());
			pstmt.setString(5, dto.getLdate());
			pstmt.setString(6, dto.getResult());
			check = pstmt.executeUpdate()==1?true:false;
		}catch (SQLException e){
			System.out.println("result에 입력하지 못했습니다.");
		} finally {
			dbConn.close(rs);
			dbConn.close(pstmt);
			dbConn.close(con);
		}
		return check;
	}
	
	public ArrayList<ResultShowDTO> selectResult() {
		ArrayList<ResultShowDTO> resultList = new ArrayList<ResultShowDTO>();
		DateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat afterFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = null, ldate = null;
		String sDate = null, lDate = null;
		try {
			// select p.no, p.name, l.name, r.sdate, r.status, r.ldate, r.result from patient p inner join result r on p.no = r.no inner join lab_test l on r.code = l.code
			sql = "select p.no, p.name, l.name, r.sdate, r.status, r.ldate, r.result from patient p inner join result r on p.no = r.no inner join lab_test l on r.code = l.code order by p.no asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ResultShowDTO dto = new ResultShowDTO();
				dto.setPationtNo(rs.getString(1));
				dto.setPationtName(rs.getString(2));
				dto.setLabName(rs.getString(3));
				try{
					sdate = beforeFormat.parse(rs.getString(4));
					ldate = beforeFormat.parse(rs.getString(6));
					sDate = afterFormat.format(sdate);
					lDate = afterFormat.format(ldate);
				}catch(Exception e){
					System.out.println("date 설정에 문제가 생겼습니다.");
				}
				dto.setSdate(sDate); // sdate
				dto.setStatus(rs.getString(5).equals("1")?"검사중":"검사완료"); // status
				dto.setLdate(lDate); // ldate
				// P : 양성, X : 미입력, N : 음성
				dto.setResult(rs.getString(7).equals("P")?"양성":rs.getString(7).equals("X")?"미입력":"음성"); // result
				resultList.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("resultShow의 결과값을 갖고 오지 못했습니다!");
		}finally {
			dbConn.close(rs);
			dbConn.close(pstmt);
			dbConn.close(con);
		}
		return resultList;
	}
	
//	public static void main(String[] args) {
//		ResultDAO dao = new ResultDAO();
//		ArrayList<ResultShowDTO> dtos = dao.selectResult();
//		ResultShowDTO dto = dtos.get(0);
//	}
}
