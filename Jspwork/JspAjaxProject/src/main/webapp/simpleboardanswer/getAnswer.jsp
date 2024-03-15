<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDto"%>
<%@page import="simpleboardanswer.model.SimpleAnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idx=request.getParameter("idx");
	
	SimpleAnswerDao dao=new SimpleAnswerDao();
	SimpleAnswerDto dto=dao.getAnswerData(idx);
	
	JSONObject ob=new JSONObject();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	ob.put("idx",dto.getIdx());
	ob.put("num",dto.getNum());
	ob.put("nickname",dto.getNickname());
	ob.put("content",dto.getContent());
	ob.put("writeday",sdf.format(dto.getWriteday()));
%>
<%=ob.toString() %>