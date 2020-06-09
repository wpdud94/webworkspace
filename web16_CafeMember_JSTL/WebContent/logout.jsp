<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%
	MemberVO vo =(MemberVO)session.getAttribute("vo");
	if(vo==null){
%>		
		<b><a href="login.hmtl">로그인부터 하세요</a></b>
<%
	}else{
		session.invalidate();
	}
%> --%>

<c:choose>
	<c:when test="${vo==null}">
		<script>
			<b><a href="login.hmtl">로그인부터 하세요</a></b>
			location.href="login.html";
		</script>
	</c:when>
	<c:otherwise>
		${sessionScope.invalidate}
		${sessionScope.id}


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
	</c:otherwise>
</c:choose>
</html>