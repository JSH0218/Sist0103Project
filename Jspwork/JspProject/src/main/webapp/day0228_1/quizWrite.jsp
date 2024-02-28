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

	String name=request.getParameter("name");
	String ipsa=request.getParameter("ipsa");
	String menu1=request.getParameter("menu1");
	String []menu2=request.getParameterValues("menu2");
%>

<h4>출력모양</h4>
<h5>
	사원명 : <%=name %><br>
	입사일자 : <%=ipsa %><br>
	오늘 선택 점심메뉴 : <img src="<%=menu1%>" style="width:300px"><br>
	사원명 : <%
			if(menu2==null)
			{%>
				<font>원하는 메뉴없음</font>
			<%}else
			{
				for(int i=0;i<menu2.length;i++)
				{%>
					[<%=menu2[i] %>]&nbsp;&nbsp;
				<%}
			}
		%>
</h5>
</body>
</html>