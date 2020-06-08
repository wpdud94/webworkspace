<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberVO vo = (MemberVO) session.getAttribute("vo");
if(vo==null){
%>
	<h3>로그인부터 시작하세요</h3> <!-- 로그인성공 페이지로 바로 치고 들어오는 사람 있음 -->
	<a href="login.html">로그인페이지로 돌아가기</a>
<%	
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Success</title>
</head>
<body>
<h2>Login Information</h2>
Login	ID : <b><%=vo.getId() %></b><p></p>
Login	Name : <b><%=vo.getName() %></b><p></p>
Login	Address : <b><%=vo.getAddr() %></b><p></p>
JSESSION ID VALUE :: <b><%=session.getId() %></b><p></p>
<hr>
<a href="logout.jsp">LOG OUT</a> &nbsp;&nbsp;&nbsp; <a href="index.html">INDEX</a>
</body>
</html>