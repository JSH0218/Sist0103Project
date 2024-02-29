<%@page import="quiz.model.quizDto"%>
<%@page import="quiz.model.quizDao"%>
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
	String no=request.getParameter("no");
	quizDao dao=new quizDao();
	quizDto dto=dao.getData(no);
%>
<body>
	<form action="updateAction.jsp" method="post">
		<table class="table table-bordered">
			<tr>
				<th class="table-warning">이름</th>
				<td>
					<input type="text" name="name" placeholder="이름" required="required" class="form-control">
				</td>
			</tr>
			<tr>
				<th class="table-warning">나이</th>
				<td>
					<input type="text" name="age" placeholder="나이" required="required" class="form-control">
				</td>
			</tr>
			<tr>
				<th class="table-warning">핸드폰</th>
				<td>
					<input type="text" name="hp" placeholder="핸드폰" required="required" class="form-control">
				</td>
			</tr>
			<tr>
				<th class="table-warning">운전면허</th>
				<td>
					<input type="checkbox" name="driver">있음
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="수정" class="btn btn-outline-success">
					<input type="button" value="목록" class="btn btn-outline-warning" onclick="location.href='list.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>