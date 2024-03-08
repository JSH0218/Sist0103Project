<%@page import="simpleguest.model.GuestDto"%>
<%@page import="simpleguest.model.GuestDao"%>
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
		
		/* String nickname=request.getParameter("nickname");
		String pass=request.getParameter("pass");
		String image=request.getParameter("image");
		String content=request.getParameter("content");
		
		GuestDto dto=new GuestDto();
		dto.setNickname(nickname);
		dto.setPass(pass);
		dto.setImage(image);
		dto.setContent(content);
		
		GuestDao dao=new GuestDao();
		dao.insertGuest(dto);
		
		response.sendRedirect("insertForm.jsp"); */
	
	%>
	
	<jsp:useBean id="dao" class="simpleguest.model.GuestDao"/>
	<jsp:useBean id="dto" class="simpleguest.model.GuestDto"/>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		dao.insertGuest(dto);
		response.sendRedirect("guestList.jsp");
	%>
</body>
</html>