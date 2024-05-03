<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idx=request.getParameter("idx");
	String nickname=request.getParameter("nickname");
	String content=request.getParameter("content");
	
	SimpleAnswerDto dto=new SimpleAnswerDto();
	dto.setIdx(idx);
	dto.setNickname(nickname);
	dto.setContent(content);
	
	SimpleAnswerDao dao=new SimpleAnswerDao();
	dao.updateAnswer(dto);
%>