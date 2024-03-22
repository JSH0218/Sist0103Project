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
	
		String email=request.getParameter("email1")+"@"+request.getParameter("email2");
		String pass=request.getParameter("pass1");
	%>
	<jsp:useBean id="dao" class="data.dao.MemberDao"/>
	<jsp:useBean id="dto" class="data.dto.MemberDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		dto.setEmail(email);
		dto.setPass(pass);
		dao.insertMember(dto);
		
		response.sendRedirect("../index.jsp?main=member/gaipsucess.jsp?id="+dto.getId());
	%>
</body>
</html>