<%@page import="mem_gaip.model.MemgaipDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String m_num=request.getParameter("m_num");
	String m_pass=request.getParameter("m_pass");
	
	MemgaipDao dao=new MemgaipDao();
	if(dao.isPassCheck(m_num, m_pass)){
		response.sendRedirect("updateForm.jsp?m_num="+m_num);
	} else{
		%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸습니다");
			history.go(-2);
		</script>
		<%
	}
%>