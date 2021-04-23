package z_first.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import z_first.DBConn.DBConn;
import z_first.DTO.CityDTO;

public class CityDAO {
	
	private DBConn dbConn = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public CityDAO() {
		dbConn = new DBConn();
		con = dbConn.conn;
	}
	
	public ArrayList<CityDTO> selectCity() {
		// select city, count(*) from patient p inner join result r on p.no = r.no group by city order by city asc;
		ArrayList<CityDTO> cityList = new ArrayList<CityDTO>();
		
		try {
			sql = "select city, count(*) from patient p inner join result r on p.no = r.no group by city order by city asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			String city = null;
			while(rs.next()) {
				CityDTO dto = new CityDTO();
				dto.setCityCode(rs.getString(1));
				if(rs.getString(1).equals("10")) city = "서울";
				else if(rs.getString(1).equals("20")) city = "경기";
				else if(rs.getString(1).equals("30")) city = "강원";
				else if(rs.getString(1).equals("40")) city = "대구";
				dto.setCityName(city);
				dto.setCityCase(rs.getString(2));
				cityList.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("city 정보를 못 갖고 왔습니다.");
		} finally {
			dbConn.close(rs);
			dbConn.close(pstmt);
			dbConn.close(con);
		}
		
		return cityList;
	}
}
