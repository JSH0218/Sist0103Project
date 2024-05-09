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
	<h3 class="alert alert-info">Ex2번 예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-info">List2 Json 데이터 출력</button>
	<div id="out1"></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			
			$.ajax({
				type:"get",
				dataType:"json",
				url:"list2",
				success:function(res){
					
					var s="";
					$.each(res,function(i,elt){
						s+="<figure>";
						s+="<img src='upload/"+elt.photo+"' width=100>";
						s+="<figcaption><b>"+elt.foodName+"</b></figcaption>";
						s+="</figure>";
					});
					
					$("#out1").html(s);
				}
			});
		});
	</script>
</body>
</html>