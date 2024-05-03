<%@page import="myInfo.db.MyInfoDao"%>
<%@page import="myInfo.db.MyInfoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name=request.getParameter("name");
	String hp=request.getParameter("hp1")+"-"+request.getParameter("hp2")+"-"+request.getParameter("hp3");
	String blood=request.getParameter("blood");
	String birth=request.getParameter("birth");
	
	MyInfoDto dto=new MyInfoDto();
	dto.setName(name);
	dto.setHp(hp);
	dto.setBlood(blood);
	dto.setBirth(birth);
	
	MyInfoDao dao=new MyInfoDao();
	dao.insertMyInfo(dto);
	
	response.sendRedirect("infoList.jsp");
%>