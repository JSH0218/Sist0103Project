<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	
	MemberDao dao=new MemberDao();
	
	if(dao.isIdPass(id, pass)){
		response.sendRedirect("../index.jsp?main=member/updateform.jsp?id="+id);
	} else{
		%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다")
			history.back();
		</script>
		<%
	}
%>