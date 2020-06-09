<%@page import="java.util.ArrayList"%>
<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allShow</title>
</head>
<body>
<h2>전체 회원 명단</h2>
<table border="">
	<thead>
		<tr>
			<th>번 호</th><th>I D</th><th>이 름</th><th>주 소</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${mlist}" var="member">
			<tr>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.addr}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p></p>
<a href="index.html">메인 페이지로 돌아가기</a>
</body>
</html>