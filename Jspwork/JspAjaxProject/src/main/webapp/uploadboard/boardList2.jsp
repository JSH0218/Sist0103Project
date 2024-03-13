<%@page import="uploadboard.data.UploadBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="uploadboard.data.UploadBoardDao"%>
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
<%
	UploadBoardDao dao=new UploadBoardDao();
	List<UploadBoardDto> list=dao.getAllDatas();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
	<b>전체글보기</b>
	<br>
	<span><%=list.size() %>개의 글</span>
	<hr>
	<div style="width: 700px; display: flex; flex-flow: wrap;">
		<%
			for(int i=0;i<list.size();i++){
				UploadBoardDto dto=list.get(i);
				%>
				<div style="margin: 20px;">
					<img src="../save/<%=dto.getImgname()%>" style="width: 75px; height: 100px;">
					<br>
					<%=dto.getSubject() %>
					<br>
					<%=dto.getWriter() %>
					<br>
					<%=sdf.format(dto.getWriteday()) %>
					<br>
					조회수: <%=dto.getReadcount() %>
				</div>
				<%
			}
		%>
	</div>
</body>
</html>