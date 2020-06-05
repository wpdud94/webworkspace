<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = request.getParameter("id");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find_Ok</title>
</head>
<body>
<h2>회원 검색 결과 :: id와 일치하는 회원은 없습니다.</h2>
<a href="index.html">메인 페이지로 돌아가기</a>
</body>
</html>