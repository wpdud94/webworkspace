<%@page import="java.io.PrintWriter"%>
<%@page import="servlet.Model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO uvo = (UserVO)session.getAttribute("uvo");
	if(uvo==null){
%>
	<a href="login.html">로그인 먼저 해주세요</a>	
<%
	}

	else{
		session.invalidate();
		out.print(session.getId());
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
</head>
<body>
<h2>로그아웃이 완료됐습니다.</h2>
<a href="login.html">Home으로</a>
<%
	}
%>
</body>
</html>