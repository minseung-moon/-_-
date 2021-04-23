package z_first.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import z_first.DBConn.DBConn;
import z_first.DTO.PationtDTO;

public class PationtDAO {
	private DBConn dbConn = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = null;
	
	public PationtDAO() {
		dbConn = new DBConn();
		con = dbConn.conn;
	}
	// select city, count(*) from patient p inner join result r on p.no = r.no group by city; 
	
	public ArrayList<PationtDTO> pationtList() {
		ArrayList<PationtDTO> pationtList = new ArrayList<PationtDTO>();
		DateFormat beforeFormat = new SimpleDateFormat("yyyyMMdd");
	    DateFormat afterFormat = new SimpleDateFormat("yyyy��MM��dd��");
	    Date tempDate = null;
	    String date = null;
		try{
			sql = "select * from patient order by no asc";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PationtDTO dto = new PationtDTO();
				dto.setNo(rs.getString(1));
				dto.setName(rs.getString(2));
				try {
					tempDate = beforeFormat.parse(rs.getString(3));
					date = afterFormat.format(tempDate);
				} catch (ParseException e) {
					System.out.println("Date format���� ������ ������ϴ�!");
				}
				dto.setBirth(date);
				dto.setGender(rs.getString(4).equals("M")?"��":"��");
				dto.setTel(rs.getString(5)+"-"+rs.getString(6)+"-"+rs.getString(7));
				String city = null;
				if(rs.getString(8).equals("10")) city = "����";
				if(rs.getString(8).equals("20")) city = "���";
				if(rs.getString(8).equals("30")) city = "����";
				if(rs.getString(8).equals("40")) city = "�뱸";
				dto.setCity(city);
				pationtList.add(dto);
			}
		}catch(SQLException e){
			System.out.println("pationt�� ������ ���� ���� ���߽��ϴ�!");
		}finally{
			dbConn.close(rs);
			dbConn.close(pstmt);
			dbConn.close(con);
		}
		
		return pationtList;
	}
	
//	public static void main(String[] args) {
//		PationtDAO dao = new PationtDAO();
//		dao.pationtList();
//	}
}
