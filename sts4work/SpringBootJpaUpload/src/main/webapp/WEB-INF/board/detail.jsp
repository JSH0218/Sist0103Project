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
		<table class="table table-bordered">
			<tr>
				<td style="text-align: center;"><b>${dto.subject }</b></td>
			</tr>
			<tr>
				<td>
					<div style="display: flex; justify-content: space-between;">
						<span>${dto.writer }</span>
						<span style="color: gray;"><fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/></span>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<c:if test="${dto.photo!='no' }">
						<div>
							<img src="../save/${dto.photo }" style="max-width: 1000px;">
						</div>
					</c:if>
					<div>
						${dto.content }
					</div>
				</td>
			</tr>
			<tr>
				<td align="right">
					<button type="button" class="btn btn-success" onclick="location.href='list'">목록</button>
					<button type="button" class="btn btn-info" onclick="location.href='addform'">글쓰기</button>
					<button type="button" class="btn btn-warning" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-danger" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>