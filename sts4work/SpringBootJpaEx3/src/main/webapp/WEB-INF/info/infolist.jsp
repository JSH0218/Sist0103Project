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
</head>
<body>
	<div style="margin: auto; width: 1000px;">
		<button type="button" class="btn btn-info" onclick="location.href='addform'">학생정보입력</button>
		<br>
		<h5 class="alert alert-warning">${totalCount }명의 학생정보가 있습니다</h5>
		<table class="table table-bordered">
			<tr class="table-success">
				<th>번호</th>
				<th>학생명</th>
				<th>사진</th>
				<th>연락처</th>
				<th>주소</th>
				<th>편집</th>
			</tr>
			<c:if test="${totalCount==0 }">
				<tr>
					<td colspan="6">학생정보가 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${totalCount!=0 }">
				<c:forEach var="list" items="${list }" varStatus="i">
					<tr>
						<td>${i.count }</td>
						<td>${list.stuname }</td>
						<td>
							<img src="../${list.stuphoto }" width="50px;" height="50px;">
						</td>
						<td>${list.stuhp }</td>
						<td>${list.stuaddr }</td>
						<td>
							<button type="button" class="btn btn-warning btn-sm" onclick="location.href='updateform?num=${list.num}'">수정</button>
							<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${list.num}'">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>