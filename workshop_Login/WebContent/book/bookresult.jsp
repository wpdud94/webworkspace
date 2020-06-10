<%@page import="servlet.Model.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Result</title>
</head>
<body>
<h2>결과 페이지</h2>
<p></p>
<h3>정상적으로 저장되었습니다.</h3>
<h4>저장 도서 내용</h4>
도서번호 : ${book.isbn} <br>
도서이름 : ${book.title}<p>

<div id="footer">
	<a href="Book.html">추가 등록</a> <a href="AllBookServlet">도서목록</a>
</div>
<a href="loginSuccess.jsp">Home으로</a>

</body>
</html>