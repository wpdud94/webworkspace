<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo =(MemberVO)session.getAttribute("vo");
	if(vo==null){
%>		
		<b><a href="login.hmtl">로그인부터 하세요</a></b>
<%
	}else{
		session.invalidate();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
<script type="text/javascript">
	function logoutpopup() {
		alert("Log Out!!");
	}
</script>
</head>
<body onload="return logoutpopup()">
	<b>로그아웃 되셨습니다</b><p></p>
	<a href="index.html">Home으로</a>
</body>
</html>