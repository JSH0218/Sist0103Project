<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
	<style type="text/css">
		#mainimg{
			width: 100px;
			height: 100px;
			border-radius: 100px;
			margin-top: 30px;
			margin-left: 20px;
			border: 1px solid tomato;
		}
	</style>
</head>
<%
	//프로젝트 경로
	String root=request.getContextPath();
%>
<body>
	<div style="font-size: 13pt; line-height: 25px;">
		<i class="bi bi-person-circle"></i>도로롱 전문점<br>
		<i class="bi bi-telephone-inbound"></i>07-1256-8598<br>
		<i class="bi bi-house-add"></i>팰파고스 바닷바람 군도<br>
		<i class="bi bi-envelope-arrow-down"></i>dororong@gmail.com<br>
		<i class="bi bi-upc-scan"></i><img src="image/admin.webp" id="mainimg">
	</div>
</body>
</html>