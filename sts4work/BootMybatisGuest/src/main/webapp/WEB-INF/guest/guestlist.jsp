<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
   $(function(){
	   $("i.photo").click(function(){
		  $("#photos").trigger("click");
	   });
	   
	   
	   $("#btnsave").click(function(){
		   
		   if($("#nick").val()==''){
			   alert("닉네임 입력바람");
			   return;
		   }
		   if($("#pass").val()==''){
			   alert("비밀번호 입력바람");
			   return;
		   }
		   if($("#content").val()==''){
			   alert("내용을 입력바람");
			   return;
		   }
		   
		   //데이타 전송
		   var s=$("#frm").serialize();
		   
		   //insert ajax
		   $.ajax({
			  type:"post",
			  url:"insert",
			  data:s,
			  dataType:"json",
			  success:function(res){
				  alert(res.msg);
				  
				  location.reload();
				  
				  $("#nick").val("");
				  $("#pass").val("");
				  $("#content").val("");
			  }
		   });
	   });
	   
	   $("#photos").change(function(){
			  var fdata=new FormData();
			  var inputFile=$("#photos");
			  var files=inputFile[0].files;
			  
			  if(files.length==0)
			  {
				  return false;
			  }
			  
			  for(var i=0;i<files.length;i++)
			  {
				  console.log(i);
				  fdata.append("photos",files[i]);
			  }
			  
			  $.ajax({
				 url:"upload",
				 processData:false, /* 서버전달 데이터는 query String이라는 형태로 전달된다, 파일전송의 경우는 이를 하지 않아야한다 */
				 contentType:false, /* enctype의 기본설정인 application/x.www형태를 multipart/form-data형태로 변경하는것이 false */
				 type:"post",
				 data:fdata,
				 dataType:"json",
				 success:function(res){
					 console.log("파일명 확인: "+res.photoname);
				 }
			  });
		   });
	   
   });
   
   function deleteEntry(num){
	   var pass=prompt("비밀번호를 입력해 주세요");
	   
	   $.ajax({
		  type:"get",
		  url:"delete",
		  data:{"num":num,"pass":pass},
		  dataType:"json",
		  success:function(res){
			  alert(res.msg);
			  
			  location.reload();
		  }
	   });
   }

</script>
</head>
<body>
<div style="margin: 50px 100px;" id="inputform">
   <h4>원하는 사진들을 등록하세요
   <input type="file" name="photos" id="photos" multiple="multiple" style="display: none;">
   &nbsp;&nbsp;
   <i class="bi bi-camera-fill photo" style="font-size: 30px;"></i></h4>
   
   
    <form id="frm">
       <table class="table table-bordered" style="width: 700px;">
          <tr>
            <th width="100">닉네임</th>
            <td>
              <input type="text" class="form-control input-sm"
              style="width: 100px;" id="nick" name="nick">
            </td>
            <th width="100">비밀번호</th>
            <td>
              <input type="password" class="form-control input-sm"
              style="width: 100px;" id="pass" name="pass">
            </td>
          </tr>
          <tr>
            <td colspan="4">
              <div class="d-inline-flex">
              <textarea style="width: 580px; height: 100px;"
              class="form-control" id="content" name="content"></textarea>
              <button type="button" class="btn btn-danger" style="width: 100px;height: 100px; margin-left: 10px;"
              id="btnsave">저장</button></div>
            </td>
          </tr>
       </table>
    </form>
    <hr>
    <c:forEach var="a" items="${list }">
    	<table class="table table-bordered" style="width: 500px;">
    		<tr>
    			<td>
    				<b>${a.nick }</b>
    				<span>
    					작성일: <fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd"/>
    				</span>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<c:if test="${a.photo!='no' }">
    					<c:forTokens var="imp" items="${a.photo }" delims=",">
    						<a href="../guestphoto/${imp }">
    							<img src="../guestphoto/${imp }" style="width: 100px; border: 1px solid green; border-radius: 200px;">
    						</a>
    					</c:forTokens>
    				</c:if>
    				<pre>
    					<h6>${a.content }</h6>
    				</pre>
    			</td>
    		</tr>
    		<tr>
    			<td>
    				<button type="button" class="btn btn-warning" onclick="location.href=''">수정</button>
    				<button type="button" class="btn btn-danger" onclick="deleteEntry(${a.num})">삭제</button>
    			</td>
    		</tr>
    	</table>
    </c:forEach>
</div>
</body>
</html>