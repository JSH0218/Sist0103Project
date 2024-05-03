<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="ajaxwrite.model.AjaxWriteDao"/>
<jsp:useBean id="dto" class="ajaxwrite.model.AjaxWriteDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
	dao.insertWrite(dto);
%>