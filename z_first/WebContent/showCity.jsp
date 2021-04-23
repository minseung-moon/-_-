<%@page import="z_first.DTO.CityDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="z_first.DAO.CityDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정평가형 자격 cbq_11</title>
<link rel="stylesheet" href="./css/showPationt.css">
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div id="main">
		<h2>(지역별)검사건수 통계</h2>
		<table>
			<thead>
				<tr>
					<th>지역코드</th>
					<th>지역명</th>
					<th>검사건수</th>
				</tr>
			</thead>
			<tbody>
				<%
					CityDAO cityDAO = new CityDAO();
					ArrayList<CityDTO> dtos = cityDAO.selectCity();
					for(CityDTO dto : dtos){
				%>
					<tr>
						<td><%=dto.getCityCode() %></td>
						<td><%=dto.getCityName() %></td>
						<td><%=dto.getCityCase() %></td>
					</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>