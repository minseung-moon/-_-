<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="z_first.DTO.PationtDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="z_first.DAO.PationtDAO" %>
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
		<h2>환자 조회</h2>
		<table>
			<thead>
				<tr>
					<th>환자번호</th>
					<th>환자성명</th>
					<th>생년월일</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>지역</th>
				</tr>
			</thead>
			<tbody>
			<%
				
				PationtDAO pationtDAO = new PationtDAO();
				ArrayList<PationtDTO> pationtList = pationtDAO.pationtList();
				for(PationtDTO dto : pationtList){
			%>
				<tr>
					<td><%=dto.getNo() %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getBirth() %></td>
					<td><%=dto.getGender() %></td>
					<td><%=dto.getTel() %></td>
					<td><%=dto.getCity() %></td>
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