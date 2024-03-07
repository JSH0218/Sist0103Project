<%@page import="team.model.TeamDao"%>
<%@page import="team.model.TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		
		TeamDto dto=new TeamDto();
		dto.setNum(request.getParameter("num"));
		dto.setName(request.getParameter("name"));
		dto.setDriver(request.getParameter("driver")==null?"없음":"있음");
		dto.setAddr(request.getParameter("addr"));
		
		TeamDao dao=new TeamDao();
		dao.updateTeam(dto);
		
		response.sendRedirect("teamList.jsp");
	%>
</body>
</html>