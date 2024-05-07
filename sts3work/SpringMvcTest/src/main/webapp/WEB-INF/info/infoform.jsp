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
	<h2>정보등록</h2>
	<form action="result" method="post">
		<div>이름: <input type="text" name="name"></div>
		<div>좋아하는 색상: <input type="color" name="color"></div>
		<div>취미: 
			<input type="checkbox" name="hobby" value="운동">운동
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="독서">독서
			<input type="checkbox" name="hobby" value="산책">산책
			<input type="checkbox" name="hobby" value="드라이브">드라이브
		</div>
		<div>
			가장 재미있는 언어선택: 
			<select name="lan">
				<option value="java">java
				<option value="html">html
				<option value="ajax">ajax
				<option value="spring">spring
			</select>
		</div>
		<div>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>