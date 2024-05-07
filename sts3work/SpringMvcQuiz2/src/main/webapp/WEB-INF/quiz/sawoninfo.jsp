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
	<table class="table table-bordered" style="width: 500px;">
		<tr>
			<th>사원명</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>급여</th>
			<td><fmt:formatNumber value="${dto.pay }" type="number"/></td>
		</tr>
		<tr>
			<th>나이</th>
			<td>${dto.age }</td>
		</tr>
		<tr>
			<th>부서</th>
			<td>${dto.buseo }</td>
		</tr>
	</table>
</body>
</html>