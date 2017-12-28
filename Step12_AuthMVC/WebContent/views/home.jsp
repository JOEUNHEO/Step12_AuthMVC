<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/home.jsp</title>
</head>
<body>
<%
	//세션 영역에 "id" 라는 키값으로 저장된 값이 있는지 불러오기
	String id = (String)session.getAttribute("id");
%>
<h3>인덱스 페이지 입니다.</h3>
<%if(id != null){ %>
	<p><a href="users/private/info.do"><%=id %></a>님 로그인중...</p>
	<a href="users/logout.do">로그아웃</a>
<%}else{ %>
<ul>
	<li><a href="users/signup_form.do">회원가입</a></li>
	<li><a href="users/login_form.do?url=${pageContext.request.contextPath }/home.do">로그인</a></li>
</ul>
<%} %>
</body>
</html>