<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form action="quizWrite.jsp">
		<table class="table table-bordered" style="width:500px">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name" placeholder="이름" required="required" class="form-controll" style="width:120px">
				</td>
			</tr>
			<tr>
				<th>입사일자</th>
				<td>
					<input type="date" name="ipsa">
				</td>
			</tr>
			<tr>
				<th>점심메뉴</th>
				<td>
					<input type="radio" name="menu1" value="../image/Food/1.jpg">토스트
					<input type="radio" name="menu1" value="../image/Food/2.jpg">꼬치
					<input type="radio" name="menu1" value="../image/Food/3.jpg">육개장
					<input type="radio" name="menu1" value="../image/Food/4.jpg">찜닭
				</td>
			</tr>
			<tr>
				<th>건의메뉴</th>
				<td>
					<select name="menu2" class="form-control" style="width: 100px;" multiple="multiple">
						<option value="쌀국수">쌀국수</option>
						<option value="마라탕">마라탕</option>
						<option value="순대국밥">순대국밥</option>
						<option value="떡볶이">떡볶이</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" class="btn btn-success" value="전송"  style="width:120px">
					<input type="reset" class="btn btn-warning" value="초기화"  style="width:120px">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>