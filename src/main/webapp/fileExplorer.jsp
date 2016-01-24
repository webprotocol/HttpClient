<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileExplorer.jsp</title>
</head>
<body>
<%
	String path = "c:\\";
	File root = new File("C:\\");
	File[] files = root.listFiles();
%>
<c:set var="path" value="<%=path%>"/>
<c:set var="files" value="<%=new File(path).listFiles() %>"/>
<ol>
<c:forEach var="item" items="${files}">
	<c:if test="${item.file}">
		<li><a href="down?name=${path}${item.name}">${item.name}</a></li>
	</c:if>
	<c:if test="${not item.file}">
		<li>${item.name}</li>
	</c:if>	
</c:forEach>
</ol>
<form action="upload" method="post" enctype="multipart/form-data">
	<input type="file" name="f"/>
	<button type="submit">upload</button>
</form>

</body>
</html>