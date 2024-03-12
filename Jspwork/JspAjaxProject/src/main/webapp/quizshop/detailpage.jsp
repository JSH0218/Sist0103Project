<%@page import="quizshop.model.QuizShopDto"%>
<%@page import="quizshop.model.QuizShopDao"%>
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
<%
	request.setCharacterEncoding("utf-8");

	String num=request.getParameter("num");
	
	QuizShopDao dao=new QuizShopDao();
	QuizShopDto dto=dao.getData(num);
%>
<body>
	<table class="table table-bordered" style="width: 400px;">
		<tr>
			<td rowspan="3"><img src="../image/쇼핑몰사진/<%=dto.getPhoto()%>.jpg" style="width: 200px"></td>
			<td>상품명: <%=dto.getSang_name() %></td>
		</tr>
		<tr>
			<td>가격: <%=dto.getPrice() %></td>
		</tr>
		<tr>
			<td>입고날짜: <%=dto.getIpgoday() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button class="btn btn-success" onclick="location.href='shoplist.jsp'">목록</button>
				<button class="btn btn-info" onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
				<button class="btn btn-danger" onclick="location.href='deleteaction.jsp?num=<%=dto.getNum()%>'">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>