<%@page import="servlet.Model.BookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% BookVO book = (BookVO) request.getAttribute("book"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>결과 페이지</h2>
<p></p>
<h3>정상적으로 저장되었습니다.</h3>
<h4>저장 도서 내용</h4>
도서번호 : <%= book.getIsbn()%> <br>
도서이름 : <%= book.getTitle()%><p>
<a href="loginSuccess.jsp">Home으로</a>
</body>
</html>