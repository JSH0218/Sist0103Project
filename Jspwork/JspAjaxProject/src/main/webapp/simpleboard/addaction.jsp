<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String writer=request.getParameter("writer");
	String pass=request.getParameter("pass");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	
	SimpleBoardDto dto=new SimpleBoardDto();
	dto.setWriter(writer);
	dto.setPass(pass);
	dto.setSubject(subject);
	dto.setContent(content);
	
	SimpleBoardDao dao=new SimpleBoardDao();
	dao.insertSimpleBoard(dto);
	
	//response.sendRedirect("boardlist.jsp");
	
	int num=dao.getmaxNum();
	response.sendRedirect("contentview.jsp?num="+num);
%>