<%@page import="java.io.File"%>
<%@page import="uploadboard.data.UploadBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String num=request.getParameter("num");
	String pass=request.getParameter("pass");
	
	UploadBoardDao dao=new UploadBoardDao();
	boolean b=dao.isEqualPass(num, pass);
	
	if(b){
		//게시글 지우기전 업로드된 이미지 지우기
		String imgName=dao.getData(num).getImgname();
		//업로드 경로
		String uploadPath=getServletContext().getRealPath("/save");
		//파일생성
		File file=new File(uploadPath+"\\"+imgName);
		//파일삭제
		if(file.exists()){
			file.delete();
		}
		
		//db삭제
		dao.deleteUploadBoard(num);
		
		response.sendRedirect("boardList.jsp");
	} else{
		%>
		<script type="text/javascript">
			alert("비밀번호가 틀렸어요");
			history.back();
		</script>
		<%
	}
%>