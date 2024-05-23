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
	<div class="alert alert-warning" style="margin: auto; width: 1000px;">
	    <h3>총 ${totalCount} 권의 도서가 판매중입니다</h3>
	    <button type="button" class="btn btn-outline-info" onclick="location.href='addform'">도서등록</button>
	    <c:if test="${totalCount > 0}">
	        <div>
	            <c:forEach var="dto" items="${list}" varStatus="i">
	                <c:if test="${i.count % 4 == 1}">
	                    <div class="row"> <!-- 각 4개의 도서를 한 행으로 묶기 위한 row 시작 -->
	                </c:if>
	                <div class="col-md-3"> <!-- 각 도서의 정보를 3열로 배치 -->
	                    <c:if test="${dto.bookimage == 'no'}">
	                        <img src="/bookphoto/no.png" style="width: 150px; height: 200px;">
	                    </c:if>
	                    <c:if test="${dto.bookimage != 'no'}">
	                        <img src="/bookphoto/${dto.bookimage}" style="width: 150px; height: 200px;">
	                    </c:if>
	                    <h4>${dto.bookname}</h4>
	                    <div>저자: ${dto.writer}</div>
	                    <div>출판사: ${dto.bookcompany}</div>
	                </div>
	                <c:if test="${i.count % 4 == 0 || i.last}">
	                    </div> <!-- 각 4개의 도서를 한 행으로 묶기 위한 row 종료 -->
	                </c:if>
	            </c:forEach>
	        </div>
	    </c:if>
	</div>
</body>
</html>