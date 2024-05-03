<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uploadPath=getServletContext().getRealPath("/shopsave");
	System.out.println(uploadPath);	

	int uploadSize=1024*1024*5;
	
	MultipartRequest multi=null;
	
	try{
		multi=new MultipartRequest(request,uploadPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
		
		String sangpum=multi.getParameter("sangpum");
		String category=multi.getParameter("category");
		String photo=multi.getFilesystemName("photo");
		int price=Integer.parseInt(multi.getParameter("price"));
		String ipgoday=multi.getParameter("ipgoday");
		
		ShopDao dao=new ShopDao();
		
		ShopDto dto=new ShopDto();
		dto.setSangpum(sangpum);
		dto.setCategory(category);
		dto.setPhoto(photo);
		dto.setPrice(price);
		dto.setIpgoday(ipgoday);
		
		dao.insertShop(dto);
		
		response.sendRedirect("../index.jsp?main=shop/addform.jsp");
	} catch(Exception e){
		
	}
%>