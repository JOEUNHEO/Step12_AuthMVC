<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/logout.jsp</title>
</head>
<body>
<%
	String msg = (String)request.getAttribute("msg");
%>
<script>
	alert("<%=msg %>");
	location.href="/home.do";
</script>
</body>
</html>