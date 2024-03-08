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
	<%
		request.setCharacterEncoding("utf-8");
	%>
	
	<jsp:useBean id="dao" class="simpleguest.model.GuestDao"></jsp:useBean>
	<jsp:useBean id="dto" class="simpleguest.model.GuestDto"></jsp:useBean>
	<jsp:setProperty property="*" name="dto"/>
	
	<%
		if(dao.isEqulPass(dto.getNum(), dto.getPass())){
			dao.updateGuest(dto);
			response.sendRedirect("guestList.jsp");
		} else{%>
			<script type="text/javascript">
				alert("비밀번호가 맞지않습니다.");
				history.back();
			</script>
			<%
		}
	
	%>
</body>
</html>