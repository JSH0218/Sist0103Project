<%@page import="java.text.SimpleDateFormat"%>
<%@page import="simpleboard.model.SimpleBoardDto"%>
<%@page import="simpleboard.model.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
	<style type="text/css">
		body *{
			font-family: "Noto Serif KR";
			font-size: 11pt;
		}
		
		span.day{
			color: #ccc;
			font-size: 0.8em;
		}
		
		span.aday{
			float: right;
			font-size: 0.8em;
			color: #bbb;
		}
		
		div.alist{
			margin-left: 20px;
		}
		
		i.amod{
			margin-left: 20px;
			color: green;
		}
		
		i.adel{
			color: red;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("div.uform").hide();
			list();
			$("#btnsend").click(function(){
				var num=$("#num").val();
				var nickname=$("#nickname").val();
				var content=$("#content").val();
				
				if(nickname==""){
					alert("닉네임을 입력후 저장해주세요");
					return;
				}else if(content==""){
					alert("댓글내용을 입력후 저장해주세요");
					return;
				}else{
					$.ajax({
						type:"post",
						url:"../simpleboardanswer/insertanswer.jsp",
						dataType:"html",
						data:{"num":num,"nickname":nickname,"content":content},
						success:function(){
							$("#nickname").val("");
							$("#content").val("");
							
							list();
						}
					});
				}
			});
			
			$(document).on("click","i.adel",function(){
				$.ajax({
					type:"get",
					url:"../simpleboardanswer/deleteanswer.jsp",
					dataType:"html",
					data:{"idx":$(this).attr("idx")},
					success:function(){
						list();
					}
				});
			});
			
			$(document).on("click","i.amod",function(){
				if($("div.aform").is(":visible")==true && $("div.uform").is(":visible")==false){
					$("div.aform").hide();
					$("div.uform").show();
				} else if($("#ubtnsend").attr("idx")==$(this).attr("idx")){
					$("div.aform").show();
					$("div.uform").hide();
				}
				
				$.ajax({
					type:"get",
					url:"../simpleboardanswer/getAnswer.jsp",
					dataType:"json",
					data:{"idx":$(this).attr("idx")},
					success:function(res){
						$("#unickname").val(res.nickname);
						$("#ucontent").val(res.content);
						$("#ubtnsend").attr("idx",res.idx);
					}
				});
			});
			
			$("#ubtnsend").click(function(){
				var idx=$(this).attr("idx");
				var content=$("#ucontent").val();

				$.ajax({
					type:"get",
					url:"../simpleboardanswer/updateAnswer.jsp",
					dataType:"html",
					data:{"idx":idx,"content":content},
					success:function(){
						list();
						$("div.aform").show();
						$("div.uform").hide();
					}
				});
			});
		});
		
		function list(){
			
			$.ajax({
				type:"get",
				url:"../simpleboardanswer/listanswer.jsp",
				dataType:"json",
				data:{"num":$("#num").val()},
				success:function(res){
					$("b.acount>span").text(res.length);

					var s="";
					$.each(res,function(idx,item){
						s+="<div>"+item.nickname+" : "+item.content;
						s+="<span class='aday'>"+item.writeday+"</span>";
						s+="<i class='bi bi-pencil-square amod' idx='"+item.idx+"'></i>";
						s+="<i class='bi bi-trash adel' idx='"+item.idx+"'></i>";
						s+="</div>";
					});
					$("div.alist").html(s);
				}
				
			});
		}
	</script>
</head>
<%
	String num=request.getParameter("num");
	SimpleBoardDao dao=new SimpleBoardDao();
	dao.updateReadCount(num);
	SimpleBoardDto dto=dao.getData(num);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>
<body>
	<input type="hidden" id="num" value=<%=num %>>
	<div style="margin: 50px 100px; width: 500px;">
		<table class="table table-bordered">
			<caption align="top"><b style="font-size: 15pt;"><%=dto.getSubject() %></b></caption>
			<tr>
				<td>
					<b>작성자: <%=dto.getWriter() %></b><br>
					<span class="day"><%=sdf.format(dto.getWriteday()) %></span>
					&nbsp;&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount() %>
				</td>
			</tr>
			<tr height="250">
				<td>
					<%=dto.getContent().replace("\n", "<br>") %>
				</td>
			</tr>
			<!-- 댓글 -->
			<tr>
				<td>
					<b class="acount">댓글<span>0</span></b>
					<div class="alist">
						댓글목록
					</div>
					<div class="aform input-group">
						<input type="text" id="nickname" class="form-control" style="width: 80px;" placeholder="닉네임">
						<input type="text" id="content" class="form-control" style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">
						<button type="button" id="btnsend" class="btn btn-info btn-sm" style="margin-left: 10px;">저장</button>
					</div>
					<div class="uform input-group">
						<input type="text" id="unickname" class="form-control" style="width: 80px;" placeholder="닉네임">
						<input type="text" id="ucontent" class="form-control" style="width: 300px; margin-left: 10px;" placeholder="댓글메세지">
						<button type="button" id="ubtnsend" class="btn btn-success btn-sm" style="margin-left: 10px;" idx="0">수정</button>
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<button type="button" class="btn btn-outline-info" onclick="location.href='addform.jsp'"><i class="bi bi-pencil"></i>글쓰기</button>
					<button type="button" class="btn btn-outline-success" onclick="location.href='boardlist.jsp'"><i class="bi bi-list-check"></i>목록</button>
					<button type="button" class="btn btn-outline-primary" onclick="location.href='updatepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-pencil-square"></i>수정</button>
					<button type="button" class="btn btn-outline-danger" onclick="location.href='deletepassform.jsp?num=<%=dto.getNum()%>'"><i class="bi bi-trash"></i>삭제</button>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>