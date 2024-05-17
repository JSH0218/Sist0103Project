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
		<div style="margin-bottom: 10px;">
			<button type="button" class="btn btn-outline-info" onclick="location.href='writeform'">상품입력</button>
		</div>
		<div>
			<h3 class="alert alert-success"><b>총 ${totalCount }개의 상품정보가 있습니다</b></h3>
			<table class="table table-bordered">
				<tr class="table-success" style="text-align: center; vertical-align: middle;">
					<th>번호</th>
					<th>상품명</th>
					<th>색상</th>
					<th>가격</th>
					<th>입고일</th>
					<th>등록일</th>
					<th>편집</th>
				</tr>
				<c:if test="${totalCount==0 }">
					<tr>
						<td colspan="7" style="text-align: center; vertical-align: middle;">상품정보가 없습니다</td>
					</tr>
				</c:if>
				<c:if test="${totalCount!=0 }">
					<c:forEach var="list" items="${list }" varStatus="i">
						<tr style="text-align: center; vertical-align: middle;">
							<td>${i.count }</td>
							<td>${list.sangname }</td>
							<td style="background-color: ${list.sangcolor};"></td>
							<td>
								<fmt:formatNumber value="${list.sangprice }" type="currency"/>
							</td>
							<td>${list.sangipgo }</td>
							<td>
								<fmt:formatDate value="${list.writeday }" pattern="yyyy-MM-dd"/>
							</td>
							<td>
								<button type="button" class="btn btn-warning btn-sm" onclick="location.href='updateform?num=${list.num}'">수정</button>
								<button type="button" class="btn btn-danger btn-sm" onclick="location.href='delete?num=${list.num}'">삭제</button>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
	</div>
</body>
</html>