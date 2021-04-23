<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="z_first.DTO.Lab_testDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="z_first.DAO.Lab_testDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과정평가형 자격 cbq_11</title>
<link rel="stylesheet" href="./css/resultForm.css">
<script type="text/javascript" src="./js/resultFormValidate.js" defer></script>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div id="main">
		<h2>검사결과 입력</h2>
		<form method="post" action="resultProc.jsp">
		<table>
			<tr>
				<th><label for="no">환자번호</label></th>
				<td>
					<input type="text" id="no" name="no" maxlength="4" required="required">
					<span>예)1001</span>
				</td>
			</tr>
			<tr>
				<th><label for="code">검사코드</label></th>
				<td>
					<select name="code" id="code">
					<option>검사명</option>
					<%
						Lab_testDAO lab_testDAO = new Lab_testDAO();
						ArrayList<Lab_testDTO> labList = lab_testDAO.selectLab();
						for(Lab_testDTO dto : labList){
					%>
						<option value="<%=dto.getCode()%>"><%=dto.getName() %></option>
					<%
						}
					%>
					</select>
				</td>
			</tr>
			<tr>
				<th><label for="sdate">검사시작일자</label></th>
				<td>
					<input type="text" id="sdate" name="sdate" maxlength="8" required="required">
					<span>예)20200101</span>
				</td>
			</tr>
			<tr>
				<th><label>검사상태</label></th>
				<td>
					<input type="radio" value="1" name="status" class="status"> 검사중
					<input type="radio" value="2" name="status" class="status"> 검사완료
				</td>
			</tr>
			<tr>
				<th><label for="ldate">검사완료일자</label></th>
				<td>
					<input type="text" id="ldate" name="ldate" maxlength="8" required="required">
					<span>예)20200101</span>
				</td>
			</tr>
			<tr>
				<th>검사결과</th>
				<td>
					<%-- P : 양성, X : 미입력, N : 음성 --%>
					<input type="radio" value="X" name="result" class="result"> 미입력
					<input type="radio" value="P" name="result" class="result"> 양성
					<input type="radio" value="N" name="result" class="result"> 음성
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input id="submit" type="submit" value="검사 결과 등록">
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
		</form>
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>