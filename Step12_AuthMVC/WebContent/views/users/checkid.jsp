<%@page import="test.users.dao.UsersDao"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<%if(msg.equals("이미 사용하는 아이디입니다.")){%>
	{"response":true}
<%}else{ %>
	{"response":false}
<%} %>
