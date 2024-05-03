<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="simpleboard.model.SimpleBoardDto"/>
<jsp:useBean id="dao" class="simpleboard.model.SimpleBoardDao"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dao.updateSimpleBoard(dto);
	
	response.sendRedirect("contentview.jsp?num="+dto.getNum());
%>