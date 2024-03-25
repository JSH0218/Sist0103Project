<%@page import="java.io.File"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String num=request.getParameter("num");
	String currentPage=request.getParameter("currentPage");
	
	GuestDao dao=new GuestDao();
	GuestDto dto=dao.getData(num);
	
	String realPath=getServletContext().getRealPath("/save")+File.separator+dto.getPhotoname();
	File photo=new File(realPath);
	
	if(dto.getPhotoname()!=null){
		photo.delete();
	}
	
	dao.deleteGuest(num);
	
	response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp?currentPage="+currentPage);
%>