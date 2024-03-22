<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String myid=(String)session.getAttribute("myid");
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	int uploadSize=1024*1024*3;
	
	MultipartRequest multi=null;
	
	try{
		multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
		
		String content=multi.getParameter("content");
		String photoname=multi.getFilesystemName("photo");
		
		GuestDto dto=new GuestDto();
		
		dto.setMyid(myid);
		dto.setContent(content);
		dto.setPhotoname(photoname);
		
		GuestDao dao=new GuestDao();
		dao.insertGuest(dto);
		
		response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp");
	} catch(Exception e){
		
	}
%>