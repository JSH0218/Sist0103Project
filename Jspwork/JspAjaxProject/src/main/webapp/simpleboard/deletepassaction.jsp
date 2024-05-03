<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	
	SimpleBoardDao dao=new SimpleBoardDao();
	boolean flag=dao.isEqualPass(num, pass);
	
	if(flag){
		dao.deleteSimpleBoard(num);
		
		response.sendRedirect("boardlist.jsp");
	}else{
		%>
			<script type="text/javascript">
				alert("비밀번호가 틀렸습니다")
				history.go(-2);
			</script>
		<%
	}
%>