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
	String m_num=request.getParameter("m_num");
%>
<body>
	<div>
		<form action="deletePassAction.jsp" method="post">
			<table>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="hidden" name="m_num" value="<%=m_num %>">
						<input type="password" name="m_pass" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<button type="submit">확인</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>