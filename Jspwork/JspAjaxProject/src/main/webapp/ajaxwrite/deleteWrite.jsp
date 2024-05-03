<%@page import="ajaxwrite.model.AjaxWriteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num=request.getParameter("num");

	AjaxWriteDao dao=new AjaxWriteDao();
	dao.deleteWrite(num);
%>