<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String num=request.getParameter("num");
	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	
	SimpleAnswerDto dto=new SimpleAnswerDto();
	dto.setNum(num);
	dto.setNickname(nickname);
	dto.setContent(content);
	
	SimpleAnswerDao dao=new SimpleAnswerDao();
	dao.insertAnswer(dto);
%>