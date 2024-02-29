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

	String grade=request.getParameter("grade");
	String []lang=request.getParameterValues("lang");
	String like=request.getParameter("like");
	int height=Integer.parseInt(request.getParameter("height"));
	int weight=Integer.parseInt(request.getParameter("weight"));
	String ipsaday=request.getParameter("ipsaday");
%>

<h3 class="alert alert-success">***사원정보***</h3>
<h4>
	최종학력: <%=grade %><br>
	사용가능언어: 
	<%
		if(lang==null)
		{%>
			없음
		<%}
		else
		{
			for(int i=0;i<lang.length;i++)
			{%>
				[<%=lang[i]%>]
			<%}
		}
	%>
	<br>
	같은조 하고싶은 사람: <%=like %><br>
	키: <%=height %><br>
	몸무게: <%=weight %><br>
	입사날짜: <%=ipsaday %>
</h4>
</body>
</html>