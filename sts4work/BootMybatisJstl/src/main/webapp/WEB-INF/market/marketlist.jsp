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
		<div>
			<button type="button" class="btn btn-outline-info" onclick="location.href='addform'">상품등록</button>
		</div>
		<c:if test="${totalCount==0 }">
			<div class="alert alert-info">
				<b>저장된 정보가 없습니다</b>
			</div>
		</c:if>
		<c:if test="${totalCount>0 }">
			<div class="alert alert-danger">
				<b>총 ${totalCount }개의 상품정보가 있습니다</b>
			</div>
			<div>
				<c:forEach var="dto" items="${list }" varStatus="i">
					<div style="display: flex;">
						<div>
							<c:if test="${dto.photoname=='no' }">
								<img src="/photo/no.png" style="width: 200px;">
							</c:if>
							<c:if test="${dto.photoname!='no' }">
								<img src="/photo/${dto.photoname }" style="width: 200px;">
							</c:if>
						</div>
						<div style="display: flex; flex-direction: column; justify-content: center;">
							<div>
								<h4>상품명: ${dto.sang }</h4>
								<h4>가격: <fmt:formatNumber value="${dto.dan }" type="currency"/> </h4>
								<h4>입고일: <fmt:formatDate value="${dto.ipgoday }" pattern="yyyy-MM-dd HH:mm"/></h4>
							</div>
							<div>
								<button type="button" class="btn btn-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
								<button type="button" class="btn btn-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
							</div>
						</div>
					</div>
					<hr>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>