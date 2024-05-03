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
	<style type="text/css">
		div.board{
			position: absolute;
			left: 20%;
			top: 20%;
			font-family: "Noto Sans KR";
			font-size: 1.1em;
		}
		
		div.list{
			width: 800px;
			
		}
	</style>
	<script type="text/javascript">
		$(function(){
			list();
			
			$("div.addform").hide();
			$("div.updateform").hide();
			$("div.list").show();
			$("div.detailview").hide();
			
			//이미지 선택시
			$("#selimage").change(function(){
				var im=$(this).val();
				
				//이미지명을 현재값에 넣기
				$("#image").val(im);
				
				//아래 이미지뷰에 추가로 이미지 보이게
				var s="<img src='"+im+"' width='50'>";
				$("#imgview").html(s);
			});
			
			//글쓰기 버튼 누르면 입력폼 나오게
			$(document).on("click",".addbtn",function(){
				$("div.list").hide();
				$("div.addform").show();
			});
			
			$("#btninsert").click(function(){
				$.ajax({
					type:"get",
					url:"insertWrite.jsp",
					dataType:"html",
					data:$("#addfrm").serialize(),
					success:function(){
						$("#writer").val("");
						$("#subject").val("");
						$("#story").val("");
						$("#image").val("../image/avata/b1.png");
						$("#selimage option:eq(0)").prop("selected",true);
						$("#imgview").children("img").attr("src","../image/avata/b1.png");
						
						list();
						$("div.addform").hide();
						$("div.list").show();
					}
				});
			});
			
			$(document).on("click",".sub",function(){
				$.ajax({
					type:"get",
					url:"getDataWrite.jsp",
					dataType:"json",
					data:{"num":$(this).attr("num")},
					success:function(res){
						$("div.list").hide();
						$("div.detailview").show();
						
						var s="<table>";
						s+="<tr>";
						s+="<td colspan='2'>제목: "+res.subject+"</td>";
						s+="<td colspan='2' rowspan='3'><img src='"+res.image+"'></td>";
						s+="</tr>";
						s+="<tr>";
						s+="<td>작성자: "+res.writer+"</td>";
						s+="<td>"+res.writeday+"</td>";
						s+="</tr>";
						s+="<tr>";
						s+="<td>"+res.story+"</td>";
						s+="</tr>";
						s+="<tr>";
						s+="<td colspan='4' align='center'>";
						s+="<button type='button' onclick=insertform()>글쓰기</button>";
						s+="<button type='button' onclick=listform()>목록</button>";
						s+="<button type='button'>수정</button>";
						s+="<button type='button' class='delbtn' num='"+res.num+"'>삭제</button>";
						s+="</td>";
						s+="</tr>";
						s+="</table>";
						
						
						$("div.detailview").html(s);
						
					}
				});
			});
			
			$(document).on("click",".delbtn",function(){
				$.ajax({
					type:"get",
					url:"deleteWrite.jsp",
					dataType:"html",
					data:{"num":$(this).attr("num")},
					success:function(){
						$("div.detailview").hide();
						list();
						$("div.list").show();
					}
				});
			});
		});
		
		function list(){
			$.ajax({
				type:"get",
				url:"listWrite.jsp",
				dataType:"json",
				success:function(res){
					
					var s="";
					
					s+="<table class='board table table-bordered'>";
					s+="<caption align='top'><button type='button' class='btn btn-info addbtn'>";
					s+="<i class='bi bi-pencil'>글쓰기</i></button></caption>";
					s+="<tr>";
					s+="<td width='100'>번호</td>";
					s+="<td width='300'>제목</td>";
					s+="<td width='150'>작성자</td>";
					s+="<td width='200'>작성일</td>";
					s+="<td width='100'>추천</td>";
					s+="</tr>";
					
					var n=res.length;
					if(n==0){
						s+="<tr>";
						s+="<td colspan='5' align='center'>";
						s+="<b>게시된 글이 없습니다</b></td>";
						s+"</tr>";
					} else{
						$.each(res,function(i,elt){
							//출력
							s+="<tr align='center'>";
							s+="<td>"+(i+1)+"</td>";
							s+="<td>"+"<a num='"+elt.num+"' class='sub'>"+elt.subject+"</a>"+"</td>";
							s+="<td>"+elt.writer+"</td>";
							s+="<td>"+elt.writeday+"</td>";
							s+="<td>"+elt.likes+"</td>";
							s+="</tr>";
						});
					}
					s+="</table>";
					
					$("div.list").html(s);
				}
			});
		}
		
		function insertform(){
			$("div.detailview").hide();
			$("div.addform").show();
		}
		
		function listform(){
			$("div.detailview").hide();
			list();
			$("div.list").show();
		}
		
	</script>
</head>
<body>
	<!-- 추가폼 -->
	<div class="board addform" style="width: 400px;">
		<form id="addfrm">
			<table class="table table-bordered">
				<caption align="top"><b>글쓰기</b></caption>
				<tr>
					<th width="100" class="table-warning">작성자</th>
					<td>
						<input type="text" name="writer" id="writer" class="form-control" required="required" style="width: 130px;">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-warning">제목</th>
					<td>
						<input type="text" name="subject" id="subject" class="form-control" required="required" style="width: 250px;">
					</td>
				</tr>
				<tr>
					<th width="100" class="table-warning">내용</th>
					<td>
						<textarea style="width: 300px; height: 100px;" name="story" id="story" required="required" class="form-control"></textarea>
					</td>
				</tr>
				<tr>
					<th width="100" class="table-warning">이미지</th>
					<td>
						<input type="hidden" name="image" id="image" width="100%" value="../image/avata/b1.png">
						<select id="selimage" style="width: 100px;" class="form-control">
							<option value="../image/avata/b1.png" selected="selected">사랑해</option>
							<option value="../image/avata/b2.png">우울함</option>
							<option value="../image/avata/b5.png">배고파</option>
							<option value="../image/avata/b6.png">좌절</option>
							<option value="../image/avata/b10.png">심심해</option>
							<option value="../image/avata/b8.png">최고</option>
						</select>
						<div id="imgview"><img src="../image/avata/b1.png" width="50"></div>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<button type="button" class="btn btn-danger" id="btninsert">DB추가</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div class="board updateform">수정</div>
	<div class="board list">목록</div>
	<div class="board detailview">내용보기</div>
</body>
</html>