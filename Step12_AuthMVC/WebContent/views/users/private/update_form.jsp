<%@page import="test.users.dto.UsersDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/users/private/update_form.jsp</title>
</head>
<body>
<%
	UsersDto dto = (UsersDto)request.getAttribute("dto");
%>
<h3>회원정보 수정 페이지 입니다.</h3>
<form action="update.do" method="post" id="updateForm">
	<input type="hidden" name="id" value="<%=dto.getId() %>"/>
	<label for="id">아이디</label>
	<input type="text" id="id" value="<%=dto.getId() %>" 
		disabled="disabled"/><br/>
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"
		value="<%=dto.getPwd()%>"/><br/>
	<label for="pwd2">비밀번호 확인</label>
	<input type="password" id="pwd2" value="<%=dto.getPwd()%>"/><br/>
	<label for="email">이메일 주소</label>
	<input type="text" name="email" id="email" 
		value="<%=dto.getEmail()%>"/><br/>
	<button type="submit">수정 확인</button>
</form>
<script>
document.querySelector("#updateForm").addEventListener("submit",function(event){
	var inputPwd = document.querySelector("#pwd").value;
	var inputPwd2 = document.querySelector("#pwd2").value;
	if(inputPwd != inputPwd2){
		alert("비밀번호를 확인 하세요");
		event.preventDefault();//폼전송 막기
	}
});
</script>
</body>
</html>