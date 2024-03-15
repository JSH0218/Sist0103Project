<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
	SimpleBoardDao dao=new SimpleBoardDao();
	
	int totalCount=dao.getTotalCount(); //전체갯수
	int perPage=3; //한페이지당 보여질 글의 갯수
	int perBlock=5; //한블럭당 페이지 갯수
	int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이 0번, 오라클은 1번)
	int startPage; //각블럭당 보여질 시작페이지
	int endPage; //각블럭당 보여질 끝페이지
	int currentPage; //현재페이지
	int totalPage; //총페이지수
	int no; //각페이지당 출력할 시작번호
	
	//현재페이지 읽는데 단 null일경우는 1페이지로 준다
	if(request.getParameter("currentPage")==null){
		currentPage=1;
	} else{
		currentPage=Integer.parseInt(request.getParameter("currentPage"));
	}
	
	//총페이지수 구하기
	//나머지가 1이라도 있으면 무조건 1페이지 추가
	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
	
	//각블럭당 보여질 시작페이지
	startPage=(currentPage-1)/perBlock*perBlock+1;
	endPage=startPage+perBlock-1;
	
	//총페이지가 23일경우 마지막 블럭은 끝페이지가 23
	if(endPage>totalPage){
		endPage=totalPage;
	}
	
	//각페이지에서 보여질 시작번호
	startNum=(currentPage-1)*perPage;
	
	//각페이지당 출력할 시작번호 구하기
	no=totalCount-(currentPage-1)*perPage;
	
	//페이지에서 보여질 글만 가져오기
	List<SimpleBoardDto> list=dao.getPagingList(startNum, perPage);
	
	//List<SimpleBoardDto> list=dao.getAllDatas();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	//int count=list.size();
%>
<body>
	<div style="margin: 50px 100px; width: 800px;">
		<button type="button" class="btn btn-outline-info" onclick="location.href='addform.jsp'" style="margin-left: 550px;"><i class="bi bi-pencil"></i>글쓰기</button>
		<br>
		<h6><b>총<%=totalCount %>개의 글이 있습니다</b></h6>
		<table class="table table-bordered">
			<caption align="top"><b>간단목록게시판</b></caption>
			<tr class="table-light" align="center">
				<th width="80">번호</th>
				<th width="350">제목</th>
				<th width="180">작성자</th>
				<th width="180">작성일</th>
				<th width="80">조회</th>
			</tr>
			<%
				if(totalCount==0){
					%>
					<tr>
						<td colspan="5" align="center">
							<h6><b>등록된 게시글이 없습니다</b></h6>
						</td>
					</tr>
					<%
				} else{
					for(int i=0;i<list.size();i++){
						SimpleBoardDto dto=list.get(i);
						%>
						<tr align="center">
							<td><%=no-- %></td>
							<td><a href="contentview.jsp?num=<%=dto.getNum()%>" style="text-decoration: none; color: black;"><%=dto.getSubject() %></a></td>
							<td><%=dto.getWriter() %></td>
							<td><%=sdf.format(dto.getWriteday()) %></td>
							<td><%=dto.getReadcount() %></td>
						</tr>
						<%
					}
				}
			%>
		</table>
		<!-- 페이지 번호 출력 -->
		<ul class="pagination justify-content-center">
			<%
				//이전
				if(startPage>1){
					%>
					<li class="page-item">
						<a class="page-link" href="boardlist.jsp?currentPage=<%=startPage-1%>" style="color: black;">이전</a>
					</li>
					<%
				}
				for(int pp=startPage;pp<=endPage;pp++){
					if(pp==currentPage){
						%>
						<li class="page-item active">
							<a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
						</li>
						<%
					}else{
						%>
						<li class="page-item">
							<a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
						</li>
						<%
					}
				}
				
				//다음
				if(endPage<totalPage){
					%>
					<li class="page-item">
						<a class="page-link" href="boardlist.jsp?currentPage=<%=endPage+1%>" style="color: black;">다음</a>
					</li>
					<%
				}
			%>
		</ul>
	</div>
</body>
</html>