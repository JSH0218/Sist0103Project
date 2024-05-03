<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
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
	<style type="text/css">
		img.photo{
			width: 60px;
			height: 80px;
			border: 2px solid gray;
		}
		
		div.sangpum{
			cursor: pointer;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("#allcheck").click(function(){
				$("input.idx").prop("checked",$(this).is(":checked"));
			});
			
			$("div.sangpum").click(function(){
				location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+$(this).attr("shopnum");
			});
			
			$("#btncartdel").click(function(){
				var cnt=$("input.idx:checked").length;

				if(cnt==0){
					alert("삭제할 상품을 선택해주세요");
				} else{
					for(var i=0;i<cnt;i++){
						$.ajax({
							type:"get",
							url:"shop/cartdelete.jsp",
							dataType:"html",
							data:{"idx":$("input.idx:eq("+i+")").attr("idx")}
						});
					}
				}
				
				location.reload();
			});
		});
	</script>
</head>
<%
	String id=(String)session.getAttribute("myid");
	ShopDao dao=new ShopDao();
	List<HashMap<String,String>> list=dao.getCartList(id);
	NumberFormat nf=NumberFormat.getCurrencyInstance();
	
%>
<body>
	<h4 class="alert alert-info" style="width: 1000px;"><%=id %>님의 장바구니</h4>
	<table class="table table-striped" style="width: 1000px;">
		<tr>
			<th style="width: 30px;"><input type="checkbox" id="allcheck"></th>
			<th style="width: 200px;">상품정보</th>
			<th style="width: 200px;">상품금액</th>
		</tr>
		<%
			int total=0;
			for(int i=0;i<list.size();i++){
				HashMap<String,String> map=list.get(i);
				//사진얻기
				String photo=map.get("photo");
				%>
				<tr>
					<td>
						<input type="checkbox" name="idx" idx="<%=map.get("idx") %>" class="idx">
					</td>
					<td>
						<div class="sangpum" shopnum="<%=map.get("shopnum") %>">
							<img src="shopsave/<%=photo %>" class="photo" align="left" hspace="20">
							<b>상품명: <%=map.get("sangpum") %></b>
							<br>
							<b>갯수: <%=map.get("cnt") %>개</b>
							<br>
							<b>날짜: <%=map.get("cartday") %></b>
						</div>
					</td>
					<td>
						<div>
							<b>단가: <%=nf.format(Integer.parseInt(map.get("price"))) %></b>
							<br>
							<b>총금액: <%=nf.format(Integer.parseInt(map.get("price"))*Integer.parseInt(map.get("cnt"))) %></b>
						</div>
					</td>
				</tr>
				<%
				total+=Integer.parseInt(map.get("price"))*Integer.parseInt(map.get("cnt"));
			}
		%>
		<tr>
			<td colspan="3">
				<div>
					<button type="button" class="btn btn-danger" id="btncartdel">선택상품삭제</button>
					<b style="font-size: 1.2em; float: right;">총금액: <%=nf.format(total) %></b>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>