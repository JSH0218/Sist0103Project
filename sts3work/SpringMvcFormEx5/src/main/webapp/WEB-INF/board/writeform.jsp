<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<link>
</head>
<body>
	<div style="margin: 50px 100px;">
		<form action="process" method="post">
			<div>작성자: <input type="text" name="name"></div>
			<div>날짜: <input type="date" name="date"></div>
			<div>
				성별: 
				<input type="radio" name="gender" value="남자" checked="checked">남자
				<input type="radio" name="gender" value="여자">여자
			</div>
			<div>
				<button type="submit">서버에 전송</button>
			</div>
		</form>
	</div>
</body>
</html>