<%@page import="z_first.DAO.ResultDAO"%>
<%@page import="z_first.DTO.ResultDTO"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String no = request.getParameter("no");
	String code = request.getParameter("code");
	String sdate = request.getParameter("sdate");
	String status = request.getParameter("status");
	String ldate = request.getParameter("ldate");
	String result = request.getParameter("result");
	
	ResultDTO dto = new ResultDTO(no, code, sdate, status, ldate, result);
	ResultDAO dao = new ResultDAO();
	if(dao.insertResult(dto)){
		System.out.print("성공");
	}else {
		System.out.print("실패");
	}
	response.sendRedirect("resultForm.jsp");
%>