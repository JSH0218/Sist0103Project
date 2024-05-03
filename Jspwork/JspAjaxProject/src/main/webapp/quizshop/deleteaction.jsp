<%@page import="quizshop.model.QuizShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String num=request.getParameter("num");
	
	QuizShopDao dao=new QuizShopDao();
	dao.deleteShop(num);
	
	response.sendRedirect("shoplist.jsp");
%>