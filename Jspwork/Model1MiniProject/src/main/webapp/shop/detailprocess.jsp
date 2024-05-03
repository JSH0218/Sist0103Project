<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String shopnum=request.getParameter("shopnum");
	String num=request.getParameter("num");
	int cnt=Integer.parseInt(request.getParameter("cnt"));
	
	ShopDao dao=new ShopDao();
	dao.insertCart(shopnum, num, cnt);
%>