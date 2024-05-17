<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div style="margin: auto; width: 1000px;">
		<button type="button" class="btn btn-info" onclick="location.href='addform'">글쓰기</button>
		<h2>총 ${totalCount }개의 게시글이 있습니다</h2>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
			<c:if test="${totalCount==0 }">
				<tr>
					<td colspan="4">작성된 게시글이 없습니다</td>
				</tr>
			</c:if>
			<c:if test="${totalCount!=0 }">
				<c:forEach var="list" items="${list }" varStatus="i">
					<tr>
						<td>${totalCount-i.index }</td>
						<td>
							<a href="detail?num=${list.num }">${list.subject }</a>
							<c:if test="${list.photo!='no' }"><i class="bi bi-image"></i></c:if>
						</td>
						<td>${list.writer }</td>
						<td>
							<fmt:formatDate value="${list.writeday }" pattern="yyyy-MM-dd"/>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>