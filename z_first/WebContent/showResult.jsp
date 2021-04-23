<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="z_first.DTO.ResultShowDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="z_first.DAO.ResultDAO"%>
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
		<h2>검사결과조회</h2>
		<table>
			<thead>
				<tr>
					<th>환자번호</th>
					<th>환자명</th>
					<th>검사명</th>
					<th>검사시작일</th>
					<th>검사상태</th>
					<th>검사완료일</th>
					<th>검사결과</th>
				</tr>
			</thead>
			<tbody>
				<%
					ResultDAO dao = new ResultDAO();
					ArrayList<ResultShowDTO> dtos = dao.selectResult();
					for(ResultShowDTO dto : dtos) {
				%>
					<tr>
						<td><%=dto.getPationtNo() %></td>
						<td><%=dto.getPationtName() %></td>
						<td><%=dto.getLabName() %></td>
						<td><%=dto.getSdate() %></td>
						<td><%=dto.getStatus() %></td>
						<td><%=dto.getLdate() %></td>
						<td><%=dto.getResult() %></td>
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