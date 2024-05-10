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
	<div>
		<button type="button" class="btn btn-info" onclick="location.href='addform'">회원가입</button>
	</div>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>회원명</th>
			<th>아이디</th>
			<th>핸드폰</th>
			<th>가입일</th>
			<th>편집</th>
		</tr>
		<c:if test="${count==0 }">
			<tr>
				<td colspan="6" align="center">회원이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${count>0 }">
			<c:forEach var="list" items="${list }" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${list.name }</td>
					<td>${list.id }</td>
					<td>${list.hp }</td>
					<td><fmt:formatDate value="${list.gaipday }" pattern="yyyy-MM-dd"/></td>
					<td>
						<button type="button" class="btn btn-warning btn-sm" onclick="location.href='updateform?num=${list.num}'">수정</button>
						<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${list.num}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>