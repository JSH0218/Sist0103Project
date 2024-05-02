<%@page import="java.text.NumberFormat"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
	String shopnum=request.getParameter("shopnum");
	String loginok=(String)session.getAttribute("loginok");
	String myid=(String)session.getAttribute("myid");
	
	MemberDao mdao=new MemberDao();
	String num=mdao.getNum(myid);
	
	ShopDao dao=new ShopDao();
	ShopDto dto=dao.getData(shopnum);
	
	NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
	<div style="width: 1200px; height: 700px; display: flex;">
		<div style="width: 50%; height: 100%;">
			<img src="shopsave/<%=dto.getPhoto() %>" style="width: 50%; margin-left: 25%;">
		</div>
		<div style="width: 50%; height: 100%;">
			<form id="frm" style="color: black;">
				<input type="hidden" name="shopnum" value="<%=shopnum %>">
				<input type="hidden" name="num" value="<%=num %>">
				<h4>카테고리: <%=dto.getCategory() %></h4>
				<br>
				<h4>상품명: <%=dto.getSangpum() %></h4>
				<br>
				<h4>가격: <%=nf.format(dto.getPrice()) %></h4>
				<br>
				<h4>
					갯수: 
					<input type="number" min="1" max="10" value="1" step="1" name="cnt">
				</h4>
				<br>
				<br>
				<div>
					<button type="button" class="btn btn-info" id="btncart">장바구니</button>
					<button type="button" class="btn btn-success" onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		$("#btncart").click(function(){
			var login="<%=loginok %>";
			
			if(login=="null"){
				alert("먼저 로그인 해주세요");
				return;
			}
			
			var cartdata=$("#frm").serialize();
			$.ajax({
				type:"get",
				url:"shop/detailprocess.jsp",
				dataType:"html",
				data:cartdata,
				success:function(){
					var a=confirm("장바구니에 저장하였습니다\n장바구니로 이동하하려면 [확인]을 눌러주세요")
					
					if(a){
						location.href="index.jsp?main=shop/mycart.jsp";
					}
				}
			});
		});
	</script>
</body>
</html>