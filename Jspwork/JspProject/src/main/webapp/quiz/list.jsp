<%@page import="java.text.SimpleDateFormat"%>
<%@page import="quiz.model.quizDto"%>
<%@page import="java.util.Vector"%>
<%@page import="quiz.model.quizDao"%>
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
	quizDao dao=new quizDao();
	Vector<quizDto> list=dao.getAllDatas();
	SimpleDateFormat sdf=new SimpleDateFormat("yyy년 MM월 dd일");
%>
</body>
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>핸드폰</th>
			<th>운전면허</th>
			<th>날짜</th>
			<th>수정/삭제</th>
		</tr>
		<%
			for(int i=0;i<list.size();i++){
				quizDto dto=list.get(i);
			%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getAge() %></td>
					<td><%=dto.getHp() %></td>
					<td><%=dto.getDriver()==null?"없음":"있음"%></td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
					<td>
						<button type="button" class="btn btn-info btn-sm" onclick="location.href='updateForm.jsp?no=<%=dto.getNo()%>'">수정</button>
						<button type="button" class="btn btn-danger btn-sm" onclick="location.href='deleteQuiz.jsp?no=<%=dto.getNo()%>'">삭제</button>
					</td>
				</tr>
			<%}
		%>
		<tr>
			<td>
				<button type="button" class="btn btn-info" onclick="location.href='insertForm.jsp'">입력폼</button>
			</td>
		</tr>
	</table>
</html>