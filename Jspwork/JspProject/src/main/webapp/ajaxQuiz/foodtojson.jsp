<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	DbConnect db=new DbConnect();
	Connection conn=db.getConnection();
	Statement stmt=null;
	ResultSet rs=null;
	
	String sql="select * from food order by num";
	
	try{
		stmt=conn.createStatement();
		rs=stmt.executeQuery(sql);
		
		JSONArray arr=new JSONArray();
		
		while(rs.next()){
			String num=rs.getString("num");
			String foodname=rs.getString("foodname");
			String foodphoto=rs.getString("foodphoto");
			String price=rs.getString("price");
			String cnt=rs.getString("cnt");
			
			JSONObject ob=new JSONObject();
			ob.put("num", num);
			ob.put("foodname", foodname);
			ob.put("foodphoto", foodphoto);
			ob.put("price", price);
			ob.put("cnt", cnt);
			
			arr.add(ob);
		}
		%>
		<%=arr.toString() %>
		<%
	}catch(SQLException e){
		
	}finally{
		db.dbClose(rs, stmt, conn);
	}
%>