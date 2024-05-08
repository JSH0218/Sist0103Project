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
	<div style="margin: 30px 50px;">
		<h3 class="alert alert-danger">MyShop목록</h3>
		<br>
		<h3 class="alert alert-danger">총 ${totalCount }개의 상품이 있습니다</h3>
		<table class="table table-bordered" style="width: 800px;">
			<tr align="center">
				<th>상품번호</th>
				<th>상품명</th>
				<th>색상</th>
				<th>가격</th>
				<th>사진이름</th>
				<th>비고</th>
			</tr>
			<c:if test="${totalCount==0 }">
				<tr>
					<td colspan="5" align="center">
						<b>등록된 상품이 없습니다</b>
					</td>
				</tr>
			</c:if>
			<c:if test="${totalCount>0 }">
				<c:forEach var="dto" items="${list }" varStatus="i">
					<tr align="center">
						<td>${dto.num }</td>
						<td>${dto.sangpum }</td>
						<td>${dto.color }</td>
						<td><fmt:formatNumber value="${dto.price }" type="currency"/></td>
						<td>${dto.imagename }</td>
						<td>
							<button type="button" class="btn btn-success btn-sm">수정</button>
							<button type="button" class="btn btn-danger btn-sm">삭제</button>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>