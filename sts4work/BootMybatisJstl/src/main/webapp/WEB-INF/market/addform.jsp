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
	<div style="margin: auto; width: 500px;">
		<h2>Market정보 입력하기</h2>
		<form action="insert" method="post" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<th class="table-light">상품명</th>
					<td>
						<input type="text" name="sang" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th class="table-light">단가</th>
					<td>
						<input type="text" name="dan" class="form-control" required="required">
					</td>
				</tr>
				<tr>
					<th class="table-light">이미지</th>
					<td>
						<input type="file" name="photo" class="form-control">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info">저장</button>
						<button type="button" class="btn btn-success" onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>