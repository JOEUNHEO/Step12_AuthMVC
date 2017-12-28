<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/loginform.jsp</title>
</head>
<body>
<%
	String url = (String)request.getAttribute("url");
	String savedId = (String)request.getAttribute("savedId");
%>
<h3>로그인 폼</h3>
<form action="login.do?url=<%=url %>" method="post">
	<label for="id">아이디</label>
	<input type="text" name="id" value="<%=savedId %>" />
	<label for="pwd">비밀 번호</label>
	<input type="password" name="pwd"/>
	<label>
		<input type="checkbox" name="isSave" value="yes" />
		아이디 저장
	</label>
	<button type="submit">로그인</button>
</form>
</body>
</html>