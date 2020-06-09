<%@page import="java.io.PrintWriter"%>
<%@page import="servlet.Model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${uvo==null}">
		<script>
			alert('로그인 먼저 해주세요');
			location.href="login.html";
		</script>
	</c:when>
	<c:otherwise>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log Out</title>
</head>
<body>
<h2>로그아웃이 완료됐습니다.</h2>
<a href="login.html">Home으로</a>
	</c:otherwise>
</c:choose>
</body>
</html>