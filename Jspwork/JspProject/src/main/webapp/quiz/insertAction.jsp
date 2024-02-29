<%@page import="quiz.model.quizDao"%>
<%@page import="quiz.model.quizDto"%>
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

	String name=request.getParameter("name");
	String age=request.getParameter("age");
	String hp=request.getParameter("hp");
	String driver=request.getParameter("driver");
	
	quizDto dto=new quizDto();
	dto.setName(name);
	dto.setAge(age);
	dto.setHp(hp);
	dto.setDriver(driver);
	
	quizDao dao=new quizDao();
	dao.insertInfo(dto);
	
	response.sendRedirect("list.jsp");
%>
</body>
</html>