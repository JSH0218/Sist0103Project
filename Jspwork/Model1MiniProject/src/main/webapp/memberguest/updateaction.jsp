<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String realPath=getServletContext().getRealPath("/save");
	System.out.println(realPath);
	
	int uploadSize=1024*1024*3;
	
	MultipartRequest multi=null;
	
	try{
		multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
		
		String num=multi.getParameter("num");
		String currentPage=multi.getParameter("currentPage");
		String content=multi.getParameter("content");
		String photoname=multi.getFilesystemName("photo");
		
		//기존포토명 가져오기
		GuestDao dao=new GuestDao();
		String old_photoname=dao.getData(num).getPhotoname();
		
		GuestDto dto=new GuestDto();
		
		dto.setNum(num);
		dto.setContent(content);
		dto.setPhotoname(photoname==null?old_photoname:photoname);
		
		dao.updateGuest(dto);
		
		response.sendRedirect("../index.jsp?main=memberguest/guestlist.jsp?currentPage="+currentPage);
	} catch(Exception e){
		
	}
%>