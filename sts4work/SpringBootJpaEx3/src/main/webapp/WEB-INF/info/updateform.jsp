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
	<div style="margin: auto; width: 500px;">
		<form action="save" method="post">
			<input type="hidden" name="num" value="${dto.num }">
			<table class="table table-bordered">
				<caption align="top"><b>학생정보수정</b></caption>
				<tr>
					<th>학생명</th>
					<td>
						<input type="text" name="stuname" class="form-control" style="width: 150px;" required="required" value="${dto.stuname }">
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" name="stuhp" class="form-control" style="width: 150px;" required="required" value="${dto.stuhp }">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" name="stuaddr" class="form-control" style="width: 150px;" required="required" value="${dto.stuaddr }">
					</td>
				</tr>
				<tr>
					<th>사진</th>
					<td>
						<select name="stuphoto">
							<option value="1.jpg" ${dto.stuphoto=="1.jpg"?"selected='selected'":"" }>사진1</option>
							<option value="2.jpg" ${dto.stuphoto=="2.jpg"?"selected='selected'":"" }>사진2</option>
							<option value="3.jpg" ${dto.stuphoto=="3.jpg"?"selected='selected'":"" }>사진3</option>
							<option value="4.jpg" ${dto.stuphoto=="4.jpg"?"selected='selected'":"" }>사진4</option>
							<option value="5.jpg" ${dto.stuphoto=="5.jpg"?"selected='selected'":"" }>사진5</option>
							<option value="6.jpg" ${dto.stuphoto=="6.jpg"?"selected='selected'":"" }>사진6</option>
							<option value="7.jpg" ${dto.stuphoto=="7.jpg"?"selected='selected'":"" }>사진7</option>
							<option value="8.jpg" ${dto.stuphoto=="8.jpg"?"selected='selected'":"" }>사진8</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info">수정</button>
						<button type="button" class="btn btn-success" onclick="location.href='list'">목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>