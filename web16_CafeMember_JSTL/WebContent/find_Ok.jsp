<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find_Ok</title>
</head>
<body>
<h2>회원 검색 결과</h2>
<table border="1">
	<thead>
		<tr>
			<th>I D</th><th>이 름</th><th>주 소</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${vo.id}</td>
			<td>${vo.name}</td>
			<td>${vo.addr}</td>
		</tr>
	</tbody>
</table>
<a href="index.html">메인 페이지로 돌아가기</a>
</body>
</html>