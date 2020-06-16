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
<title>Login Success</title>
<style type="text/css">
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}
	
	body{
		width: 800px;
		margin: 0 auto;
		text-align: center;
	}
	#wrap{
		width: 400px;
		margin: 100px 0px 0px 150px;
		padding: 50px; 10px;
		border: 1px solid blue;
	}
	
</style>
</head>
<body>
<div id="wrap">
<b> ${uvo.userid}님이 로그인 되셨습니다!!!</b>
<br><br><br><br>
<a href="./book/Book.html">도서 등록</a>
<br><br>
<a href="loginout.jsp">로그아웃</a>
<br><br>
<a href="./book/booklist.jsp">도서 목록</a>
</div>
	</c:otherwise>
</c:choose>
</body>
</html>