<%@page import="servlet.Model.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Result</title>
<style type="text/css">
	*{
		margin:0;
		padding:0;
		box-sizing: border-box;
	}
	body{
		width: 1000px;
		margin: 0 auto;
	}
	#wrap{
		margin: 20px 0px 0px 10px;
		text-align: center;
	}
	
</style>
</head>
<body>
<h2>결과 페이지</h2>
<p></p>
<div id="header">
<h3>정상적으로 저장되었습니다.</h3>
</div>
<div id="wrap">
<h4>저장 도서 내용</h4>
도서번호 : ${book.isbn} <br>
도서이름 : ${book.title}<p>
</div>

<div id="footer">
	<a href="Book.html">추가 등록</a> <a href="AllBookServlet">도서목록</a>
</div>
<a href="loginSuccess.jsp">Home으로</a>

</body>
</html>