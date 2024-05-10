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
	<script type="text/javascript">
		$(function(){
			
			$("#btncheck").click(function(){
				
				var id=$("#id").val();

				$.ajax({
					type:"get",
					url:"idcheck",
					dataType:"json",
					data:{"id":id},
					success:function(res){
						
						if(res.count>0){
							alert("이미 가입된 아이디입니다\n다시 입력해 주세요");
							$("#id").val("");
						} else{
							alert("가입이 가능한 아이디 입니다");
						}
					}
				});
			});
		});
	</script>
</head>
<body>
	<div style="margin: 100px 100px; width: 500px;">
		<form action="update" method="post">
			<input type="hidden" name="num" value="${dto.num }">
			<table class="table table-bordered">
				<caption><b>회원수정</b></caption>
				<tr>
					<th>회원명</th>
					<td>
						<input type="text" name="name" required="required" style="width: 130px;" class="form-control" value="${dto.name }">
					</td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><b>${dto.id }</b></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="pass" required="required" style="width: 130px;" class="form-control">
					</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>
						<input type="text" name="hp" required="required" style="width: 130px;" class="form-control" value="${dto.hp }">
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="submit" class="btn btn-info">회원수정</button>
						<button type="button" class="btn btn-success" onclick="location.href='list'">회원목록</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>