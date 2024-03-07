<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String foodphoto="<img src='../image/Food/"+request.getParameter("foodphoto")+".jpg'>";
	String foodname=request.getParameter("foodname");
	int score1=Integer.parseInt(request.getParameter("score1"));
	int score2=Integer.parseInt(request.getParameter("score2"));
	int score3=Integer.parseInt(request.getParameter("score3"));
	
	int tot=score1+score2+score3;
	double avg=tot/3.0;
	
	JSONObject ob=new JSONObject();
	ob.put("foodphoto",foodphoto);
	ob.put("foodname",foodname);
	ob.put("tot",tot);
	ob.put("avg",avg);
%>

<%=ob.toString()%>